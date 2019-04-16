package customer.supu.service;


import customer.supu.common.po.Page;
import customer.supu.common.po.PageResponse;
import customer.supu.dto.CoachTimeDto;
import customer.supu.dto.CoachTimeEditDto;

public interface PriCourseTimeService {
	/**
	 * 添加选择时间类型
	 * @param coachTimeDto
	 * @throws Exception
	 */
	public  void addTime(CoachTimeDto coachTimeDto) throws Exception;

	/**
	 * 获取教练的  时间
	 * @param coachId  教练id
	 * @param date 日期
	 * @return
	 * @throws Exception
	 */
	public CoachTimeEditDto selectPriCourseTime (Integer coachId,String date) throws Exception;


	/**
	 * 编辑保存
	 * @param coachTimeDto
	 * @throws Exception
	 */
	public void editSave(CoachTimeDto coachTimeDto,String date) throws Exception;

	/**
	 * 查询教练   各个月份的时间
	 * @param coachId 根据教练id查询
	 * @param selectYmonth  根据选择月份查询  2018-07
	 * @return
	 * @throws Exception
	 */
	public  PageResponse selectCoachTimeList(Page page,Integer coachId,String selectYmonth) throws Exception;
}
