package customer.supu.appoint;

import customer.supu.domain.EmployeeBuyPri;
import customer.supu.mapper.EmployeeAppointCourseMapper;
import customer.supu.mapper.EmployeeBuyPriMapper;
import customer.supu.po.EmployeeAppointCourse;
import org.apache.log4j.Logger;

/**
 * @CLassName AppointThread
 * @Description TODO
 * @Author ll
 * @Date 2018/11/6 10:36
 **/
public class AppointThread extends Thread{

    private Logger logger = Logger.getLogger(AppointThread.class);

    private Long endTime;

    private EmployeeAppointCourseMapper employeeAppointCourseMapper;

    private Integer totalClass;

    private EmployeeAppointCourse employeeAppointCourse;

    private EmployeeBuyPriMapper employeeBuyPriMapper;

    public AppointThread(Long endTime , EmployeeAppointCourseMapper employeeAppointCourseMapper , EmployeeAppointCourse employeeAppointCourse , int totalClass ,EmployeeBuyPriMapper employeeBuyPriMapper){
        logger.info("create thread...");
        this.endTime = endTime;
        this.employeeAppointCourseMapper = employeeAppointCourseMapper;
        this.employeeAppointCourse = employeeAppointCourse;
        this.totalClass = totalClass;
        this.employeeBuyPriMapper = employeeBuyPriMapper;
    }

    @Override
    public void run() {
        super.run();
        try{
            logger.info("thread run...");
            long sleepTime = endTime - System.currentTimeMillis();
            if(sleepTime > 0){
                Thread.sleep(sleepTime);
            }
            EmployeeAppointCourse updateCourse = new EmployeeAppointCourse();
            updateCourse.setId(employeeAppointCourse.getId());
            //1  已经预约  2 已经取消  3已经完成(适用于私教课 )
            updateCourse.setStatus(3);
            employeeAppointCourseMapper.updateByPrimaryKeySelective(updateCourse);

            //检查私教课是否都完成
            EmployeeAppointCourse searchCourse = new EmployeeAppointCourse();
            searchCourse.setStatus(3);

            Integer courseId = employeeAppointCourse.getCourseid();
            Integer userId = employeeAppointCourse.getUserid();
            Long coachId = employeeAppointCourse.getCoachId();

            searchCourse.setCourseid(courseId);
            searchCourse.setUserid(userId);
            searchCourse.setCoachId(coachId);
            int count = employeeAppointCourseMapper.selectAppointPriCount(searchCourse);
            if(count >= totalClass){
                //私教课全部结束
                EmployeeBuyPri employeeBuyPri = new EmployeeBuyPri();
                employeeBuyPri.setCoachId(coachId.intValue());
                employeeBuyPri.setUserId(userId);
                employeeBuyPri.setCourseId(courseId);
                //1未完成 1已完成
                employeeBuyPri.setStatus((byte)2);
                employeeBuyPriMapper.updateBuyPriByCourse(employeeBuyPri);
            }

            logger.info("thread end...");
        }catch (InterruptedException e){
            logger.info("thread Interrupted...e=" + e);
            e.printStackTrace();
        }
    }
}
