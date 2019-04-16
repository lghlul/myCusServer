package customer.supu.dao;

import java.util.List;
import java.util.Map;

import customer.supu.dto.CoachTimeDto;
import customer.supu.mapper.CoachTimeMapper;

public interface CoachTimeDao extends CoachTimeMapper{

	/**
	 * 批量插入
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public void insertCourseTimeList(Map<String,Object> map) throws Exception;


	/**
	 * 查询教练时间
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<CoachTimeDto> selectCoachTimeList(Map<String,Object> map) throws Exception;

	/**
	 * 计算总数
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer countList(Map<String,Object> map) throws Exception;
}
