package customer.supu.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import customer.supu.common.utils.CusAccessObjectUtil;
import customer.supu.po.Employee;



@Controller
@RequestMapping(value = "/user")
public class B_LoginController {
	  /**
     * 用户登录
     *
     * @param user
     * @param result
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Employee user, BindingResult result, Model model, HttpServletRequest request) {
        try {
            Subject subject = SecurityUtils.getSubject();

            // 已登陆则 跳到首页
            if (subject.isAuthenticated()) {
                return "redirect:/user/index";
            }
            if (result.hasErrors()) {
                model.addAttribute("error", "参数错误！");
                return "login";
            }
        } catch (Exception e) {
            // 身份验证失败
            return "login";
        }
        return "/login";
    }

    /**
     * 登陆失败
     *
     * @param user
     * @param result
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName, Model model,HttpServletRequest request) {
		model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
		//销毁session 不能销毁 ，否则销毁session中的验证码，导致二次登陆时候，验证码为空
		//session.invalidate();
		HttpSession session = request.getSession();

		String ip=CusAccessObjectUtil.getIpAddress(request);

		//如果参数大于3，则表示需要验证码
		if (session.getAttribute(ip+"count")==null) {
			session.setAttribute(ip+"count", 1);
		}else{
			session.setAttribute(ip+"count", Integer.parseInt(String.valueOf(session.getAttribute(ip+"count")))+1);
		}
        int loginCount= Integer.parseInt(String.valueOf(request.getSession().getAttribute(ip+"count")));
        model.addAttribute("loginCount", loginCount);
		return "login";
    }


    /**
     * 用户登出
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session,HttpServletResponse response,HttpServletRequest request) {
        session.removeAttribute("userInfo");
        // 登出操作
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
		return "redirect:/user/login";
    }

}
