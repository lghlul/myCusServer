package customer.supu.dao;

import java.util.List;
import java.util.Map;

import customer.supu.dto.CourseExcGroupDto;
import customer.supu.mapper.CourseExcGroupMapper;
import customer.supu.po.CourseExcGroup;
import customer.supu.po.CoursePriCoach;

public interface CourseExcGroupDao extends CourseExcGroupMapper{

	/**
	 * 前台   获取精品团课
	 * @param map
	 * @return
	 */
	public List<CourseExcGroupDto> selectCourseExcGroup(Map<String,Object> map);
	/**
	 * 获取所有门店的精品课程
	 * @param map
	 */
	public List<CourseExcGroupDto>  selectAllCourseGroupList(Map<String,Object> map);

	/**
	 * 根据课程id查询是否存在此工作室课程
	 * @param map
	 * @return
	 */
	public List<CourseExcGroupDto> selectExistCourseGroup(Map<String,Object> map);

	/**
	 * 查询所有工作是课程
	 * @param map
	 * @return
	 */
	public List<CourseExcGroupDto> selectFontWxStudioList(Map<String,Object> map);
	
	
	//得到团员信息	
	public CourseExcGroupDto selectCourseGroupDtoByCourseId(Map<String,Object> map)throws Exception;

}
