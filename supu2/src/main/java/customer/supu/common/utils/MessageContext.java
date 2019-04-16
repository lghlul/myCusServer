package customer.supu.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MessageContext implements ApplicationContextAware
{

    private static final Logger log = LoggerFactory.getLogger(MessageContext.class);

    private static ApplicationContext applicationContext;

    public MessageContext()
    {
    }

    public void setApplicationContext(ApplicationContext applicationContext)
    {
        MessageContext.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext()
    {
        return applicationContext;
    }

    public static Object getBean(String name)
    {
        try
        {
            return applicationContext.getBean(name);
        }
        catch(BeansException e)
        {
            if(e instanceof NoSuchBeanDefinitionException)
            {
                log.warn((new StringBuilder()).append("No bean named '").append(name).append("' is defined").toString());
                return null;
            } else
            {
                throw e;
            }
        }
    }

    public static <T> T getBean(Class<T> clazz)
    {
        String className = clazz.getSimpleName();
        String firstLetter = String.valueOf(className.charAt(0)).toLowerCase();
        String beanName = (new StringBuilder()).append(firstLetter).append(className.substring(1)).toString();
        return (T)applicationContext.getBean(beanName);
    }

}
