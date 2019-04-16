package customer.supu.dao;

import java.util.List;
import java.util.Map;

import customer.supu.dto.CourseDto;

public interface CourseDao{

	/**
	 * 查询所有
	 */
	public List<CourseDto> selectCourseByList(Map<String,Object> map) throws Exception;
	/**
	 * 查询总数
	 */
	public Integer countByList(Map<String,Object> map) throws Exception;


	/**
	 * 查询用户的已经完成和未完成的课程
	 * @param map
	 * @return   type=1已经完成   type=0 未完成
	 * @throws Exception
	 */

	public List<CourseDto>  selectFinishedCourse(Map<String,Object> map) throws Exception;
}
