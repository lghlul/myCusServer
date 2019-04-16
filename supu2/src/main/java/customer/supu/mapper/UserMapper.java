package customer.supu.mapper;

import customer.supu.po.EmployeeBuyCard;
import customer.supu.po.EmployeeBuyCardExample;
import customer.supu.po.UserData;
import customer.supu.po.UserPO;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	int updatevip(EmployeeBuyCard member);
	
	int updateuser(EmployeeBuyCard member);
	
	UserData selectuserById(Integer id);
	
	UserData selectvipById(Integer org);

	UserData selectvipByUserId(Integer org);


	
    int countByExample(UserData userData);

    int deleteByExample(EmployeeBuyCardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeBuyCard record);

    int insertSelective(EmployeeBuyCard record);

    List<UserPO> selectByExample(UserData userData);

    UserData selectByPrimaryKey(Integer id,Integer org);

    int updateByExampleSelective(@Param("record") EmployeeBuyCard record, @Param("example") EmployeeBuyCardExample example);

    int updateByExample(@Param("record") EmployeeBuyCard record, @Param("example") EmployeeBuyCardExample example);

    int updateByPrimaryKeySelective(EmployeeBuyCard record);

    int updateByPrimaryKey(EmployeeBuyCard record);
}