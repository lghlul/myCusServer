package customer.supu.mapper;

import customer.supu.po.CourseGroupTime;
import customer.supu.po.CourseGroupTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseGroupTimeMapper {
    int countByExample(CourseGroupTimeExample example);

    int deleteByExample(CourseGroupTimeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseGroupTime record);

    int insertSelective(CourseGroupTime record);

    List<CourseGroupTime> selectByExample(CourseGroupTimeExample example);

    CourseGroupTime selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourseGroupTime record, @Param("example") CourseGroupTimeExample example);

    int updateByExample(@Param("record") CourseGroupTime record, @Param("example") CourseGroupTimeExample example);

    int updateByPrimaryKeySelective(CourseGroupTime record);

    int updateByPrimaryKey(CourseGroupTime record);
    
    CourseGroupTime selectToDay(CourseGroupTime obj);
}