package customer.supu.dao;

import java.util.List;
import java.util.Map;

import customer.supu.dto.EmployeeAppointCourseDto;
import customer.supu.mapper.EmployeeAppointCourseMapper;

public interface EmployeeAppointCourseDao extends EmployeeAppointCourseMapper{

	/**
	 * 查询所有预约课程
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<EmployeeAppointCourseDto> selectEmpAppCourseByList(Map<String,Object> map) throws Exception;

	/**
	 * 计算数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer countByList(Map<String,Object> map) throws Exception;
}
