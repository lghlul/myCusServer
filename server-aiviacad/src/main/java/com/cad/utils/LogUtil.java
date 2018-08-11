package com.cad.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Lu
 * @Description: 日志工具类
 * @Package com.cad.utils
 * @date 2017年5月6日 下午9:58:43 
 * @version V1.0
 */
public class LogUtil {
	private static final Logger log = LoggerFactory.getLogger(LogUtil.class.getName());

	/**
	 * 
	* @Title: i 
	* @Description: info
	* @param @param tag
	* @param @param msg    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public static void i(String tag, String msg) {
		if (log.isInfoEnabled())
			log.info(tag + "==>" + msg);
	}

	/**
	 * 
	* @Title: e 
	* @Description: error
	* @param @param tag
	* @param @param msg    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public static void e(String tag, String msg) {
		if (log.isErrorEnabled())
			log.error(tag + "==>" + msg);
	}

	/**
	 * 
	* @Title: d 
	* @Description: debug 
	* @param @param tag
	* @param @param msg    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public static void d(String tag, String msg) {
		if (log.isDebugEnabled())
			log.debug(tag + "==>" + msg);
	}
}
