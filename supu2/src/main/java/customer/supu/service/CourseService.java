package customer.supu.service;

import java.util.Date;
import java.util.List;


import customer.supu.common.po.Page;
import customer.supu.common.po.PageResponse;
import customer.supu.domain.CoursePriCoachBean;
import customer.supu.dto.CourseAllDto;
import customer.supu.dto.CourseDto;
import customer.supu.dto.CourseExcGroupDto;
import customer.supu.dto.CourseExcTimeDto;
import customer.supu.dto.CourseExcTimeWeekDto;
import customer.supu.dto.CourseGroupTimeDto;
import customer.supu.dto.CourseStudioTimeDto;
import customer.supu.dto.CourseStudioTimeAddDto;
import customer.supu.dto.CourseStudioTimeShowDto;
import customer.supu.po.CourseExcGroupWithBLOBs;
import customer.supu.po.CoursePriCoach;
import customer.supu.po.CourseStudioTime;


/**
 * 课程管理业务类接口
 * @author
 *
 */
public interface CourseService {

	/**
	 * 查询所有课程
	 */
	public PageResponse selectAllByList(Page page,CourseDto courseDto) throws Exception;
	
	
	/**
	 * 查询所有课程
	 */
	public List<CoursePriCoach> selectCourseIsPopular() throws Exception;



	/**
	 * 保存添加
	 * @param type 0：私教课  1：精品团课
	 * @param courseExcGroup
	 * @param coursePriCoach
	 * @throws Exception
	 */
	public void addSave(String type,CourseAllDto courseAllDto) throws Exception;

	/**
	 *
	 * @param type type 0：私教课  1：精品团课
	 * @param courseAllDto 课程
	 * @throws Exception
	 */
	public void editSave(String type,CourseAllDto courseAllDto) throws Exception;

	/**
	 * 改变课程状态
	 */
	public void updateCourseStatus(Integer status,Integer id,Integer type) throws Exception;


	/**
	 * 根据课程id获取精品课程
	 * @param courseId
	 * @throws Exception
	 */
	public CourseExcGroupWithBLOBs selectCourseGroupById(Integer courseId,Integer type) throws Exception;


	/**
	 * 根据课程id获取私教课
	 * @param courseId
	 * @return
	 * @throws Exception
	 */
	public CoursePriCoach selectCoursePriById(Integer courseId) throws Exception;


	/**
	 * 前台异步获取私教课
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<CoursePriCoach> selectCoursePriCoach(Page page) throws Exception;


	/**
	 * 根据教练id获取该教练下的私教课或精品团课    type=0私教  1团课
	 * @param coachId
	 * @return
	 * @throws Exception
	 */
	public List<CoursePriCoach> selectCoachPriByCoachId(Integer coachId,Integer type)throws Exception;



	/**
	 * 根据课程id获取私教课   后台
	 * @param courseId
	 * @return
	 * @throws Exception
	 */
	public CoursePriCoach selectCoursePriById_Back(Integer courseId) throws Exception;

	  /**
	   * 保存团课排期
	   * @param courseGroupTimeDto
	   * @param year  年
	   * @param month 月
	   * @param courseId 课程id
	   */
	 public void addSaveTime(CourseGroupTimeDto courseGroupTimeDto,String year,String month,Integer courseId) throws Exception;


	 /**
	  * 编辑保存
	  * @param courseGroupTimeDto
	  * @throws Exception
	  */
	 public void editSaveTime(CourseGroupTimeDto courseGroupTimeDto)throws Exception;

	 /**
	  * 根据课程id ,年月 查询课程的排期时间
	  * @param courseId 课程id
	  * @param year 年
	  * @param month 月
	  * @return
	  */
	 public List<CourseGroupTimeDto> selectCourseGroupTime(Integer courseId,String year,String month)throws Exception;

	 /**
	  *	根据团课id查询团课排期列表
	  * @param courseId 根据团课id
	  * @return
	  * @throws Exception
	  */
	 public List<CourseGroupTimeDto> selectListByCourseId(Integer courseId)throws Exception;

	  /**
	   * 获取教练名称
	   */
	  public String getCochAllNames(String coachs)throws Exception;




	 /**
	  * 查询本月是否已经添加过记录  有：返回true  没有：false
	  * @param courseId 课程id
	  * @param year  年
	  * @param month 月
	  * @return
	  * @throws Exception
	  */
	 public boolean isAlreadyAddTime(Integer courseId,String year,String month)throws Exception;

		/**
		 * 根据课程id获取课程
		 * @param courseId
		 * @return
		 * @throws Exception
		 */
		public CourseExcGroupWithBLOBs selectCourseGroupById(Integer courseId) throws Exception;


		/**
		  * 添加精品团课排期
		  * @param courseId 课程id
		  * @param date 日期
		  * @param courseExcTimeList
		 * @return
		  */

	public Date add_exc_Time(Integer courseId,Date startDate,CourseExcTimeDto courseExcTimeDto) throws Exception;

		/**
		 * 根据精品团课id 查询某精品团课所有计划时间内的排期列表
		 * @param courseId 精品团课id
		 * @return
		 */
		public List<CourseExcTimeDto> selectExcListByCourseId(Integer courseId)throws Exception;

		/**
		 * 根据精品团课编号，开始日期查询
		 * @param courseId 精品团课编号
		 * @param startdate 开始日期
		 * @return
		 * @throws Exception
		 */
		public List<CourseExcTimeDto> detial_exc(Integer courseId,Date startdate)throws Exception;


		/**
		 * 编辑训练营 排期
		 * @param courseId
		 * @param startDate
		 * @param courseExcTimeDto
		 * @throws Exception
		 */
		public void edit_exc_time(Integer courseId,Date startDate,Date editStartDate,CourseExcTimeDto courseExcTimeDto)throws Exception;


		/**
		 * 根据courseid 查询精品团课排期
		 * @param courseId 精品团课id
		 * @return
		 * @throws Exception
		 */
		public List<CourseExcTimeDto> selectExctimeByCourseId(Integer courseId,Date startdate,Date enddate)throws Exception;


		/**
		 * 获取训练营的 编辑的    排期
		 * @param excTimeDtos
		 * @return
		 * @throws Exception
		 */
		public CourseExcTimeWeekDto edit_ext(Integer courseId,Date startdate)throws Exception;

		/**
		* 根据工作室课程id 查询此课程所有计划时间内的排期列表
		* @param courseId 工作室课程id
		* @return
		*/
		public List<CourseStudioTimeDto> selectStudioListByCourseId(Integer courseId) throws Exception;

		/**
		 * 添加工作室排期时间
		 * @param courseStudioTimeAddDto
		 */
		public void addStudioTimeSave(Integer courseId,String year,String month, String day,CourseStudioTimeAddDto courseStudioTimeAddDto )throws Exception;



		/**
		 * 根据日期查询工作室 排期
		 * @param courseId  课程id
		 * @param year 年
		 * @param month 月
		 * @param day 日
		 * @return
		 * @throws Exception
		 */
		public List<CourseStudioTimeDto> selectCourseStudioTimeByDate(Integer courseId,String year,String month,String day)throws Exception;

		/**
		 * 编辑保存
		 * @param courseStudioTime
		 * @param beforeStartTime
		 * @param beforeEndTime
		 * @return
		 * @throws Exception
		 */
		public void editStudioTimeSave(CourseStudioTime courseStudioTime)throws Exception;

		/**
		 * 根据课程id和年月查询数据   展示到页面中
		 * @param courseStudioTime
		 * @return
		 * @throws Exception
		 */
		public  List<CourseStudioTimeShowDto>  selectStudioTimeDateAndList(Integer courseId,String year,String month) throws Exception;

		/**
		 * 根据主键id 删除工作室排期时间
		 * @param id
		 * @throws Exception
		 */
		public void delStudioTime(Integer id) throws Exception;

		/**
		 * 根据主键id  查询工作室某个排期时间
		 * @param id
		 * @return
		 * @throws Exception
		 */
		public CourseStudioTime  selectStudioTimeById(Integer id) throws Exception;


		/**
		 * 是否进行过   工作室排期
		 * @param courseId
		 * @param date
		 * @param model
		 * @return
		 */
		 public boolean isAlreadyAddStudioTime(Integer courseId,String year,String month)throws Exception;
		 
		 
		//得到团员信息	
		 public CourseExcGroupDto selectCourseGroupDtoByCourseId(Integer courseId)throws Exception;


		 /*
		  * @author ll
		  * @Description 课程详情
		  * @date 2018/8/28 15:12
		  * @param [id]
		  * @return customer.supu.domain.CoursePriCoachBean
		  */
		public CoursePriCoachBean getPriCoachDetail(int id);


}
