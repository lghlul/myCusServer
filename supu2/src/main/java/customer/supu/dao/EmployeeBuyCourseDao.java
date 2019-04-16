package customer.supu.dao;


import java.util.List;
import java.util.Map;

import customer.supu.dto.EmployeeBuyCourseDto;
import customer.supu.mapper.EmployeeBuyCourseMapper;

public interface EmployeeBuyCourseDao extends EmployeeBuyCourseMapper{
	/**
	 * 根据客户id 课程id 查询已经购买的私教课
	 * @param map
	 * @return
	 */
	public List<EmployeeBuyCourseDto> selectEmpByCourseByList(Map<String, Object> map);
	/**
	 * 查询会员购买的所有工作室课程
	 * @param map
	 * @return
	 */
	public List<EmployeeBuyCourseDto> selectAllStudioCourseBuy(Map<String, Object> map);
	
	
	/**
	 * 查询会员购买的所有训练营课程
	 * @param map
	 * @return
	 */
	public List<EmployeeBuyCourseDto> selectAllGroupCourseBuy(Map<String, Object> map);

}
