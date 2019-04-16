package customer.supu.dao;

import java.util.List;
import java.util.Map;

import customer.supu.dto.CoachDto;
import customer.supu.mapper.CoachMapper;

public interface CoachDao extends CoachMapper{
	/**
	 * 查询所有
	 */
	public List<CoachDto> selectCoachByList(Map<String,Object> map) throws Exception;


	/**
	 * 查询所有有效的教练 并且标记选中的
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<CoachDto> selectCoachChecked(Map<String,Object> map) throws Exception;

	/**
	 * 查询人气王教练
	 * @return
	 * @throws Exception
	 */

	public List<CoachDto> selectCoachIsPopular() throws Exception;


	/**
	 * 前台获取所有教练
	 * @return
	 * @throws Exception
	 */
	public List<CoachDto> selectAllCoach(Map<String,Object> map)throws Exception;


	/**
	 * 根据教练id获取教练信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public CoachDto selectCoachById(Map<String,Object> map)throws Exception;
	/**
	 * 根据团课id获取教练信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<CoachDto> selectGroupCoachById(Map<String,Object> map)throws Exception;


	/*
	 * @author ll
	 * @Description 根据课程和类型查询教练
	 * @date 2018/8/27 15:01
	 * @param [map]
	 * @return java.util.List<customer.supu.dto.CoachDto>
	 */
	public List<CoachDto> queryCourseCoach(Map<String , Object> map);

}
