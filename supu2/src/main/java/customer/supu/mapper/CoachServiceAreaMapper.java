package customer.supu.mapper;

import customer.supu.po.CoachServiceArea;
import customer.supu.po.CoachServiceAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CoachServiceAreaMapper {
    int countByExample(CoachServiceAreaExample example);

    int deleteByExample(CoachServiceAreaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CoachServiceArea record);

    int insertSelective(CoachServiceArea record);

    List<CoachServiceArea> selectByExample(CoachServiceAreaExample example);

    CoachServiceArea selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CoachServiceArea record, @Param("example") CoachServiceAreaExample example);

    int updateByExample(@Param("record") CoachServiceArea record, @Param("example") CoachServiceAreaExample example);

    int updateByPrimaryKeySelective(CoachServiceArea record);

    int updateByPrimaryKey(CoachServiceArea record);
}