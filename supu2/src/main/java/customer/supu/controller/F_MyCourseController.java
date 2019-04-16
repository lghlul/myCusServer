package customer.supu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import customer.supu.dto.CourseExcGroupDto;
import customer.supu.jenum.CourseGroupTypeEnum;
import customer.supu.jenum.CourseTypeEnum;
import customer.supu.jenum.MobileBottomEnum;
import customer.supu.po.CourseExcGroup;
import customer.supu.po.EmployeeAppointCourse;
import customer.supu.service.CoachService;
import customer.supu.service.CourseService;
import customer.supu.service.F_AboutClassService;
import customer.supu.service.F_MyCourseService;
import customer.supu.service.StoreService;
@Controller
@RequestMapping("/outside/myCourse")
public class F_MyCourseController {
	@Autowired
	private F_MyCourseService f_MyCourseService;
	
	@Autowired
	private F_AboutClassService f_AboutClassService;
	@Autowired
	private StoreService storeService;
    
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CoachService coachService;


	/**
	 * 进入页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="listPage")
	public String listPage(HttpServletRequest request,HttpSession session,Model model){
		Integer countCourse=0;
		try {
			//移动端 底端 样式
			model.addAttribute("bottom", MobileBottomEnum.MYCOURSE.getCode());

			 countCourse=f_MyCourseService.countAppiontCourse(request);



			if(countCourse>0){//表示有相关的课程
				//进入已完成课程页面
				model.addAttribute("course",f_MyCourseService.selectIsFinishedCourse(1, session));

				return "/outside/mycourse/finishedcourselist";
			}else{//表示没有预约的课程

				//进入没有课程的页面
				return "/outside/mycourse/nofinishlist";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/outside/mycourse/nofinishlist";


	}


	/**
	 * 进入未完成的页面
	 * @return
	 */
	@RequestMapping(value="nofinishPage")
	public String nofinishlist(Model model,HttpSession session){
		try {
			//移动端 底端 样式
			model.addAttribute("bottom", MobileBottomEnum.MYCOURSE.getCode());

			model.addAttribute("course",f_MyCourseService.selectIsFinishedCourse(0, session));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "/outside/mycourse/nofinishlist";
	}


	/*
	 * 进入已经完成的页面
	 */
	@RequestMapping(value="finishedcoursePage")
	public String finishedlist(Model model,HttpSession session){
		try {
			//移动端 底端 样式
			model.addAttribute("bottom", MobileBottomEnum.MYCOURSE.getCode());
			model.addAttribute("course",f_MyCourseService.selectIsFinishedCourse(1, session));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "/outside/mycourse/finishedcourselist";
	}
	
	
	@RequestMapping(value="/courseDetail",method=RequestMethod.GET)
	public String courseDetail(@RequestParam(value="id")Integer id,@RequestParam(value="type")String type,Model model){
		try{
			if(type.equals("1")){
				CourseExcGroup courseExcGroup=courseService.selectCourseGroupById(id,CourseGroupTypeEnum.BASIC.getCode());
				if(courseExcGroup==null){
					return "/error/404";
				}
				
				CourseExcGroupDto dto=courseService.selectCourseGroupDtoByCourseId(id);
				model.addAttribute("courseExcGroup",courseExcGroup);
				/*//查找该课程是否开放
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

				//根据门店id 课程id查询指定门店
				model.addAttribute("store",storeService.selectStoreByStIdAndCoId(storeId, id,CourseTypeEnum.COURSEGROUP.getCode()));
				//精品团课下教练详情
				model.addAttribute("coachs",coachService.selectCoachByGroupId(id,CourseTypeEnum.COURSEGROUP.getCode()));
				*/
				return "outside/aboutclass/detail_aboutclasslist";
			}
   
		} catch (Exception e) {

			e.printStackTrace();
		}

		return "outside/aboutclass/pri_appointsuccess";

	}
	
}
