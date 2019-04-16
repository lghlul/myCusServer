package customer.supu.controller;

import java.util.ArrayList;
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

import customer.supu.common.po.Page;
import customer.supu.common.po.PageResponse;
import customer.supu.dao.CourseDao;
import customer.supu.domain.CoachBean;
import customer.supu.domain.CoursePriCoachBean;
import customer.supu.dto.CoachDto;
import customer.supu.dto.CourseDto;
import customer.supu.jenum.CourseGroupTypeEnum;
import customer.supu.jenum.CourseTypeEnum;
import customer.supu.jenum.MobileBottomEnum;
import customer.supu.jenum.ResultCodeEnum;
import customer.supu.po.Coach;
import customer.supu.po.CourseExcGroup;
import customer.supu.po.CoursePriCoach;
import customer.supu.po.MemberCard;
import customer.supu.po.Store;
import customer.supu.service.BasicDataService;
import customer.supu.service.F_AboutClassService;
import customer.supu.service.F_BuyCardService;
import customer.supu.service.CoachService;
import customer.supu.service.CourseService;

import customer.supu.service.StoreService;

import customer.supu.service.MemberCardService;


/**
 * 会员购买控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/outside/buyCard")
public class F_BuyCardController {

	@Autowired
	private F_BuyCardService buyCardService;


	@Autowired
	private BasicDataService basicDataService;

	@Autowired
	private CoachService coachService;

	@Autowired
	private CourseService courseService;


	@Autowired
	private StoreService storeService;

	@Autowired
	private MemberCardService memberCardService;

	@Autowired
	private F_AboutClassService f_AboutClassService;


	/**
	 * 进入购买页面
	 */
	@RequestMapping(value="/listPage",method=RequestMethod.GET)
	public String aboutclass(Model model,HttpServletRequest request){
		try {


			//移动端 底端 样式
			model.addAttribute("bottom", MobileBottomEnum.PURCHASE.getCode());

			//获取会员卡类型基础数据

			model.addAttribute("memberCardType",basicDataService.getBasicDataByType("memberCardType"));



		} catch (Exception e) {

			e.printStackTrace();
		}
		return "outside/buycard/membercard/membercardlist";
	}



	/**
	 * 异步获取列表数据
	 */
	@RequestMapping(value="/getMemberCardList",method = RequestMethod.POST)
	@ResponseBody
	public PageResponse getMemberCardList(Page page,String cardtype){
		PageResponse response=new PageResponse();
		  try {

			  response.setRecords(buyCardService.selectAllByList(page, cardtype));


	        } catch (Exception e) {

	        	e.printStackTrace();
	        }
	        return response;
	}

	/**
	 * 私教课  页面
	 * @return
	 */
	@RequestMapping(value="/coursePriCoachPage",method=RequestMethod.GET)
	public String course_pri_coach(Model model){

		try {

			//移动端 底端 样式
			model.addAttribute("bottom", MobileBottomEnum.PURCHASE.getCode());

			//获取教练人气王
			//model.addAttribute("coach", coachService.selectAllPopularCoach()) ;
			
			model.addAttribute("coursePriCoach", courseService.selectCourseIsPopular()) ;

			//Page page=new Page();

			//page.setOffset("0");
			//page.setLimit("9");
			//私教课
			//model.addAttribute("coursePriCoach", courseService.selectCoursePriCoach(page));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "outside/buycard/coursepricoach/course_pri_list";
	}

	/**
	 * 异步获取教练
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/coursePriCoachlist",method=RequestMethod.GET)
	@ResponseBody
	public PageResponse getCoursePricoach(Page page){
		PageResponse response=new PageResponse();
		try {
			//获取私教课程
			response.setRecords(courseService.selectCoursePriCoach(page));
			//response.setRecords(coachService.selectCoursePriCoach(page));
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}

		return response;

	}
	
	/**
	 * 根据课程id进入详情页面
	 * @param id 课程id
	 * @return
	 */
	@RequestMapping(value="/coursePriListDetail",method=RequestMethod.GET)
	public String coursePriListDetail(@RequestParam(value="id")Integer id,Model model){
		
		/*try {
			CoursePriCoach coursePriCocah=courseService.selectCoursePriById(id);
			if(coursePriCocah==null){
				return "error/404";
			}
			//教练详情
			model.addAttribute("coursePriCocah",coursePriCocah);
			List<Coach> coachs=new ArrayList<Coach>();
			coachs.add(coachService.selectCoachById(Integer.parseInt(coursePriCocah.getCoachs())));
			model.addAttribute("coachs",coachs);
		} catch (Exception e) {
			return "error/404";
		}
		return "outside/buycard/coursepricoach/detail_course_pri_list";*/
		//修改一个课程含多个私教
		CoursePriCoachBean coursePriCoach = courseService.getPriCoachDetail(id);
		if(coursePriCoach==null){
			return "error/404";
		}
		model.addAttribute("coursePriCoach",coursePriCoach);
		model.addAttribute("coachs",coursePriCoach.getCoachList());
		model.addAttribute("id",id);
		return "outside/buycard/coursepricoach/detail_course_pri_list2";
		
	}

	/**
	 * 根据教练id进入详情页面
	 * @param id 教练id
	 * @return
	 */
	@RequestMapping(value="/coachPriDetail",method=RequestMethod.GET)
	public String coursePriDetail(@RequestParam(value="id")Integer id,Model model){

		try {
			//获得的证书有几张
			model.addAttribute("certificate", coachService.selectCoachCertificate(id));
			CoachDto coach=coachService.selectCoachByCoachId(id);
			if(coach==null){
				return "error/404";
			}

			//相册有几张照片
			model.addAttribute("imgCount",coachService.selectImgCount(coach));

			//教练详情
			model.addAttribute("coach",coach );

			//该教练拥有的私教课
			model.addAttribute("coachPri", courseService.selectCoachPriByCoachId(id, CourseTypeEnum.PRICOACH.getCode()));

			//获取所有服务场地（所有门店)
			model.addAttribute("store",storeService.selectAllStore());

			model.addAttribute("id",id);

		} catch (Exception e) {
			return "error/404";
		}
		return "outside/buycard/coursepricoach/detail_course_pri_coach";
	}




    /**
     * 进入会员卡详情页面
     * @param id
     * @param model
     * @return
     */
	@RequestMapping(value="detailPage",method=RequestMethod.GET)
	public String  detailPage(@RequestParam(value="id")Integer id,Model model){

		try {
			//移动端 底端 样式
			model.addAttribute("bottom", MobileBottomEnum.PURCHASE.getCode());
			//会员卡
			model.addAttribute("mCard", memberCardService.selecMemberCardInfoById(id));
			//适用会员卡的所有门店
			model.addAttribute("storeList", buyCardService.selectStoreByMembercardId(id));
			//适用会员卡的所有门店数量
			model.addAttribute("count", buyCardService.countByMembercardId(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "outside/buycard/membercard/detail_membercard";
	}


	/**
	 * 获取最近门店地址和id
	 * @param lng 经度
	 * @param lat 纬度
	 * @return
	 */
	@RequestMapping(value="/getNearestStore",method=RequestMethod.GET)
	@ResponseBody
	public PageResponse getNearestStore(@RequestParam(value="lng")double lng,@RequestParam(value="lat")double lat,Integer id){
		PageResponse response=new PageResponse();

		 try {

			response.setRecords(f_AboutClassService.sortMinDistance(lng, lat,id).get(0));
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}

		return response;

	}


	/**
	 * 精品团课  页面
	 * @return
	 */
	@RequestMapping(value="/courseGroupPage",method=RequestMethod.GET)
	public String course_group_coach(Model model){

		try {
			//移动端 底端 样式
			model.addAttribute("bottom", MobileBottomEnum.PURCHASE.getCode());
			//精品团课
//			model.addAttribute("courseGroup", courseService.selectCoursePriCoach(page));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "outside/buycard/coursegroup/course_group_list";
	}


	/**
	 * 异步获取精品团课
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/courseGrouplist",method=RequestMethod.GET)
	@ResponseBody
	public PageResponse getCourseGroup(Page page){
		PageResponse response=new PageResponse();
		try {

			//获取精品团课
			response.setRecords(buyCardService.selectCourseGroupList(page));
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}

		return response;

	}


	/**
	 * 根据团课id进入详情页面
	 * @param id 团课id
	 * @param storeid 门店 id
	 * @return
	 */
	@RequestMapping(value="/courseGroupDetail",method=RequestMethod.GET)
	public String courseGroupDetail(@RequestParam(value="id")Integer id,@RequestParam(value="storeid")Integer storeid,
			@RequestParam(value="startDate")String startDate,
			@RequestParam(value="endDate")String endDate,
			Model model){

		try {

			CourseExcGroup courseExcGroup=courseService.selectCourseGroupById(id,CourseGroupTypeEnum.EXCELLENT.getCode());
			if(courseExcGroup==null){
				return "/error/404";
			}
			//精品团课详情
			model.addAttribute("courseExcGroup",courseExcGroup);
			//精品团课下教练详情
			model.addAttribute("coachs",coachService.selectCoachByGroupId(id,CourseTypeEnum.COURSEGROUP.getCode()));
			//根据门店id 课程id查询指定门店
			model.addAttribute("store",storeService.selectStoreByStIdAndCoId(storeid, id,CourseTypeEnum.COURSEGROUP.getCode()));

			//获取训练营的排期时间  如：周二：10：00  -11：00
			model.addAttribute("weekTime",buyCardService.selectCourseGroupById(id, startDate, endDate));
			//训练营的开始结束时间
			model.addAttribute("startDate", startDate);
			model.addAttribute("endDate", endDate);
		} catch (Exception e) {
			return "/error/404";
		}
		return "outside/buycard/coursegroup/detail_course_group_list";
	}


	/**
	 * 进入支付成功页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/buyCardSuccess",method=RequestMethod.GET)
	public String buyCardSuccess(Model model){

		return "outside/buycard/coursepricoach/buymcard_success";
	}


	/**
	 * 判断会员是否已经购买了同类型会员卡
	 * @param model
	 * @param cid  会员卡id
	 * @return
	 */
	@RequestMapping(value="/buySameCard",method=RequestMethod.POST)
	@ResponseBody
	public PageResponse buySameCard(Model model,HttpSession session,@RequestParam(value="cid")Integer cid){
		PageResponse response=new PageResponse();
		try {

			//获取精品团课
			response.setRecords(buyCardService.hasBuyCard(session, cid));
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
			response.setMessage(e.getMessage());
		}

		return response;

	}


	/**
	 * 进入私教课支付成功页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/buyPriCoachSuccess",method=RequestMethod.GET)
	public String buyPriCoachSuccess(Model model){

		return "outside/buycard/coursepricoach/buypricoach_success";
	}


	/**
	 * 进入工作室支付成功页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/buyStudioSuccess",method=RequestMethod.GET)
	public String buyStudioSuccess(Model model){

		return "outside/buycard/coursepricoach/buystudio_success";
	}



	/**
	 * 进入(精品团课)支付成功页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/buyGrouCourseSucce",method=RequestMethod.GET)
	public String buyGrouCourseSuccess(Model model){

		return "outside/buycard/coursepricoach/buycoursegroup_success";
	}


	/**
	 * 判断会员是否已经购买该课程 （判断的是精品团课）
	 * @param model
	 * @param cid  课程id
	 * @param startDate  训练营开始日期
	 *  @param endDate  训练营结束日期
	 * @return
	 */
/*	@RequestMapping(value="/buySameGrouCourse",method=RequestMethod.POST)
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

	}*/


	/**
	 * 工作室  前端展示  页面
	 * @return
	 */
	@RequestMapping(value="/studioListPage",method=RequestMethod.GET)
	public String studioListPage(Model model){

		try {
			//移动端 底端 样式
			model.addAttribute("bottom", MobileBottomEnum.PURCHASE.getCode());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "outside/buycard/studio/course_studio_list";
	}


	/**
	 * 异步获取工作室课程列表
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/getCourseStudio",method=RequestMethod.GET)
	@ResponseBody
	public PageResponse getCourseStudio(Page page){
		PageResponse response=new PageResponse();
		try {

			//获取工作室课程
			response.setRecords(buyCardService.selectCourseStudioList(page));
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}

		return response;

	}


	/**
	 * 根据工作室课程id 进入详情页面
	 * @param id 团课id
	 * @param storeid 门店 id
	 * @return
	 */
	@RequestMapping(value="/courseStudioDetail",method=RequestMethod.GET)
	public String courseStudioDetail(@RequestParam(value="id")Integer id,@RequestParam(value="storeid")Integer storeid,Model model){

		try {

			CourseExcGroup courseExcGroup=courseService.selectCourseGroupById(id,CourseGroupTypeEnum.STUDIO.getCode());
			if(courseExcGroup==null){
				return "/error/404";
			}
			//工作室课程详情
			model.addAttribute("courseExcGroup",courseExcGroup);
			//工作室课程下教练详情
			model.addAttribute("coachs",coachService.selectCoachByGroupId(id,CourseTypeEnum.STUDIO.getCode()));
			//根据门店id 课程id查询指定门店
			model.addAttribute("store",storeService.selectStoreByStIdAndCoId(storeid, id,CourseTypeEnum.STUDIO.getCode()));

			//获取训练营的排期时间  如：周二：10：00  -11：00
			model.addAttribute("TimeList",buyCardService.selectTimeListByStudioId(id));
		} catch (Exception e) {
			return "/error/404";
		}
		return "outside/buycard/studio/detail_course_studio_list";
	}


	/*
	 * @author ll
	 * @Description 私教课详情
	 * @date 2018/8/28 14:39
	 * @param [id]
	 * @return java.lang.Object
	 */
	@ResponseBody
	@RequestMapping(value="/priCourseDetail",method=RequestMethod.GET)
	public Object priCourseDetail(@RequestParam(value="id")Integer id){
		return this.courseService.getPriCoachDetail(id);
	}

}

