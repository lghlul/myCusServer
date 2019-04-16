package customer.supu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import customer.supu.common.po.Page;
import customer.supu.common.po.PageResponse;
import customer.supu.dto.CourseDto;
import customer.supu.dto.EmployeeAppointCourseDto;
import customer.supu.po.EmployeeAppointCourse;
import customer.supu.service.CoachService;
import customer.supu.service.EmployeeAppointCourseService;

@Controller
@RequestMapping("/user/appoint")
public class B_EmployeeAppointCourseController {

	@Autowired
	private EmployeeAppointCourseService employeeAppointCourseService;

	@Autowired
	private CoachService coachService;

	/**
	 * 进入页面
	 * @return
	 */
	@RequestMapping(value="/listPage",method=RequestMethod.GET)
	public String listPge(Model model){
		try {

			model.addAttribute("coachlist", coachService.selectAllCoach());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/appoint/appointcourselist";

	}


	/**
	 * 异步获取列表数据
	 */
	@RequestMapping(value="/getAppointCourseList",method = RequestMethod.GET)
	@ResponseBody
	public PageResponse getCourseList(Page page, EmployeeAppointCourseDto employeeAppointCourseDto){
		  try {
			  PageResponse appointcourseList=employeeAppointCourseService.selectAllByList(page, employeeAppointCourseDto);

			  return appointcourseList;

	        } catch (Exception e) {

	        	e.printStackTrace();
	        }
	        return null;
	}

}
