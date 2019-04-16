package customer.supu.dao;

import java.util.List;
import java.util.Map;

import customer.supu.dto.CourseStudioTimeDto;
import customer.supu.mapper.CourseStudioTimeMapper;

public interface CourseStudioTimeDao extends CourseStudioTimeMapper{

	/**
	 * 根据工作室课程id 查询某课程所有计划时间内的排期列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<CourseStudioTimeDto> selectListByCourseId(Map<String,Object> map) throws Exception;

	/**
	 * 根据工作室课程id 查询某课程每一天 所有课程时间列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<CourseStudioTimeDto> selectTimeListByCourseId(Map<String,Object> map) throws Exception;


	/**
	 * 查询编辑工作室的时间   是否和数据库中有冲突
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer   selectStudioTimeIsConflict(Map<String,Object> map) throws Exception;

	/**
	 * 查询工作室时间
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<CourseStudioTimeDto> selectTimeList(Map<String,Object> map) throws Exception;


}
