package customer.supu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import customer.supu.common.po.PageResponse;
import customer.supu.jenum.ESmsType;
import customer.supu.jenum.ResultCodeEnum;
import customer.supu.po.Employee;
import customer.supu.service.CommentService;
import customer.supu.service.F_LoginService;
import customer.supu.service.F_PersonalService;
import customer.supu.service.SmsLogService;

@Controller
@RequestMapping("")
public class F_DoorLoginController {
	@Autowired
	private F_LoginService f_LoginService;

	@Autowired
	private SmsLogService smsLogService;


	@Autowired
	private F_PersonalService f_PersonalService;

	/**
	 * 外部用户登陆
	 * @return
	 */
	@RequestMapping(value="/outside/door_login",method=RequestMethod.GET)
	public String outsidelogin(HttpServletRequest request,String type){


			return "redirect:/wx/wxLogin";



//		if("1".equals(type)){//用户名密码登陆
//			return "/outside/login/door_loginpasswd";
//
//		}else if("2".equals(type)){//用户名短信登陆
//			return "/outside/login/door_loginmsg";
//		}
//
//		//默认用户密码登陆
//		return "/outside/login/door_loginpasswd";

	}
//
//	/**
//	 * 外部用户登陆
//	 * @param session
//	 * @param type 1;代表用户名密码登陆  2：代表用户名短信登陆
//	 * @param username 用户名
//	 * @param password  密码
//	 * @param captcha 验证码
//	 * @param request
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value="/outside/door_login",method=RequestMethod.POST)
//	public String outsideloginSuc(HttpSession session,@RequestParam(value="type")String type,
//			 @RequestParam(value="username")String username
//			,@RequestParam(value="password")String password,String captcha,
//			HttpServletRequest request,HttpServletResponse response,RedirectAttributes model,Model modell){
//		Integer count=0;
//		try {
//			//获取登陆次数
//		    count=f_LoginService.LoginCount(request);
//		    if("1".equals(type)){//1;代表用户名密码登陆
//		    	f_LoginService.jugdePasswordCorrect(username, password, captcha, request);
//			}else if("2".equals(type)){//2：代表用户名短信登陆
//				f_LoginService.jugdeMsgCorrect(username, password, captcha, request);
//
//			}else{
//				throw new Exception("基础数据错误");
//			}
//			request.getSession().setAttribute("username", username);
//			request.getSession().setAttribute("userId", username);
//
//			//return "redirect:/outside/aboutClass/listPage";
//		} catch (Exception e) {
//			model.addFlashAttribute("username", username);
//		    model.addFlashAttribute("count", count);
//			model.addFlashAttribute("error", e.getMessage());
//			if("2".equals(type)){//表示户名短信登陆
//				return "redirect:/outside/door_login?type=2";
//			}else{//代表用户名密码登陆
//				return "redirect:/outside/door_login";
//			}
//		}
//
//		//跳转到开门页面
//		return "redirect:/outside/personal/opendoor";
//
//	}

    /**
     * 外部用户登陆
     * @param session
     * @param type 1;代表用户名密码登陆  2：代表用户名短信登陆
     * @param username 用户名
     * @param password  密码
     * @param captcha 验证码
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value="/outside/door_login",method=RequestMethod.POST)
    public String outsideloginSuc(HttpSession session,@RequestParam(value="type")String type,
                                  @RequestParam(value="username")String username
            ,@RequestParam(value="openid")String openid
            ,@RequestParam(value="password")String password,String captcha,
                                  HttpServletRequest request,HttpServletResponse response,RedirectAttributes model) {
        Integer count = 0;
//		try {
        //获取登陆次数
//		    count=f_LoginService.LoginCount(request);

        try {
            Employee employee = new Employee();
            employee.setUsername(username);
            String nickname = (String) request.getSession().getAttribute("nickName");
            String heaimgurl = (String) request.getSession().getAttribute("headimgurl");
            employee.setMobilephone(username);
            employee.setOpenid(openid);
            employee.setHead(heaimgurl);
            employee.setFlag(1);
            employee.setCnname(nickname);

            try {
                Integer employid  =   f_LoginService.addOutsideEmployee(employee, request);;
                session.setAttribute("employeeId",  employid);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return "redirect:/outside/aboutClass/listPage";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
