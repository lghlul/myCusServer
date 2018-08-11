package com.cad.cache;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import com.cad.utils.ConstantUtil;
import com.cad.utils.LogUtil;


/**
 * 
 * @author Lu
 * @Description: 缓存初始化
 * @Package com.cad.cache
 * @date 2017年5月6日 下午9:45:22 
 * @version V1.0
 */
@Component
public class CacheInit {
	
	private static final String TAG = CacheInit.class.getName();
	
	 @Autowired
	 private CacheDeviationHelper cacheDeviationHelper;
	 
	 @Autowired
	 private CachePressureHelper cachePressureHelper;
	 
	 @Autowired
	 private CacheProjectMaterialHelper cacheProjectMaterialHelper;
	
	@Resource(name="redisTemplate")
	public RedisTemplate<String, String> template;
	
	/**
	 * 
	* @Title: initCache 
	* @Description: 缓存预热
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void initCache(){
		LogUtil.i(TAG, "initCache start...");
		cacheDeviationHelper.initDeviation();
		cachePressureHelper.initPressure();
		cacheProjectMaterialHelper.initProjectMaterial();
		LogUtil.i(TAG, "initCache end...");
	}
	
	/**
	 * 
	* @Title: cleanCache 
	* @Description: 缓存清理
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void cleanCache(){
		LogUtil.i(TAG, "cleanCache start...");
		template.delete(ConstantUtil.CacheKey.DEVIATION_LIST_KEY);
		template.delete(ConstantUtil.CacheKey.PRESSURE_LIST_KEY);
		template.delete(ConstantUtil.CacheKey.PRESSURE_VALUE_KEY);
		template.delete(ConstantUtil.CacheKey.PROJECT_MATERIAL_KEY);
		LogUtil.i(TAG, "cleanCache end...");
	}
	
	
	
	
}
