package com.cad.mapper;

import java.util.List;

import com.cad.domain.Pressure;

/**
 * 
 * @author Lu
 * @Description: 气缸压力
 * @Package com.cad.mapper
 * @date 2017年5月6日 下午10:04:36 
 * @version V1.0
 */
public interface PressureMapper {
	/**
	 * 
	* @Title: findBoreSize 
	* @Description: 缸径
	* @param @return    设定文件 
	* @return List<Pressure>    返回类型 
	* @throws
	 */
	public List<Pressure> findBoreSize();

	/**
	 * 
	* @Title: findPressureSize 
	* @Description: 压力 
	* @param @return    设定文件 
	* @return List<Pressure>    返回类型 
	* @throws
	 */
	public List<Pressure> findPressureSize();

	/**
	 * 
	* @Title: findValue 
	* @Description: 获取伸缩压力
	* @param @param paramPressure
	* @param @return    设定文件 
	* @return List<Pressure>    返回类型 
	* @throws
	 */
	public List<Pressure> findValue(Pressure paramPressure);
	
	/**
	 * 
	* @Title: findAllValue 
	* @Description: 获取所有伸缩压力  用于存入redis 
	* @param @return    设定文件 
	* @return List<Pressure>    返回类型 
	* @throws
	 */
	public List<Pressure> findAllValue();
}
