package customer.supu.dao;

import java.util.List;
import java.util.Map;

import customer.supu.dto.CourseGroupTimeDto;
import customer.supu.mapper.CourseGroupTimeMapper;
import customer.supu.po.CourseGroupTime;

public interface CourseGroupTimeDao extends CourseGroupTimeMapper{


	/**
	 * 根据条件获取  排期信息
	 * @param map
	 * @return
	 */
	public List<CourseGroupTimeDto> selectCourseGroupTimeByCondition(Map<String,Object> map);

	/**
	 * 根据团课id 查询某团课每个月排期列表
	 * @param map
	 * @return
	 */
	public List<CourseGroupTimeDto> selectListByCourseId(Map<String,Object> map);
}
