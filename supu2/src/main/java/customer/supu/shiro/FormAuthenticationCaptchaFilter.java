package customer.supu.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import customer.supu.exception.IncorrectCaptchaException;


/**
 * form表单  过滤器
 * @author Administrator
 *
 */
public class FormAuthenticationCaptchaFilter extends FormAuthenticationFilter{

	public static final String DEFAULT_CAPTCHA_PARAM = "captcha";
	private String captchaParam = DEFAULT_CAPTCHA_PARAM;

	@Autowired
	private SecurityRealm securityRealm;
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token,
			Subject subject, ServletRequest request, ServletResponse response)
			throws Exception {
		//登录成功 显示调用授权方法
	//	securityRealm.doGetAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String url = this.getSuccessUrl();
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + url);    //页面跳转
        return false;
	}


	protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
    	UsernamePasswordCaptchaToken token = createToken(request, response);
        if (token == null) {
            String msg = "createToken method implementation returned null. A valid non-null AuthenticationToken " +
                    "must be created in order to execute a login attempt.";
            throw new IllegalStateException(msg);
        }
        try {
        	//这里也可以记录一些登陆信息
        	doCaptchaValidate((HttpServletRequest) request, token);
            Subject subject = getSubject(request, response);
            subject.login(token);
            return onLoginSuccess(token, subject, request, response);
        } catch (AuthenticationException e) {
            return onLoginFailure(token, e, request, response);
        }
    }


    @Override
    protected UsernamePasswordCaptchaToken createToken(ServletRequest request, ServletResponse response) {
        String username = getUsername(request);
        String password = getPassword(request);
        String captcha = request.getParameter(getCaptchaParam());
        boolean rememberMe = isRememberMe(request);
        String host = getHost(request);

        return new UsernamePasswordCaptchaToken(username, password.toCharArray(), rememberMe, host, captcha);
    }


//    @Override
//    protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
//        String exMsg = "登录失败";
//        if (ae instanceof IncorrectCaptchaException) {
//            exMsg = "验证码错误";
//        }
//        else if (ae instanceof IncorrectCredentialsException) {
//            exMsg = "手机号与密码不匹配";
//        }
//        else if (ae instanceof UnknownAccountException) {
//            exMsg = "手机号码不存在";
//        }
//        else if (ae instanceof ExcessiveAttemptsException) {
//            exMsg = "密码验证失败次数过多，请30分钟后重试";
//        }
//        request.setAttribute(getFailureKeyAttribute(), exMsg);
//    }

    // 验证码校验
    protected void doCaptchaValidate(HttpServletRequest request, UsernamePasswordCaptchaToken token)
            throws IncorrectCaptchaException {
        // session中的图形码字符串
        String captcha =
                (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        // 比对
        if (captcha != null && !captcha.equalsIgnoreCase(token.getCaptcha())) {
            throw new IncorrectCaptchaException("验证码错误！");
        }
    }


    public String getCaptchaParam() {
		return captchaParam;
	}


	public void setCaptchaParam(String captchaParam) {
		this.captchaParam = captchaParam;
	}
}
