package customer.supu.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import customer.supu.common.po.PageResponse;
import customer.supu.dao.CourseExcGroupDao;
import customer.supu.dto.CourseExcGroupDto;
import customer.supu.dto.CourseTimeDto;
import customer.supu.jenum.CourseGroupTypeEnum;
import customer.supu.jenum.CourseTypeEnum;
import customer.supu.jenum.MobileBottomEnum;
import customer.supu.jenum.ResultCodeEnum;
import customer.supu.po.CourseExcGroup;
import customer.supu.po.EmployeeAppointCourse;
import customer.supu.po.Store;
import customer.supu.service.CoachService;
import customer.supu.service.CourseService;
import customer.supu.service.F_AboutClassService;
import customer.supu.service.StoreService;

/**
 * 会员约课控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/outside/aboutClass")
public class F_AboutClassController {
	@Autowired
	private F_AboutClassService f_AboutClassService;
	@Autowired
	private StoreService storeService;

	@Autowired
	private CourseService courseService;
	@Autowired
	private CoachService coachService;

	/**
	 * 进入约课页面
	 */
	@RequestMapping(value="/listPage",method=RequestMethod.GET)
	public String aboutclass(Model model,HttpServletRequest request){
		try {

			//移动端 底端 样式
			model.addAttribute("bottom", MobileBottomEnum.APPOINT.getCode());


			//获取门店信息
			List<Store> storeList= storeService.selectAllStore();
			model.addAttribute("store",storeList);

			//门店不为空
			if(CollectionUtils.isNotEmpty(storeList)){

				//查询精品团课  默认第一个门店id，
				//model.addAttribute("courseExcGroup", f_AboutClassService.selectCourseExcGroup(storeList.get(0).getId(), null, null));
				//日期按钮
				model.addAttribute("weekAndDate", f_AboutClassService.getDateAndWeek());
			}
			model.addAttribute("weekAndDate", f_AboutClassService.getDateAndWeek());


		} catch (Exception e) {

			e.printStackTrace();
		}
		return "outside/aboutclass/aboutclasslist";
	}


	/**
	 * 获取基础课程
	 * @param storeId 门店id
	 * @param week  星期几  例子：1
	 * @param date   日期  例子：2018-01-01
	 * @param signType   日期顺序标记 例子：0
	 * @param start 开始查询第几个    例子：0
	 * @param end   sql查询个数  例子：9
	 * @return
	 */
	@RequestMapping(value="/getAboutClass",method=RequestMethod.POST)
	@ResponseBody
	public PageResponse getAboutClass(@RequestParam(value="storeId")Integer storeId,
			@RequestParam(value="week")String week,@RequestParam(value="date")String date,@RequestParam(value="start")Integer start,
			@RequestParam(value="end")Integer end,@RequestParam(value="signType")Integer signType){
		PageResponse response=new PageResponse();

		 try {
			List<CourseExcGroupDto> result_course=f_AboutClassService.selectCourseExcGroup(storeId, week, date, start, end,signType);
			response.setRecords(result_course);
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}

		return response;

	}


	/**
	 * 获取最近门店地址和id
	 * @param lng 经度
	 * @param lat 纬度
	 * @param id 会员卡id
	 * @return
	 */
	@RequestMapping(value="/getNearestStore",method=RequestMethod.GET)
	@ResponseBody
	public PageResponse getNearestStore(@RequestParam(value="lng")double lng,@RequestParam(value="lat")double lat,Integer id){
		PageResponse response=new PageResponse();

		 try {

			response.setRecords(f_AboutClassService.sortMinDistance(lng, lat,id));
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}

		return response;

	}

	/**
	 * 获取最近门店距离
	 * @param lng 经度
	 * @param lat 纬度
	 * @param id 会员卡id
	 * @return
	 */
	@RequestMapping(value="/getStoreDis",method=RequestMethod.GET)
	@ResponseBody
	public PageResponse getStoreDistance(@RequestParam(value="lng")double lng,@RequestParam(value="lat")double lat,@RequestParam(value="storeId")Integer storeId){
		PageResponse response=new PageResponse();

		 try {

			response.setRecords(f_AboutClassService.getStoreDistance(lng, lat, storeId));
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}

		return response;

	}

	/**
	 * 根据团课id进入详情页面
	 * @param id 团课id
	 * @param //storeid 门店 id
	 * @return
	 */
	@RequestMapping(value="/courseGroupDetail",method=RequestMethod.POST)
	public String courseGroupDetail(@RequestParam(value="id")Integer id,@RequestParam(value="storeId")Integer storeId,Model model,
			@RequestParam(value="date")Date date,
			@RequestParam(value="startTime")String startTime,
			@RequestParam(value="endTime")String endTime
			){

		try {

			//获取基础课程
			CourseExcGroup courseExcGroup=courseService.selectCourseGroupById(id,CourseGroupTypeEnum.BASIC.getCode());
			if(courseExcGroup==null){
				return "/error/404";
			}

			//查找该课程是否开放
			model.addAttribute("isOpen", f_AboutClassService.isOpen(date));

			//排队状态
			model.addAttribute("queueStatus",f_AboutClassService.getQueueStatus(id,date));
			//精品团课详情
			model.addAttribute("courseExcGroup",courseExcGroup);
			//精品团课下教练详情
			model.addAttribute("date",date);

			//该基础团课的开始结束时间
			model.addAttribute("startTime", startTime);
			model.addAttribute("endTime", endTime);
			model.addAttribute("id",id);

			//根据门店id 课程id查询指定门店
			model.addAttribute("store",storeService.selectStoreByStIdAndCoId(storeId, id,CourseTypeEnum.COURSEGROUP.getCode()));
			//精品团课下教练详情
			model.addAttribute("coachs",coachService.selectCoachByGroupId(id,CourseTypeEnum.COURSEGROUP.getCode()));
		} catch (Exception e) {
			return "/error/404";
		}
		return "outside/aboutclass/detail_aboutclasslist";
	}


//	/**
//	 * 预约  排队
//	 * @return
//	 */
//	@RequestMapping(value="/queue",method=RequestMethod.POST)
//	@ResponseBody
//	public PageResponse queue(EmployeeAppointCourse employeeAppointCourse,HttpSession session){
//		PageResponse response=new PageResponse();
//
//		 try {
//
//			f_AboutClassService.insertEmployeeAppointCourse(employeeAppointCourse, session);
//			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
//		} catch (Exception e) {
//			response.setResultCode(ResultCodeEnum.FAIL.getCode());
//			response.setMessage(e.getMessage());
//		}
//
//		return response;
//
//	}

	/**
	 * 进入私教课页面
	 *
	 */
	@RequestMapping(value="/privatePage",method=RequestMethod.GET)
	public String aboutpriclass(Model model,HttpSession session){
		try {
			//移动端 底端 样式
			model.addAttribute("bottom", MobileBottomEnum.APPOINT.getCode());
			//查询用户购买的  私教课
			model.addAttribute("priclass",f_AboutClassService.selectEmployeeBuyCardByList(session));


		} catch (Exception e) {

			return "outside/aboutclass/pri_aboutclass";
		}
		return "outside/aboutclass/pri_aboutclass";

	}


	/**
	 * 进入私教课页面  约课
	 *
	 */
	@RequestMapping(value="/appointPage",method=RequestMethod.GET)
	public String appointPage(Model model,HttpSession session,@RequestParam(value="coachId")Integer coachId,@RequestParam(value="id")Integer id) throws Exception {

		//门店不为空


			//查询精品团课  默认第一个门店id，
			//model.addAttribute("courseExcGroup", f_AboutClassService.selectCourseExcGroup(storeList.get(0).getId(), null, null));
			//日期按钮
		model.addAttribute("weekAndDate", f_AboutClassService.getDateAndWeek());
		model.addAttribute("weekAndDate", f_AboutClassService.getDateAndWeek());
		model.addAttribute("coachId",coachId);
		model.addAttribute("id",id);

//		try {
//			//查询用户购买的  私教课
//			model.addAttribute("timeList",f_AboutClassService.selectEnableAppointCoachTime(coachid,courseid));
//
//			//门店
//			model.addAttribute("stores",storeService.selectStoreByCourseIdDistance(lng, lat,courseid));
//
//			//教练名字
//			model.addAttribute("coachname",coachname);
//
//			//课程id
//			model.addAttribute("courseid",courseid);
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
		return "outside/aboutclass/pri_appointclass";

	}


	/**
	 * 进入私教课预约列表
	 *
	 */
	@RequestMapping(value="/appoList",method=RequestMethod.GET)
	public String appointList(Model model,HttpSession session) throws Exception {

		return "outside/aboutclass/pri_appointlist";
	}


	/**
	 * 进入私教课页面  约课
	 *
	 */
	@RequestMapping(value="/appoint",method=RequestMethod.GET)
	public String appoint(Model model,@RequestParam(value="coachid")Integer coachid,@RequestParam(value="lng")double lng,@RequestParam(value="lat")double lat,
							  @RequestParam(value="coachname")String coachname,@RequestParam(value="courseid")Integer courseid){

		return "outside/aboutclass/pri_appointclass";
	}


//	/**
//	 *进行 约课 操作
//	 *
//	 */
//	@RequestMapping(value="/doappointCourse",method=RequestMethod.POST)
//	@ResponseBody
//	public PageResponse doappointCourse(Model model,HttpSession session,EmployeeAppointCourse employeeAppointCourse){
//		PageResponse response=new PageResponse();
//		try {
//			response.setRecords(f_AboutClassService.insertEmployeeBuyCourseDto(session, employeeAppointCourse));
////			f_AboutClassService.insertEmployeeBuyCourseDto(session, employeeAppointCourse);
//			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
//
//			//预约
//			//response.setRecords(employeeAppointCourse.getId());
//
//		} catch (Exception e) {
//
//			response.setResultCode(ResultCodeEnum.FAIL.getCode());
//			response.setMessage(e.getMessage());
//		}
//		return response;
//
//	}



	/**
	 *进行 约课页面   成功
	 *
	 */
	@RequestMapping(value="/appointSuccess",method=RequestMethod.POST)
	public String appointSuccess(Model model,HttpSession session,EmployeeAppointCourse employeeAppointCourse,@RequestParam(value="coachname")String coachname,@RequestParam(value="appointid")Integer appointid){
		try {
			//查询门店信息
			model.addAttribute("store",storeService.selectStoreById(employeeAppointCourse.getStoreid()));

			//购买课数   预约课数    约课结束时间
			model.addAttribute("EmployeeBuyCourseDto",f_AboutClassService.getAppointCountAndEndTime(session, employeeAppointCourse));

			//约课开始时间
			model.addAttribute("starttime",employeeAppointCourse.getStarttime());
			//教练名称
			model.addAttribute("coachname",coachname);
			//新增预约  id
			model.addAttribute("appointid",appointid);
			//预约日期
			model.addAttribute("date",employeeAppointCourse.getAppointtime());

		} catch (Exception e) {

			e.printStackTrace();
		}

		return "outside/aboutclass/pri_appointsuccess";

	}

	/**
	* 取消预约  预约id
	* @return
	*/
	@RequestMapping(value="/cancelAppointCourse",method=RequestMethod.GET)
	@ResponseBody
	public PageResponse cancelAppointCourse(@RequestParam(value="id")Integer id,HttpSession session){
		PageResponse response=new PageResponse();
		try {
			f_AboutClassService.cancelAppointCourse(session,id);
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}

		return response;
	}



	/**
	 * 进入已购买工作室课程页面
	 *
	 */
	@RequestMapping(value="/studioPage",method=RequestMethod.GET)
	public String aboutStudioclass(Model model,HttpSession session){
		try {
			//移动端 底端 样式
			model.addAttribute("bottom", MobileBottomEnum.APPOINT.getCode());
			//查询用户购买的  私教课
			model.addAttribute("studioclass",f_AboutClassService.selectStudioCourseList(session));


		} catch (Exception e) {

			return "outside/aboutclass/studio_aboutclass";
		}
		return "outside/aboutclass/studio_aboutclass";

	}


	/**
	 *  进入工作室  约课页面
	 * @param model
	 * @param courseid 工作室课程名称
	 * @return
	 */
	@RequestMapping(value="/appointStudioPage",method=RequestMethod.GET)
	public String appointStudioPage(Model model,@RequestParam(value="courseid")Integer courseid){
		try {
			//model.addAttribute("timeList",f_AboutClassService.selectEnableAppointCoachTime(coachid));
			List<CourseExcGroupDto> excGroupDtos=f_AboutClassService.isExistStudioCourse(courseid);
			//判断工作是课程是否存在
			if (CollectionUtils.isNotEmpty(excGroupDtos)) {
				//课程id
				model.addAttribute("courseid",courseid);
				//教练名称
				model.addAttribute("coachname",excGroupDtos.get(0).getCoachname());
				//门店id
				model.addAttribute("storeid",excGroupDtos.get(0).getStores());
				//课程时间
				model.addAttribute("timeList",f_AboutClassService.selectEnableAppointStudioTime(courseid));
			}else{
				return "/error/404";
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return "outside/aboutclass/studio_aboutclass_ing";

	}

	/**
	 * 约课(工作室)成功  页面
	 *
	 */
	@RequestMapping(value="/appointStudioSuccess",method=RequestMethod.POST)
	public String appointStudioSuccess(Model model,HttpSession session, CourseTimeDto courseTimeDto){
		try {
			List<CourseExcGroupDto> excGroupDtos=f_AboutClassService.isExistStudioCourse(courseTimeDto.getCourseid());
			//判断工作是课程是否存在
			if (CollectionUtils.isNotEmpty(excGroupDtos)) {
				//教练名称
				model.addAttribute("coachname",excGroupDtos.get(0).getCoachname());
				//教练电话
				model.addAttribute("phonenumber",excGroupDtos.get(0).getPhonenumber());
				//课程时间
				model.addAttribute("timeList",f_AboutClassService.getAppointSuccessStudio(courseTimeDto.getEmployeeAppointCourses()));
			}else{
				return "/error/404";
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return "outside/aboutclass/studio_aboutsuccess";

	}
	
	
	/**
	 * 进入已购买训练营课程页面
	 *
	 */
	@RequestMapping(value="/courseGroupPage",method=RequestMethod.GET)
	public String courseGroupPage(Model model,HttpSession session){
		try {
			//移动端 底端 样式
			model.addAttribute("bottom", MobileBottomEnum.APPOINT.getCode());
			//查询用户购买的  私教课
			model.addAttribute("coursegroupclass",f_AboutClassService.selectCourseGroupList(session));


		} catch (Exception e) {

			return "outside/aboutclass/coursegroup_aboutclass";
		}
		return "outside/aboutclass/coursegroup_aboutclass";

	}
	
	
	

}
