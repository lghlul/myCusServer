package customer.supu.controller;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import customer.supu.common.po.PageResponse;
import customer.supu.common.utils.SpringPropertyResourceReader;
import customer.supu.dto.DemoDto;

import customer.supu.jenum.ResultCodeEnum;
import customer.supu.service.demoService;

@Controller
@RequestMapping("/demo")
public class demoController {

	@Autowired
	private demoService demoService;



	@RequestMapping(value = "/a",method=RequestMethod.GET)
	public String a(){
		return "/demo/coachlist";

	}

	@RequestMapping(value = "/a1",method=RequestMethod.GET)
	public String a1(){
		return "/outside/test2";

	}


	/**
	 * 保存添加页面
	 * @param store
	 * @return
	 */
	@RequestMapping(value="addSave",method=RequestMethod.POST)
	@ResponseBody
	public PageResponse addSave(Model model, DemoDto demoDto){
		PageResponse response=new PageResponse();
		try {
			//添加保存
			demoService.insertCoachList(demoDto);

			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}

		return response;

	}

}
