package com.cad.service;

import java.util.List;
import java.util.Map;
import com.cad.domain.ProjectMaterial;

/**
 * 
 * @author Lu
 * @Description: 工程材料
 * @Package com.cad.service
 * @date 2017年5月6日 下午10:01:07 
 * @version V1.0
 */
public interface IProjectMaterialService {

	/**
	 * 
	* @Title: getProjectMaterial 
	* @Description: 工程材料列表
	* @param @return    设定文件 
	* @return List<List<ProjectMaterial>>    返回类型 
	* @throws
	 */
	public List<List<ProjectMaterial>> getProjectMaterial();

	/**
	 * 
	* @Title: getProjectMaterialValue 
	* @Description: 根据工程材料获取热处理以及百度百科
	* @param @param pm_id
	* @param @return    设定文件 
	* @return ProjectMaterial    返回类型 
	* @throws
	 */
	public ProjectMaterial getProjectMaterialValue(int pm_id);
	
	
}
