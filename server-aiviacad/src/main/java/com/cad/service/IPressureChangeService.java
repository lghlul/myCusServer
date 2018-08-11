package com.cad.service;

import com.cad.domain.PressureChange;

/**
 * 
 * @author Lu
 * @Description: 压力转换
 * @Package com.cad.service
 * @date 2017年5月6日 下午10:02:36 
 * @version V1.0
 */
public interface IPressureChangeService {
	/**
	 * 
	* @Title: change 
	* @Description:  压力转换
	* @param @param paramPressureChange
	* @param @return    设定文件 
	* @return PressureChange    返回类型 
	* @throws
	 */
	public PressureChange change(PressureChange paramPressureChange);
}
