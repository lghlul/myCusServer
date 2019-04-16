package customer.supu.mapper;

import customer.supu.po.SmsLog;
import customer.supu.po.SmsLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsLogMapper {
    int countByExample(SmsLogExample example);

    int deleteByExample(SmsLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SmsLog record);

    int insertSelective(SmsLog record);

    List<SmsLog> selectByExample(SmsLogExample example);

    SmsLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SmsLog record, @Param("example") SmsLogExample example);

    int updateByExample(@Param("record") SmsLog record, @Param("example") SmsLogExample example);

    int updateByPrimaryKeySelective(SmsLog record);

    int updateByPrimaryKey(SmsLog record);
}