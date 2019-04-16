package customer.supu.controller;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import customer.supu.service.impl.F_AboutClassServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import customer.supu.common.po.PageResponse;
import customer.supu.dto.CourseTimeDto;
import customer.supu.jenum.CourseGroupTypeEnum;
import customer.supu.jenum.MobileBottomEnum;
import customer.supu.jenum.ResultCodeEnum;
import customer.supu.po.Employee;
import customer.supu.po.EmployeeAppointCourse;
import customer.supu.service.CourseService;
import customer.supu.service.F_AboutClassService;
import customer.supu.service.F_BuyCardService;
import customer.supu.service.F_PersonalService;
import customer.supu.service.MemberCardService;
import customer.supu.service.MemberService;
import customer.supu.service.StoreService;

@Controller
@RequestMapping("/outside/personal")
public class F_PersonalController {

	private Logger logger = Logger.getLogger(F_PersonalController.class);

	@Autowired
	private F_PersonalService f_PersonalService;

	@Autowired
	private StoreService storeService;

	@Autowired
	private F_BuyCardService buyCardService;

	@Autowired
	private MemberCardService memberCardService;

	@Autowired
	private F_AboutClassService f_AboutClassService;

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private MemberService memberService;
	/**
	 * 进入个人中心页面
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/personalinfo",method=RequestMethod.GET)
	public String personalInfo(HttpSession session,Model model){
		try {
			//移动端 底端 样式
			model.addAttribute("bottom", MobileBottomEnum.PERSONAL.getCode());

			//获取登录用户的信息
			model.addAttribute("employee", f_PersonalService.selectEmployeeInfo(session));

			//获取会员卡信息，并标记是否购买
			model.addAttribute("mCard", f_PersonalService.selectMcardByUserId(session));

			//
			//memberCardService.employeeBuyCourse(1, 0, 1, "123", session);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return  "/outside/personal/personalinfo";
	}

	/**
	 * 进入会员卡详情
	 * @param Id  会员卡id
	 * @return
	 */
	@RequestMapping(value="/mCardInfo",method=RequestMethod.GET)
	public String mCardInfo(@RequestParam(value="id")Integer id,HttpSession session,Model model){
		try {
			//根据会员卡id获取会员信息
			model.addAttribute("mCard",memberCardService.selecMCardInfoById(id,session));

			//是否该买会员卡
			model.addAttribute("isBuyCard", memberCardService.isBuyCard(session));

			//根据会员卡id查询适用的门店
			model.addAttribute("storeList",storeService.selectStoreByMcardId(id));


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return "/outside/personal/mcardinfo";
	}


	/**
	 * 进入系统设置
	 * @return
	 */
	@RequestMapping(value="/systemsettings",method=RequestMethod.GET)
	public String systemsettings(Model model){

		//移动端 底端 样式
		model.addAttribute("bottom", MobileBottomEnum.PERSONAL.getCode());
		return "/outside/personal/systemsettings/systemset";
	}


	/**
	 * 进入会员协议  页面
	 * @return
	 */
	@RequestMapping(value="/membershipagreement",method=RequestMethod.GET)
	public String membershipagreement(Model model){

		return "/outside/personal/systemsettings/memberagreement";
	}


	/**
	 * 进入关于我们  页面
	 * @return
	 */
	@RequestMapping(value="/aboutus",method=RequestMethod.GET)
	public String aboutus(Model model){

		return "/outside/personal/systemsettings/aboutus";
	}

	/**
	 * 进入账号设置  页面
	 * @return
	 */
	@RequestMapping(value="/accountsettings",method=RequestMethod.GET)
	public String accountsettings(Model model){

		//移动端 底端 样式
		model.addAttribute("bottom", MobileBottomEnum.PERSONAL.getCode());

		return "/outside/personal/systemsettings/accountsettings";
	}

	/**
	 * 进入账号修改  页面1  填写原来手机号
	 * @return
	 */
	@RequestMapping(value="/updateaccount_first",method=RequestMethod.GET)
	public String updateaccount_first(Model model){

		return "/outside/personal/systemsettings/updateaccount_first";
	}


	/**
	 * 进入我的门店
	 * @return
	 */
	@RequestMapping(value="/mystores",method=RequestMethod.GET)
	public String mystores(Model model){

		return "/outside/personal/mystores";
	}

	/**
	 * 获取最近门店地址和id
	 * @param lng 经度
	 * @param lat 纬度
	 * @param id 会员卡id
	 * @return
	 */
	@RequestMapping(value="/getMyStores",method=RequestMethod.GET)
	@ResponseBody
	public PageResponse getMyStores(@RequestParam(value="lng")double lng,@RequestParam(value="lat")double lat,Integer id){
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
	 * 进入门店详情
	 * @param lng 经度
	 * @param lat 纬度
	 * @param id 会员卡id
	 * @return
	 */
	@RequestMapping(value="/mystoresDetail",method=RequestMethod.GET)
	public String mystoresDetail(@RequestParam(value="id")Integer id,Model model){
		model.addAttribute("id",id);
		return "/outside/personal/mystoresDetail";
	}


	/**
	 * 购买私教课界面
	 * @param courseId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/buyPriCoach",method=RequestMethod.GET)
	public String buyPriCoach(@RequestParam(value="courseId")Integer courseId,HttpServletRequest request,Model model){
		try {
			//获取私教课程信息
			String openId=(String) request.getSession().getAttribute("openId");
			model.addAttribute("openId", openId);
			model.addAttribute("course", courseService.selectCoursePriById(courseId));
		} catch (Exception e) {
			return "/error/404";
		}
		return "outside/buycard/coursepricoach/buypricoach";
	}


	/**
	 * 购买工作室界面
	 * @param courseId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/buyStudio",method=RequestMethod.GET)
	public String buyStudio(@RequestParam(value="courseId")Integer courseId,HttpServletRequest request,Model model){
		try {
			//获取私教课程信息
			String openId=(String) request.getSession().getAttribute("openId");
			model.addAttribute("openId", openId);
			model.addAttribute("course", courseService.selectCourseGroupById(courseId,CourseGroupTypeEnum.STUDIO.getCode()));
		} catch (Exception e) {
			return "/error/404";
		}
		return "outside/buycard/coursepricoach/buystudio";
	}



	/**
	 * 进入确认购买会员卡页面
	 * @param courseId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/buyMcard",method=RequestMethod.GET)
	public String buyMcard(@RequestParam(value="mCardId")Integer mCardId,Model model,HttpServletRequest request){
		try {

			String openId=(String) request.getSession().getAttribute("openId");
			model.addAttribute("openId", openId);
			//获取会员卡信息
			model.addAttribute("mCard", memberCardService.selecMemberCardInfoById(mCardId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "/error/404";
		}
		return "outside/buycard/coursepricoach/buymcard";
	}



	/**
	 * 进入购买精品团课的页面
	 * @param courseId
	 * @param startDate 训练营的开始时间
	 * @param endDate 结束时间
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/buygroupcourse",method=RequestMethod.GET)
	public String buygroupcourse(@RequestParam(value="courseId")Integer courseId,
			@RequestParam(value="startDate")String startDate,
			@RequestParam(value="endDate")String endDate,Model model,HttpServletRequest request){
		try {

			String openId=(String) request.getSession().getAttribute("openId");
			model.addAttribute("openId", openId);
			//获取精品团课课程信息
			model.addAttribute("course", courseService.selectCourseGroupById(courseId,CourseGroupTypeEnum.EXCELLENT.getCode()));
			model.addAttribute("startDate", startDate);
			model.addAttribute("endDate", endDate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "/error/404";
		}
		return "outside/buycard/coursepricoach/buygroupcourse";
	}



	/**
	 * 预约  排队
	 * @return
	 */
	@RequestMapping(value="/queue",method=RequestMethod.POST)
	@ResponseBody
	public PageResponse queue(EmployeeAppointCourse employeeAppointCourse,HttpSession session){
		PageResponse response=new PageResponse();
		logger.info(" queue start...employeeAppointCourse" + JSON.toJSONString(employeeAppointCourse));
		 try {

			f_AboutClassService.insertEmployeeAppointCourse(employeeAppointCourse, session);
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
		 	e.printStackTrace();
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
			response.setMessage(e.getMessage());
		}
		logger.info(" queue end...response" + JSON.toJSONString(response));
		return response;

	}


	/**
	 *进行 私教课 约课 操作
	 *
	 */
	@RequestMapping(value="/doappointCourse",method=RequestMethod.POST)
	@ResponseBody
	public PageResponse doappointCourse(Model model,HttpSession session,EmployeeAppointCourse employeeAppointCourse){
		PageResponse response=new PageResponse();
		try {
			response.setRecords(f_AboutClassService.insertEmployeeBuyCourseDto(session, employeeAppointCourse));
//			f_AboutClassService.insertEmployeeBuyCourseDto(session, employeeAppointCourse);
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());

			//预约
			//response.setRecords(employeeAppointCourse.getId());

		} catch (Exception e) {

			response.setResultCode(ResultCodeEnum.FAIL.getCode());
			response.setMessage(e.getMessage());
		}
		return response;

	}

	/**
	 * 支付
	 */
	@RequestMapping(value="/pay",method=RequestMethod.POST)
	public void pay(){

	}


	/**
	 * 用户开门
	 */
	@RequestMapping(value="/opendoor",method=RequestMethod.GET)

	public String opendoor(HttpSession session,Model model){
		try {

			//f_PersonalService.opendoor(session);

		} catch (Exception e) {
	/*		model.addAttribute("result", false);
			model.addAttribute("msg", e.getMessage());
			return "/outside/login/door_result";*/
		}
		//model.addAttribute("result", true);

		return "/outside/login/door_result";

	}


	/**
	 * 该用户是否购买过私教课
	 * @return
	 */
	@RequestMapping(value="/isBuyPriCoach",method=RequestMethod.GET)
	@ResponseBody
	public PageResponse isBuyPriCoach (HttpSession session){
		PageResponse response=new PageResponse();

		try {
			boolean result=f_PersonalService.isBuyPriCoach(session);
			response.setRecords(result);
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}
		return response;
	}


	  /**
	   * 1.开门   2.判断是否超出开门距离
	   * @param session
	   * @param lng 经度
	   * @param lat 纬度
	   * @return
	   */
	  @RequestMapping(value="/ableToOpenDoor",method=RequestMethod.GET)
	  @ResponseBody
	  public PageResponse ableToOpenDoor(HttpSession session,@RequestParam(value="lng")BigDecimal lng,@RequestParam(value="lat")BigDecimal lat){
	    PageResponse response=new PageResponse();

	     try {

	       //  f_PersonalService.out_of_distance(lng.doubleValue(), lat.doubleValue());
	       f_PersonalService.opendoor(session,lng.doubleValue(), lat.doubleValue());

	      response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
	    } catch (Exception e) {
	      response.setResultCode(ResultCodeEnum.FAIL.getCode());
	      response.setMessage(e.getMessage());
	    }

	    return response;

	  }

		/**
		 * 判断会员是否已经购买该课程 （判断的是精品团课）
		 * @param model
		 * @param cid  课程id
		 * @param startDate  训练营开始日期
		 *  @param endDate  训练营结束日期
		 * @return
		 */
		@RequestMapping(value="/buySameGrouCourse",method=RequestMethod.POST)
		@ResponseBody
		public PageResponse buySameGrouCourse(Model model,HttpSession session,@RequestParam(value="cid")Integer cid,
				@RequestParam(value="startDate")Date startDate,@RequestParam(value="endDate")Date endDate){
			PageResponse response=new PageResponse();
			try {

				//获取精品团课
				response.setRecords(buyCardService.hasBuyGroupCourse(session, cid,startDate,endDate));
				response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				response.setResultCode(ResultCodeEnum.FAIL.getCode());
				response.setMessage(e.getMessage());
			}

			return response;

		}


		/**
		 *进行 工作室  约课 操作
		 *
		 */
		@RequestMapping(value="/doAppointStudio",method=RequestMethod.POST)
		@ResponseBody
		public PageResponse doAppointStudio(Model model,HttpSession session, CourseTimeDto courseTimeDto){
			PageResponse response=new PageResponse();
			try {
				f_AboutClassService.insertAppointStudioCourse(session, courseTimeDto);
//				f_AboutClassService.insertEmployeeBuyCourseDto(session, employeeAppointCourse);
				response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
				//预约
				//response.setRecords(employeeAppointCourse.getId());

			} catch (Exception e) {

				response.setResultCode(ResultCodeEnum.FAIL.getCode());
				response.setMessage(e.getMessage());
			}
			return response;

		}
		
		/**
		 * 取消绑定手机号
		 * @param employeeId
		 * @return
		 */
		@RequestMapping(value="/cancleBind",method=RequestMethod.GET)
		public String cancleBind(HttpServletRequest request,Model model){
			Integer employeeId = (Integer) request.getSession().getAttribute("employeeId");
			Employee employee = new Employee();
			employee.setEmployeeid(employeeId);
			employee.setMobilephone("");
			try {
				memberService.cancleBind(employee);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "outside/login/loginmsg";
		}

}
