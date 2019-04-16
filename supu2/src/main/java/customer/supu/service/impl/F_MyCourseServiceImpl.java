package customer.supu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import customer.supu.dao.CourseDao;
import customer.supu.dao.EmployeeAppointCourseDao;
import customer.supu.dto.CourseDto;
import customer.supu.jenum.DataValidEnum;
import customer.supu.po.EmployeeAppointCourseExample;
import customer.supu.service.F_MyCourseService;

@Service
public class F_MyCourseServiceImpl implements F_MyCourseService{


	@Autowired
	private EmployeeAppointCourseDao employeeAppointCourseDao;

	@Autowired
	private CourseDao courseDao;
	/**
	 * 获取用户 预约的课程数目
	 * @return
	 */
	public Integer countAppiontCourse(HttpServletRequest request) throws Exception{
		Integer userId= (Integer) request.getSession().getAttribute("employeeId");
		EmployeeAppointCourseExample example=new EmployeeAppointCourseExample();
		example.createCriteria().andUseridEqualTo(userId).andStatusEqualTo(DataValidEnum.EFFECT.getCode());
		return employeeAppointCourseDao.countByExample(example);
	}


	/**
	 * 获取已经结束或未完成的课程
	 * @param type  0：未完成   1：已结束
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public List<CourseDto>  selectIsFinishedCourse(Integer type,HttpSession session)throws Exception{
		Integer userId= (Integer) session.getAttribute("employeeId");
		Map<String,Object> map=new HashMap<String,Object>();

		map.put("type", type);
		map.put("userId", userId);

		List<CourseDto> courseDtos=courseDao.selectFinishedCourse(map);
		return courseDtos;
	}




}
