package customer.supu.appoint;

import customer.supu.common.utils.DateTimeUtil;
import customer.supu.domain.EmployeeBuyPri;
import customer.supu.mapper.EmployeeAppointCourseMapper;
import customer.supu.mapper.EmployeeBuyPriMapper;
import customer.supu.po.EmployeeAppointCourse;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @CLassName AppointInit
 * @Description TODO
 * @Author ll
 * @Date 2018/11/6 10:36
 **/
@Component
public class AppointInit implements InitializingBean {

    @Autowired
    private EmployeeAppointCourseMapper employeeAppointCourseMapper;

    @Autowired
    private EmployeeBuyPriMapper employeeBuyPriMapper;

    @Override
    public void afterPropertiesSet() throws Exception {
        initPoint();
    }


    private void initPoint(){

        //查询出所有 状态为1(预约状态的私教课)
        List<EmployeeAppointCourse> employeeAppointCourses = employeeAppointCourseMapper.selectUnFinishPri();

        //遍历创建线程
        if(employeeAppointCourses != null && employeeAppointCourses.size() > 0){
            for(EmployeeAppointCourse employeeAppointCourse : employeeAppointCourses){
                Long endTime = DateTimeUtil.getTimestamp(DateTimeUtil.getDateWithoutTime(employeeAppointCourse.getAppointtime()) + " " + employeeAppointCourse.getEndtime() + ":00");

                EmployeeBuyPri employeeBuyPri = new EmployeeBuyPri();
                employeeBuyPri.setCourseId(employeeAppointCourse.getCourseid());
                employeeBuyPri.setCoachId(employeeAppointCourse.getCoachId().intValue());
                employeeBuyPri.setUserId(employeeAppointCourse.getUserid());

                List<EmployeeBuyPri> buyPris = employeeBuyPriMapper.selectAll(employeeBuyPri);

                AppointThread appointThread = new AppointThread(endTime , employeeAppointCourseMapper , employeeAppointCourse,buyPris.get(0).getTotalClass() , employeeBuyPriMapper) ;

                AppointManage.putThread(employeeAppointCourse.getId() , appointThread);
            }
        }
    }
}
