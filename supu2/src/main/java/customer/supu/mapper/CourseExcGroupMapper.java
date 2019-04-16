package customer.supu.mapper;

import customer.supu.po.CourseExcGroup;
import customer.supu.po.CourseExcGroupExample;
import customer.supu.po.CourseExcGroupWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseExcGroupMapper {
    int countByExample(CourseExcGroupExample example);

    int deleteByExample(CourseExcGroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseExcGroupWithBLOBs record);

    int insertSelective(CourseExcGroupWithBLOBs record);

    List<CourseExcGroupWithBLOBs> selectByExampleWithBLOBs(CourseExcGroupExample example);

    List<CourseExcGroup> selectByExample(CourseExcGroupExample example);

    CourseExcGroupWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourseExcGroupWithBLOBs record, @Param("example") CourseExcGroupExample example);

    int updateByExampleWithBLOBs(@Param("record") CourseExcGroupWithBLOBs record, @Param("example") CourseExcGroupExample example);

    int updateByExample(@Param("record") CourseExcGroup record, @Param("example") CourseExcGroupExample example);

    int updateByPrimaryKeySelective(CourseExcGroupWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CourseExcGroupWithBLOBs record);

    int updateByPrimaryKey(CourseExcGroup record);
}