package customer.supu.mapper;

import customer.supu.po.MemberCardStore;
import customer.supu.po.MemberCardStoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberCardStoreMapper {
    int countByExample(MemberCardStoreExample example);

    int deleteByExample(MemberCardStoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberCardStore record);

    int insertSelective(MemberCardStore record);

    List<MemberCardStore> selectByExample(MemberCardStoreExample example);

    MemberCardStore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemberCardStore record, @Param("example") MemberCardStoreExample example);

    int updateByExample(@Param("record") MemberCardStore record, @Param("example") MemberCardStoreExample example);

    int updateByPrimaryKeySelective(MemberCardStore record);

    int updateByPrimaryKey(MemberCardStore record);
}