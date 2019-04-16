package customer.supu.listener;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;


import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import customer.supu.common.utils.SpringPropertyResourceReader;


public class MyContextLoaderListener extends ContextLoaderListener {
	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		ServletContext context = event.getServletContext();
		// 获取web环境下的ApplicationContext
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		// 将ApplicationContext，set到SpringPropertyResourceReader的静态变量context
		SpringPropertyResourceReader.setContext(ctx);
	}

}
