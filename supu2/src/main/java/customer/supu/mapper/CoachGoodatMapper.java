package customer.supu.mapper;

import customer.supu.po.CoachGoodat;
import customer.supu.po.CoachGoodatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CoachGoodatMapper {
    int countByExample(CoachGoodatExample example);

    int deleteByExample(CoachGoodatExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CoachGoodat record);

    int insertSelective(CoachGoodat record);

    List<CoachGoodat> selectByExample(CoachGoodatExample example);

    CoachGoodat selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CoachGoodat record, @Param("example") CoachGoodatExample example);

    int updateByExample(@Param("record") CoachGoodat record, @Param("example") CoachGoodatExample example);

    int updateByPrimaryKeySelective(CoachGoodat record);

    int updateByPrimaryKey(CoachGoodat record);
}