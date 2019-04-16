package customer.supu.mapper;

import customer.supu.po.CoachStores;
import customer.supu.po.CoachStoresExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CoachStoresMapper {
    int countByExample(CoachStoresExample example);

    int deleteByExample(CoachStoresExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CoachStores record);

    int insertSelective(CoachStores record);

    List<CoachStores> selectByExample(CoachStoresExample example);

    CoachStores selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CoachStores record, @Param("example") CoachStoresExample example);

    int updateByExample(@Param("record") CoachStores record, @Param("example") CoachStoresExample example);

    int updateByPrimaryKeySelective(CoachStores record);

    int updateByPrimaryKey(CoachStores record);
}