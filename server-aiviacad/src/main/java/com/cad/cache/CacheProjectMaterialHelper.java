package com.cad.cache;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.cad.domain.ProjectMaterial;
import com.cad.mapper.ProjectMaterialMapper;
import com.cad.utils.ConstantUtil;
import com.cad.utils.LogUtil;

/**
 * 
 * @author Lu
 * @Description: 工程材料缓存
 * @Package com.cad.cache
 * @date 2017年5月6日 下午9:47:37 
 * @version V1.0
 */
@Component
public class CacheProjectMaterialHelper{
	
	private static final String TAG = CacheProjectMaterialHelper.class.getName();
	
	@Resource(name="redisTemplate")
	private ValueOperations<String, String> redisCacheValue;
	
	@Resource(name="redisTemplate")
	private HashOperations<String, String,String> redisCacheHash;
	
	@Autowired
	private ProjectMaterialMapper projectMaterialMapper;
	
	/**
	 * 
	* @Title: getProjectMaterialList 
	* @Description: 按排序获取所有的工程材料
	* @param @return    设定文件 
	* @return List<ProjectMaterial>    返回类型 
	* @throws
	 */
	public List<List<ProjectMaterial>> getProjectMaterialList(){
		LogUtil.i(TAG, "getProjectMaterialList start...");
		List<List<ProjectMaterial>> result = new ArrayList<List<ProjectMaterial>>();
		result.add(JSON.parseArray(redisCacheValue.get(ConstantUtil.CacheKey.PROJECT_MATERIAL_CHINA_KEY), ProjectMaterial.class));
		result.add(JSON.parseArray(redisCacheValue.get(ConstantUtil.CacheKey.PROJECT_MATERIAL_GERMANY_KEY), ProjectMaterial.class));
		result.add(JSON.parseArray(redisCacheValue.get(ConstantUtil.CacheKey.PROJECT_MATERIAL_USA_KEY), ProjectMaterial.class));
		result.add(JSON.parseArray(redisCacheValue.get(ConstantUtil.CacheKey.PROJECT_MATERIAL_TURKEY_KEY), ProjectMaterial.class));
		result.add(JSON.parseArray(redisCacheValue.get(ConstantUtil.CacheKey.PROJECT_MATERIAL_MEXICO_KEY), ProjectMaterial.class));
		result.add(JSON.parseArray(redisCacheValue.get(ConstantUtil.CacheKey.PROJECT_MATERIAL_SPAIN_KEY), ProjectMaterial.class));
		result.add(JSON.parseArray(redisCacheValue.get(ConstantUtil.CacheKey.PROJECT_MATERIAL_INDIA_KEY), ProjectMaterial.class));
		LogUtil.i(TAG, "getDeviationList end...result = " + result);
		return result;
	}
	
	/**
	 * 
	* @Title: getPmValue 
	* @Description: 获取材料值
	* @param @param pm_id
	* @param @return    设定文件 
	* @return ProjectMaterial    返回类型 
	* @throws
	 */
	public ProjectMaterial getPmValue(int pm_id){
		 String str = redisCacheHash.get(ConstantUtil.CacheKey.PROJECT_MATERIAL_KEY, this.getPmKey(pm_id));
		 ProjectMaterial pm = JSON.parseObject(str, ProjectMaterial.class);
		
		if(pm == null){
			List<ProjectMaterial> projectMaterialValue = projectMaterialMapper.findProjectMaterialValue(pm_id);
			if(projectMaterialValue != null && projectMaterialValue.size() > 0)
				return projectMaterialValue.get(0);
		}else{
			return pm;
		}
		return null;
	}
	
	
	/**
	 * 
	* @Title: initProjectMaterial 
	* @Description: 工程材料缓存初始化
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void initProjectMaterial(){
		LogUtil.i(TAG, "initProjectMaterial start... ");
		//初始化所有工程材料
		List<ProjectMaterial> projectMaterialList = projectMaterialMapper.findProjectMaterial();
		if(projectMaterialList != null && projectMaterialList.size() > 0){
			for(ProjectMaterial pm : projectMaterialList){
				redisCacheHash.put(ConstantUtil.CacheKey.PROJECT_MATERIAL_KEY, this.getPmKey(pm.getPm_id()), JSON.toJSONString(pm));
			}
		}
		
		//初始化每个国家排序后的列表
		List<ProjectMaterial> china = projectMaterialMapper.findChina();
		this.sortPm(china, 1);
		redisCacheValue.set(ConstantUtil.CacheKey.PROJECT_MATERIAL_CHINA_KEY, JSON.toJSONString(china));
		List<ProjectMaterial> germany = projectMaterialMapper.findGermany();
		this.sortPm(germany, 2);
		redisCacheValue.set(ConstantUtil.CacheKey.PROJECT_MATERIAL_GERMANY_KEY, JSON.toJSONString(germany));
		List<ProjectMaterial> usa = projectMaterialMapper.findUsa();
		this.sortPm(usa, 3);
		redisCacheValue.set(ConstantUtil.CacheKey.PROJECT_MATERIAL_USA_KEY, JSON.toJSONString(usa));
		List<ProjectMaterial> turkey = projectMaterialMapper.findTurkey();
		this.sortPm(turkey, 4);
		redisCacheValue.set(ConstantUtil.CacheKey.PROJECT_MATERIAL_TURKEY_KEY, JSON.toJSONString(turkey));
		List<ProjectMaterial> mexico = projectMaterialMapper.findMexico();
		this.sortPm(mexico, 5);
		redisCacheValue.set(ConstantUtil.CacheKey.PROJECT_MATERIAL_MEXICO_KEY, JSON.toJSONString(mexico));
		List<ProjectMaterial> spain = projectMaterialMapper.findSpain();
		this.sortPm(spain, 6);
		redisCacheValue.set(ConstantUtil.CacheKey.PROJECT_MATERIAL_SPAIN_KEY, JSON.toJSONString(spain));
		List<ProjectMaterial> india = projectMaterialMapper.findIndia();
		this.sortPm(india, 7);
		redisCacheValue.set(ConstantUtil.CacheKey.PROJECT_MATERIAL_INDIA_KEY, JSON.toJSONString(india));
		LogUtil.i(TAG, "initProjectMaterial end...result = " + projectMaterialList);
	}
	
	/**
	 * 
	* @Title: getPmKey 
	* @Description: 获取field
	* @param @param pm_id
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String getPmKey(int pm_id){
		return "pm_" + pm_id;
	}
	
	/**
	 * 
	* @Title: sortPm 
	* @Description: 排序呢
	* @param @param list
	* @param @param type    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private void sortPm(List<ProjectMaterial> list,int type){
		List<ProjectMaterial> tempList = new ArrayList<ProjectMaterial>();
		if(list != null && list.size() > 0){
			String value = "----";
			for(ProjectMaterial pm : list){
				String pmValue = "";
				switch (type) {
				case 1:
					pmValue = pm.getChina();
					break;
				case 2:
					pmValue = pm.getGermany();
					break;
				case 3:
					pmValue = pm.getUsa();
					break;
				case 4:
					pmValue = pm.getTurkey();
					break;
				case 5:
					pmValue = pm.getMexico();
					break;
				case 6:
					pmValue = pm.getSpain();
					break;
				case 7:
					pmValue = pm.getIndia();
					break;
				default:
					break;
				}
				
				if(value.equals(pmValue)){
					tempList.add(pm);
				}
			}
		}
		list.removeAll(tempList);
		list.addAll(tempList);
	}
}
