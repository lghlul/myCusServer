package customer.supu.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import customer.supu.dto.CourseExcGroupDto;
import customer.supu.dto.CourseTimeDto;
import customer.supu.dto.EmployeeBuyCourseDto;
import customer.supu.dto.StoreDto;
import customer.supu.po.EmployeeAppointCourse;

/**
 * 会员约课业务接口
 * @author Administrator
 *
 */
public interface F_AboutClassService {
	/**
	 * 查询基础团课
	 * @param storeId  门店id
	 * @param week
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public List<CourseExcGroupDto> selectCourseExcGroup(Integer storeId,String week,String date,Integer start,Integer end,Integer signType) throws Exception;

	/**
	 * 获取 星期  日期   日期简写
	 */
	public List<Map> getDateAndWeek() throws Exception;


	/**
	 * 获取与手机端最近的门店
	 */
	public List<StoreDto> sortMinDistance(double lng,double lat,Integer memberCardId) throws Exception;

	/**
	 * 团课约课状态
	 * 1.约课
	 * 2.排队
	 * 3.不能排队
	 * @param id 团课id
	 * @throws Exception
	 */
	public CourseExcGroupDto getQueueStatus(Integer id,Date appointtime) throws Exception;

	/**
	 * 会员进行约课  排队
	 *
	 */
	public void insertEmployeeAppointCourse(EmployeeAppointCourse employeeAppointCourse,HttpSession session)throws Exception;
	/**
	 * 查询购买表中 会员购买的私教课
	 * @param userId 用户账号
	 * @param courseId 课程编号
	 */
	public List<EmployeeBuyCourseDto> selectEmployeeBuyCardByList(HttpSession session)throws Exception;

	/**
	 * 查询教练可以约课时间  集合
	 * @param coachid  教练id
	 */
	public List<CourseTimeDto>  selectEnableAppointCoachTime(Integer coachid,Integer courseid)throws Exception;

	/**
	 * 私教课预约
	 * @param session
	 * @param courseId
	 * @return
	 * @throws Exception
	 */
	public  Integer  insertEmployeeBuyCourseDto(HttpSession session,EmployeeAppointCourse employeeAppointCourse) throws Exception;
	/**
	 * 将要在预约成功页面展示的数据
	 * @param session
	 * @param employeeAppointCourse
	 * @return
	 * @throws Exception
	 */
	public EmployeeBuyCourseDto  getAppointCountAndEndTime(HttpSession session,EmployeeAppointCourse employeeAppointCourse)throws Exception;


	/**
	 * 取消预约
	 * @param id 预约id
	 * @throws Exception
	 */
	public void cancelAppointCourse(HttpSession session,Integer id) throws Exception;


	/**
	 * 该课程等是否开放  （超过三天的课程默认不开放）
	 * @param courseStartDate
	 * @return
	 * @throws ParseException
	 */
	public boolean  isOpen(Date courseStartDate) throws ParseException;

	/**
	 * 根据门店id获取门店距离
	 * @param lng  经度
	 * @param lat  纬度
	 * @param storeid  门店id
	 * @return
	 * @throws Exception
	 */
	public  StoreDto getStoreDistance(double lng,double lat,Integer storeid)throws Exception;

	/**
	 * 根据coachid查询coachname
	 * @param coachid
	 */
	public String getCoachnameById(String coachid)throws Exception;

	/**
	 * 查询购买表中 会员购买的工作室课程
	 * @param userId 用户账号
	 * @param courseId 课程编号
	 */
	public List<EmployeeBuyCourseDto> selectStudioCourseList(HttpSession session)throws Exception;


	/**
	 * 根据课程id查询是否存在此工作室课程
	 * @return
	 * @throws Exception
	 */
	public List<CourseExcGroupDto> isExistStudioCourse(Integer courseid)throws Exception;

	/**
	 * 查询教练可以约课时间  集合
	 * @param coachid  教练id
	 */
	public List<CourseTimeDto>  selectEnableAppointStudioTime(Integer courseid)throws Exception;

	/**
	 * 用户进行预约操作(工作室)
	 * (1)购买次数和预约次数的比较
	 * (2)是否预约过相同时间段的课程
	 * (3)预约某节课是判断 当前预约人数是否已满
	 * @param session
	 * @param courseTimeDto
	 * @throws Exception
	 */
	public void insertAppointStudioCourse(HttpSession session,CourseTimeDto courseTimeDto) throws Exception;

	/**
	 * 在预约成功后,返回开始时间和结束时间不为空的   预约时间集合
	 * @param appointCourses
	 * @return
	 * @throws Exception
	 */
	public List<EmployeeAppointCourse> getAppointSuccessStudio(List<EmployeeAppointCourse> appointCourses) throws Exception;
	
	
	/**
	 * 训练营
	 * @param appointCourses
	 * @return
	 * @throws Exception
	 */
	public List<EmployeeBuyCourseDto> selectCourseGroupList(HttpSession session) throws Exception;


}
