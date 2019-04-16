package customer.supu.common.utils;

import java.lang.reflect.Method;
import java.util.Properties;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.PropertyResourceConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.io.support.PropertiesLoaderSupport;

public class SpringPropertyResourceReader {
	private static ApplicationContext applicationContext;

	public static ApplicationContext getContext() {
		return applicationContext;
	}

	public static void setContext(ApplicationContext aContext) {
		applicationContext = aContext;
	}

	// private static ApplicationContext applicationContext=new
	// ClassPathXmlApplicationContext("applicationContext.xml");
	static Properties properties = new Properties();

	private static void init() {
		AbstractApplicationContext abstractContext = (AbstractApplicationContext) applicationContext;
		try {
			// get the names of BeanFactoryPostProcessor
		 	String[] postProcessorNames = abstractContext.getBeanNamesForType(
					BeanFactoryPostProcessor.class, true, true);
			for (String ppName : postProcessorNames) {
				// get the specified BeanFactoryPostProcessor
				BeanFactoryPostProcessor beanProcessor = (BeanFactoryPostProcessor) abstractContext
						.getBean(ppName, BeanFactoryPostProcessor.class);
				// check whether the beanFactoryPostProcessor is
				// instance of the PropertyResourceConfigurer
				// if it is yes then do the process otherwise continue
				if (beanProcessor instanceof PropertyResourceConfigurer) {
					PropertyResourceConfigurer propertyResourceConfigurer = (PropertyResourceConfigurer) beanProcessor;
					// get the method mergeProperties
					// in class PropertiesLoaderSupport
					Method mergeProperties = PropertiesLoaderSupport.class
							.getDeclaredMethod("mergeProperties");
					// get the props
					mergeProperties.setAccessible(true);
					Properties props = (Properties) mergeProperties
							.invoke(propertyResourceConfigurer);
					// get the method convertProperties
					// in class PropertyResourceConfigurer
					Method convertProperties = PropertyResourceConfigurer.class
							.getDeclaredMethod("convertProperties",
									Properties.class);
					// convert properties
					convertProperties.setAccessible(true);
					convertProperties.invoke(propertyResourceConfigurer, props);
					properties.putAll(props);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String getProperty(String propertyName) {
		if (applicationContext != null && properties.isEmpty()) {
			init();
		}
		if (applicationContext == null) {
			return null;
		}
		return properties.getProperty(propertyName);
	}

}
