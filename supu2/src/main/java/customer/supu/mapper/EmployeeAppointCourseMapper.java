package customer.supu.mapper;

import customer.supu.po.EmployeeAppointCourse;
import customer.supu.po.EmployeeAppointCourseExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface EmployeeAppointCourseMapper {
    int countByExample(EmployeeAppointCourseExample example);

    int deleteByExample(EmployeeAppointCourseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeAppointCourse record);

    int insertSelective(EmployeeAppointCourse record);

    List<EmployeeAppointCourse> selectByExample(EmployeeAppointCourseExample example);

    EmployeeAppointCourse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmployeeAppointCourse record, @Param("example") EmployeeAppointCourseExample example);

    int updateByExample(@Param("record") EmployeeAppointCourse record, @Param("example") EmployeeAppointCourseExample example);

    int updateByPrimaryKeySelective(EmployeeAppointCourse record);

    int updateByPrimaryKey(EmployeeAppointCourse record);


    List<EmployeeAppointCourse> selectAppointTime(EmployeeAppointCourse employeeAppointCourse);

    List<EmployeeAppointCourse> selectAppointPriPage(EmployeeAppointCourse employeeAppointCourse);

    int selectAppointPriCount(EmployeeAppointCourse employeeAppointCourse);

    List<EmployeeAppointCourse> selectAppointTimeByPri(Map<String , Object> map);


    List<EmployeeAppointCourse> selectUnFinishPri();

}