package customer.supu.mapper;

import customer.supu.po.CoachTime;
import customer.supu.po.CoachTimeExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CoachTimeMapper {
    int countByExample(CoachTimeExample example);

    int deleteByExample(CoachTimeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CoachTime record);

    int insertSelective(CoachTime record);

    List<CoachTime> selectByExample(CoachTimeExample example);

    CoachTime selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CoachTime record, @Param("example") CoachTimeExample example);

    int updateByExample(@Param("record") CoachTime record, @Param("example") CoachTimeExample example);

    int updateByPrimaryKeySelective(CoachTime record);

    int updateByPrimaryKey(CoachTime record);

    List<CoachTime> selectCoachTime(CoachTime coachTime);

}