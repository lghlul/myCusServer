package com.cad.service;

import java.util.List;

import com.cad.domain.Pressure;

/**
 * 
 * @author Lu
 * @Description: 气缸压力
 * @Package com.cad.service
 * @date 2017年5月6日 下午10:01:53 
 * @version V1.0
 */
public interface IPressureService {

	/**
	 * 
	* @Title: getBoreSize 
	* @Description: 获取缸径
	* @param @return    设定文件 
	* @return List<Pressure>    返回类型 
	* @throws
	 */
	public List<Pressure> getBoreSize();

	/**
	 * 
	* @Title: getPressureSize 
	* @Description: 获取气压
	* @param @return    设定文件 
	* @return List<Pressure>    返回类型 
	* @throws
	 */
	public List<Pressure> getPressureSize();
	
	/**
	 * 
	* @Title: getValue 
	* @Description: 获取伸缩压力
	* @param @param paramPressure
	* @param @return    设定文件 
	* @return List<Pressure>    返回类型 
	* @throws
	 */
	public List<Pressure> getValue(Pressure paramPressure);
}
