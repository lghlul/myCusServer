package customer.supu.dao;

import java.util.List;
import java.util.Map;

import customer.supu.domain.CoursePriCoachBean;
import customer.supu.mapper.CoursePriCoachMapper;
import customer.supu.po.CoursePriCoach;

public interface CoursePriCoachDao extends CoursePriCoachMapper{

	/**
	 * 前台  获取私教
	 * @param map
	 * @return
	 */
	List<CoursePriCoach> selectCoursePri(Map<String,Object> map);


	/**
	 * 根据教练id获取该教练下的私教课或精品团课
	 * @param map
	 * @return
	 */
	List<CoursePriCoach> selectCoachPriByCoachId(Map<String,Object> map);
	
	
	/**
	 * 获取推荐私教课程
	 * @param map
	 * @return
	 */
	List<CoursePriCoach> selectCourseIsPopular();


	/*
	 * @author ll
	 * @Description 根据ID查询课程
	 * @date 2018/8/28 15:14
	 * @param [id]
	 * @return customer.supu.domain.CoursePriCoachBean
	 */
	CoursePriCoachBean queryPriCourseById(int id);

}
