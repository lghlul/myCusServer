package com.cad.cache;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cad.utils.LogUtil;

/**
 * 
 * @author Lu
 * @Description: 缓存监听器
 * @Package com.cad.cache
 * @date 2017年5月6日 下午9:46:32 
 * @version V1.0
 */
@Component
public class CacheListener implements ServletContextListener{
	
	private static final String TAG = CacheListener.class.getName();
	
	private ServletContext context = null; 
	
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		
	}

	/**
	 * 启动时预热redis
	 */
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		LogUtil.i(TAG, "contextInitialized start...");
		context = servletContextEvent.getServletContext(); 
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		CacheInit cacheHelper = ctx.getBean(CacheInit.class);
		/*cacheHelper.cleanCache();
		cacheHelper.initCache();*/
		LogUtil.i(TAG, "contextInitialized end...");
	}

}
