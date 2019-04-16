package customer.supu.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import customer.supu.dao.*;
import customer.supu.domain.CoachBean;
import customer.supu.domain.CoursePriCoachBean;
import customer.supu.domain.StoreBean;
import customer.supu.mapper.CommentMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Timed;
import org.springframework.transaction.annotation.Transactional;

import com.aliyun.oss.common.utils.DateUtil;

import customer.supu.common.po.Page;
import customer.supu.common.po.PageResponse;
import customer.supu.common.utils.DateTimeUtil;
import customer.supu.common.utils.StringUtils;

import customer.supu.dto.CourseAllDto;
import customer.supu.dto.CourseDes;
import customer.supu.dto.CourseExcGroupDto;
import customer.supu.dto.CourseExcTimeDto;
import customer.supu.dto.CourseExcTimeWeekDto;
import customer.supu.dto.CourseGroupTimeDto;
import customer.supu.dto.CourseStudioTimeDto;
import customer.supu.dto.CourseStudioTimeAddDto;
import customer.supu.dto.CourseStudioTimeShowDto;


import customer.supu.dto.CourseDto;

import customer.supu.jenum.CourseTypeEnum;
import customer.supu.jenum.DataValidEnum;


import customer.supu.po.CourseExcGroup;
import customer.supu.po.CourseExcGroupWithBLOBs;
import customer.supu.po.CoursePriCoach;

import customer.supu.po.CourseCoach;
import customer.supu.po.CourseCoachExample;
import customer.supu.po.CourseExcGroupExample;
import customer.supu.po.CourseExcTime;
import customer.supu.po.CourseExcTimeExample;
import customer.supu.po.CourseGroupTime;
import customer.supu.po.CourseGroupTimeExample;
import customer.supu.po.CoursePriCoachExample;
import customer.supu.po.CourseStores;
import customer.supu.po.CourseStoresExample;
import customer.supu.po.CourseStudioTime;
import customer.supu.po.CourseStudioTimeExample;
import customer.supu.po.CourseStudioTimeExample.Criteria;
import customer.supu.po.EmployeeBuyCourse;
import customer.supu.po.EmployeeBuyCourseExample;


import customer.supu.service.CourseService;
import customer.supu.service.F_AboutClassService;

/**
 * 课程管理业务实现类
 *
 * @author Administrator
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private StoreDao storeDao;

    @Autowired
    private CoursePriCoachDao coursePriCoachDao;


    @Autowired
    private CourseExcGroupDao coursExcGroupDao;


    @Autowired
    private CourseStoresDao courseStoresDao;


    @Autowired
    private CourseExcGroupDao courseExcGroupDao;


    @Autowired
    private CourseCoachDao courseCoachDao;

    @Autowired
    private EmployeeBuyCourseDao employeeBuyCourseDao;

    @Autowired
    private F_AboutClassService aboutClassService;


    @Autowired
    private CourseGroupTimeDao courseGroupTimeDao;


    @Autowired
    private CourseExcTimeDao courseExcTimeDao;


    @Autowired
    private CourseStudioTimeDao courseStudioTimeDao;

    @Autowired
    private CommentMapper commentMapper;


    /**
     * 查询所有课程
     *
     * @param page
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public PageResponse selectAllByList(Page page, CourseDto courseDto) throws Exception {
        PageResponse pageResponse = new PageResponse();
        Map<String, Object> map = new HashMap<String, Object>();
        //如果名称不为空
        if (StringUtils.hasText(courseDto.getCoursename())) {
            map.put("coursename", courseDto.getCoursename());
        }
        //如果课程状态不为空
        if (courseDto.getStatus() != null) {
            map.put("status", new String[]{courseDto.getStatus().toString()});
        } else {
            map.put("status", new String[]{"1", "2"});
        }
        //如果课程类型不为空
        if (courseDto.getCoursetype() != null) {
            if (courseDto.getCoursetype() == 2 || courseDto.getCoursetype() == 3) {
                map.put("coursetype", 1);
            } else {
                map.put("coursetype", courseDto.getCoursetype());
            }
            //私教课
            if (courseDto.getCoursetype() == 0) {

            } else {
                map.put("type", courseDto.getCoursetype());
            }
        }

        map.put("start", Integer.valueOf(page.getOffset()));
        map.put("end", Integer.valueOf(page.getLimit()));
        //总数
        int count = courseDao.countByList(map);
        //查询
        List<CourseDto> courseDtos = courseDao.selectCourseByList(map);
        for (int i = 0; i < courseDtos.size(); i++) {
            CourseDto dto = courseDtos.get(i);
            String coachname = getCochAllNames(dto.getCoachs());
            if (StringUtils.hasText(coachname)) {
                dto.setCoachname(coachname);
            }

        }
        pageResponse.setRecords(courseDtos);
        pageResponse.setTotal(count);
        return pageResponse;
    }


    /**
     * 保存添加
     *
     * @param type 0：私教课  1：团课
     * @param
     * @param
     * @throws Exception
     */
    @Transactional(rollbackFor = Throwable.class)
    public void addSave(String type, CourseAllDto courseAllDto) throws Exception {
        Date d = new Date();
        if ("0".equals(type)) {//私教

            CoursePriCoach coursePriCoach = courseAllDto.getCoursePriCoach();

            //添加时间
            coursePriCoach.setAddtime(d);
            //类型精品团课
            coursePriCoach.setCoursetype(CourseTypeEnum.PRICOACH.getCode());
            //有效
            coursePriCoach.setStatus(DataValidEnum.EFFECT.getCode());
            coursePriCoach.setCourseEndTime(DateTimeUtil.getStringDateToTimeLong(coursePriCoach.getCourseEndTimeStr()));
            coursePriCoachDao.insertSelective(coursePriCoach);

            //添加课程教练表  type 0：私教课  1：团课  ，课程id,教练
            addCourseCoach(type, coursePriCoach.getId(), coursePriCoach.getCoachs(), coursePriCoach.getPrice(), coursePriCoach.getOrderNum());

            //添加课程门店表  type 0：私教课  1：团课  ，       课程id,        门店id
            addCourseStores(type, coursePriCoach.getId(), coursePriCoach.getStores());

        } else if ("1".equals(type)) {//团课

            CourseExcGroupWithBLOBs courseExcGroup = courseAllDto.getCourseExcGroup();

            //获取精品课程标签
            courseExcGroup.setCoursedes(getCourseDes(courseAllDto.getCourseDes()));

            //添加时间
            courseExcGroup.setAddtime(d);
            //类型私教
            courseExcGroup.setCoursetype(CourseTypeEnum.COURSEGROUP.getCode());

            //有效
            courseExcGroup.setStatus(DataValidEnum.EFFECT.getCode());

            coursExcGroupDao.insertSelective(courseExcGroup);

            //添加课程教练表  type 0：私教课  1：团课  ，课程id,教练
            addCourseCoach(type, courseExcGroup.getId(), courseExcGroup.getCoachs(), null, null);

            //添加课程门店表  type 0：私教课  1：团课  ，       课程id,        门店id
            addCourseStores(type, courseExcGroup.getId(), courseExcGroup.getStores());

        } else if ("2".equals(type)) {//工作室
            CourseExcGroupWithBLOBs courseExcGroup = courseAllDto.getCourseExcGroup();


            //添加时间
            courseExcGroup.setAddtime(d);
            //类型  工作室 默认为团课    coursetype=团课   通过type来区分团课还是工作室
            courseExcGroup.setCoursetype(CourseTypeEnum.COURSEGROUP.getCode());

            //有效
            courseExcGroup.setStatus(DataValidEnum.EFFECT.getCode());

            coursExcGroupDao.insertSelective(courseExcGroup);

            //添加课程教练表  type 0：私教课  1：团课    2工作室，课程id,教练
            addCourseCoach(type, courseExcGroup.getId(), courseExcGroup.getCoachs(), null, null);

            //添加课程门店表  type 0：私教课  1：团课  ， 2工作室      课程id,        门店id
            addCourseStores(type, courseExcGroup.getId(), courseExcGroup.getStores());
        }


    }

    /**
     * 添加课程 门店中间表
     *
     * @param type      0：代表私教  1：团课   2工作室
     * @param courseId  课程id
     * @param storesIds 门店id
     */
    public void addCourseStores(String type, Integer courseId, String storesIds) {
        if (StringUtils.hasText(storesIds)) {
            String[] storesId = storesIds.split("[,，]");
            if (null != storesId) {

                for (int i = 0; i < storesId.length; i++) {
                    CourseStores record = new CourseStores();

                    //门店id
                    record.setStoreid(Integer.valueOf(storesId[i]));

                    //状态有效
                    record.setStatus(DataValidEnum.EFFECT.getCode());

                    //type 0：代表私教  1：电表精品团课
                    record.setType(Integer.valueOf(type));

                    //课程id
                    record.setCourseid(courseId);
                    courseStoresDao.insertSelective(record);
                }
            }

        }
    }


    /**
     * 删除课程门店关联表
     *
     * @param courseId
     * @param type     0：私教课   1：奖品团课
     */
    public void deleteCourseStoreByCourseId(Integer courseId, Integer type) {
        CourseStoresExample example = new CourseStoresExample();
        example.createCriteria().andCourseidEqualTo(courseId).andTypeEqualTo(type);
        courseStoresDao.deleteByExample(example);

    }

    /**
     * 添加课程  教练中间表
     *
     * @param type     0：代表私教  1：电表精品团课  2工作室
     * @param courseId 课程id
     * @param coachIds 教练id
     */
    public void addCourseCoach(String type, Integer courseId, String coachIds, String prices, String orders) {
        if (StringUtils.hasText(coachIds)) {
            String[] coachId = coachIds.split("[,，]");
            String[] orderArr = null;
            if (orders != null) {
                orderArr = orders.split(",");
                orderArr = this.transToArr(orderArr);
            }
            String[] priceArr = null;
            if (prices != null) {
                priceArr = prices.split(",");
                priceArr = this.transToArr(priceArr);
            }

            if (null != coachId) {

                for (int i = 0; i < coachId.length; i++) {
                    CourseCoach record = new CourseCoach();

                    //教练id
                    record.setCoachid(Integer.valueOf(coachId[i]));

                    //状态有效
                    record.setStatus(DataValidEnum.EFFECT.getCode());

                    //type 0：代表私教  1：电表精品团课
                    record.setType(Integer.valueOf(type));

                    //课程id
                    record.setCourseid(courseId);
                    if (orderArr != null) {
                        record.setOrderNum(Integer.parseInt(orderArr[i]));
                    }
                    if (priceArr != null) {
                        record.setPrice(Integer.parseInt(priceArr[i]));
                    }

                    courseCoachDao.insertSelective(record);
                }
            }
        }

    }


    /**
     * 将课题标签  的list  装换成string存入库中
     *
     * @param
     * @return
     */
    public String getCourseDes(List<CourseDes> courseDesList) {
        StringBuffer buffer = new StringBuffer();
        if (CollectionUtils.isNotEmpty(courseDesList)) {
            for (int i = 0; i < courseDesList.size(); i++) {
                //获取单个标签
                CourseDes courseDes = courseDesList.get(i);

                if (null != courseDes && StringUtils.hasText(courseDes.getName())) {
                    //加载到buffer上，并用逗号隔开
                    buffer.append(courseDes.getName() + ",");
                }

            }
            //截取标签
            buffer.substring(0, buffer.length() - 1);
        }
        return buffer.toString();
    }


    /**
     * @param type         type 0：私教课  1：精品团课  2；工作室
     * @param courseAllDto 课程
     * @throws Exception
     */
    @Transactional(rollbackFor = Throwable.class)
    public void editSave(String type, CourseAllDto courseAllDto) throws Exception {
        if ("0".equals(type)) {//私教

            CoursePriCoach upd_coursePriCoach = courseAllDto.getCoursePriCoach();
            if (upd_coursePriCoach.getId() == null && upd_coursePriCoach.getId() <= 0) {

                throw new Exception("数据无法修改");
            }
            //根据私教id查询
            CoursePriCoach before_coursePriCoach = coursePriCoachDao.selectByPrimaryKey(upd_coursePriCoach.getId());
            if (before_coursePriCoach == null) {
                throw new Exception("找不到该数据");
            }
            //更新私教内容
            UpdCoursePriCoach(before_coursePriCoach, upd_coursePriCoach);

            //如果教练不等与数据库值（已经修改过），就更新表
            //if (!before_coursePriCoach.getCoachs().equals(upd_coursePriCoach.getCoachs())) {
                //删除课程教练中间表
                delCourseCoachByCourseId(Integer.valueOf(type), before_coursePriCoach.getId());
                //添加课程中间表
                addCourseCoach(type, before_coursePriCoach.getId(), upd_coursePriCoach.getCoachs(), upd_coursePriCoach.getPrice(), upd_coursePriCoach.getOrderNum());
            //}
            //如果门店不等（已经修改过），就更新表
            if (!before_coursePriCoach.getStores().equals(upd_coursePriCoach.getStores())) {
                //删除课程门店
                deleteCourseStoreByCourseId(before_coursePriCoach.getId(), CourseTypeEnum.PRICOACH.getCode());

                //添加课程门店表  type 0：私教课  1：精品团课  ，       课程id,        门店id
                addCourseStores(type, before_coursePriCoach.getId(), before_coursePriCoach.getStores());
            }

        } else if ("1".equals(type) || "2".equals(type)) {//1:精品团课    2:工作室
            CourseExcGroupWithBLOBs upd_courseExcGroup = courseAllDto.getCourseExcGroup();
            if (upd_courseExcGroup.getId() == null && upd_courseExcGroup.getId() <= 0) {

                throw new Exception("数据无法修改");
            }

            CourseExcGroupWithBLOBs before_courseExcGroup = coursExcGroupDao.selectByPrimaryKey(upd_courseExcGroup.getId());
            if (before_courseExcGroup == null) {
                throw new Exception("找不到该数据");
            }
            //更新精品团课
            UpdCourseExcGroup(before_courseExcGroup, upd_courseExcGroup, courseAllDto.getCourseDes());

            //如果教练不等（已经修改过），就更新表
            if (!before_courseExcGroup.getCoachs().equals(upd_courseExcGroup.getCoachs())) {
                //删除课程教练中间表
                delCourseCoachByCourseId(Integer.valueOf(type), before_courseExcGroup.getId());
                //添加课程教练中间表
                addCourseCoach(type, before_courseExcGroup.getId(), upd_courseExcGroup.getCoachs(), null, null);

            }

            //如果门店不等（已经修改过），就更新表
            if (!before_courseExcGroup.getStores().equals(upd_courseExcGroup.getStores())) {
                //删除课程门店
                if (type.equals("2")) {//删除训练营对应门店
                    deleteCourseStoreByCourseId(before_courseExcGroup.getId(), CourseTypeEnum.STUDIO.getCode());
                } else {//删除精品团课对应门店
                    deleteCourseStoreByCourseId(before_courseExcGroup.getId(), CourseTypeEnum.COURSEGROUP.getCode());
                }

                //添加课程门店表  type 0：私教课  1：精品团课  ，       课程id,        门店id
                addCourseStores(type, before_courseExcGroup.getId(), upd_courseExcGroup.getStores());
            }
        } else {
            throw new Exception("参数错误");
        }


    }

    /**
     * 删除 课程教练中间表
     *
     * @param type     0:私教课  1:团课
     * @param courseId 课程id
     */
    public void delCourseCoachByCourseId(Integer type, Integer courseId) {
        CourseCoachExample example = new CourseCoachExample();
        example.createCriteria().andTypeEqualTo(type).andCourseidEqualTo(courseId);
        courseCoachDao.deleteByExample(example);
    }


    /**
     * 更新私教内容
     *
     * @param before_coursePriCoach 更新之前的内容
     * @param upd_coursePriCoach    前台传入的  更新的内容
     */
    public void UpdCoursePriCoach(CoursePriCoach before_coursePriCoach, CoursePriCoach upd_coursePriCoach) {
        //添加时间
        upd_coursePriCoach.setAddtime(before_coursePriCoach.getAddtime());

        //课题类型：私教
        upd_coursePriCoach.setCoursetype(before_coursePriCoach.getCoursetype());

        //更新是否为体验课
        upd_coursePriCoach.setIsexperience(before_coursePriCoach.getIsexperience());

        //状态有效
        upd_coursePriCoach.setStatus(before_coursePriCoach.getStatus());

        upd_coursePriCoach.setCourseEndTime(DateTimeUtil.getStringDateToTimeLong(upd_coursePriCoach.getCourseEndTimeStr()));

        coursePriCoachDao.updateByPrimaryKeyWithBLOBs(upd_coursePriCoach);

    }

    /**
     * 更新精品团课内容
     *
     * @param before_courseExcGroup 更新之前的内容
     * @param upd_courseExcGroup    前台传入的 更新内容
     * @param courseDes             精品团课的 课程标签
     */
    public void UpdCourseExcGroup(CourseExcGroupWithBLOBs before_courseExcGroup, CourseExcGroupWithBLOBs upd_courseExcGroup, List<CourseDes> courseDes) {
        //添加时间
        upd_courseExcGroup.setAddtime(before_courseExcGroup.getAddtime());

        //状态有效
        upd_courseExcGroup.setStatus(before_courseExcGroup.getStatus());

        //课题类型：精品团课
        upd_courseExcGroup.setCoursetype(before_courseExcGroup.getCoursetype());


        //类型
        upd_courseExcGroup.setType(before_courseExcGroup.getType());

        //课题标签
        upd_courseExcGroup.setCoursedes(getCourseDes(courseDes));

        coursExcGroupDao.updateByPrimaryKeyWithBLOBs(upd_courseExcGroup);
    }


    /**
     * 改变课程状态
     */
    @Override
    public void updateCourseStatus(Integer status, Integer id, Integer type) throws Exception {
        //判断课程类型
        if (type == 0) {
            //创建对象
            CoursePriCoach coursePriCoach = new CoursePriCoach();
            //赋值
            coursePriCoach.setStatus(status);
            coursePriCoach.setId(id);
            //改变状态
            coursePriCoachDao.updateByPrimaryKeySelective(coursePriCoach);
        } else if (type == 1) {
            //创建对象
            CourseExcGroupWithBLOBs courseExcGroup = new CourseExcGroupWithBLOBs();
            //赋值
            courseExcGroup.setStatus(status);
            courseExcGroup.setId(id);
            //改变状态
            courseExcGroupDao.updateByPrimaryKeySelective(courseExcGroup);
        }

    }

    /**
     * 根据课程id获取精品课程
     *
     * @param courseId
     * @param type     1:精品团课  2基础团课  3 工作室     0：表示没有条件
     * @throws Exception
     */
    public CourseExcGroupWithBLOBs selectCourseGroupById(Integer courseId, Integer type) throws Exception {

        CourseExcGroupExample example = new CourseExcGroupExample();

        if (type != 0) {
            //课程id并且有效   是精品课程
            example.createCriteria().andIdEqualTo(courseId).andStatusEqualTo(DataValidEnum.EFFECT.getCode()).andTypeEqualTo(type);
        } else {
            example.createCriteria().andIdEqualTo(courseId).andStatusEqualTo(DataValidEnum.EFFECT.getCode());
        }


        //获取精品课程
        List<CourseExcGroupWithBLOBs> resultCourseExcGroupWithBLOBs = courseExcGroupDao.selectByExampleWithBLOBs(example);

        if (CollectionUtils.isNotEmpty(resultCourseExcGroupWithBLOBs)) {
            return resultCourseExcGroupWithBLOBs.get(0);
        } else {
            throw new Exception();
        }

    }

    /**
     * 根据课程id获取课程
     *
     * @param courseId 课程id
     * @return
     * @throws Exception
     */
    public CourseExcGroupWithBLOBs selectCourseGroupById(Integer courseId) throws Exception {

        CourseExcGroupExample example = new CourseExcGroupExample();

        //课程id并且有效   是精品课程
        example.createCriteria().andIdEqualTo(courseId).andStatusEqualTo(DataValidEnum.EFFECT.getCode());

        //获取课程
        List<CourseExcGroupWithBLOBs> resultCourseExcGroupWithBLOBs = courseExcGroupDao.selectByExampleWithBLOBs(example);

        if (CollectionUtils.isNotEmpty(resultCourseExcGroupWithBLOBs)) {
            return resultCourseExcGroupWithBLOBs.get(0);
        } else {
            throw new Exception();
        }

    }

    /**
     * 是否可以购买该精品课程
     *
     * @param courseId
     * @return
     * @throws Exception
     */
    public boolean canBuyCourse(Integer courseId) throws Exception {
        EmployeeBuyCourseExample example = new EmployeeBuyCourseExample();
        //根据课程id和课程类型查询精品团课已经被购买多少次
        example.createCriteria().andCourseidEqualTo(courseId).andCoursetypeEqualTo(CourseTypeEnum.COURSEGROUP.getCode());

        Integer buyCourseCount = employeeBuyCourseDao.countByExample(example);


        CourseExcGroup courseExcGroup = courseExcGroupDao.selectByPrimaryKey(courseId);
        if (null != courseExcGroup) {
            //该精品课程允许的最大人数    与购买的人数相比

            //还没达到最大人数，可以购买
            if (buyCourseCount < courseExcGroup.getMaxpeople()) {
                return true;
            } else {//不能购买了
                return false;
            }
        } else {
            throw new Exception("");
        }


    }

    /**
     * 根据课程id获取私教课
     *
     * @param courseId
     * @return
     * @throws Exception
     */
    public CoursePriCoach selectCoursePriById(Integer courseId) throws Exception {
        CoursePriCoachExample example = new CoursePriCoachExample();
        //课程id并且有效
        example.createCriteria().andIdEqualTo(courseId).andStatusEqualTo(DataValidEnum.EFFECT.getCode());

        List<CoursePriCoach> resultCoursePri = coursePriCoachDao.selectByExampleWithBLOBs(example);
        if (CollectionUtils.isNotEmpty(resultCoursePri)) {

            return resultCoursePri.get(0);
        } else {
            //差不多私教课
            throw new Exception();
        }


    }


    /**
     * 根据课程id获取私教课   后台
     *
     * @param courseId
     * @return
     * @throws Exception
     */
    public CoursePriCoach selectCoursePriById_Back(Integer courseId) throws Exception {
        CoursePriCoachExample example = new CoursePriCoachExample();
        //课程id并且有效
        example.createCriteria().andIdEqualTo(courseId);

        List<CoursePriCoach> resultCoursePri = coursePriCoachDao.selectByExampleWithBLOBs(example);
        if (CollectionUtils.isNotEmpty(resultCoursePri)) {

            return resultCoursePri.get(0);
        } else {
            //差不多私教课
            throw new Exception();
        }


    }

    /**
     * 前台异步获取私教课
     *
     * @param page
     * @return
     * @throws Exception
     */
    public List<CoursePriCoach> selectCoursePriCoach(Page page) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", Integer.valueOf(page.getOffset()));
        map.put("end", Integer.valueOf(page.getLimit()));
        List<CoursePriCoach> coursePriCoaches = coursePriCoachDao.selectCoursePri(map);
        if(coursePriCoaches != null){
            for(CoursePriCoach cp : coursePriCoaches){
                //评价来源标识：1私教课2团课3门店4私教
                Map<String, Object> stringObjectMap = commentMapper.selectCommentWithStartLevel(1, cp.getId());
                cp.setCommentCount(stringObjectMap.get("commentCount") == null ? 0 : Integer.parseInt(stringObjectMap.get("commentCount").toString()));
                cp.setTotalStar(stringObjectMap.get("totalStar") == null ? 0 : Integer.parseInt(stringObjectMap.get("totalStar").toString()));
            }
        }
        return coursePriCoaches;


    }

    /**
     * 根据教练id获取该教练下的私教课
     *
     * @param coachId
     * @return
     * @throws Exception
     */
    public List<CoursePriCoach> selectCoachPriByCoachId(Integer coachId, Integer type) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("coachId", coachId);
        map.put("type", type);
        return coursePriCoachDao.selectCoachPriByCoachId(map);

    }

    /**
     * 获取教练名称
     */
    public String getCochAllNames(String coachs) throws Exception {
        StringBuffer buffer = new StringBuffer();
        if (StringUtils.hasText(coachs)) {
            String[] coachId = coachs.split("[,，]");
            for (int i = 0; i < coachId.length; i++) {
                //查询
                String name = aboutClassService.getCoachnameById(coachId[i]);
                //拼接coachname
                buffer.append(name + ",");
            }

            if (StringUtils.hasText(buffer.toString())) {
                return buffer.substring(0, buffer.length() - 1);
            } else {
                return null;
            }

        }
        return null;
    }


    //排期-----------------------------------------------------------------------------------------------------------------------------------


    /**
     * 保存团课排期
     *
     * @param courseGroupTimeDto
     * @param year               年
     * @param month              月
     * @param courseId           课程id
     */
    @Transactional(rollbackFor = Throwable.class)
    public void addSaveTime(CourseGroupTimeDto courseGroupTimeDto, String year, String month, Integer courseId) throws Exception {
        if (isAlreadyAddTime(courseId, year, month)) {
            throw new Exception("你已经排期过了");
        }

        List<CourseGroupTime> time_list = courseGroupTimeDto.getCourseGroupTimeList();
        System.out.println(time_list.size());
        if (CollectionUtils.isNotEmpty(time_list)) {
            for (int i = 0; i < time_list.size(); i++) {
                CourseGroupTime record = time_list.get(i);
                ;

                record.setCourseid(courseId);
                record.setYear(year);
                record.setMonth(month);
                if (record.getDay().length() == 1) {
                    record.setDay("0" + record.getDay());//01，02，03
                }
                courseGroupTimeDao.insertSelective(record);
            }
        } else {
            throw new Exception("请填写排期时间");
        }

    }


    /**
     * 根据课程id ,年月 查询课程的排期时间
     *
     * @param courseId 课程id
     * @param year     年
     * @param month    月
     * @return
     */
    public List<CourseGroupTimeDto> selectCourseGroupTime(Integer courseId, String year, String month) throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("courseId", courseId);
        map.put("year", year);
        map.put("month", month);
        return courseGroupTimeDao.selectCourseGroupTimeByCondition(map);
    }


    /**
     * 编辑保存
     *
     * @param courseGroupTimeDto
     * @throws Exception
     */
    @Transactional(rollbackFor = Throwable.class)
    public void editSaveTime(CourseGroupTimeDto courseGroupTimeDto) throws Exception {
        List<CourseGroupTime> time_list = courseGroupTimeDto.getCourseGroupTimeList();
        for (int i = 0; i < time_list.size(); i++) {
            CourseGroupTime record = time_list.get(i);
            //id没有值，说明页面不能编辑该是日期 ，所以不能该修改
            if (null != record.getId()) {
                courseGroupTimeDao.updateByPrimaryKey(record);
            }
        }


    }

    /**
     * 根据团课id查询团课排期列表
     *
     * @param courseId 根据团课id
     * @return
     * @throws Exception
     */
    public List<CourseGroupTimeDto> selectListByCourseId(Integer courseId) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("courseId", courseId);
        List<CourseGroupTimeDto> dtoDtos = courseGroupTimeDao.selectListByCourseId(map);
        return dtoDtos;

    }


    /**
     * 基础团课排期
     * 查询本月是否已经添加过记录  有：返回true  没有：false
     *
     * @param courseId 课程id
     * @param year     年
     * @param month    月
     * @return
     * @throws Exception
     */
    public boolean isAlreadyAddTime(Integer courseId, String year, String month) throws Exception {
        CourseGroupTimeExample example = new CourseGroupTimeExample();
        example.createCriteria().andCourseidEqualTo(courseId).andYearEqualTo(year).andMonthEqualTo(month);
        Integer count = courseGroupTimeDao.countByExample(example);
        if (count > 0) {
            return true;
        }
        return false;
    }

    /**
     * 工作室排期
     * 查询本月是否已经添加过记录  有：返回true  没有：false
     *
     * @param courseId 课程id
     * @param year     年
     * @param month    月
     * @return
     * @throws Exception
     */
    public boolean isAlreadyAddStudioTime(Integer courseId, String year, String month) throws Exception {
        CourseStudioTimeExample example = new CourseStudioTimeExample();
        example.createCriteria().andCourseidEqualTo(courseId).andYearEqualTo(year).andMonthEqualTo(month);
        Integer count = courseStudioTimeDao.countByExample(example);
        if (count > 0) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int count = 0;
        Calendar cd = Calendar.getInstance();
        Date newDate = null;
        while (count <= 10) {
            cd.add(cd.DAY_OF_WEEK, 1);
            newDate = cd.getTime();

            //获取当前日期是   周几  从周日到周六分别是1-7
            Integer week = DateTimeUtil.getDayOfWeek(newDate);
            System.out.println(week);
            count++;
        }

    }

    /**
     * 添加精品团课排期
     *
     * @param courseId 课程id
     * @param
     * @param
     */
    @Transactional(rollbackFor = Throwable.class)
    public Date add_exc_Time(Integer courseId, Date startDate, CourseExcTimeDto courseExcTimeDto) throws Exception {
        CourseExcGroupWithBLOBs courseExc = selectCourseGroupById(courseId, 1);

        if (courseExc == null || !StringUtils.hasText(courseExc.getTotalhours().toString())) {
            throw new Exception("数据有误");
        }
        //判断训练营开始时间是否大于结束时间  大于true 否则false;
	/*	 if(!selectIsMoreEndDate(courseId, startDate)){
			 throw new Exception("该时间段内训练营有课程");
		 }*/
        //获取list
        List<CourseExcTime> courseExcTimeList = courseExcTimeDto.getCourseExcTimeList();

        //根据课程id查询课程信息
        int count = 0;
        Calendar cd = Calendar.getInstance();
        cd.setTime(startDate);

        //先减去一天，之后循环再加上
        cd.add(Calendar.DATE, -1);
        //结束日期
        Date newDate = null;
        //当小于该课程的总课时，则继续添加
        while (count < courseExc.getTotalhours().intValue()) {
            cd.add(Calendar.DATE, 1);
            newDate = cd.getTime();

            //获取当前日期是   周几  从周日到周六分别是1-7
            Integer week = DateTimeUtil.getDayOfWeek(newDate);
            //System.out.println(week);

            //courseExcTimeList  不会超过7条记录
            for (int k = 0; k < courseExcTimeList.size(); k++) {
                CourseExcTime courseExcTime = courseExcTimeList.get(k);
                //如果开始时间和结束时间有值，且  周  相等
                if (StringUtils.hasText(courseExcTime.getStarttime()) &&
                        StringUtils.hasText(courseExcTime.getEndtime()) &&
                        week == courseExcTime.getWeek()) {
                    //开始时间
                    courseExcTime.setStartdate(startDate);
                    courseExcTime.setCourseid(courseId);
                    //添加一条记录
                    courseExcTimeDao.insertSelective(courseExcTime);
                    count++;
                    break;
                }
            }
        }

        //判断开始结束时间是否  在之前的排期之中


        /**
         * 判断开始结束日期是与已录入的开始结束日期冲突
         */
        if (!isAmongBeforeDte(courseId, startDate, newDate)) {
            throw new Exception("与已录入的排期时间有冲突");
        }
        //最后全部更新结束日期  根据 课程id,开始日期
        editCourseExcTime(courseId, startDate, newDate);

        return newDate;

    }

    /**
     * 查询当前开始和结束时间是否在以前排期时间之中
     *
     * @return
     */
    public boolean isAmongBeforeDte(Integer courseId, Date startDate, Date endDate) throws Exception {
        boolean result = true;

        //获取已经录入的排期时间
        List<CourseExcTimeDto> dto_list = selectExcListByCourseId(courseId);
        if (CollectionUtils.isNotEmpty(dto_list)) {

            //遍历排期时间
            for (int i = 0; i < dto_list.size(); i++) {
                CourseExcTimeDto dto = dto_list.get(i);

                //已录入 排期时间的  开始日期  ，结束日期
                Date own_startDate = dto.getStartdate();
                Date own_endDate = dto.getEnddate();

                //如果刚录入的开始结束日期  在之前已录入的开始结束日期之间，，表示冲突，无法成功录入

                if (startDate.getTime() >= own_startDate.getTime() && startDate.getTime() <= own_endDate.getTime() || endDate.getTime() >= own_startDate.getTime()
                        && endDate.getTime() <= own_endDate.getTime()) {
                    result = false;
                    break;

                }
			/*	 if(own_startDate.before(startDate)&&own_endDate.after(startDate)||own_startDate.before(endDate)&&own_endDate.after(endDate)){
					 result=false;
					 break;
				 }*/
            }
        }

        return result;

    }

    /**
     * 判断训练营开始时间是否大于结束时间  大于true 否则false;
     *
     * @param courseId  课程id
     * @param startDate 开始时间
     * @return
     */
    public boolean selectIsMoreEndDate(Integer courseId, Date startDate) {

        //Map<String,Object> map=new HashMap<String,Object>();
        // map.put("courseId", courseId);
        // CourseExcTime courseExcTime= courseExcTimeDao.selectMaxDateByCourseId(map);
        //CourseExcTime courseExcTime= courseExcTimeDao.selectMaxDateByCourseId(map);

		/* if(courseExcTime !=null){

			 //该训练营的开始时间   要大于训练营的最大结束时间
			 if(startDate.getTime()>courseExcTime.getEnddate().getTime()){
				 return true;

			 }else{
				 return false;

			 }
		 }*/
        return true;
    }


    /**
     * 根据 课程id,开始日期
     * 更新结束日期
     *
     * @param courseId  课程id
     * @param startDate 开始日期
     * @param endDate   结束日期
     */
    public void editCourseExcTime(Integer courseId, Date startDate, Date endDate) {
        CourseExcTime record = new CourseExcTime();
        record.setEnddate(endDate);

        CourseExcTimeExample example = new CourseExcTimeExample();
        example.createCriteria().andCourseidEqualTo(courseId).andStartdateEqualTo(startDate);
        courseExcTimeDao.updateByExampleSelective(record, example);
    }

    /**
     * 根据精品团课id 查询某精品团课所有计划时间内的排期列表
     *
     * @param courseId 精品团课id
     * @return
     */
    @Override
    public List<CourseExcTimeDto> selectExcListByCourseId(Integer courseId)
            throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("courseId", courseId);
        List<CourseExcTimeDto> courseExcTimeDtos = courseExcTimeDao.selectExcListByCourseId(map);
        return courseExcTimeDtos;
    }

    /**
     * 根据精品团课编号，开始日期查询
     *
     * @param courseId  精品团课编号
     * @param startdate 开始日期
     * @return
     * @throws Exception
     */
    public List<CourseExcTimeDto> detial_exc(Integer courseId, Date startdate) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("courseId", courseId);
        map.put("startdate", startdate);
        List<CourseExcTimeDto> courseExcTimeDtos = courseExcTimeDao.selectExcListByWeek(map);
        return courseExcTimeDtos;

    }

    /**
     * 获取训练营的 编辑的    排期
     *
     * @param
     * @return
     * @throws Exception
     */
    public CourseExcTimeWeekDto edit_ext(Integer courseId, Date startdate) throws Exception {
        List<CourseExcTimeDto> excTimeDtos = detial_exc(courseId, startdate);
        CourseExcTimeWeekDto dtos = new CourseExcTimeWeekDto();
        if (CollectionUtils.isNotEmpty(excTimeDtos)) {
            for (int i = 0; i < excTimeDtos.size(); i++) {
                if (excTimeDtos.get(i).getWeek() == 1) {//周日
                    dtos.setList_sun(excTimeDtos.get(i));
                } else if (excTimeDtos.get(i).getWeek() == 2) {
                    dtos.setList_mon(excTimeDtos.get(i));
                } else if (excTimeDtos.get(i).getWeek() == 3) {
                    dtos.setList_tue(excTimeDtos.get(i));
                } else if (excTimeDtos.get(i).getWeek() == 4) {
                    dtos.setList_wed(excTimeDtos.get(i));
                } else if (excTimeDtos.get(i).getWeek() == 5) {
                    dtos.setList_ths(excTimeDtos.get(i));
                } else if (excTimeDtos.get(i).getWeek() == 6) {
                    dtos.setList_fri(excTimeDtos.get(i));
                } else if (excTimeDtos.get(i).getWeek() == 7) {
                    dtos.setList_sat(excTimeDtos.get(i));
                }
            }
        }

        return dtos;
    }

    /**
     * 根据courseId和开始时间  来删除训练营的排期
     *
     * @param courseId  课程id
     * @param startDate 开始时间
     * @throws Exception
     */
    public void delCourseExcTime(Integer courseId, Date startDate) throws Exception {
        CourseExcTimeExample example = new CourseExcTimeExample();
        example.createCriteria().andCourseidEqualTo(courseId).andStartdateEqualTo(startDate);
        courseExcTimeDao.deleteByExample(example);
    }


    /**
     * 编辑训练营 排期
     *
     * @param courseId         课程id
     * @param startDate        训练营编辑之前的开始日期（用于条件查询）
     * @param editStartDate    编辑后端开始日期
     * @param courseExcTimeDto
     */
    @Transactional(rollbackFor = Throwable.class)
    public void edit_exc_time(Integer courseId, Date startDate, Date editStartDate, CourseExcTimeDto courseExcTimeDto) throws Exception {
        delCourseExcTime(courseId, startDate);

        //获得排气后的结束时间
        Date newEndDate = add_exc_Time(courseId, editStartDate, courseExcTimeDto);

        //编辑购买课程表employee_buy_course
        // 训练营排期编辑之后，需要更将编辑后的开始时间和结束时间更新到employee_buy_course中
        //updEmployeeBuyCourseByDate(courseId, startDate, editStartDate, newEndDate);
    }

    /**
     * 训练营排期编辑之后，需要更将编辑后的开始时间和结束时间更新到employee_buy_course中
     *
     * @param courseId      课程id
     * @param startDate     编辑前的开始日期
     * @param editStartDate 编辑后的开始日期
     * @param newEndDate    编辑后的结束日期
     */
    public void updEmployeeBuyCourseByDate(Integer courseId, Date startDate, Date editStartDate, Date newEndDate) {
        EmployeeBuyCourseExample example = new EmployeeBuyCourseExample();
        example.createCriteria().andCourseidEqualTo(courseId).andStartdateEqualTo(startDate);
        //根据课程和开始时间查询是否已经被客户购买
        List<EmployeeBuyCourse> emList = employeeBuyCourseDao.selectByExample(example);
        //如果有值，表示已经被购买，需要更新时间
        if (CollectionUtils.isNotEmpty(emList)) {
            for (int i = 0; i < emList.size(); i++) {
                EmployeeBuyCourse buyCourse = emList.get(i);

                //如果结束时间不等,更新 ，如果相等，跳出循环，不用再更新
                if (!buyCourse.getEnddate().equals(newEndDate)) {
                    buyCourse.setStartdate(editStartDate);
                    buyCourse.setEnddate(newEndDate);
                    employeeBuyCourseDao.updateByPrimaryKeySelective(buyCourse);
                } else {
                    break;
                }
            }

        }


    }

    /**
     * 根据courseid 查询精品团课排期
     *
     * @param courseId 精品团课id
     * @return
     * @throws Exception
     */
    public List<CourseExcTimeDto> selectExctimeByCourseId(Integer courseId, Date startdate, Date enddate) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("courseId", courseId);
        map.put("startdate", startdate);
        map.put("enddate", enddate);
        //查询
        List<CourseExcTimeDto> courseExcTimeDtos = courseExcTimeDao.selectCourseExcTimeList(map);
        return courseExcTimeDtos;

    }


    /**
     * 根据工作室课程id 查询此课程所有计划时间内的排期列表
     *
     * @param courseId 工作室课程id
     * @return
     */
    @Override
    public List<CourseStudioTimeDto> selectStudioListByCourseId(Integer courseId) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("courseId", courseId);
        List<CourseStudioTimeDto> courseStudioTimeDtos = courseStudioTimeDao.selectListByCourseId(map);
        return courseStudioTimeDtos;
    }


    /**
     * 添加工作室排期时间
     *
     * @param courseId               课程id
     * @param year                   年
     * @param month                  月
     * @param day                    日
     * @param courseStudioTimeAddDto
     * @return
     */
    @Transactional(rollbackFor = Throwable.class)
    public void addStudioTimeSave(Integer courseId, String year, String month, String day, CourseStudioTimeAddDto courseStudioTimeAddDto) throws Exception {
        List<CourseStudioTime> time_list = courseStudioTimeAddDto.getAddCourseStudio();
        if (CollectionUtils.isNotEmpty(time_list)) {
            //循环
            for (int i = 0; i < time_list.size(); i++) {

                //添加的时间不能与数据库时间冲突
                CourseStudioTime courseStudioTime = time_list.get(i);
                courseStudioTime.setCourseid(courseId);
                courseStudioTime.setYear(year);
                courseStudioTime.setMonth(month);
                courseStudioTime.setDay(day);
                //如果开始结束时间不为空
                if (StringUtils.hasText(courseStudioTime.getStarttime()) &&
                        StringUtils.hasText(courseStudioTime.getEndtime()) &&
                        courseStudioTime.getClasshour() != null) {
                    //当天时间必须早于当前小时
                    boolean isBeforeNowTime = isBeforeNowTime(courseStudioTime);
                    if (isBeforeNowTime) {
                        throw new Exception("编辑的时间不能早于当前时间");
                    }
                    Integer isTimeConflict = isTimeConflict(courseStudioTime);
                    if (isTimeConflict > 0) {
                        throw new Exception("添加的时间有冲突");
                    }
                    //添加排期
                    courseStudioTimeDao.insertSelective(courseStudioTime);
                }

            }
        }

    }

    /**
     * 根据日期查询工作室 排期
     *
     * @param courseId 课程id
     * @param year     年
     * @param month    月
     * @param day      日
     * @return
     * @throws Exception
     */
    public List<CourseStudioTimeDto> selectCourseStudioTimeByDate(Integer courseId, String year, String month, String day) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("courseId", courseId);
	/*	CourseStudioTimeExample example=new CourseStudioTimeExample();
		example.setOrderByClause("starttime asc");
		Criteria c= example.createCriteria();
		c.andCourseidEqualTo(courseId);*/
        if (StringUtils.hasText(year)) {//年不为空
            map.put("year", year);
        }
        if (StringUtils.hasText(month)) {//月不为空
            map.put("month", month);
        }
        if (StringUtils.hasText(day)) {//天不为空
            map.put("day", day);
        }

        List<CourseStudioTimeDto> time_list = courseStudioTimeDao.selectTimeList(map);
        return time_list;
    }

    /**
     * 编辑保存
     *
     * @param courseStudioTime
     * @param
     * @param
     * @return
     * @throws Exception
     */
    public void editStudioTimeSave(CourseStudioTime courseStudioTime) throws Exception {


        //如果是当天的时间，就会检查时间是否早于 当前的时分秒，否则跳过

        boolean isBeforeNowTime = isBeforeNowTime(courseStudioTime);
        if (isBeforeNowTime) {
            throw new Exception("编辑的时间不能早于当前时间");
        }

        Integer isTimeConflict = isTimeConflict(courseStudioTime);
        if (isTimeConflict > 0) {
            throw new Exception("编辑的时间冲突");
        }

        //更新数据
        updCourseStudioTime(courseStudioTime);

        //返回编辑后的数据
        //return selectCourseStudioTimeByDate(courseStudioTime.getCourseid(), courseStudioTime.getYear(), courseStudioTime.getMonth(), courseStudioTime.getDay());
    }


    /**
     * 判断是否早于当前时间  只有当天才需要
     *
     * @param courseStudioTime
     * @return
     */
    public boolean isBeforeNowTime(CourseStudioTime courseStudioTime) {
        //获取当前时间
        Date nowDate = new Date();

        //获取开始日期
        String date = courseStudioTime.getYear() + "-" + courseStudioTime.getMonth() + "-" + courseStudioTime.getDay();

        //获取当前时间（2017-10-20）
        String nowDate_String_year = DateTimeUtil.getDateWithoutTime(nowDate);

        //小时格式  10：00
        String nowDate_String_hour = DateTimeUtil.getCurrTime_withoutSec(nowDate);

        //只有当天 才判断是否早于当前时间   2017-10-20=2017-10-20
        if (nowDate_String_year.equals(date)) {

            //获取开始时间 的  10：00
            Date startTime_date = DateTimeUtil.getCurrTime_withoutSec(courseStudioTime.getStarttime());

            //当前时间的小时  10：00
            Date nowDate_date = DateTimeUtil.getCurrTime_withoutSec(nowDate_String_hour);


            //如果当前时间  在开始时间之后，不能编辑
            if (nowDate_date.after(startTime_date)) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }

    }


    /**
     * 判断工作室时间是否冲突
     *
     * @param courseStudioTime
     * @return
     * @throws Exception
     */
    public Integer isTimeConflict(CourseStudioTime courseStudioTime) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();

        //课程id
        map.put("courseId", courseStudioTime.getCourseid());

        //年
        map.put("year", courseStudioTime.getYear());

        //月
        map.put("month", courseStudioTime.getMonth());

        //日
        map.put("day", courseStudioTime.getDay());

        //开始时间
        map.put("startTime", courseStudioTime.getStarttime());

        //结束时间
        map.put("endTime", courseStudioTime.getEndtime());

        //自身的主键id(用来判断是否和数据库时间冲突的时候  来排除自身)
        map.put("id", courseStudioTime.getId());

        //查询编辑的时间是否与原数据库的时间冲突，如果大于0，表示冲突
        Integer isConflict = courseStudioTimeDao.selectStudioTimeIsConflict(map);

        return isConflict;

    }


    /**
     * 更新工作室时间
     *
     * @param courseStudioTime
     * @throws Exception
     */
    public void updCourseStudioTime(CourseStudioTime courseStudioTime) throws Exception {

	/*	CourseStudioTime studioTime=courseStudioTimeDao.selectByPrimaryKey(courseStudioTime.getId());
		//赋值开始时间
		studioTime.setStarttime(courseStudioTime.getStarttime());

		//结束时间
		studioTime.setEndtime(courseStudioTime.getEndtime());*/

        //更新
        courseStudioTimeDao.updateByPrimaryKeySelective(courseStudioTime);

    }


    /**
     * 根据课程id和年月查询数据   展示到页面中
     *
     * @param
     * @return
     * @throws Exception
     */
    public List<CourseStudioTimeShowDto> selectStudioTimeDateAndList(Integer courseId, String year, String month) throws Exception {
        List<CourseStudioTimeShowDto> timeShowListDto = new ArrayList<CourseStudioTimeShowDto>();

        String nowDate = DateTimeUtil.getDateWithoutTime(new Date());
        //当月有多少天
        Integer dayCount = DateTimeUtil.getCountMonthOfDay(Integer.valueOf(year), Integer.valueOf(month));


        //根据年月  和课程id查询    所有满足条件的 记录
        List<CourseStudioTimeDto> data_studioTimeDtos = selectCourseStudioTimeByDate(courseId, year, month, null);


        //从第一天开始   如果当前天和数据库相等，则将数据塞入
        for (int i = 0; i < dayCount; i++) {
            //CourseStudioTimeShowDto timeShowDto=new CourseStudioTimeShowDto();

            CourseStudioTimeShowDto timeDto = new CourseStudioTimeShowDto();

            Integer day = i + 1;
            //转化成string
            String days_todstring = getDayToString(day);

            //天
            timeDto.setDay(days_todstring);

            if (CollectionUtils.isNotEmpty(data_studioTimeDtos)) {

                //申明 list
                List<CourseStudioTimeDto> studioTimeList = new ArrayList<CourseStudioTimeDto>();

                //循环从数据库得到的值，
                for (int j = 0; j < data_studioTimeDtos.size(); j++) {
                    CourseStudioTimeDto time = data_studioTimeDtos.get(j);

                    //如果和当前循环的天相等
                    if (time.getDay().equals(days_todstring)) {
                        //塞入list
                        studioTimeList.add(time);
                        data_studioTimeDtos.remove(j);
                        j--;

                    }
                }
                //将当天的值放入list
                timeDto.setCourseStudioTime(studioTimeList);

            }
            //是否可以编辑
            timeDto.setIsedit(getStudioTimeIsEdit(year, month, days_todstring, nowDate));
            timeShowListDto.add(timeDto);

        }
        return timeShowListDto;

    }


    /**
     * 判断工作室  时间是否可以编辑
     *
     * @param year
     * @param month
     * @param day
     * @param nowDate
     * @return
     */
    public boolean getStudioTimeIsEdit(String year, String month, String day, String nowDate) {
        String date = year + "-" + month + "-" + day;
        if (DateTimeUtil.isDateAfter(nowDate, date)) {
            return false;
        }

        return true;
    }

    /**
     * 将天转化成String类型
     *
     * @param Day
     * @return
     */
    public String getDayToString(Integer Day) {
        String day_toString = String.valueOf(Day);
        if (day_toString.length() == 1) {
            day_toString = "0" + day_toString;
        }
        return day_toString;
    }

    /**
     * 根据主键id 删除工作室排期时间
     *
     * @param id
     * @throws Exception
     */
    public void delStudioTime(Integer id) throws Exception {
        courseStudioTimeDao.deleteByPrimaryKey(id);
    }


    /**
     * 根据主键id  查询工作室某个排期时间
     *
     * @param id
     * @return
     * @throws Exception
     */
    public CourseStudioTime selectStudioTimeById(Integer id) throws Exception {
        return courseStudioTimeDao.selectByPrimaryKey(id);
    }


    @Override
    public CourseExcGroupDto selectCourseGroupDtoByCourseId(Integer courseId) throws Exception {
        // TODO Auto-generated method stub
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("courseid", courseId);
        return courseExcGroupDao.selectCourseGroupDtoByCourseId(map);
    }


    @Override
    public List<CoursePriCoach> selectCourseIsPopular() throws Exception {
        // TODO Auto-generated method stub
        return coursePriCoachDao.selectCourseIsPopular();
    }


    private String[] transToArr(String[] arr) {
        //用StringBuffer来存放数组中的非空元素，用“;”分隔
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            if ("".equals(arr[i])) {
                continue;
            }
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append(";");
            }
        }
        //用String的split方法分割，得到数组
        arr = sb.toString().split(";");
        return arr;
    }

    @Override
    public CoursePriCoachBean getPriCoachDetail(int id) {
        Map<String , Object> map = new HashMap<>();
        CoursePriCoachBean coursePriCoachBean = this.coursePriCoachDao.queryPriCourseById(id);
        map.put("courseId" , coursePriCoachBean.getId());
        map.put("type" , coursePriCoachBean.getCourseType());
        //状态 0：删除  1：有效
        map.put("status" , 1);
        //教练
        List<CoachBean> coachList = this.courseCoachDao.queryCourseCoachByPri(map);
        coursePriCoachBean.setCoachList(coachList);
        //门店
        List<StoreBean> storeList = storeDao.queryStoreByCourse(map);
        coursePriCoachBean.setStoreList(storeList);

        Map<String, Object> stringObjectMap = commentMapper.selectCommentWithStartLevel(1, coursePriCoachBean.getId());
        coursePriCoachBean.setCommentCount(stringObjectMap.get("commentCount") == null ? 0 : Integer.parseInt(stringObjectMap.get("commentCount").toString()));
        coursePriCoachBean.setTotalStar(stringObjectMap.get("totalStar") == null ? 0 : Integer.parseInt(stringObjectMap.get("totalStar").toString()));


        return coursePriCoachBean;
    }
}
