package customer.supu.mapper;

import customer.supu.po.EmployeeBuyCard;
import customer.supu.po.EmployeeBuyCardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeBuyCardMapper {
    int countByExample(EmployeeBuyCardExample example);

    int deleteByExample(EmployeeBuyCardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeBuyCard record);

    int insertSelective(EmployeeBuyCard record);

    List<EmployeeBuyCard> selectByExample(EmployeeBuyCardExample example);

    EmployeeBuyCard selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmployeeBuyCard record, @Param("example") EmployeeBuyCardExample example);

    int updateByExample(@Param("record") EmployeeBuyCard record, @Param("example") EmployeeBuyCardExample example);

    int updateByPrimaryKeySelective(EmployeeBuyCard record);

    int updateByPrimaryKey(EmployeeBuyCard record);
    
    int updateByUserId(EmployeeBuyCard record);
    
    List<EmployeeBuyCard> selectByUserId(Integer userId);


    int delete(String id);
}