package customer.supu.service.impl;

import com.alibaba.fastjson.JSON;
import customer.supu.appoint.AppointManage;
import customer.supu.appoint.AppointThread;
import customer.supu.common.po.PageResponse;
import customer.supu.common.utils.DateTimeUtil;
import customer.supu.common.utils.SendAiliDaYuMsg;
import customer.supu.domain.EmployeeBuyPri;
import customer.supu.domain.PriCoachCourse;
import customer.supu.domain.UOrder;
import customer.supu.jenum.ESmsType;
import customer.supu.jenum.ResultCodeEnum;
import customer.supu.mapper.*;
import customer.supu.po.*;
import customer.supu.service.IEmployeeBuyPriService;
import customer.supu.service.SmsLogService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;


@Service
@PropertySource("classpath:uup.properties")
public class EmployeeBuyPriImpl extends BaseServiceImpl<EmployeeBuyPri> implements IEmployeeBuyPriService {

    private Logger logger = Logger.getLogger(EmployeeBuyPriImpl.class);

    @Autowired
    private EmployeeBuyPriMapper employeeBuyPriMapper;


    @Autowired
    private CoachTimeMapper coachTimeMapper;

    @Autowired
    private EmployeeAppointCourseMapper employeeAppointCourseMapper;

    @Value("${cancel.appoint.time}")
    private Long cancelTime;

    @Autowired
    private SmsLogService smsLogService;


    @Autowired
    private CoachMapper coachMapper;

    @Autowired
    private EmployeeMapper employeeMapper;


    @Autowired
    private CoursePriCoachMapper coursePriCoachMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public PageResponse selectPriPage(EmployeeBuyPri employeeBuyPri){
        List<PriCoachCourse> priCoachCourseList = employeeBuyPriMapper.selectPriCoachPage(employeeBuyPri);
        int count = employeeBuyPriMapper.selectPriCoachPageCount(employeeBuyPri);
        if(count > 0){
            for(PriCoachCourse pc : priCoachCourseList){
                EmployeeAppointCourse employeeAppointCourse = new EmployeeAppointCourse();
                Integer courseId = pc.getCourseId();
                Integer coachId = pc.getCoachId();
                Integer userId = pc.getUserId();

                employeeAppointCourse.setCourseid(courseId);
                employeeAppointCourse.setCourseId(courseId);
                employeeAppointCourse.setCoachId(coachId.longValue());
                employeeAppointCourse.setUserid(userId);
                //查询出私教课已经预约的数量
                pc.setUseClass(employeeAppointCourseMapper.selectAppointPriCount(employeeAppointCourse));
                UOrder order = new UOrder();
                order.setUserId(userId);
                order.setCoachId(coachId);
                order.setCid(courseId);
                //总金额
                pc.setAmount(orderMapper.selectAllAmount(order));
            }

        }
        PageResponse response = new PageResponse();
        response.setRecords(priCoachCourseList);
        response.setTotal(count);
        return response;
    }

    @Override
    public PageResponse makeAppoint(Long id, Long startTime, Long endTime , int userId) {


        if(startTime <= System.currentTimeMillis()){
            //开始时间不能小于当前时间
            return ResultCodeEnum.STARTTIME_NOT_ALLOW.getResponse();
        }

        EmployeeBuyPri employeeBuyPri = employeeBuyPriMapper.selectById(id + "");
        if(employeeBuyPri.getUserId() != userId){
            //没有购买过改私教课
            return ResultCodeEnum.NOT_BUY_PRI.getResponse();
        }

        if(!this.isWork(employeeBuyPri.getCoachId() , startTime , endTime)){
            //不在工作时间内
            return ResultCodeEnum.PRI_NOT_WORK.getResponse();
        }

        if(this.isConflict(employeeBuyPri.getCourseId() ,employeeBuyPri.getCoachId() , startTime , endTime)){
            //时间已被预约
            return ResultCodeEnum.PRI_TIME_CONFLICT.getResponse();
        }

        CoursePriCoach coursePriCoach = coursePriCoachMapper.selectByPrimaryKey(employeeBuyPri.getCourseId());
        if(coursePriCoach.getCourseEndTime() != null && System.currentTimeMillis() > coursePriCoach.getCourseEndTime()){
            //私教课已经结束
            return ResultCodeEnum.PRI_COURSE_OVER.getResponse();
        }

        EmployeeAppointCourse employeeAppointCourse = new EmployeeAppointCourse();
        employeeAppointCourse.setAppointtime(new Date(startTime));
        employeeAppointCourse.setCoachId((long)employeeBuyPri.getCoachId());
        employeeAppointCourse.setCourseid(employeeBuyPri.getCourseId());
        employeeAppointCourse.setAddtime(new Date());
        employeeAppointCourse.setUserid(userId);
        //11 私教课预约
        employeeAppointCourse.setType(11);

        employeeAppointCourse.setStarttime(DateTimeUtil.timemillonToStr(startTime , "HH:mm"));
        employeeAppointCourse.setEndtime(DateTimeUtil.timemillonToStr(endTime , "HH:mm"));
        //1  已经预约  2 已经取消  3已经完成(适用于私教课 )
        employeeAppointCourse.setStatus(1);

        //可以预约
        employeeAppointCourseMapper.insertSelective(employeeAppointCourse);

        try {
            // 短信通知私教
            Coach coach = coachMapper.selectByPrimaryKey(employeeBuyPri.getCoachId());
            Employee employee = employeeMapper.selectByPrimaryKey(userId);
            //用户姓名
            String cnname = employee.getCnname();
            String appointTime = DateTimeUtil.timemillonToStr(startTime , "yyyy-MM-dd") + " " + DateTimeUtil.timemillonToStr(startTime , "HH:mm:ss") + "-" + DateTimeUtil.timemillonToStr(endTime , "HH:mm:ss");
            String coursename = coursePriCoach.getCoursename();
            Map<String , Object> map = new HashMap<>();
            map.put("name",cnname);
            map.put("time",appointTime);
            map.put("class",coursename);
            logger.info("makeAppoint SendAiliDaYuMsg.send map=" + JSON.toJSONString(map) + ",Phonenumber=" + coach.getPhonenumber());
            SendAiliDaYuMsg.send(coach.getPhonenumber(),"SMS_152285670",map );
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 开启课程结束线程
        AppointThread appointThread = new AppointThread(endTime , employeeAppointCourseMapper , employeeAppointCourse,employeeBuyPri.getTotalClass() , employeeBuyPriMapper) ;
        AppointManage.putThread(employeeAppointCourse.getId() , appointThread);

        return ResultCodeEnum.SUCCESS.getResponse();
    }


    /*
     * @author ll
     * @Description 是否在教练的工作时间内
     * @date 2018/11/5 16:16
     * @param []
     * @return boolean  true 在工作时间 可预约   false不在工作时间 不可预约
     */
    private boolean isWork( int coachId , long startTime , long endTime){
        boolean b = false;
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(startTime);
        String year = now.get(Calendar.YEAR) + "";
        String month = (now.get(Calendar.MONTH) + 1) + "";
        String day = now.get(Calendar.DAY_OF_MONTH) + "";
        if(month.length() < 2){
            month = "0" + month;
        }
        String selectYmonth = year + "-" + month;
        if(day.length() < 2){
            day = "0" + day;
        }

        CoachTime coachTime = new CoachTime();
        coachTime.setSelectymonth(selectYmonth);
        coachTime.setCoachid(coachId);
        coachTime.setDay(day);
        List<CoachTime> coachTimes = this.coachTimeMapper.selectCoachTime(coachTime);
        if(coachTimes != null && coachTimes.size() > 0){
            for(CoachTime ct : coachTimes){
                String startWorkTimeStr = ct.getSelectymonth() + "-" + ct.getDay() + " " + ct.getStarttime() + ":00";
                String endWorkTimeStr = ct.getSelectymonth() + "-" + ct.getDay() + " " + ct.getEndtime() + ":00";
                long startWorkTime = DateTimeUtil.getTimestamp(startWorkTimeStr);
                long endWorkTime = DateTimeUtil.getTimestamp(endWorkTimeStr);
                if(startTime >= startWorkTime && endTime <= endWorkTime){
                    //在工作时间内
                    b = true;
                    break;
                }
            }
        }
        return b;
    }

    /*
     * @author ll
     * @Description 是否与其他预约冲突
     * @date 2018/11/5 16:49
     * @param []
     * @return boolean  true 冲突  不可预约  false不冲突 可预约
     */
    public boolean isConflict(int courseId , long coachId , long startTime , long endTime){
        boolean b = false;
        EmployeeAppointCourse employeeAppointCourse = new EmployeeAppointCourse();
        employeeAppointCourse.setCourseid(courseId);
        employeeAppointCourse.setCoachId(coachId);
        employeeAppointCourse.setAppointTimeStr(DateTimeUtil.getDateWithoutTime(new Timestamp(startTime)));
        List<EmployeeAppointCourse> employeeAppointCourses = employeeAppointCourseMapper.selectAppointTime(employeeAppointCourse);
        if(employeeAppointCourses != null && employeeAppointCourses.size() > 0){
            for(EmployeeAppointCourse ea : employeeAppointCourses){
                long appointStart = DateTimeUtil.getTimestamp(DateTimeUtil.getDateWithoutTime(ea.getAppointtime()) + " " + ea.getStarttime() + ":00");
                long appointEnd = DateTimeUtil.getTimestamp(DateTimeUtil.getDateWithoutTime(ea.getAppointtime()) + " " + ea.getEndtime() + ":00");
                if(!(startTime >= appointEnd || endTime <= appointStart)){
                    b = true;
                    break;
                }
            }
        }

        return b;
    }


    @Override
    public PageResponse selectAppointPage(EmployeeAppointCourse employeeAppointCourse) {
        List<EmployeeAppointCourse> courseList = employeeAppointCourseMapper.selectAppointPriPage(employeeAppointCourse);
        int count = employeeAppointCourseMapper.selectAppointPriCount(employeeAppointCourse);
        if(count > 0){
            for(EmployeeAppointCourse ea : courseList){
                long appointStart = DateTimeUtil.getTimestamp(DateTimeUtil.getDateWithoutTime(ea.getAppointtime()) + " " + ea.getStarttime() + ":00");
                long appointEnd = DateTimeUtil.getTimestamp(DateTimeUtil.getDateWithoutTime(ea.getAppointtime()) + " " + ea.getEndtime() + ":00");
                ea.setStarttime(appointStart + "");
                ea.setEndtime(appointEnd + "");
            }
        }
        PageResponse response = new PageResponse();
        response.setRecords(courseList);
        response.setTotal(count);
        return response;
    }

    @Override
    public PageResponse selectPriTime(int coachId , String dateTime) {

        //已经被预约时间
        Map<String ,Object> map = new HashMap<>();
        map.put("coachId",coachId);
        map.put("appointTime",dateTime);
        List<EmployeeAppointCourse> employeeAppointCourses = employeeAppointCourseMapper.selectAppointTimeByPri(map);
        if(employeeAppointCourses != null && employeeAppointCourses.size() > 0){
            for(EmployeeAppointCourse ea : employeeAppointCourses){
                ea.setStarttime(DateTimeUtil.getDateWithoutTime(ea.getAppointtime()) + " " + ea.getStarttime() + ":00");
                ea.setEndtime(DateTimeUtil.getDateWithoutTime(ea.getAppointtime()) + " " + ea.getEndtime() + ":00");
            }
        }

        //教练工作时间
        CoachTime coachTime = new CoachTime();
        coachTime.setCoachid(coachId);
        String[] times = dateTime.split("-");
        coachTime.setSelectymonth(times[0] + "-" + times[1]);
        coachTime.setDay(times[2]);
        List<CoachTime> coachTimes = coachTimeMapper.selectCoachTime(coachTime);
        if(coachTimes != null && coachTimes.size() > 0){
            for(CoachTime ct : coachTimes){
                String realTime = ct.getSelectymonth() + "-" + ct.getDay();
                ct.setStarttime(realTime + " " + ct.getStarttime() + ":00");
                ct.setEndtime(realTime + " " + ct.getEndtime() + ":00");
            }
        }

        Map<String , Object> result = new HashMap<>();
        result.put("appointList" , employeeAppointCourses);
        result.put("coachTimeList" , coachTimes);

        return ResultCodeEnum.SUCCESS.getResponse(result);
    }


    @Override
    public PageResponse cancleAppoint(int id, int userId) {
        EmployeeAppointCourse eac = employeeAppointCourseMapper.selectByPrimaryKey(id);
        if(eac != null && eac.getUserid() == userId){

            String startTime = DateTimeUtil.getDateWithoutTime(eac.getAppointtime()) + " " + eac.getStarttime() + ":00";
            long startMillis = DateTimeUtil.getTimestamp(startTime);
            if(startMillis - System.currentTimeMillis() < cancelTime ){
                //只能在规定时间内取消
                return ResultCodeEnum.NOT_CANCEL_APPOINT.getResponse();
            }

            EmployeeAppointCourse employeeAppointCourse = new EmployeeAppointCourse();
            employeeAppointCourse.setId(id);
            //1  已经预约  2 已经取消  3已经完成(适用于私教课 )
            employeeAppointCourse.setStatus(2);
            int i = employeeAppointCourseMapper.updateByPrimaryKeySelective(employeeAppointCourse);

            //发送短信提醒私教
            try {

                // 短信通知私教
                Coach coach = coachMapper.selectByPrimaryKey(eac.getCourseid());
                Employee employee = employeeMapper.selectByPrimaryKey(userId);
                //用户姓名
                String cnname = employee.getCnname();
                String appointTime = startTime + "-" +eac.getEndtime() + ":00";
                CoursePriCoach coursePriCoach = coursePriCoachMapper.selectByPrimaryKey(eac.getCourseid());
                String coursename = coursePriCoach.getCoursename();
                Map<String , Object> map = new HashMap<>();
                map.put("name",cnname);
                map.put("time",appointTime);
                map.put("class",coursename);
                logger.info("cancleAppoint SendAiliDaYuMsg.send map=" + JSON.toJSONString(map) + ",Phonenumber=" + coach.getPhonenumber());
                SendAiliDaYuMsg.send(coach.getPhonenumber(),"SMS_152285677",map );
            } catch (Exception e) {
                e.printStackTrace();
            }

            //关闭 课程结束的线程
            AppointManage.removeThread(id);

            if(i > 0){
                return ResultCodeEnum.SUCCESS.getResponse();
            }else{
                return ResultCodeEnum.FAIL.getResponse();
            }
        }else{
            return ResultCodeEnum.NOT_APPOINT_PRI.getResponse();
        }

    }
}
