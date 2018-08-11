package com.cad.mapper;

import java.util.List;

import com.cad.domain.Deviation;

/**
 * 
 * @author Lu
 * @Description: 公差查询
 * @Package com.cad.mapper
 * @date 2017年5月6日 下午10:04:05 
 * @version V1.0
 */
public interface DeviationMapper {
	
	/**
	 * 
	* @Title: findDeviation 
	* @Description: 公差列表
	* @param @param paramDeviation
	* @param @return    设定文件 
	* @return List<Deviation>    返回类型 
	* @throws
	 */
	public List<Deviation> findDeviation(Deviation paramDeviation);

	/**
	 * 
	* @Title: findDeviationValue 
	* @Description: 获取结果
	* @param @param paramDeviation
	* @param @return    设定文件 
	* @return Deviation    返回类型 
	* @throws
	 */
	public Deviation findDeviationValue(Deviation paramDeviation);
}
