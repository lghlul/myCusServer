package customer.supu.dao;

import java.util.List;
import java.util.Map;

import customer.supu.dto.CourseExcTimeDto;
import customer.supu.mapper.CourseExcTimeMapper;

public interface CourseExcTimeDao extends CourseExcTimeMapper{

	/**
	 * 根据精品团课id 查询某精品团课所有计划时间内的排期列表
	 * @param map
	 * @return
	 */
	public List<CourseExcTimeDto> selectExcListByCourseId(Map<String,Object> map);


	/**
	 * 根据课程id查询该训练营的最大结束时间
	 * @param map
	 * @return
	 */
	public CourseExcTimeDto selectMaxDateByCourseId(Map<String,Object> map);

	/**
	 * 根据精品团课id 查询精品团课某个计划时间内的  详细排期
	 * @param map
	 * @return
	 */
	public List<CourseExcTimeDto> selectExcListByWeek(Map<String,Object> map);

	/**
	 * 根据courseid 查询精品团课排期
	 * @param map
	 * @return
	 */
	public List<CourseExcTimeDto> selectCourseExcTimeList(Map<String,Object> map);
}
