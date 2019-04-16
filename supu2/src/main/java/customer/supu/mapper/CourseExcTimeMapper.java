package customer.supu.mapper;

import customer.supu.po.CourseExcTime;
import customer.supu.po.CourseExcTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseExcTimeMapper {
    int countByExample(CourseExcTimeExample example);

    int deleteByExample(CourseExcTimeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseExcTime record);

    int insertSelective(CourseExcTime record);

    List<CourseExcTime> selectByExample(CourseExcTimeExample example);

    CourseExcTime selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourseExcTime record, @Param("example") CourseExcTimeExample example);

    int updateByExample(@Param("record") CourseExcTime record, @Param("example") CourseExcTimeExample example);

    int updateByPrimaryKeySelective(CourseExcTime record);

    int updateByPrimaryKey(CourseExcTime record);
}