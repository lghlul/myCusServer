package customer.supu.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import customer.supu.dto.CourseDto;

public interface F_MyCourseService {
	/**
	 * 获取用户 预约的课程数目
	 * @return
	 */
	public Integer countAppiontCourse(HttpServletRequest request) throws Exception;

	/**
	 * 获取已经结束或未完成的课程
	 * @param type  0：未完成   1：已结束
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public List<CourseDto>  selectIsFinishedCourse(Integer type,HttpSession session)throws Exception;

}
