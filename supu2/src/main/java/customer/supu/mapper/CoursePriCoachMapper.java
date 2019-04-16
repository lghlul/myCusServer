package customer.supu.mapper;

import customer.supu.po.CoursePriCoach;
import customer.supu.po.CoursePriCoachExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CoursePriCoachMapper {
    int countByExample(CoursePriCoachExample example);

    int deleteByExample(CoursePriCoachExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CoursePriCoach record);

    int insertSelective(CoursePriCoach record);

    List<CoursePriCoach> selectByExampleWithBLOBs(CoursePriCoachExample example);

    List<CoursePriCoach> selectByExample(CoursePriCoachExample example);

    CoursePriCoach selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CoursePriCoach record, @Param("example") CoursePriCoachExample example);

    int updateByExampleWithBLOBs(@Param("record") CoursePriCoach record, @Param("example") CoursePriCoachExample example);

    int updateByExample(@Param("record") CoursePriCoach record, @Param("example") CoursePriCoachExample example);

    int updateByPrimaryKeySelective(CoursePriCoach record);

    int updateByPrimaryKeyWithBLOBs(CoursePriCoach record);

    int updateByPrimaryKey(CoursePriCoach record);
}