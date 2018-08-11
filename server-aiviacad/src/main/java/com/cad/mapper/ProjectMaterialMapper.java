package com.cad.mapper;

import java.util.List;
import com.cad.domain.ProjectMaterial;

/**
 * 
 * @author Lu
 * @Description: 工程材料
 * @Package com.cad.mapper
 * @date 2017年5月6日 下午10:05:54 
 * @version V1.0
 */
public interface ProjectMaterialMapper {
	
	/**
	 * 
	* @Title: findProjectMaterial 
	* @Description: 所有工程材料
	* @param @return    设定文件 
	* @return List<ProjectMaterial>    返回类型 
	* @throws
	 */
	public List<ProjectMaterial> findProjectMaterial();

	/**
	 * 
	* @Title: findProjectMaterialValue 
	* @Description: 根据材料获取热处理
	* @param @param pm_id
	* @param @return    设定文件 
	* @return List<ProjectMaterial>    返回类型 
	* @throws
	 */
	public List<ProjectMaterial> findProjectMaterialValue(int pm_id);
	
	/**
	 * 
	* @Title: findChina 
	* @Description: 中国材料
	* @param @return    设定文件 
	* @return List<ProjectMaterial>    返回类型 
	* @throws
	 */
	public List<ProjectMaterial> findChina();
	
	/**
	 * 
	* @Title: findGermany 
	* @Description: 德国材料 
	* @param @return    设定文件 
	* @return List<ProjectMaterial>    返回类型 
	* @throws
	 */
	public List<ProjectMaterial> findGermany();
	
	/**
	 * 
	* @Title: findSpain 
	* @Description: 西班牙材料
	* @param @return    设定文件 
	* @return List<ProjectMaterial>    返回类型 
	* @throws
	 */
	public List<ProjectMaterial> findSpain();
	
	/**
	 * 
	* @Title: findTurkey 
	* @Description: 土耳其材料
	* @param @return    设定文件 
	* @return List<ProjectMaterial>    返回类型 
	* @throws
	 */
	public List<ProjectMaterial> findTurkey();
	
	/**
	 * 
	* @Title: findUsa 
	* @Description:  美国材料
	* @param @return    设定文件 
	* @return List<ProjectMaterial>    返回类型 
	* @throws
	 */
	public List<ProjectMaterial> findUsa();
	
	/**
	 * 
	* @Title: findMexico 
	* @Description: 墨西哥材料
	* @param @return    设定文件 
	* @return List<ProjectMaterial>    返回类型 
	* @throws
	 */
	public List<ProjectMaterial> findMexico();
	
	/**
	 * 
	* @Title: findIndia 
	* @Description: 印度材料
	* @param @return    设定文件 
	* @return List<ProjectMaterial>    返回类型 
	* @throws
	 */
	public List<ProjectMaterial> findIndia();
}
