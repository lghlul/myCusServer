package customer.supu.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 系统配置文件
 * @author clq
 *
 */
public class SystemConfig
{
	private static Properties config = null; 
	static 
	{  
		InputStream in = SystemConfig.class.getClassLoader().getResourceAsStream("config/config.properties"); 
		config = new Properties(); 
		try 
		{  
			config.load(in);  
			in.close(); 
		} 
		catch (IOException e)
		{  
			System.out.println("No AreaPhone.properties defined error");
		} 
	}

	// 根据key读取value 
	public static String readValue(String key) 
	{ 
		// Properties props = new Properties();  
		try
		{   
			String value = config.getProperty(key);  
			return value; 
		} 
		catch (Exception e)
		{  
			e.printStackTrace();  
			System.err.println("ConfigInfoError" + e.toString()); 
			return null;  
		} 
	}

}
