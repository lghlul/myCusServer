package customer.supu.mapper;

import customer.supu.po.MemberCard;
import customer.supu.po.MemberCardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberCardMapper {
    int countByExample(MemberCardExample example);

    int deleteByExample(MemberCardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberCard record);

    int insertSelective(MemberCard record);

    List<MemberCard> selectByExampleWithBLOBs(MemberCardExample example);

    List<MemberCard> selectByExample(MemberCardExample example);

    MemberCard selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemberCard record, @Param("example") MemberCardExample example);

    int updateByExampleWithBLOBs(@Param("record") MemberCard record, @Param("example") MemberCardExample example);

    int updateByExample(@Param("record") MemberCard record, @Param("example") MemberCardExample example);

    int updateByPrimaryKeySelective(MemberCard record);

    int updateByPrimaryKeyWithBLOBs(MemberCard record);

    int updateByPrimaryKey(MemberCard record);
}