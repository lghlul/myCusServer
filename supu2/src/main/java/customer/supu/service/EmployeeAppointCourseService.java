package customer.supu.service;

import customer.supu.common.po.Page;
import customer.supu.common.po.PageResponse;
import customer.supu.dto.EmployeeAppointCourseDto;

public interface EmployeeAppointCourseService {

	/**
	 * 根据条件查询所有订单
	 * @param page  分页参数
	 * @param orderDto
	 * @return
	 * @throws Exception
	 */
	public PageResponse selectAllByList(Page page, EmployeeAppointCourseDto employeeAppointCourseDto) throws Exception;


	/**
	 * 拼接教练名称
	 * @param courseId 课程id
	 * @param type 课程类型
	 * @return
	 * @throws Exception
	 */
	public String selectCourseCoachByCid(Integer courseId,Integer type)throws Exception;

}
