package com.answer.Interceptor;

import com.answer.common.ResultCodeEnum;
import com.answer.common.CommonConstant;
import com.answer.domain.TAdmin;
import com.answer.utils.CommonUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @CLassName SessionInterceptor
 * @Description TODO
 * @Author ll
 * @Date 2018/12/11 15:55
 **/
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getServletPath().equals("/toLogin")
                || request.getServletPath().equals("/login")) {
            return true;
        }

        TAdmin admin = (TAdmin) CommonUtil.getSessionObj(request,
                CommonConstant.Str.ADMIN);

        if (null == admin) {
            if(request.getServletPath().equals("/toPage")){
                request.getRequestDispatcher("toLogin").forward(request,response);
            }else{
                response.setCharacterEncoding("UTF-8");
                PrintWriter printWriter = response.getWriter();
                printWriter.write(ResultCodeEnum.NOT_LOGIN.getResponse());
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
