package customer.supu.mapper;

import customer.supu.po.CoachCertificate;
import customer.supu.po.CoachCertificateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CoachCertificateMapper {
    int countByExample(CoachCertificateExample example);

    int deleteByExample(CoachCertificateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CoachCertificate record);

    int insertSelective(CoachCertificate record);

    List<CoachCertificate> selectByExample(CoachCertificateExample example);

    CoachCertificate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CoachCertificate record, @Param("example") CoachCertificateExample example);

    int updateByExample(@Param("record") CoachCertificate record, @Param("example") CoachCertificateExample example);

    int updateByPrimaryKeySelective(CoachCertificate record);

    int updateByPrimaryKey(CoachCertificate record);
}