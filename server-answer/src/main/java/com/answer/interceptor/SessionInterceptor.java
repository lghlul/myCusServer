package com.answer.interceptor;

import com.alibaba.fastjson.JSON;
import com.answer.cache.CacheHelper;
import com.answer.domain.Result;
import com.answer.domain.User;
import com.answer.domain.WXSessionCache;
import com.answer.service.IUserService;
import com.answer.utils.Constant;
import com.answer.utils.Log4jUtil;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SessionInterceptor implements HandlerInterceptor {
	@Autowired
	private CacheHelper cacheHelper;
	@Autowired
	private IUserService userService;

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String wx_session = request.getParameter("wxSession");
		Log4jUtil.info("preHandle...wx_session=" + wx_session);
		WXSessionCache session = this.cacheHelper.getSession(wx_session);
		Log4jUtil.info("preHandle...session=" + JSON.toJSONString(session));
		Result res = new Result();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		//校验是否有凭证
		if (session.getOpenID() == null) {
			res.setResultCode(Constant.returnCode.SESSOIN_TIMEOUT);
			Log4jUtil.info("preHandle...res=" + JSON.toJSONString(res));
			PrintWriter writer = response.getWriter();
			writer.print(JSON.toJSON(res));
			writer.close();
			response.flushBuffer();
			return false;
		}else{
			String jobNumUrl = "checkJobNum,bindJobNum,userInfo,update";
			String url = request.getRequestURI();
			String[] arr = url.split("/");
			if(jobNumUrl.indexOf(arr[arr.length-1]) < 0){
				//校验是否有工号
				User user = userService.getUserByOpenID(session.getOpenID());
				if(user.getJobNum() == null || "".equals(user.getJobNum())){
					res.setResultCode(Constant.returnCode.NO_JOBNUM);
					PrintWriter writer = response.getWriter();
					Log4jUtil.info("preHandle...res=" + JSON.toJSONString(res));
					writer.print(JSON.toJSON(res));
					writer.close();
					response.flushBuffer();
					return false;
				}
			}
		}
		return true;
	}
}
