package customer.supu.filter;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.supu.controller.F_LoginController;
import customer.supu.service.F_LoginService;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.OncePerRequestFilter;

import customer.supu.po.Employee;

public class OutsideLoginFilter extends OncePerRequestFilter {

    private F_LoginService f_LoginService;

    private Logger logger = Logger.getLogger(OutsideLoginFilter.class);
    /**
     * 过滤  outside/*   登陆和注册除外
     */
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        logger.info("doFilterInternal start...");
        // 获取容器
        HttpServletRequest req = (HttpServletRequest) request;
        ServletContext sc = req.getSession().getServletContext();
        XmlWebApplicationContext cxt = (XmlWebApplicationContext) WebApplicationContextUtils.getWebApplicationContext(sc);

        // 从容器中获取redisTemplate
        if (cxt != null && cxt.getBean("f_LoginService") != null && f_LoginService == null)
            f_LoginService = (F_LoginService) cxt.getBean("f_LoginService");

//        String openId = (String) request.getSession().getAttribute("openId");
//        if (StringUtils.hasText(openId)) {//如果session有值
//            filterChain.doFilter(request, response);
//        }else{
//            response.sendRedirect(request.getContextPath() + "/wx/wxlogin");
//        }

//        response.sendRedirect(request.getContextPath()+"/outside/login");
System.out.println(1111111);
        //获取请求url
        String path = request.getRequestURI();
        System.out.println(path);
        Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组
        String openid = null;
        if (null == cookies) {
            System.out.println("没有cookie=========");

        } else {
            for (Cookie cookie : cookies) {
                System.out.println("name:" + cookie.getName() + ",value:" + cookie.getValue());
                if ("nickName".equals(cookie.getName())) {
                    String nickName = cookie.getValue();
                    URLDecoder.decode(nickName, "utf-8");
                    request.getSession().setAttribute("nickName", nickName);
                }
                if ("headimgurl".equals(cookie.getName())) {
                    String headimgurl = cookie.getValue();
                    request.getSession().setAttribute("headimgurl", headimgurl);
                }
                if ("openid".equals(cookie.getName())) {
                    openid = cookie.getValue();
                    request.getSession().setAttribute("openId", openid);
                }
            }
        }
        if (!(path.contains("wxLogin") || path.contains("callBack") || path.contains("outside/login"))) {

///findpasswd/isExist

            if (openid == null) {
                System.out.println("filter wxLogin");
                String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
                String queryurl=request.getQueryString();
                if(null!=queryurl){
                    basePath+="?"+queryurl;
                }
                logger.info("doFilterInternal basePath=" + basePath);
                response.sendRedirect(request.getContextPath() + "/wx/wxLogin?realPath=" + URLEncoder.encode(basePath));
            } else {
                try {
//
//                    if (path.contains("/outside/login")) {
//                        filterChain.doFilter(request, response);
//                    }
//
//                    if(path.contains("isExist")){
//                        filterChain.doFilter(request, response);
//                    }
                	Employee employee = f_LoginService.selectByOpenid(openid);
                    if (employee == null || StringUtils.isEmpty(employee.getMobilephone())) {
                        System.out.println("filter bindMobile");
                        response.sendRedirect(request.getContextPath() + "/outside/bindMobile");
                    } else {
                        request.getSession().setAttribute("employeeId", employee.getEmployeeid());
                        System.out.println("filter go");
                        filterChain.doFilter(request, response);
                    }
                } catch (Exception e) {
                    System.out.println("error" + e.getMessage());
                    // response.sendRedirect(request.getContextPath() + "/outside/bindMobile");
                }


            }



    } else

    {
        filterChain.doFilter(request, response);


    }


}
}
