package customer.supu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import customer.supu.common.po.Page;
import customer.supu.common.po.PageResponse;
import customer.supu.dto.CoachTimeDto;

import customer.supu.jenum.ResultCodeEnum;
import customer.supu.po.Store;
import customer.supu.service.CoachService;
import customer.supu.service.PriCourseTimeService;



@Controller
@RequestMapping("user/pricoursetime")
public class B_PriCourseTimeController {
	@Autowired
	private PriCourseTimeService priCourseTimeService;

	@Autowired
	private CoachService coachService;
	/**
	 * 进入添加页面
	 * @return
	 */
	@RequestMapping(value="listPage",method=RequestMethod.GET)
	public String listPage(Model model){

		try {
			//加载教练
			model.addAttribute("coachList", coachService.selectAllCoach());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/pricoursetime/pri_time_list";
	}

	/**
	 * 异步获取列表数据
	 */
	@RequestMapping(value="/getpricoursetimeList",method = RequestMethod.GET)
	@ResponseBody
	public PageResponse getpricoursetimeList(Page page,Integer coachId,String date){

		  try {
			PageResponse pricoursetimeList=priCourseTimeService.selectCoachTimeList(page, coachId, date);

			return pricoursetimeList;

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
	public String addPage(Model model){

		try {
			//加载教练
			model.addAttribute("coachList", coachService.selectAllCoach());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/pricoursetime/add_pri_time";
	}

	/**
	 * 保存添加页面
	 * @param store
	 * @return
	 */
	@RequestMapping(value="addSave",method=RequestMethod.POST)
	@ResponseBody
	public PageResponse addSave(Model model,CoachTimeDto coachTimeDto){
		PageResponse response=new PageResponse();
		try {
			//添加保存
			//memberService.addSave(MemberDto);
			priCourseTimeService.addTime(coachTimeDto);

			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
			response.setMessage(e.getMessage());
		}

		return response;

	}



	/**
	 * 根据添加id进入添加页面
	 * @param model
	 * @param coachId 教练id
	 * @param  date 年月 2017-08  没有默认当前月
	 * @return
	 */
	@RequestMapping(value="editPage",method=RequestMethod.GET)
	public String editPage(Model model,@RequestParam(value="coachId")Integer coachId,@RequestParam(value="date")String date){

		try {
			//加载教练
			model.addAttribute("coach", coachService.selectCoachById(coachId));

			//时间
			model.addAttribute("date",date);

			//加载教练本月的可预约时间
			model.addAttribute("caochTime", priCourseTimeService.selectPriCourseTime(coachId, date));
			//获取本月的日期


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/pricoursetime/edit_pri_time";
	}


	/**
	 * 编辑保存
	 * @param model
	 * @param coachTimeDto
	 * @return
	 */
	@RequestMapping(value="editSave",method=RequestMethod.POST)
	@ResponseBody
	public PageResponse editSave(Model model,CoachTimeDto coachTimeDto,String date){
		PageResponse response=new PageResponse();
		try {
			//编辑保存

			priCourseTimeService.editSave(coachTimeDto, date);

			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
			response.setMessage(e.getMessage());
		}

		return response;

	}


}
