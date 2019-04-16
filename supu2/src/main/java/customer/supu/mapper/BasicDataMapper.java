package customer.supu.mapper;

import customer.supu.po.BasicData;
import customer.supu.po.BasicDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BasicDataMapper {
    int countByExample(BasicDataExample example);

    int deleteByExample(BasicDataExample example);

    int deleteByPrimaryKey(Integer basicdataid);

    int insert(BasicData record);

    int insertSelective(BasicData record);

    List<BasicData> selectByExample(BasicDataExample example);

    BasicData selectByPrimaryKey(Integer basicdataid);

    int updateByExampleSelective(@Param("record") BasicData record, @Param("example") BasicDataExample example);

    int updateByExample(@Param("record") BasicData record, @Param("example") BasicDataExample example);

    int updateByPrimaryKeySelective(BasicData record);

    int updateByPrimaryKey(BasicData record);
}