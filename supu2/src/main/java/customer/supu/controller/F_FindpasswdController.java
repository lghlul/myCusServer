package customer.supu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import customer.supu.common.po.PageResponse;
import customer.supu.jenum.ESmsType;
import customer.supu.jenum.ResultCodeEnum;
import customer.supu.po.Employee;
import customer.supu.service.F_FindPasswdService;
import customer.supu.service.F_LoginService;
import customer.supu.service.SmsLogService;

@Controller
@RequestMapping("/findpasswd")
public class F_FindpasswdController {

	@Autowired
	private SmsLogService smsLogService;

	@Autowired
	private F_FindPasswdService f_FindPasswdService;


	@Autowired
	private F_LoginService f_LoginService;
	/**
	 * 进入找回密码第一步
	 * @return
	 */
	@RequestMapping(value="/firststep",method=RequestMethod.GET)
	public String firstStep(){

		return "/outside/findpasswd/firststep";
	}


	/**
	 * 提交    找回密码第一步：
	 * @param mobile 手机号
	 * @param Code 验证码
	 * @return
	 */
	@RequestMapping(value="/firststep",method=RequestMethod.POST)
	public String firstStep(@RequestParam(value="mobile")String mobile,@RequestParam(value="code")String code,Model model){

		try {
			smsLogService.doValidMobileCode(mobile, code,ESmsType.MODIFY);
			//response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			model.addAttribute("mobile", mobile);
			return "/outside/findpasswd/firststep";
		}

		//跳转到第二步
		model.addAttribute("mobile", mobile);
		return "/outside/findpasswd/secondstep";
		//return "redirect:/findpasswd/secondstep?mobile="+mobile;
	}

	/*@RequestMapping(value="/secondstep",method=RequestMethod.GET)
	public String secondStep(@RequestParam(value="mobile")String mobile,Model model){
		model.addAttribute("mobile", mobile);
		return "/findpasswd/secondstep_passwd";
	}*/

	/**
	 * 找回密码第二步，设置密码
	 * @param mobile  手机号
	 * @param passwd 密码
	 * @return
	 */
	@RequestMapping(value="/secondstep",method=RequestMethod.POST)
	public String secondStep(@RequestParam(value="mobile")String mobile,@RequestParam(value="passwd")String passwd,Model model){
		try {
			Employee employee=new Employee();
			employee.setEcode(mobile);
			employee.setPassword(passwd);
			//修改密码
			f_FindPasswdService.resetPassword(employee);
		} catch (Exception e) {
			model.addAttribute("mobile", mobile);
			model.addAttribute("error",e.getMessage());
			return "/findpasswd/secondstep";
		}

		//return "redirect:/findpasswd/thirdstep";
		//return "redirect:/outside/findpasswd/thirdstep";
		return "redirect:/outside/login";
	}



	/**
	 * 修改密码
	 * 发送验证码  返回mobile
	 */
	@RequestMapping(value="/getMobileCode",method=RequestMethod.GET)
	@ResponseBody
	public PageResponse getMobileCode(@RequestParam(value="mobile")String mobile,HttpServletRequest request){
		PageResponse response=new PageResponse();
		try {

			//发送6位随机数字
			f_FindPasswdService.getMobileCode(mobile,"SMS_105855047",request);

			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());

		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}
		return response;

	}

	/**
	 * 异步  判断账号是否存在
	 */
	@RequestMapping(value="/isExist",method=RequestMethod.GET)
	@ResponseBody
	public PageResponse isExist(Employee employee,HttpServletRequest request){
		PageResponse response=new PageResponse();
		try {

			response.setResultCode(f_LoginService.isExist(employee ,request));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}


}
