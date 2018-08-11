package com.cad.service;

import java.util.List;

import com.cad.domain.Deviation;

/**
 * 
 * @author Lu
 * @Description: 公差查询
 * @Package com.cad.service
 * @date 2017年5月6日 下午10:02:54 
 * @version V1.0
 */
public interface IDeviationService {

	/**
	 * 
	* @Title: getDeviation 
	* @Description: 公差列表
	* @param @param paramDeviation
	* @param @return    设定文件 
	* @return List<Deviation>    返回类型 
	* @throws
	 */
	public List<Deviation> getDeviation(Deviation paramDeviation);

	
	/**
	 * 
	* @Title: getDeviationValue 
	* @Description: 获取结果
	* @param @param paramDeviation
	* @param @return    设定文件 
	* @return Deviation    返回类型 
	* @throws
	 */
	public Deviation getDeviationValue(Deviation paramDeviation);
}
