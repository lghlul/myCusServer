package customer.supu.mapper;

import customer.supu.po.EmployeeBuyCourse;
import customer.supu.po.EmployeeBuyCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeBuyCourseMapper {
    int countByExample(EmployeeBuyCourseExample example);

    int deleteByExample(EmployeeBuyCourseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeBuyCourse record);

    int insertSelective(EmployeeBuyCourse record);

    List<EmployeeBuyCourse> selectByExample(EmployeeBuyCourseExample example);

    EmployeeBuyCourse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmployeeBuyCourse record, @Param("example") EmployeeBuyCourseExample example);

    int updateByExample(@Param("record") EmployeeBuyCourse record, @Param("example") EmployeeBuyCourseExample example);

    int updateByPrimaryKeySelective(EmployeeBuyCourse record);

    int updateByPrimaryKey(EmployeeBuyCourse record);
}