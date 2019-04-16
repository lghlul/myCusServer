package customer.supu.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import customer.supu.common.po.Page;
import customer.supu.common.po.PageResponse;
import customer.supu.common.utils.DateTimeUtil;
import customer.supu.common.utils.StringUtils;
import customer.supu.dto.CourseAllDto;
import customer.supu.dto.CourseDto;
import customer.supu.dto.CourseExcTimeDto;
import customer.supu.dto.CourseGroupTimeDto;
import customer.supu.dto.CourseStudioTimeAddDto;

import customer.supu.jenum.ResultCodeEnum;
import customer.supu.po.CourseExcGroupWithBLOBs;
import customer.supu.po.CoursePriCoach;
import customer.supu.po.CourseStudioTime;
import customer.supu.service.BasicDataService;
import customer.supu.service.CoachService;
import customer.supu.service.CourseService;
import customer.supu.service.StoreService;

/**
 * 课程管理控制器
 * @author
 *
 */
@Controller
@RequestMapping("/user/course")
public class B_CourseController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private BasicDataService basicDataService;


	@Autowired
	private StoreService storeService;


	@Autowired
	private CoachService coachService;
	/**
	 * 进入页面
	 * @return
	 */
	@RequestMapping(value="/listPage",method=RequestMethod.GET)
	public String listPge(Model model){
		try {
			//课程状态
			model.addAttribute("coursetype", basicDataService.getBasicDataByType("coursetype"));
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "/course/courselist";

	}

	/**
	 * 异步获取列表数据
	 */
	@RequestMapping(value="/getCourseList",method = RequestMethod.GET)
	@ResponseBody
	public PageResponse getCourseList(Page page,CourseDto courseDto){
		  try {
			  PageResponse courseList=courseService.selectAllByList(page, courseDto);

			  return courseList;

	        } catch (Exception e) {

	        	e.printStackTrace();
	        }
	        return null;
	}


	/**
	 * 进入添加页面
	 * @return
	 */
	@RequestMapping(value="addPage",method=RequestMethod.GET)
	public String addPage(Model model,@RequestParam(value="type")String type){
		try {
			//课程教练
			model.addAttribute("coach", coachService.selectAllCoach());
			//获取门店区域
			model.addAttribute("area", storeService.selectStoreByArea(null));

			if("0".equals(type)){//私教页面
				//获取课程健身需求
				model.addAttribute("courseFitDemand", basicDataService.getBasicDataByType("courseFitDemand"));

				return "/course/add_course_pri";
			}else if("1".equals(type)){//团课页面
					//获取小时
		/*			model.addAttribute("hour", GetTimeUtil.selectHours());

					//获取分钟
					model.addAttribute("minutes",GetTimeUtil.selectMiutes());
					//获取月
					model.addAttribute("months", GetTimeUtil.selectMonths());
					//星期
					model.addAttribute("week", basicDataService.getBasicDataByType("week"));

					//当前时间
					model.addAttribute("date",new Date());*/

				 return "/course/add_course_group";
			}else if("2".equals(type)){//工作室添加页面

				return "/course/add_course_studio";

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "/error/404";
	}

	/**
	 * 保存添加页面
	 * @param store
	 * @return
	 */
	@RequestMapping(value="addSave",method=RequestMethod.POST)
	@ResponseBody
	public PageResponse addSave(Model model,@RequestParam(value="type")String type,CourseAllDto courseAllDto){
		PageResponse response=new PageResponse();

		try {
			courseService.addSave(type, courseAllDto);
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}
		return response;

	}


	/**
	 * 进入编辑页面
	 * @param id
	 * @return type  0：私教   1：团课    2：工作室
	 */
	@RequestMapping(value="editPage",method=RequestMethod.GET)
	public String editPage(@RequestParam(value="id")Integer id,@RequestParam(value="type")String type,Model model){
		try {
			if("0".equals(type)){//私教页面
				CoursePriCoach coursePriCoach=courseService.selectCoursePriById(id);
				if(coursePriCoach ==null){
					throw new Exception();
				}

				model.addAttribute("coursePriCoach", coursePriCoach);
				//获取私教课的门店
				model.addAttribute("area", storeService.selectStoreByArea(coursePriCoach.getStores()));
				//获取该课程选择教练
				//model.addAttribute("coach",coachService.selectCoachChecked(coursePriCoach.getCoachs()));
				model.addAttribute("coach",coachService.queryCoach(coursePriCoach.getId() , coursePriCoach.getCoursetype()));

			/*	//获取该会员选的门店
				model.addAttribute("stores", storeService.selectStoreByArea(coursePriCoach.getStores()));*/

				//获取该课程选中的  课程健身需求
				model.addAttribute("courseFitDemand", basicDataService.selectBasicChecked("courseFitDemand", coursePriCoach.getFitdemand()));
				return "/course/edit_course_pri";
			}else if("1".equals(type)){//团课页面

				CourseExcGroupWithBLOBs courseGroup =courseService.selectCourseGroupById(id,0);
				if(courseGroup ==null){
					throw new Exception();

				}
				//当前时间
				//model.addAttribute("date",new Date());

				model.addAttribute("courseGroup", courseGroup);
				//获取私教课的门店
				model.addAttribute("area", storeService.selectStoreByArea(courseGroup.getStores()));
				//获取该课程选择教练
				model.addAttribute("coach",coachService.selectCoachChecked(courseGroup.getCoachs()));
/*				//获取开始小时选中
				model.addAttribute("startHour", GetTimeUtil.selectHoursChecked(String.valueOf(courseGroup.getStarthour())));
				//获取开始分钟选中
				model.addAttribute("startMinutes", GetTimeUtil.selectMiutesChecked(String.valueOf(courseGroup.getStartmin())));
				//获取结束小时选中
				model.addAttribute("endHour", GetTimeUtil.selectHoursChecked(String.valueOf(courseGroup.getEndhour())));
				//获取结束分钟选中
				model.addAttribute("endMinutes",GetTimeUtil.selectMiutesChecked(String.valueOf(courseGroup.getEndmin())));
				//获取开始几号选中
				model.addAttribute("startDay", GetTimeUtil.selectMonthsChecked(String.valueOf(courseGroup.getStartmonth())));
				//获取结束几号选中
				model.addAttribute("endDay", GetTimeUtil.selectMonthsChecked(String.valueOf(courseGroup.getEndmonth())));

				model.addAttribute("weekcheck", basicDataService.selectBasicChecked("week", courseGroup.getWeek()));
				//获取小时
				model.addAttribute("hour", GetTimeUtil.selectHours());
				//获取分钟
				model.addAttribute("minutes",GetTimeUtil.selectMiutes());
				//获取月
				model.addAttribute("months", GetTimeUtil.selectMonths());
				//星期
				model.addAttribute("week", basicDataService.getBasicDataByType("week"));*/
				return "/course/edit_course_group";
		 }else if("2".equals(type)){//工作室
			   CourseExcGroupWithBLOBs courseGroup =courseService.selectCourseGroupById(id,3);
				if(courseGroup ==null){
					throw new Exception();
				}
				//当前时间
				//model.addAttribute("date",new Date());
				model.addAttribute("courseGroup", courseGroup);
				//获取私教课的门店
				model.addAttribute("area", storeService.selectStoreByArea(courseGroup.getStores()));
				//获取该课程选择教练
				model.addAttribute("coach",coachService.selectCoachChecked(courseGroup.getCoachs()));
				return "/course/edit_course_studio";
		 }
		} catch (Exception e) {

		}
		return "/error/404";
	}


	/**
	 * 保存编辑页面
	 * @param store
	 * @return
	 */
	@RequestMapping(value="editSave",method=RequestMethod.POST)
	@ResponseBody
	public PageResponse editSave(CourseAllDto courseAllDto,@RequestParam(value="type")String type){
		PageResponse response=new PageResponse();
		try {
			courseService.editSave(type, courseAllDto);
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}
		return response;
	}

	/**
	 * 改变课程状态
	 */
	@RequestMapping(value="updateCourseStatus",method=RequestMethod.GET)
	@ResponseBody
	public PageResponse updateCourseStatus(Model model,@RequestParam(value="type")Integer type,@RequestParam(value="id")Integer id,
			@RequestParam(value="status")Integer status){
		PageResponse response=new PageResponse();
		try {
			//添加保存
			courseService.updateCourseStatus(status, id, type);

			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}

		return response;

	}


	/**
	 * 进入详情页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value="detailPage",method=RequestMethod.GET)
	public String detailPage(@RequestParam(value="id")Integer id,@RequestParam(value="type")String type,Model model){
		try {
			if("0".equals(type)){//私教页面
				CoursePriCoach coursePriCoach=courseService.selectCoursePriById_Back(id);
				if(coursePriCoach ==null){
					throw new Exception();
				}
				model.addAttribute("coursePriCoach", coursePriCoach);
				//获取私教课的门店
				model.addAttribute("area", storeService.selectStoreByArea(coursePriCoach.getStores()));
				//获取该课程选择教练
				model.addAttribute("coach",coachService.selectCoachChecked(coursePriCoach.getCoachs()));

			/*	//获取该会员选的门店
				model.addAttribute("stores", storeService.selectStoreByArea(coursePriCoach.getStores()));*/

				//获取该课程选中的  课程健身需求
				model.addAttribute("courseFitDemand", basicDataService.selectBasicChecked("courseFitDemand", coursePriCoach.getFitdemand()));
				return "/course/detail_course_pri";
			}else if("1".equals(type)){//团课页面

				CourseExcGroupWithBLOBs courseGroup =courseService.selectCourseGroupById(id,0);
				if(courseGroup ==null){
					throw new Exception();

				}
				model.addAttribute("courseGroup", courseGroup);
				//获取私教课的门店
				model.addAttribute("area", storeService.selectStoreByArea(courseGroup.getStores()));
				//获取该课程选择教练
				model.addAttribute("coach",coachService.selectCoachChecked(courseGroup.getCoachs()));
/*				//获取开始小时选中
				model.addAttribute("startHour", GetTimeUtil.selectHoursChecked(String.valueOf(courseGroup.getStarthour())));
				//获取开始分钟选中
				model.addAttribute("startMinutes", GetTimeUtil.selectMiutesChecked(String.valueOf(courseGroup.getStartmin())));
				//获取结束小时选中
				model.addAttribute("endHour", GetTimeUtil.selectHoursChecked(String.valueOf(courseGroup.getEndhour())));
				//获取结束分钟选中
				model.addAttribute("endMinutes",GetTimeUtil.selectMiutesChecked(String.valueOf(courseGroup.getEndmin())));
				//获取开始几号选中
				model.addAttribute("startDay", GetTimeUtil.selectMonthsChecked(String.valueOf(courseGroup.getStartmonth())));
				//获取结束几号选中
				model.addAttribute("endDay", GetTimeUtil.selectMonthsChecked(String.valueOf(courseGroup.getEndmonth())));

				model.addAttribute("weekcheck", basicDataService.selectBasicChecked("week", courseGroup.getWeek()));

				//星期
				model.addAttribute("week", basicDataService.getBasicDataByType("week"));*/


				return "/course/detail_course_group";
		 }else if("2".equals(type)){//工作室

			   CourseExcGroupWithBLOBs courseGroup =courseService.selectCourseGroupById(id,3);
				if(courseGroup ==null){
					throw new Exception();
				}
				//当前时间
				//model.addAttribute("date",new Date());
				model.addAttribute("courseGroup", courseGroup);
				//获取私教课的门店
				model.addAttribute("area", storeService.selectStoreByArea(courseGroup.getStores()));
				//获取该课程选择教练
				model.addAttribute("coach",coachService.selectCoachChecked(courseGroup.getCoachs()));
				return "/course/detail_course_studio";

		 }
		} catch (Exception e) {

		}
		return "/error/404";
	}



	//排期-----------------------------------------------------------------------------------------------------------------------------------

	/**
	 *  基础团课排期
	 * 进入新增页面  ,选择年月
	 * @return
	 */
	@RequestMapping(value="addTimePageFirst",method=RequestMethod.GET)
	public String addTimePage_first(@RequestParam(value="courseId")Integer courseId,Model model,String choosedate){

		model.addAttribute("courseId", courseId);
		if (StringUtils.hasText(choosedate)) {
			model.addAttribute("date", choosedate);
		}else{
			model.addAttribute("date", DateTimeUtil.getDateTimeWithMon(new Date()));
		}
//		model.addAttribute("date", DateTimeUtil.getDateTimeWithMon(new Date()));
		return "course/schedule/add_coursegroup_first_time";

	}


	/**
	 * 基础团课排期
	 * 新增第二个页面
	 * @param year 年
	 * @param month 月
	 * @return
	 */
	@RequestMapping(value="addTimePageSecond",method=RequestMethod.POST)
	public String addTimePage_second(@RequestParam(value="date")String date,@RequestParam(value="courseId")Integer courseId,Model model){

		String d_date[]=date.split("-");
		//计算本月有多少天
		model.addAttribute("countDays", DateTimeUtil.daysOfMonth(Integer.valueOf(d_date[0]), Integer.valueOf(Integer.valueOf(d_date[1]))));

		model.addAttribute("courseId", courseId);

		model.addAttribute("year", d_date[0]);
		model.addAttribute("month", d_date[1]);
		String now_day=DateTimeUtil.getDateWithoutTime(new Date());
		model.addAttribute("now_day", now_day);
		return "course/schedule/add_coursegroup_second_time";
	}


	/**
	 * 基础团课排期
	 * 保存添加内容
	 * @param courseGroupTimeDto
	 */
	@RequestMapping(value="addSaveTime",method=RequestMethod.POST)
	@ResponseBody
	public PageResponse addSaveTime(CourseGroupTimeDto courseGroupTimeDto,@RequestParam(value="year")String year,
			@RequestParam(value="month")String month,@RequestParam(value="courseId")Integer courseId){
		PageResponse response=new PageResponse();
		try {
			courseService.addSaveTime(courseGroupTimeDto, year, month, courseId);
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			response.setMessage(e.getMessage());
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}

		return response;
	}


	/**
	 * 基础团课排期
	 * 编辑页面
	 * @param courseGroupTimeDto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="editPageTime",method=RequestMethod.GET)
	public String editPageTime(@RequestParam(value="courseId")Integer courseId,@RequestParam(value="year")String year,
			@RequestParam(value="month")String month,Model model)throws Exception{
		courseService.selectCourseGroupTime(courseId, year, month);
		try {
			//获取某个月团课所有排期
			model.addAttribute("editTimeList", courseService.selectCourseGroupTime(courseId, year, month));
			//年
			model.addAttribute("year", year);
			//月
			model.addAttribute("month", month);
			//课程id
			model.addAttribute("courseId", courseId);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "course/schedule/edit_coursegroup_time";
	}


	/**
	 * 基础团课排期
	 * 编辑保存
	 * @param courseGroupTimeDto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="editSaveTime",method=RequestMethod.POST)
	@ResponseBody
	public PageResponse editSaveTime(CourseGroupTimeDto courseGroupTimeDto)throws Exception{
		PageResponse response=new PageResponse();
		try {
			courseService.editSaveTime(courseGroupTimeDto);
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}

		return response;

	}

	/**基础团课排期
	 * 排期列表
	 * @return
	 */
	@RequestMapping(value="courseListPage",method=RequestMethod.GET)
	public String courseListPage(Model model,@RequestParam(value="courseId")Integer courseId){
		try {
			//获取排期列表
			model.addAttribute("courseTimeList", courseService.selectListByCourseId(courseId));
			CourseExcGroupWithBLOBs bloBs=courseService.selectCourseGroupById(courseId);
			//教练名字
			if (StringUtils.hasText(bloBs.getCoachs())) {
				model.addAttribute("coachname", courseService.getCochAllNames(bloBs.getCoachs()));
			}
			//获取排期列表
			model.addAttribute("coursename", bloBs.getCoursename());
			//团课 id
			model.addAttribute("courseId", courseId);
			//团课类型
			model.addAttribute("type", bloBs.getType());
		} catch (Exception e) {

			e.printStackTrace();

		}
		return "course/schedule/coursegroup_date_list";

	}




	 /**基础团课排期
	  * 查询本月是否已经添加过记录  有：返回true  没有：false
	  * @param courseId 课程id
	  * @param year  年
	  * @param month 月
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value="isAlreadyAddTime",method=RequestMethod.POST)
	@ResponseBody
	public PageResponse isAlreadyAddTime(@RequestParam(value="courseId")Integer courseId,@RequestParam(value="date")String date,Model model){

		PageResponse response=new PageResponse();
		try {
			boolean result=courseService.isAlreadyAddTime(courseId, date.split("-")[0],  date.split("-")[1]);
			response.setRecords(result);
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}


		return response;
	}


	/**
	 * 是否进行过   工作室排期
	 * @param courseId
	 * @param date
	 * @param model
	 * @return
	 */
	@RequestMapping(value="isAlreadyAddStudioTime",method=RequestMethod.POST)
	@ResponseBody
	public PageResponse isAlreadyAddStudioTime(@RequestParam(value="courseId")Integer courseId,@RequestParam(value="date")String date,Model model){

		PageResponse response=new PageResponse();
		try {
			boolean result=courseService.isAlreadyAddStudioTime(courseId, date.split("-")[0],  date.split("-")[1]);
			response.setRecords(result);
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}


		return response;
	}




	/**
	 * 基础团课排期
	 * 查看  进入详情页面
	 * @param model
	 * @param courseId  课程id
	 * @param year       年
	 * @param month      月
	 * @return
	 */
	@RequestMapping(value="detialcourseExcTime",method=RequestMethod.GET)
	public String detialcourseExcTime(Model model,@RequestParam(value="courseId")Integer courseId,@RequestParam(value="year")String year,
			@RequestParam(value="month")String month){
		try {
			//获取排期列表
			model.addAttribute("timeList", courseService.selectCourseGroupTime(courseId, year, month));
			//年
			model.addAttribute("year", year);
			//月
			model.addAttribute("month", month);
			//课程id
			model.addAttribute("courseId", courseId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return "course/schedule/detial_coursegroup_time";

	}


	/**
	 * 精品团课的排期列表
	 * @param model
	 * @param courseId 课程id
	 * @return
	 */
	@RequestMapping(value="courseExcTimePage",method=RequestMethod.GET)
	public String courseExcTimeList(Model model,@RequestParam(value="courseId")Integer courseId){
		try {
			//获取排期列表
			model.addAttribute("excTimeList", courseService.selectExcListByCourseId(courseId));
			CourseExcGroupWithBLOBs bloBs=courseService.selectCourseGroupById(courseId);
			//教练名字
			if (StringUtils.hasText(bloBs.getCoachs())) {
				model.addAttribute("coachname", courseService.getCochAllNames(bloBs.getCoachs()));
			}
			//获取排期列表
			model.addAttribute("coursename", bloBs.getCoursename());
			//团课 id
			model.addAttribute("courseId", courseId);
			//团课类型
			model.addAttribute("type", bloBs.getType());
		} catch (Exception e) {

			e.printStackTrace();

		}
		return "course/schedule/exc/courseexc_time_list";

	}

	/**
	 * 进入精品团课排期表
	 * @return
	 */
	@RequestMapping(value="addGroupTimePage",method=RequestMethod.GET)
	public String addGroupTimePage(Model model,@RequestParam(value="courseId")Integer courseId){
		model.addAttribute("courseId", courseId);

		model.addAttribute("date",DateTimeUtil.getDateByCurrenDateWithNum(1));
		return "course/schedule/exc/add_courseexc_time";
	}

	/**
	 * 精品团课排期保存
	 * @param courseExcTimeDto
	 */
	@RequestMapping(value="addGroupTimeSave",method=RequestMethod.POST)
	@ResponseBody
	public PageResponse addSave(Integer courseId,Date startDate,CourseExcTimeDto courseExcTimeDto){
		PageResponse response=new PageResponse();
		try {
			courseService.add_exc_Time(courseId, startDate, courseExcTimeDto);
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());

		} catch (Exception e) {

			response.setResultCode(ResultCodeEnum.FAIL.getCode());
			response.setMessage(e.getMessage());
		}

		return response;

	}


	/**
	 * 查看  进入详情页面
	 * @param model
	 * @param courseId  课程id
	 * @param startdate 开始日期
	 * @return
	 */
	@RequestMapping(value="detialExcTime",method=RequestMethod.GET)
	public String detialExcTime(Model model,@RequestParam(value="courseId")Integer courseId,@RequestParam(value="startdate")Date startdate){
		try {
			//获取排期列表
			model.addAttribute("timeList", courseService.detial_exc(courseId, startdate));
			//开始时间
			model.addAttribute("startdate", startdate);
			//课程id
			model.addAttribute("courseId", courseId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return "course/schedule/exc/detial_courseexc_time";

	}

	/**
	 * 进入精品团课编辑页面
	 * @param model
	 * @param courseId 课程id
	 * @param startdate 开始日期
	 * @return
	 */
	@RequestMapping(value="editExcTime",method=RequestMethod.GET)
	public String editExcTime(Model model,@RequestParam(value="courseId")Integer courseId,@RequestParam(value="startdate")Date startdate){
		try {
			//获取排期列表
			 model.addAttribute("timeEdit", courseService.edit_ext(courseId, startdate));
			//开始时间
			model.addAttribute("startdate", startdate);
			//课程id
			model.addAttribute("courseId", courseId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return "course/schedule/exc/edit_courseexc_time";
	}


	/**
	 * 训练营的排期   编辑保存
	 * @param courseId 课程id
	 * @param startDate  训练营编辑之前的开始日期（用于条件查询）
	 * @param editStartDate  编辑后端开始日期
	 * @param courseExcTimeDto
	 * @return
	 */
	@RequestMapping(value="editExcTimeSave",method=RequestMethod.POST)
	@ResponseBody
	public PageResponse editExcTimeSave(Integer courseId,Date startDate,Date editStartDate,CourseExcTimeDto courseExcTimeDto){
		PageResponse response=new PageResponse();
		try {
			courseService.edit_exc_time(courseId, startDate,editStartDate, courseExcTimeDto);
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());

		} catch (Exception e) {

			response.setResultCode(ResultCodeEnum.FAIL.getCode());
			response.setMessage(e.getMessage());
		}

		return response;

	}


	/**
	 * 工作室的排期列表
	 * @param model
	 * @param courseId 课程id
	 * @return
	 */
	@RequestMapping(value="workspaceTimePage",method=RequestMethod.GET)
	public String workspaceTimeList(Model model,@RequestParam(value="courseId")Integer courseId){
		try {
			//获取排期列表
			model.addAttribute("studioTimeList", courseService.selectStudioListByCourseId(courseId));
			CourseExcGroupWithBLOBs bloBs=courseService.selectCourseGroupById(courseId);
			//教练名字
			if (StringUtils.hasText(bloBs.getCoachs())) {
				model.addAttribute("coachname", courseService.getCochAllNames(bloBs.getCoachs()));
			}
			//获取排期列表
			model.addAttribute("coursename", bloBs.getCoursename());
			//团课 id
			model.addAttribute("courseId", courseId);
			//团课类型
			model.addAttribute("type", bloBs.getType());
		} catch (Exception e) {

			e.printStackTrace();

		}
		return "course/schedule/studio/coursestudio_time_list";

	}

	/**
	 * 添加工作室  时间（工作室排期）
	 * @param courseId
	 * @return
	 */
	@RequestMapping(value="addStudioTime",method=RequestMethod.GET)
	public String addStudioTime(@RequestParam(value="courseId")Integer courseId,Model model){
		model.addAttribute("date", DateTimeUtil.getDateTimeWithMon(new Date()));
		model.addAttribute("courseId", courseId);
		return "course/schedule/studio/add_studio_choose_time";
	}


	/**
	 * 进入工作室排期页面
	 * @param courseId 课程id
	 * @param date 日期  例子：yyyy-MM
	 *   type=1表示是编辑页面  用于区分返回按钮
	 * @param model
	 * @return
	 */
	@RequestMapping(value="addStudioChooseTime",method=RequestMethod.GET)
	public String addStudioChooseTime(@RequestParam(value="courseId")Integer courseId,@RequestParam(value="date")String date,Integer type,Model model){
		String[] date_spilt= date.split("-");
		try {
			CourseExcGroupWithBLOBs course=courseService.selectCourseGroupById(courseId);
			if(course!=null){
				model.addAttribute("course", course);
				model.addAttribute("coach",courseService.getCochAllNames(course.getCoachs()));
				model.addAttribute("courseStudioTime", courseService.selectStudioTimeDateAndList(courseId,date_spilt[0],date_spilt[1]));
				model.addAttribute("year", date_spilt[0]);
				model.addAttribute("month", date_spilt[1]);
				model.addAttribute("date",date);
				model.addAttribute("courseId", courseId);
				model.addAttribute("type",type);
			}else{
				return "error/404";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "course/schedule/studio/add_studio_time";
	}



	/**
	 * 添加工作室排期时间
	 * @param courseId 课程id
	 * @param year 年
	 * @param month 月
	 * @param day 日
	 * @param courseStudioTimeAddDto
	 * @return
	 */
	@RequestMapping(value="addStudioTimeSave",method=RequestMethod.POST)
	@ResponseBody
	public PageResponse addStudioTimeSave(@RequestParam(value="courseId")Integer courseId,@RequestParam(value="year")String year,
			@RequestParam(value="month")String month, @RequestParam(value="day")String day,
			CourseStudioTimeAddDto courseStudioTimeAddDto){
		PageResponse response=new PageResponse();
		try {
			courseService.addStudioTimeSave(courseId,year,month,day,courseStudioTimeAddDto);
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());

		} catch (Exception e) {
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
			response.setMessage(e.getMessage());
		}
		return response;
	}


	/**
	 * 暂时没用
	 * 根据主键id查询该 工作室的   时间
	 * @param id
	 * @return
	 */
	@RequestMapping(value="selectStudioTimeById",method=RequestMethod.GET)
	@ResponseBody
	public PageResponse selectStudioTimeById(Integer id){
		PageResponse response=new PageResponse();
		try {
			//根据主键id查询
			response.setRecords(courseService.selectStudioTimeById(id));
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());

		} catch (Exception e) {
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}
		return response;

	}

	/**
	 * 编辑保存  工作室时间
	 * @param courseStudioTime
	 * @return
	 */
	@RequestMapping(value="editStudioTimeSave",method=RequestMethod.POST)
	@ResponseBody
	public PageResponse editStudioTimeSave(CourseStudioTime courseStudioTime){
		PageResponse response=new PageResponse();
		try {
			courseService.editStudioTimeSave(courseStudioTime);
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());

		} catch (Exception e) {
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
			response.setMessage(e.getMessage());
		}
		return response;
	}


	/**
	 * 删除工作室  排期 时间
	 * @param id
	 * @return
	 */
	@RequestMapping(value="delStudioTime",method=RequestMethod.POST)
	@ResponseBody
	public PageResponse delStudioTime(Integer id){
		PageResponse response=new PageResponse();
		try {
			courseService.delStudioTime(id);
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());

		} catch (Exception e) {
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
			response.setMessage(e.getMessage());
		}
		return response;
	}


	/**
	 * 进入排期页面
	 * @param courseId 课程id
	 * @param date 日期  例子：yyyy-MM-dd
	 * @param model
	 * @return
	 */
	@RequestMapping(value="detailStudioTime",method=RequestMethod.GET)
	public String detailStudioTime(@RequestParam(value="courseId")Integer courseId,@RequestParam(value="date")String date,Model model){
		String[] date_spilt= date.split("-");
		try {
			CourseExcGroupWithBLOBs course=courseService.selectCourseGroupById(courseId);
			if(course!=null){
				model.addAttribute("course", course);
				model.addAttribute("coach",courseService.getCochAllNames(course.getCoachs()));
				model.addAttribute("courseStudioTime", courseService.selectStudioTimeDateAndList(courseId,date_spilt[0],date_spilt[1]));
				model.addAttribute("year", date_spilt[0]);
				model.addAttribute("month", date_spilt[1]);
				model.addAttribute("date",date);
				model.addAttribute("courseId", courseId);
			}else{
				return "error/404";
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "course/schedule/studio/detail_studio_time";
	}



}
