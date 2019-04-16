package customer.supu.mapper;

import customer.supu.domain.StoreBean;
import customer.supu.po.Store;
import customer.supu.po.StoreExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface StoreMapper {
    int countByExample(StoreExample example);

    int deleteByExample(StoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Store record);

    int insertSelective(Store record);

    List<Store> selectByExample(StoreExample example);

    Store selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Store record, @Param("example") StoreExample example);

    int updateByExample(@Param("record") Store record, @Param("example") StoreExample example);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);

    /*
     * @author ll
     * @Description 查询课程门店
     * @date 2018/8/28 15:46
     * @param [map]
     * @return java.util.List<customer.supu.domain.StoreBean>
     */
    List<StoreBean> queryStoreByCourse(Map<String , Object> map);
}