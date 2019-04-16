package customer.supu.service.impl;


import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import customer.supu.mapper.CommentMapper;
import customer.supu.po.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import customer.supu.common.utils.DateTimeUtil;
import customer.supu.common.utils.GetTimeUtil;
import customer.supu.common.utils.JavaListSoft;
import customer.supu.common.utils.MapOfDistanceUtil;
import customer.supu.common.utils.SendAiliDaYuMsg;
import customer.supu.common.utils.SpringPropertyResourceReader;
import customer.supu.common.utils.StringUtils;
import customer.supu.dao.CoachDao;
import customer.supu.dao.CoachTimeDao;
import customer.supu.dao.CourseExcGroupDao;
import customer.supu.dao.CourseGroupTimeDao;
import customer.supu.dao.CourseStudioTimeDao;
import customer.supu.dao.EmployeeAppointCourseDao;
import customer.supu.dao.EmployeeBuyCardDao;
import customer.supu.dao.EmployeeBuyCourseDao;
import customer.supu.dao.StoreDao;
import customer.supu.dto.CoachTimeDto;
import customer.supu.dto.CommentDto;
import customer.supu.dto.CourseExcGroupDto;
import customer.supu.dto.CourseStudioTimeDto;
import customer.supu.dto.CourseTimeDto;
import customer.supu.dto.EmployeeBuyCourseDto;
import customer.supu.dto.StoreDto;
import customer.supu.dto.TimeListDto;
import customer.supu.jenum.CoachStatusEnum;
import customer.supu.jenum.CourseAppointStatusEnum;
import customer.supu.jenum.CourseGroupTypeEnum;
import customer.supu.jenum.CourseTypeEnum;
import customer.supu.jenum.DataValidEnum;
import customer.supu.jenum.StoreStatusEnum;
import customer.supu.po.MemberCardExample.Criteria;
import customer.supu.service.CourseService;
import customer.supu.service.F_AboutClassService;
import customer.supu.service.StoreService;

/**
 * 会员约课业务实现类
 *
 * @author Administrator
 */
@Service
public class F_AboutClassServiceImpl implements F_AboutClassService {

    private Logger logger = Logger.getLogger(F_AboutClassServiceImpl.class);

    @Autowired
    private CourseExcGroupDao courseExcGroupDao;

    @Autowired
    private StoreService storeService;

    @Autowired
    private CoachDao coachDao;

    @Autowired
    private StoreDao storeDao;

    @Autowired
    private EmployeeAppointCourseDao employeeAppointCourseDao;

    @Autowired
    private EmployeeBuyCourseDao employeeBuyCourseDao;

    @Autowired
    private CoachTimeDao coachTimeDao;

    @Autowired
    private EmployeeBuyCardDao employeeBuyCardDao;

    @Autowired
    private CourseStudioTimeDao courseStudioTimeDao;

    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseGroupTimeDao courseGroupTimeDao;

    @Autowired
    private CommentMapper commentMapper;


    /**
     * 查询基础团课
     *
     * @param storeId  门店id
     * @param week     星期几  例子：1                                           -------- 暂时无用
     * @param date     日期  例子：2018-01-01                                -------- 暂时无用
     * @param signType 日期顺序标记 例子：0
     * @param start    开始查询第几个    例子：0
     * @param end      sql查询个数  例子：9
     */
    public List<CourseExcGroupDto> selectCourseExcGroup(Integer storeId, String week, String date, Integer start, Integer end, Integer signType) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();


        //根据门店id和类型为  精品团课查询课程id
        //	List<String> courseIds=storeService.selectCourseByStoreId(storeId, CourseTypeEnum.COURSEGROUP.getCode());
        //如果没有值，默认当前日期和星期
        if (!StringUtils.hasText(date) && !StringUtils.hasText(week)) {
            Date d = new Date();
            //获取当前日期  2017-09-18
            String datewithouttime = DateTimeUtil.getDateWithoutTime(d);

            map.put("date", datewithouttime);
            //获取周
            //map.put("week", DateTimeUtil.getDayOfWeek(d));

            map.put("start", start);
            map.put("end", end);
        } else {
            //
            map.put("date", date);
            //获取周
            //map.put("week", week);

            map.put("start", start);
            map.put("end", end);
        }
        map.put("storeId", storeId);

        //区分是否为第一天
        //	map.put("signType", signType);
        List<CourseExcGroupDto> courseExcGroupList = courseExcGroupDao.selectCourseExcGroup(map);

        if(courseExcGroupList != null){
            for(CourseExcGroupDto ceg : courseExcGroupList){
                //评价来源标识：1私教课2团课3门店4私教
                Map<String, Object> stringObjectMap = commentMapper.selectCommentWithStartLevel(2, ceg.getId());
                ceg.setCommentCount(stringObjectMap.get("commentCount") == null ? 0 : Integer.parseInt(stringObjectMap.get("commentCount").toString()));
                ceg.setTotalStar(stringObjectMap.get("totalStar") == null ? 0 : Integer.parseInt(stringObjectMap.get("totalStar").toString()));
            }
        }

        //循环集合
        for (int i = 0; i < courseExcGroupList.size(); i++) {
            CourseExcGroupDto dto = courseExcGroupList.get(i);
            String coachname = getCoachnames(dto.getCoachs());
            if (StringUtils.hasText(coachname)) {
                dto.setCoachnames(coachname);
            } else {
                courseExcGroupList.remove(i);
                i--;
            }

        }
        //获取课程状态
        courseExcGroupList = getAppointStatus(courseExcGroupList, signType);
        return courseExcGroupList;
    }

    //获取课程状态：1可预约  2需排队 3紧张  4不可排队   5未开放（三天内的课程可以预约，第四天的课程状态均为未开放）
    public List<CourseExcGroupDto> getAppointStatus(List<CourseExcGroupDto> dtos, Integer signType) throws ParseException {

        Date d = new Date();
        //当前时间
        String nowTime = d.getHours() + ":" + d.getMinutes();

        if (CollectionUtils.isNotEmpty(dtos)) {

            //j.sort(dtos, "courseStartTime", "asc");
            //超过不能预约
            if (signType > 2) {//	未开放：三天内的课程可以预约，第四天的课程状态均为未开放。

                return dtos;
            }

            for (int i = 0; i < dtos.size(); i++) {
                //获取精品团课对象
                CourseExcGroupDto dto = dtos.get(i);

                //课程开始时间
                //String courseStartTime=dto.getStarthour()+":"+dto.getStartmin();
                String courseStartTime = dto.getStartTime();

                dto.setCourseStartTime(courseStartTime);
                //获取单次排队最多的人数
                Integer people = dto.getPeople();
                //获取最多排队人数
                Integer maxPeople = dto.getMaxpeople();

                //已经排队的人数
                Integer appointcount = dto.getAppointcount();

                //相差的分钟数
                long min = getdifferMin(nowTime, courseStartTime);


                //第一天课程课程出现的情况
                if (signType == 0) {
                    //是否结束

                    //当前是时间    时分   10：30
                    String time = DateTimeUtil.getCurrTime_withoutSec(d);

                    //转换成日期
                    Date d_time = DateTimeUtil.getCurrTime_withoutSec(time);
                    Date end_time = DateTimeUtil.getCurrTime_withoutSec(dto.getEndTime());

                    //如果课程已经结束，则返回已经结束
                    if (end_time.before(d_time)) {
                        dto.setCourseStatus(CourseAppointStatusEnum.END.getCode());
                    } else {

                        //表示课程没有结束，在判断其他状态

                        //判断当前时间是否在课程时间之前
                        Boolean isBefore = nowBeforeCourseStart(nowTime, courseStartTime);
                        //System.out.println(isbefore);
                        //如果当前时间在开始时间之前，且，时间相差30分钟，且已排队人数＜单次可排队人数-5人时状态为可预约
                        if (isBefore && min > 30 && appointcount < (people - 5)) {
                            //可预约
                            dto.setCourseStatus(CourseAppointStatusEnum.RESERVATIONS.getCode());
                        }
                        //当前时间＜课程开始时间-30分钟，且单次可排队人数≤已排队人数＜单次课程最多预约人数时状态为需排队
                        else if (isBefore && min > 30 && (appointcount >= people) && appointcount < maxPeople) {
                            dto.setCourseStatus(CourseAppointStatusEnum.REQQUEUE.getCode());
                        }
                        //当前时间＜课程开始时间-30分钟，且单次可排队人数-5人≤已排队人数＜单次可排队人数时状态为紧张
                        else if (isBefore && min > 30 && appointcount >= (people - 5) && appointcount < maxPeople) {
                            dto.setCourseStatus(CourseAppointStatusEnum.STRAIN.getCode());
                        }
                        //当课程开始时间-30分钟≤当前时间＜课程开始时间，点击排队时提示“临近课程开始时间，不可排队”； 只有展示的第一天会出现这种情况
                        else if (isBefore && min < 30) {
                            //“临近课程开始时间，不可排队
                            dto.setCourseStatus(CourseAppointStatusEnum.NOTQUEUE.getCode());

                        }
                        //当课程开始时间＜开始时间＜结束时间时，点击排队时提示“课程进行中，不可排队” 只有展示的第一天会出现这种情况
                        else if (!isBefore) {
                            dto.setCourseStatus(CourseAppointStatusEnum.NOTUEUEING.getCode());

                        }
                        //人数已经满
                        else if (appointcount >= maxPeople) {
                            dto.setCourseStatus(CourseAppointStatusEnum.FULL.getCode());
                        }
                    }
                } else {
                    //从第二天开始，不需要考虑时间，只需要看人数是否已经满了，所以第二天开始不会出现“临近课程开始时间，不可排队”，“课程进行中，不可排队”等情况

                    //且已排队人数＜单次可排队人数-5人时状态为可预约
                    if (appointcount < (people - 5)) {
                        //可预约
                        dto.setCourseStatus(CourseAppointStatusEnum.RESERVATIONS.getCode());
                    }
                    //单次可排队人数≤已排队人数＜单次课程最多预约人数时状态为需排队
                    else if (appointcount < (people - 5)) {
                        dto.setCourseStatus(CourseAppointStatusEnum.REQQUEUE.getCode());
                    }
                    //单次可排队人数-5人≤已排队人数＜单次可排队人数时状态为紧张
                    else if (appointcount >= (people - 5) && appointcount < maxPeople) {
                        dto.setCourseStatus(CourseAppointStatusEnum.STRAIN.getCode());
                    }
                    //人数已经满
                    else if (appointcount >= maxPeople) {
                        dto.setCourseStatus(CourseAppointStatusEnum.FULL.getCode());
                    }

                }

            }
        }

        return dtos;


    }


    /**
     * 判断当前时间是否在课程时间之前
     *
     * @param nowTime
     * @param
     * @return
     * @throws ParseException
     */
    public boolean nowBeforeCourseStart(String nowTime, String courseStartTime) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date now = format.parse(nowTime);
        Date courseTime = format.parse(courseStartTime);
        if (now.before(courseTime)) {//当前时间在课程时间之前
            return true;
        }
        return false;
    }


    /**
     * 获取相差的分钟数
     *
     * @param dto
     * @return
     * @throws ParseException
     */
    public long getdifferMin(CourseExcGroupDto dto) throws ParseException {
        Date d = new Date();
        //当前时间
        String nowTime = d.getHours() + ":" + d.getMinutes();

        //课程开始时间
        String courseStartTime = dto.getStarthour().toString() + dto.getStartmin().toString();
        //课程开始时间必须在当前时间之前30 分钟


        return getdifferMin(nowTime, courseStartTime);

        //课程开始时间必须在当前时间之前30 分钟
			/*if((date1.before(sim1.parse("2016-11-08 17:00:00")) && date1.after(sim1.parse("2016-11-08 08:00:00")))){

			}*/
    }

    /**
     * 获取时间相差的分钟
     *
     * @return time1: 10:39格式
     * @throws ParseException
     */
    public static long getdifferMin(String nowTime, String courseStartTime) throws ParseException {

        SimpleDateFormat dfs = new SimpleDateFormat("HH:mm");
        Date begin = dfs.parse(nowTime);
        Date end = dfs.parse(courseStartTime);
        long between = (end.getTime() - begin.getTime()) / 1000;//除以1000是为了转换成秒
        long min = between / 60;

        return Math.abs(min);
    }


    /**
     * 获取 星期  日期   日期简写
     */
    @Override
    public List<Map> getDateAndWeek() throws Exception {
        //获取从今天起 以后七天日期
        List<String> getDateList = DateTimeUtil.getDateList(7);
        //创建map集合
        List<Map> maplist = new ArrayList<Map>();
        //循环日期
        for (int i = 0; i < getDateList.size(); i++) {
            //创建map
            Map<String, Object> map = new HashMap<String, Object>();
            if (i == 0) {
                //放入星期
                map.put("week", "今天");
                map.put("numWeek", DateTimeUtil.getWeekDate(DateTimeUtil.getStringToDate(getDateList.get(i))));
            } else {
                //放入星期
                map.put("week", DateTimeUtil.getWeekOfDate(DateTimeUtil.getStringToDate(getDateList.get(i))));
                map.put("numWeek", DateTimeUtil.getWeekDate(DateTimeUtil.getStringToDate(getDateList.get(i))));
            }
            //放入简写日期
            map.put("simpleDate", getDateConnect(getDateList.get(i)));
            //放入日期
            map.put("date", getDateList.get(i));
            //放入集合
            maplist.add(map);
        }
        return maplist;
    }


    /**
     * 简写日期 拼接
     */
    public String getDateConnect(String date) throws Exception {
        //月
        String month = date.substring(5, 7);
        //日
        String day = date.substring(8, 10);

        return month + "." + day;

    }

    /**
     * 根据coachs拼接教练
     *
     * @param coachs
     */
    public String getCoachnames(String coachs) throws Exception {
        StringBuffer buffer = new StringBuffer();
        //String name=getCoachnameById(coachs);
        if (StringUtils.hasText(coachs)) {
            String[] coachId = coachs.split("[,，]");
            for (int i = 0; i < coachId.length; i++) {
                //查询
                String name = getCoachNicknameById(coachId[i]);
                if (StringUtils.hasText(name)) {
                    //拼接coachname
                    buffer.append(name + ",");
                }
            }
            if (StringUtils.hasText(buffer.toString())) {
                return buffer.substring(0, buffer.length() - 1);
            } else {
                return null;
            }
        }
        return null;
    }


    /**
     * 根据coachid查询coachname
     *
     * @param coachid
     */
    public String getCoachNicknameById(String coachid) throws Exception {
        CoachExample example = new CoachExample();
        //给查询条件赋值
        example.createCriteria().andIdEqualTo(Integer.parseInt(coachid)).andStatusEqualTo(CoachStatusEnum.COOPERATION.getCode());
        //查询
        List<Coach> coachs = coachDao.selectByExample(example);
        if (CollectionUtils.isNotEmpty(coachs)) {
            return coachs.get(0).getNickname();
        }
        return null;


    }

    public String getCoachnameById(String coachid) throws Exception {
        CoachExample example = new CoachExample();
        //给查询条件赋值
        example.createCriteria().andIdEqualTo(Integer.parseInt(coachid)).andStatusEqualTo(CoachStatusEnum.COOPERATION.getCode());
        //查询
        List<Coach> coachs = coachDao.selectByExample(example);
        if (CollectionUtils.isNotEmpty(coachs)) {
            return coachs.get(0).getCoachname();
        }
        return null;


    }

    /**
     * 获取所有开业中的门店  计算手机端与门店之间距离
     *
     * @param lng
     * @param lat
     * @return
     */
    public List<StoreDto> sortMinDistance(double lng, double lat, Integer memberCardId) throws Exception {
        //创建map
        Map<String, Object> map = new HashMap<String, Object>();
        if (memberCardId != null) {
            map.put("membercardId", memberCardId);
        }
        //查询所有开业中的门店
        List<StoreDto> storeDtos = storeDao.selectEffectAndPreStore(map);
        //循环获取所有门店

        //double[] latAndLng=map_tx2bd(lat, lng);
        //获取门店地址
        //storeDtos=storeService.getStoresDistance(storeDtos, latAndLng[1], latAndLng[0]);
        storeDtos = storeService.getStoresDistance(storeDtos, lng, lat);
/*		JavaListSoft<StoreDto> sortList=new JavaListSoft<StoreDto>();
		//给storeDtos排序
		sortList.sort(storeDtos, "distance", "asc");*/
        if(storeDtos != null){
            for(StoreDto sd : storeDtos){
                //评价来源标识：1私教课2团课3门店4私教
                Map<String, Object> stringObjectMap = commentMapper.selectCommentWithStartLevel(3, sd.getId());
                sd.setCommentCount(stringObjectMap.get("commentCount") == null ? 0 : Integer.parseInt(stringObjectMap.get("commentCount").toString()));
                sd.setTotalStar(stringObjectMap.get("totalStar") == null ? 0 : Integer.parseInt(stringObjectMap.get("totalStar").toString()));
            }
        }



        return storeDtos;
    }


    /**
     * @param lng     经度
     * @param lat     纬度
     * @param storeid 门店id
     * @return
     * @throws Exception
     */
    public StoreDto getStoreDistance(double lng, double lat, Integer storeid) throws Exception {
        StoreDto storeDto = new StoreDto();
        Store store = storeService.selectStoreById(storeid);
        storeDto.setProvince(store.getProvince());
        storeDto.setCity(store.getCity());
        storeDto.setRegion(store.getRegion());
        //创建map
        Map<String, BigDecimal> dismap = new HashMap<String, BigDecimal>();
        //经度纬度
        dismap = MapOfDistanceUtil.getLatAndLngByAddress(storeService.getdetailAddress(storeDto));
        //计算手机与门店之间距离
        double[] latAndLng = MapOfDistanceUtil.map_tx2bd(lat, lng);
        Double dis = MapOfDistanceUtil.getDistanceFromTwoPoints(dismap.get("lng").doubleValue(), dismap.get("lat").doubleValue(), latAndLng[1], latAndLng[0]) / 1000;
        //保留两位小数
        BigDecimal bg = new BigDecimal(dis);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        //放入对象中
        storeDto.setDistance(f1);
        return storeDto;

    }

    /**
     * 团课约课状态
     * 1.约课
     * 2.排队
     * 4.不能排队
     *
     * @param id 团课id
     * @throws Exception
     */
    public CourseExcGroupDto getQueueStatus(Integer id, Date appointtime) {
        logger.info(" getQueueStatus id=" + id + ",appointtime=" + appointtime  );
        //根据id查询CourseExcGroup
        CourseExcGroup courseExcGroup = courseExcGroupDao.selectByPrimaryKey(id);
        logger.info(" getQueueStatus courseExcGroup=" + JSON.toJSONString(courseExcGroup));
        CourseExcGroupDto courseExcGroupDto = new CourseExcGroupDto();
        //课程名额
        courseExcGroupDto.setPeople(courseExcGroup.getPeople());
        //获取当前已经约课人数
        int alreadyQueuePeo = countAlreadyQueuePeople(id, CourseTypeEnum.COURSEGROUP.getCode(), appointtime);
        courseExcGroupDto.setAppointcount(alreadyQueuePeo);
        //如果当前人数<课程名额  约课
        if (alreadyQueuePeo < courseExcGroup.getPeople()) {
            courseExcGroupDto.setQueueStatus(CourseAppointStatusEnum.RESERVATIONS.getCode());
            logger.info(" getQueueStatus <" );
            return courseExcGroupDto;
        } else if (alreadyQueuePeo >= courseExcGroup.getPeople() && alreadyQueuePeo < courseExcGroup.getMaxpeople()) {//当前人数>=课程名额  && 当前人数<课程名额  排队
            courseExcGroupDto.setQueueStatus(CourseAppointStatusEnum.REQQUEUE.getCode());
            logger.info(" getQueueStatus >= & <" );
            return courseExcGroupDto;
        } else if (alreadyQueuePeo >= courseExcGroup.getMaxpeople()) {//不能排队
            courseExcGroupDto.setQueueStatus(CourseAppointStatusEnum.NOTQUEUE.getCode());
            logger.info(" getQueueStatus >=" );
            return courseExcGroupDto;
        }
        return null;

    }

    /**
     * 返回预约课程数量
     *
     * @param id
     * @param coursetype
     * @return
     * @throws Exception
     */
    public Integer countAlreadyQueuePeople(Integer id, Integer coursetype, Date date){
        //创建查询条件
        EmployeeAppointCourseExample example = new EmployeeAppointCourseExample();
        example.createCriteria().andCourseidEqualTo(id).andTypeEqualTo(coursetype)
                .andAppointtimeEqualTo(date).andStatusEqualTo(DataValidEnum.EFFECT.getCode());
        logger.info(" countAlreadyQueuePeople example=" + JSON.toJSONString(example)  );
        //查询数量
        int count = employeeAppointCourseDao.countByExample(example);
        logger.info(" countAlreadyQueuePeople count=" + count  );
        return count;

    }


    /**
     * 会员进行约课  排队
     */
    public void insertEmployeeAppointCourse(EmployeeAppointCourse employeeAppointCourse, HttpSession session) throws Exception {
        //获取用户账号
        Integer userId = (Integer) session.getAttribute("employeeId");

        if (!isBuyCard(userId)) {
            throw new Exception("2");//表示还没有购买会员卡
        }

        CourseGroupTime cgt = new CourseGroupTime();
        logger.info(" insertEmployeeAppointCourse Appointtime=" + employeeAppointCourse.getAppointtime());
        String appointTime = DateTimeUtil.getDateWithoutTime(employeeAppointCourse.getAppointtime());
        String [] appointTimeArr = appointTime.split("-");
        logger.info(" insertEmployeeAppointCourse appointTimeArr=" + appointTimeArr);
        cgt.setCourseid(employeeAppointCourse.getCourseid());
        cgt.setYear(appointTimeArr[0]);
        cgt.setMonth(appointTimeArr[1]);
        cgt.setDay(appointTimeArr[2]);
        logger.info(" insertEmployeeAppointCourse cgt=" + JSON.toJSONString(cgt));
        CourseGroupTime today = courseGroupTimeDao.selectToDay(cgt);
        logger.info(" insertEmployeeAppointCourse today=" + JSON.toJSONString(today));
        if (today != null) {
            Long cTime = DateTimeUtil.getStringDateToTimeLong(today.getYear() + "-" + today.getMonth() + "-" + today.getDay() + " " + today.getStarttime() + ":00");
            logger.info(" insertEmployeeAppointCourse cTime=" + JSON.toJSONString(cTime));
            long times = cTime - System.currentTimeMillis();
            logger.info(" insertEmployeeAppointCourse times=" + times);
            if (times < 3600000) {
                throw new Exception("79");
            }
        }

        logger.info(" insertEmployeeAppointCourse add"  );
        employeeAppointCourse.setUserid(userId);
        //设为团课
        employeeAppointCourse.setType(CourseTypeEnum.COURSEGROUP.getCode());
        //设置添加时间
        employeeAppointCourse.setAddtime(new Date());
        //预约成功status=1
        employeeAppointCourse.setStatus(DataValidEnum.EFFECT.getCode());
        //是否预约
        isAppointCourse(employeeAppointCourse);

        //查询数据库   人数是否达到最大名额
        CourseExcGroupDto excGroupDto = getQueueStatus(employeeAppointCourse.getCourseid(), employeeAppointCourse.getAppointtime());
        logger.info(" insertEmployeeAppointCourse excGroupDto=" + JSON.toJSONString(excGroupDto));
        if (excGroupDto.getQueueStatus() == 4) {
            throw new Exception("4");//表示不能排队
        } else {
            //插入数据库
            employeeAppointCourseDao.insertSelective(employeeAppointCourse);
        }
    }

    /**
     * 判断会员 是否已经预约或排队
     */
    public void isAppointCourse(EmployeeAppointCourse employeeAppointCourse) throws Exception {
        //创建查询条件
        EmployeeAppointCourseExample example = new EmployeeAppointCourseExample();
        customer.supu.po.EmployeeAppointCourseExample.Criteria contion = example.createCriteria();
        contion.andUseridEqualTo(employeeAppointCourse.getUserid());
        contion.andCourseidEqualTo(employeeAppointCourse.getCourseid());
        contion.andStoreidEqualTo(employeeAppointCourse.getStoreid());
        contion.andAppointtimeEqualTo(employeeAppointCourse.getAppointtime());
        contion.andTypeEqualTo(employeeAppointCourse.getType());
        contion.andStatusEqualTo(DataValidEnum.EFFECT.getCode());
        if (StringUtils.hasText(employeeAppointCourse.getStarttime())) {
            contion.andStarttimeEqualTo(employeeAppointCourse.getStarttime());
        }
        if (StringUtils.hasText(employeeAppointCourse.getEndtime())) {
            contion.andEndtimeEqualTo(employeeAppointCourse.getEndtime());
        }
        //查询
        List<EmployeeAppointCourse> appointCourses = employeeAppointCourseDao.selectByExample(example);
        if (CollectionUtils.isNotEmpty(appointCourses)) {
            throw new Exception("1");//您已经预约
        }
    }

    /**
     * 判断该用户是否过买会员卡
     *
     * @param userId
     * @return
     */
    public boolean isBuyCard(Integer userId) {
/*		EmployeeBuyCourseExample example=new EmployeeBuyCourseExample();
		example.createCriteria().andUseridEqualTo(userId);
		if(employeeBuyCourseDao.countByExample(example)>0){
			return true;
		}
		return false;*/
        EmployeeBuyCardExample example = new EmployeeBuyCardExample();
        //已经买会员卡或者已经到期
        Date d = new Date();
        example.createCriteria().andUseridEqualTo(userId).andExpiretimeGreaterThan(d).andBuytimeLessThanOrEqualTo(d);
        if (employeeBuyCardDao.countByExample(example) > 0) {
            return true;
        }
        return false;

    }


    /**
     * 查询购买表中 会员购买的私教课
     *
     * @param    用户账号
     * @param  课程编号
     */
    public List<EmployeeBuyCourseDto> selectEmployeeBuyCardByList(HttpSession session) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        //获取用户账号
        Integer userId = (Integer) session.getAttribute("employeeId");
        if (null != userId) {

            map.put("userId", userId);
            List<EmployeeBuyCourseDto> buyCourseDtos = employeeBuyCourseDao.selectEmpByCourseByList(map);
            //循环 添加  已经预约私教课次数
            for (int i = 0; i < buyCourseDtos.size(); i++) {

                EmployeeBuyCourseDto courseDto = buyCourseDtos.get(i);

                //判断是否为私教课  体验课，如果是，添加时间超过7天就不显示（即无法在预约）
                if (null != courseDto.getIsexperience() && courseDto.getIsexperience() == 1) {
                    //购买时间+7天
                    Calendar c = Calendar.getInstance();
                    c.setTime(courseDto.getBuytime());
                    c.add(java.util.Calendar.DAY_OF_MONTH, 7);

                    if (c.getTime().before(new Date())) {
                        buyCourseDtos.remove(i);
                        i--;
                        continue;
                    }

                }
                //预约私教课次数
                courseDto.setAppointCount(countAppointmentCourses(courseDto.getCourseid(), userId, CourseTypeEnum.PRICOACH.getCode()));
            }
            return buyCourseDtos;
        } else {
            throw new Exception();
        }


    }

    /**
     * 查询某个用户  已经预约私教课次数  或  工作室课程预约次数
     *
     * @param courseid 私教课id
     * @param
     * @return
     * @throws Exception
     */
    public Integer countAppointmentCourses(Integer courseid, Integer userId, Integer type) throws Exception {
        //创建查询条件
        EmployeeAppointCourseExample example = new EmployeeAppointCourseExample();
        example.createCriteria().andCourseidEqualTo(courseid).andTypeEqualTo(type)
                .andUseridEqualTo(userId).andStatusEqualTo(DataValidEnum.EFFECT.getCode());
        //查询数量
        int count = employeeAppointCourseDao.countByExample(example);

        return count;

    }


    /**
     * 将时间封装
     *
     * @param ()
     */
    public List<TimeListDto> getTimeListChecked() {
        List<String> list = GetTimeUtil.selectTime();
        //创建集合
        List<TimeListDto> timeListDtos = new ArrayList<TimeListDto>();
        //循环
        for (int i = 0; i < list.size(); i++) {
            TimeListDto listDto = new TimeListDto();
            listDto.setTime(list.get(i));
            timeListDtos.add(listDto);
        }
        return timeListDtos;
    }

    /**
     * 如果固定时间在startTime<固定时间<endTime
     *
     * @param
     * @param
     */
    public List<TimeListDto> betweenTimeCheckTrue(List<CoachTime> coachTimes, Integer courseid) throws Exception {
        List<TimeListDto> timeListDtos = getTimeListChecked();
        //判断教练时间段是否为空
        if (CollectionUtils.isEmpty(coachTimes)) {
            return timeListDtos;
        } else {//不为空
            for (int i = 0; i < coachTimes.size(); i++) {
                //循环教练时间段
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
                //开始时间
                Date d1 = dateFormat.parse(coachTimes.get(i).getStarttime());
                Date d2 = dateFormat.parse(coachTimes.get(i).getEndtime());
                //循环时间集合
                for (int j = 0; j < timeListDtos.size(); j++) {

                    Date d3 = dateFormat.parse(timeListDtos.get(j).getTime());

                    //判断是否在开始时间  和  结束时间之间
                    if (d1.getTime() <= d3.getTime() && d2.getTime() - 3600000 >= d3.getTime()) {
                        timeListDtos.get(j).setChecked(true);
                        String date = coachTimes.get(i).getSelectymonth() + "-" + coachTimes.get(i).getDay();
                        EmployeeAppointCourseExample example = new EmployeeAppointCourseExample();
                        example.createCriteria().andCourseidEqualTo(courseid).andTypeEqualTo(CourseTypeEnum.PRICOACH.getCode())
                                .andStarttimeEqualTo(timeListDtos.get(j).getTime()).andStatusEqualTo(DataValidEnum.EFFECT.getCode())
                                .andAppointtimeEqualTo(simpleDateFormat.parse(date));
                        //查询数量
                        int count = employeeAppointCourseDao.countByExample(example);
                        timeListDtos.get(j).setCount(count);
                    }
                }
            }
            return timeListDtos;
        }

    }

//	/**
//	 * 比较    集合中的时间   是否在教练工作时间内
//	 * @param coachTimes
//	 * @return
//	 * @throws Exception
//	 */
//	public List<TimeListDto> checkTrue(List<CoachTime> coachTimes) throws Exception{
//		//创建集合
//		List<TimeListDto> list=new ArrayList<TimeListDto>();
//		if (CollectionUtils.isEmpty(coachTimes)) {
//			getTimeListChecked();
//		}else{
//			for (int i = 0; i < coachTimes.size(); i++) {
//				CoachTime coachTime=coachTimes.get(i);
//				betweenTimeCheckTrue(getTimeListChecked(),coachTime.getStarttime(),coachTime.getEndtime());
//			}
//		}
//		return list;
//	}

    /**
     * 查询教练可以约课时间  集合
     *
     * @param coachid 教练id
     */
    public List<CourseTimeDto> selectEnableAppointCoachTime(Integer coachid, Integer courseid) throws Exception {
        //创建CoachTimeDto集合
        List<CourseTimeDto> dtos = new ArrayList<CourseTimeDto>();
        //获取从今天起 以后七天日期
        List<String> getDateList = DateTimeUtil.getDateList(7);
        for (int i = 0; i < getDateList.size(); i++) {
            //创建查询条件
            CoachTimeExample example = new CoachTimeExample();
            CourseTimeDto courseTimeDto = new CourseTimeDto();
            String date = getDateList.get(i);
            String selectYmonth = getDateList.get(i).substring(0, 7);
            String day = getDateList.get(i).substring(8, 10);
            example.createCriteria().andCoachidEqualTo(coachid).andSelectymonthEqualTo(selectYmonth).andDayEqualTo(day);
            //查询
            List<CoachTime> coachTimes = coachTimeDao.selectByExample(example);
            courseTimeDto.setTimeListDtos(betweenTimeCheckTrue(coachTimes, courseid));
            if (i == 0) {
                checkTrue(courseTimeDto.getTimeListDtos());
                courseTimeDto.setWeek("今天");
            } else {
                courseTimeDto.setWeek(DateTimeUtil.getWeekOfDate(DateTimeUtil.getStringToDate(date)));
            }
            //放入简写日期
            courseTimeDto.setSimpleDte(getDateConnect(date));
            courseTimeDto.setAppointTime(date);
            dtos.add(courseTimeDto);
        }
        return dtos;

    }

    /**
     * 判断今天  能够预约时间是否  已过
     *
     * @param timeListDtos
     * @return
     * @throws Exception
     */
    public List<TimeListDto> checkTrue(List<TimeListDto> timeListDtos) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        //获取当前时间
        String currentTime = DateTimeUtil.getCurrTime(new Date());
        Date d1 = dateFormat.parse(currentTime);
        //循环时间列表
        for (int i = 0; i < timeListDtos.size(); i++) {
            Date d2 = dateFormat.parse(timeListDtos.get(i).getTime());
            if (d2.getTime() <= d1.getTime()) {
                timeListDtos.get(i).setChecked(false);
            }
        }
        return timeListDtos;

    }

    /**
     * 私教课预约
     *
     * @param session
     * @param
     * @return
     * @throws Exception
     */
    public Integer insertEmployeeBuyCourseDto(HttpSession session, EmployeeAppointCourse employeeAppointCourse) throws Exception {
        System.out.println("进入方法insertEmployeeBuyCourseDto：");

        //查询购买的总课数
        Map<String, Object> map = new HashMap<String, Object>();
        //获取用户账号
        Integer userId = (Integer) session.getAttribute("employeeId");
        map.put("userId", userId);
        map.put("courseId", employeeAppointCourse.getCourseid());
        //查询
        List<EmployeeBuyCourseDto> buyCourseDtos = employeeBuyCourseDao.selectEmpByCourseByList(map);

        System.out.println("查询buyCourseDtos=" + buyCourseDtos);

        EmployeeBuyCourseDto buyCourseDto = buyCourseDtos.get(0);
        Integer totalclass = buyCourseDto.getTotalclass();

        //查询已经预约的次数
        Integer appointCount = countAppointmentCourses(employeeAppointCourse.getCourseid(), userId, CourseTypeEnum.PRICOACH.getCode());

        System.out.println("查询已经预约的次数=" + appointCount);
        if (totalclass <= appointCount) {
            System.out.println("您的预约次数超过购买次数=" + appointCount);
            throw new Exception("5");//您的预约次数超过购买次数！
        }
        String starttime = employeeAppointCourse.getStarttime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date d1 = dateFormat.parse(starttime);
        Date endtime = new Date(d1.getTime() + 3000000);
        employeeAppointCourse.setEndtime(dateFormat.format(endtime));
        employeeAppointCourse.setUserid(userId);
        employeeAppointCourse.setType(CourseTypeEnum.PRICOACH.getCode());
        //判断是否在  这个日期   这个时间段  已经预约这节课
        isAppointCourse(employeeAppointCourse);
        System.out.println("判断是否在  这个日期   这个时间段  已经预约这节课");
        //预约，插入数据库
        Integer id = insertPriAppointCourse(userId, employeeAppointCourse);
        System.out.println("预约，插入数据库");
        System.out.println("msg=" + SpringPropertyResourceReader.getProperty("appoint.course.msg"));
        //预约成功，拼接短信内容
        String message = new String(SpringPropertyResourceReader.getProperty("appoint.course.msg").getBytes("ISO8859-1"), "utf-8");
        System.out.println("message=" + message);
        String content = MessageFormat.format(message, session.getAttribute("username"), buyCourseDto.getCoursename());
        System.out.println("content=" + content);
        System.out.println("发送短信=" + content);
        //发送短信
        //SendAiliDaYuMsg.send(null, buyCourseDto.getPhonenumber(), "SMS_105885089", buyCourseDto.getCoachname(),(String)session.getAttribute("username"));
        SendAiliDaYuMsg.send(null, buyCourseDto.getPhonenumber(), "SMS_105885089", buyCourseDto.getCoachname(), (String) session.getAttribute("username"), 1, null, null);
        return id;

    }

    /**
     * 将要在预约成功页面展示的数据
     *
     * @param session
     * @param employeeAppointCourse
     * @return
     * @throws Exception
     */
    public EmployeeBuyCourseDto getAppointCountAndEndTime(HttpSession session, EmployeeAppointCourse employeeAppointCourse) throws Exception {
        //查询购买的总课数
        Map<String, Object> map = new HashMap<String, Object>();
        //获取用户账号
        Integer userId = (Integer) session.getAttribute("employeeId");
        map.put("userId", userId);
        map.put("courseId", employeeAppointCourse.getCourseid());
        //查询
        List<EmployeeBuyCourseDto> buyCourseDtos = employeeBuyCourseDao.selectEmpByCourseByList(map);
        Integer totalclass = buyCourseDtos.get(0).getTotalclass();
        //再次查询已经预约的次数
        Integer againCount = countAppointmentCourses(employeeAppointCourse.getCourseid(), userId, CourseTypeEnum.PRICOACH.getCode());
        EmployeeBuyCourseDto buyCourseDto = new EmployeeBuyCourseDto();
        //放入约课次数
        buyCourseDto.setAppointCount(againCount);
        //放入总课数
        buyCourseDto.setTotalclass(totalclass);
        //放入结束时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date d1 = dateFormat.parse(employeeAppointCourse.getStarttime());
        Date endtime = new Date(d1.getTime() + 3000000);
        buyCourseDto.setEndtime(dateFormat.format(endtime));
        return buyCourseDto;

    }

    /**
     * 预约私教课  插入数据库
     *
     * @param userId                用户账号
     * @param employeeAppointCourse
     * @throws Exception
     */
    public Integer insertPriAppointCourse(Integer userId, EmployeeAppointCourse employeeAppointCourse) throws Exception {
        employeeAppointCourse.setUserid(userId);
        //私教课type=0
        employeeAppointCourse.setType(CourseTypeEnum.PRICOACH.getCode());
        //新增  预约  时间
        employeeAppointCourse.setAddtime(new Date());
        //预约成功status=1
        employeeAppointCourse.setStatus(DataValidEnum.EFFECT.getCode());
        //employeeAppointCourse.setAppointtime(new Date());
        //插入数据库
        employeeAppointCourseDao.insertSelective(employeeAppointCourse);

        return employeeAppointCourse.getId();
    }


    /**
     * 取消预约
     *
     * @param id 预约id
     * @throws Exception
     */
    public void cancelAppointCourse(HttpSession session, Integer id) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        //获取用户账号
        Integer userId = (Integer) session.getAttribute("employeeId");
        map.put("userId", userId);
        //查询已经预约课程
        EmployeeAppointCourse appCourse = employeeAppointCourseDao.selectByPrimaryKey(id);
        if (null != appCourse) {
            map.put("courseId", appCourse.getCourseid());
            Date appointTime = appCourse.getAppointtime();
            String appontwithoutTime = DateTimeUtil.getDateWithoutTime(appointTime);


            String str_start_appTime = appontwithoutTime + " " + appCourse.getStarttime() + ":00";
            Date date_startappointTime = DateTimeUtil.getStringToDate(str_start_appTime);

            Date d = new Date();
            //还没有开始  ， 且相差2小时
		/*	if(d.before(date_startappointTime)&& (differhour(d, date_startappointTime))<2){
					throw new Exception("两小时之内，不能取消预约");
			}*/

            //在课程开始时间之后
            if (d.after(date_startappointTime)) {
                throw new Exception("已经开始不能取消预约");
            }
        } else {
            throw new Exception("找不到该数据");
        }
        //employeeAppointCourseDao.deleteByPrimaryKey(id);
        appCourse.setStatus(DataValidEnum.NO_EFFECT.getCode());
        employeeAppointCourseDao.updateByPrimaryKeySelective(appCourse);

        //0:私教课  1：基础团课  2工作室
        Integer type = appCourse.getType();


        map.put("type", type);

        //查询
        List<EmployeeBuyCourseDto> buyCourseDtos = employeeBuyCourseDao.selectEmpByCourseByList(map);
        EmployeeBuyCourseDto buyCourseDto = buyCourseDtos.get(0);
        //预约成功，拼接短信内容
        //String message=SpringPropertyResourceReader.getProperty("appoint.course.msg");
	/*	String message=new String(SpringPropertyResourceReader.getProperty("cancel.course.msg").getBytes("ISO8859-1"),"utf-8");
		String content=MessageFormat.format(message,session.getAttribute("username"),buyCourseDto.getCoursename());*/
        //发送短信:取消预约
        //SendAiliDaYuMsg.send(content, buyCourseDto.getPhonenumber(),"SMS_105915054",null,null);buyCourseDto.getPhonenumber()
        //SendAiliDaYuMsg.send(null, buyCourseDto.getPhonenumber(), "SMS_105915054", buyCourseDto.getCoachname(),(String)session.getAttribute("username"));

        if (type == 0) {//私教课
            SendAiliDaYuMsg.send(null, buyCourseDto.getPhonenumber(), "SMS_105915054", buyCourseDto.getCoachname(), (String) session.getAttribute("username"), 1, null, null);
        } else if (type == 2) {//工作室模板
            SendAiliDaYuMsg.send(null, buyCourseDto.getPhonenumber(), "SMS_109355331",
                    null, (String) session.getAttribute("username"), 2, buyCourseDto.getCoursename(), DateTimeUtil.getDateWithoutTime(appCourse.getAppointtime()) + " " + appCourse.getStarttime() + "~" + appCourse.getEndtime());


        }
    }


    public int differhour(Date d1, Date d2) {
        long a = d1.getTime();
        long b = d2.getTime();
        int c = (int) ((a - b) / (1000 * 60 * 60));
        return Math.abs(c);
    }

    /**
     * 该课程等是否开放  （超过三天的课程默认不开放）
     *
     * @param courseStartDate
     * @return
     * @throws ParseException
     */
    public boolean isOpen(Date courseStartDate) throws ParseException {
        Date nowDate = new Date();
        Integer days = DateTimeUtil.daysBetween(nowDate, courseStartDate);
        if (days >= 3) {
            return false;
        }
        return true;
    }


    /**
     * 查询购买表中 会员购买的工作室课程
     *
     * @param userId   用户账号
     * @param courseId 课程编号
     */
    public List<EmployeeBuyCourseDto> selectStudioCourseList(HttpSession session) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        //获取用户账号
        Integer userId = (Integer) session.getAttribute("employeeId");
        if (null != userId) {

            map.put("userId", userId);
            List<EmployeeBuyCourseDto> buyCourseDtos = employeeBuyCourseDao.selectAllStudioCourseBuy(map);
            //循环 添加  已经预约私教课次数
            for (int i = 0; i < buyCourseDtos.size(); i++) {

                EmployeeBuyCourseDto courseDto = buyCourseDtos.get(i);
                //预约私教课次数
                courseDto.setAppointCount(countAppointmentCourses(courseDto.getCourseid(), userId, CourseTypeEnum.STUDIO.getCode()));
            }
            return buyCourseDtos;
        } else {
            throw new Exception();
        }


    }

    /**
     * 根据课程id查询是否存在此工作室课程
     *
     * @return
     * @throws Exception
     */
    public List<CourseExcGroupDto> isExistStudioCourse(Integer courseid) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("courseid", courseid);
        //查询
        List<CourseExcGroupDto> groupDtos = courseExcGroupDao.selectExistCourseGroup(map);

        return groupDtos;
    }

    /**
     * 查询教练可以约课时间  集合
     *
     * @param coachid 教练id
     */
    public List<CourseTimeDto> selectEnableAppointStudioTime(Integer courseid) throws Exception {
        //创建CoachTimeDto集合
        List<CourseTimeDto> dtos = new ArrayList<CourseTimeDto>();
        //获取从今天起 以后七天日期
        List<String> getDateList = DateTimeUtil.getDateList(7);
        for (int i = 0; i < getDateList.size(); i++) {
            //创建查询条件
            CourseStudioTimeExample example = new CourseStudioTimeExample();
            CourseTimeDto courseTimeDto = new CourseTimeDto();
            String date = getDateList.get(i);
            example.createCriteria().andYearEqualTo(date.split("-")[0]).andMonthEqualTo(date.split("-")[1])
                    .andDayEqualTo(date.split("-")[2]).andCourseidEqualTo(courseid);
            //查询某一天
            List<CourseStudioTime> courseStudioTimes = courseStudioTimeDao.selectByExample(example);
            List<CourseStudioTimeDto> courseStudioTimeDtos = new ArrayList<CourseStudioTimeDto>();
            if (CollectionUtils.isNotEmpty(courseStudioTimes)) {
                for (int j = 0; j < courseStudioTimes.size(); j++) {
                    CourseStudioTime courseStudioTime = courseStudioTimes.get(j);
                    CourseStudioTimeDto timeDto = new CourseStudioTimeDto();
                    //赋值
                    timeDto.setStarttime(courseStudioTime.getStarttime());
                    timeDto.setEndtime(courseStudioTime.getEndtime());
                    timeDto.setClasshour(courseStudioTime.getClasshour());
                    //放入集合中
                    courseStudioTimeDtos.add(timeDto);
                }
            }
            //将工作室课程排期集合放入对象中
            courseTimeDto.setCourseStudioTimeDtos(courseStudioTimeDtos);
            if (i == 0) {
                checkFalse(courseTimeDto.getCourseStudioTimeDtos());
                courseTimeDto.setWeek("今天");
            } else {
                courseTimeDto.setWeek(DateTimeUtil.getWeekOfDate(DateTimeUtil.getStringToDate(date)));
            }
            //放入简写日期
            courseTimeDto.setSimpleDte(getDateConnect(date));
            courseTimeDto.setAppointTime(date);
            dtos.add(courseTimeDto);
        }
        return dtos;

    }


    /**
     * 判断今天  能够预约时间是否  已过
     *
     * @param timeListDtos
     * @return
     * @throws Exception
     */
    public List<CourseStudioTimeDto> checkFalse(List<CourseStudioTimeDto> studioTimeDtos) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        //获取当前时间
        String currentTime = DateTimeUtil.getCurrTime(new Date());
        Date d1 = dateFormat.parse(currentTime);
        //循环时间列表
        for (int i = 0; i < studioTimeDtos.size(); i++) {
            Date d2 = dateFormat.parse(studioTimeDtos.get(i).getStarttime());
            if (d2.getTime() <= d1.getTime()) {
                studioTimeDtos.get(i).setChecked(false);
            }
        }
        return studioTimeDtos;

    }


    /**
     * 用户进行预约操作(工作室)
     * (1)购买次数和预约次数的比较
     * (2)是否预约过相同时间段的课程
     * (3)预约某节课是判断 当前预约人数是否已满
     *
     * @param session
     * @param courseTimeDto
     * @throws Exception
     */
    @Transactional(rollbackFor = Throwable.class)
    public void insertAppointStudioCourse(HttpSession session, CourseTimeDto courseTimeDto) throws Exception {
        //查询购买的总课数
        Map<String, Object> map = new HashMap<String, Object>();
        //获取用户账号
        Integer userId = (Integer) session.getAttribute("employeeId");
        map.put("userId", userId);
        map.put("courseId", courseTimeDto.getCourseid());
        //查询
        List<EmployeeBuyCourseDto> buyCourseDtos = employeeBuyCourseDao.selectAllStudioCourseBuy(map);

        EmployeeBuyCourseDto buyCourseDto = buyCourseDtos.get(0);
        //获取购买工作室课程的   总课数
        Integer totalclass = buyCourseDto.getTotalclass();

        //查询已经预约的次数
        Integer appointCount = countAppointmentCourses(courseTimeDto.getCourseid(), userId, CourseTypeEnum.STUDIO.getCode());
        int nowcount = 0;

        List<EmployeeAppointCourse> employee_appointCourse = courseTimeDto.getEmployeeAppointCourses();
        if (CollectionUtils.isNotEmpty(employee_appointCourse)) {
            //循环判断开始时间  和 结束 时间是否为空
            for (int i = 0; i < employee_appointCourse.size(); i++) {
                EmployeeAppointCourse employeeAppointCourse = employee_appointCourse.get(i);
                if (StringUtils.hasText(employeeAppointCourse.getStarttime()) && StringUtils.hasText(employeeAppointCourse.getEndtime())) {
                    isAppointedStudio(employeeAppointCourse, userId);
                    //将满足条件的预约课程插入数据库
                    insertAppointStuCourse(employeeAppointCourse, userId);
                    nowcount++;
                } else {
                    employee_appointCourse.remove(i);
                    i--;
                }
            }
        }
        //如果appointCount+此次要预约的课数>totalclass(总课数)   抛异常
        if (appointCount + nowcount > totalclass) {
            throw new Exception("您的预约次数超过购买次数");//您的预约次数超过购买次数！
        }
        //是否约过相同时间的课程
        //预约此课程人数是否已满
        //将满足条件的预约课程插入数据库
        //isAbleStudioCourse(employee_appointCourse, userId);
        if (CollectionUtils.isNotEmpty(employee_appointCourse)) {
            //循环判断开始时间  和 结束 时间是否为空
            for (int i = 0; i < employee_appointCourse.size(); i++) {
                EmployeeAppointCourse appointCourse = employee_appointCourse.get(i);
                SendAiliDaYuMsg.send(null, buyCourseDto.getPhonenumber(), "SMS_109380295",
                        null, (String) session.getAttribute("username"), 2, buyCourseDto.getCoursename(), DateTimeUtil.getDateWithoutTime(appointCourse.getAppointtime()) + " " + appointCourse.getStarttime() + "~" + appointCourse.getEndtime());
            }
        }


    }

    /**
     * 过滤满足条件的预约 工作室课程  并插入数据库
     * @param studioTimeDtos
     * @param userId
     * @throws Exception
     */
    //public void isAbleStudioCourse(List<EmployeeAppointCourse> appointCourses,Integer userId) throws Exception{

    //判断集合不为空
	/*	if (CollectionUtils.isNotEmpty(appointCourses)) {
			//循环判断开始时间  和 结束 时间是否为空
			for (int i = 0; i < appointCourses.size(); i++) {
				EmployeeAppointCourse employeeAppointCourse=appointCourses.get(i);
				if (StringUtils.hasText(employeeAppointCourse.getStarttime()) && StringUtils.hasText(employeeAppointCourse.getEndtime())) {
					//是否约过相同时间的课程
					//预约此课程人数是否已满
					isAppointedStudio(employeeAppointCourse, userId);
					//将满足条件的预约课程插入数据库
					insertAppointStuCourse(employeeAppointCourse, userId);
				}
			}
		}*/
    //}

    /**
     * 判断是否预约过相同时间段的工作是课程
     *
     * @param courseStudioTimeDto
     * @return
     * @throws Exception
     */
    public void isAppointedStudio(EmployeeAppointCourse appointCourse, Integer userId) throws Exception {
        //创建查询条件
        EmployeeAppointCourseExample example = new EmployeeAppointCourseExample();
        customer.supu.po.EmployeeAppointCourseExample.Criteria contion = example.createCriteria();
        contion.andAppointtimeEqualTo(appointCourse.getAppointtime());
        contion.andStarttimeEqualTo(appointCourse.getStarttime());
        contion.andEndtimeEqualTo(appointCourse.getEndtime());
        contion.andCourseidEqualTo(appointCourse.getCourseid());
        contion.andTypeEqualTo(CourseTypeEnum.STUDIO.getCode());
        contion.andStatusEqualTo(DataValidEnum.EFFECT.getCode());
        String appointtime = DateTimeUtil.getDateWithoutTime(appointCourse.getAppointtime());
        //预约此时间段工作室 课程的总人数
        Integer count = employeeAppointCourseDao.countByExample(example);
        CourseExcGroupWithBLOBs excGroupWithBLOBs = courseService.selectCourseGroupById(appointCourse.getCourseid(), CourseGroupTypeEnum.STUDIO.getCode());

        //判断预约此课程人数是否已满
        if (count >= excGroupWithBLOBs.getMaxpeople()) {
            throw new Exception("" + appointtime + " " + appointCourse.getStarttime() + "~" + appointCourse.getEndtime() + "的课程预约人数已满");
        }
        if (null != userId) {
            contion.andUseridEqualTo(userId);
        }
        //查询
        List<EmployeeAppointCourse> appointCourses = employeeAppointCourseDao.selectByExample(example);
        //如果集合不为空   则已经预约过相同课程
        if (CollectionUtils.isNotEmpty(appointCourses)) {
            throw new Exception("时间段" + appointtime + " " + appointCourse.getStarttime() + "~" + appointCourse.getEndtime() + "的课程已经预约");
        }
    }


    /**
     * 将符合条件预约课程插入数据库
     *
     * @param timeDto
     * @throws Exception
     */
    public void insertAppointStuCourse(EmployeeAppointCourse appointCourse, Integer userId) throws Exception {
        appointCourse.setUserid(userId);
        //工作室type=2
        appointCourse.setType(CourseTypeEnum.STUDIO.getCode());
        //新增  预约  时间
        appointCourse.setAddtime(new Date());
        //预约成功status=1
        appointCourse.setStatus(DataValidEnum.EFFECT.getCode());
        //插入数据库
        employeeAppointCourseDao.insertSelective(appointCourse);

    }

    /**
     * 在预约成功后,返回开始时间和结束时间不为空的   预约时间集合
     *
     * @param appointCourses
     * @return
     * @throws Exception
     */
    public List<EmployeeAppointCourse> getAppointSuccessStudio(List<EmployeeAppointCourse> appointCourses) throws Exception {
        if (CollectionUtils.isNotEmpty(appointCourses)) {
            for (int i = 0; i < appointCourses.size(); i++) {
                EmployeeAppointCourse employeeAppointCourse = appointCourses.get(i);
                //判断开始时间和结束时间是否为空
                if (!StringUtils.hasText(employeeAppointCourse.getStarttime()) && !StringUtils.hasText(employeeAppointCourse.getEndtime())) {
                    appointCourses.remove(i);
                    i--;
                }
            }
        }
        return appointCourses;
    }


    /**
     * 查询购买表中 会员购买的训练营课程
     *
     * @param userId   用户账号
     * @param courseId 课程编号
     */
    public List<EmployeeBuyCourseDto> selectCourseGroupList(HttpSession session) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        //获取用户账号
        Integer userId = (Integer) session.getAttribute("employeeId");
        if (null != userId) {

            map.put("userId", userId);
            List<EmployeeBuyCourseDto> buyCourseDtos = employeeBuyCourseDao.selectAllGroupCourseBuy(map);
            //循环 添加  已经预约私教课次数
            for (int i = 0; i < buyCourseDtos.size(); i++) {

                EmployeeBuyCourseDto courseDto = buyCourseDtos.get(i);
                //预约私教课次数
                courseDto.setAppointCount(countAppointmentCourses(courseDto.getCourseid(), userId, CourseTypeEnum.STUDIO.getCode()));
            }
            return buyCourseDtos;
        } else {
            throw new Exception();
        }


    }


}
