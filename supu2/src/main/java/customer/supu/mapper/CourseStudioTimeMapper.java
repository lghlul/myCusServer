package customer.supu.mapper;

import customer.supu.po.CourseStudioTime;
import customer.supu.po.CourseStudioTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseStudioTimeMapper {
    int countByExample(CourseStudioTimeExample example);

    int deleteByExample(CourseStudioTimeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseStudioTime record);

    int insertSelective(CourseStudioTime record);

    List<CourseStudioTime> selectByExample(CourseStudioTimeExample example);

    CourseStudioTime selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourseStudioTime record, @Param("example") CourseStudioTimeExample example);

    int updateByExample(@Param("record") CourseStudioTime record, @Param("example") CourseStudioTimeExample example);

    int updateByPrimaryKeySelective(CourseStudioTime record);

    int updateByPrimaryKey(CourseStudioTime record);
}