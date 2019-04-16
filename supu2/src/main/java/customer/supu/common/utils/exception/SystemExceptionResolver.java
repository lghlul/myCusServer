package customer.supu.common.utils.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class SystemExceptionResolver implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex) {
    	
        // 异常处理，例如将异常信息存储到数据库
        System.out.println("************出现错误啦***************:"+ex.getMessage());

        // 视图显示专门的错误页
        ModelAndView modelAndView = new ModelAndView("exception/500");
        return modelAndView;
    }
}
