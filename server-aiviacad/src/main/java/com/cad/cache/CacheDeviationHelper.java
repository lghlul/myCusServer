package com.cad.cache;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;
import com.cad.domain.Deviation;
import com.cad.mapper.DeviationMapper;
import com.cad.utils.ConstantUtil;
import com.cad.utils.LogUtil;

/**
 * 
 * @author Lu
 * @Description: 公差查询缓存
 * @Package com.cad.cache
 * @date 2017年5月6日 下午9:46:11 
 * @version V1.0
 */
@Component
public class CacheDeviationHelper{
	
	private static final String TAG = CacheDeviationHelper.class.getName();
	
	@Resource(name="redisTemplate")
	private HashOperations<String, String, String> redisCache;
	
	@Autowired
	private DeviationMapper deviationMapper;
	
	/**
	 * 
	* @Title: getDeviationList 
	* @Description: 从缓存中获取公差查询列表
	* @param @param deviation
	* @param @return    设定文件 
	* @return List<Deviation>    返回类型 
	* @throws
	 */
	public List<Deviation> getDeviationList(Deviation deviation){
		LogUtil.i(TAG, "getDeviationList start...param = " + deviation);
		List<Deviation> deviationList = new ArrayList<Deviation>();
		String listStr = "";
		
		if(deviation.getIs_often().equals("1")){
			LogUtil.i(TAG, "redisCache.get start..." );
			listStr = redisCache.get(ConstantUtil.CacheKey.DEVIATION_LIST_KEY, ConstantUtil.CacheKey.DEVIATION_OFTEN);
			LogUtil.i(TAG, "redisCache.get end...result " + listStr);
		}else{
			LogUtil.i(TAG, "redisCache.get start..." );
			listStr = redisCache.get(ConstantUtil.CacheKey.DEVIATION_LIST_KEY, ConstantUtil.CacheKey.DEVIATION_ALL);
			LogUtil.i(TAG, "redisCache.get end...result " + listStr);
		}
		deviationList = JSON.parseArray(listStr, Deviation.class);
		
		if(deviationList == null || deviationList.size() == 0){
			LogUtil.i(TAG, "pressureMapper.findDeviation start...param = " + deviation);
			deviationList = deviationMapper.findDeviation(deviation);
			LogUtil.i(TAG, "pressureMapper.findDeviation end...result " + deviationList);
		}
		LogUtil.i(TAG, "getDeviationList end...result = " + deviationList);
		return deviationList;
	}
	
	/**
	 * 
	* @Title: initDeviation 
	* @Description: 公差查询缓存初始化
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void initDeviation(){
		LogUtil.i(TAG, "initDeviation start...");
		Deviation paramDeviation = new Deviation();
		
		LogUtil.i(TAG, "findDeviation start...param = " + paramDeviation);
		List<Deviation> deviation = deviationMapper.findDeviation(paramDeviation);
		LogUtil.i(TAG, "findDeviation start...result = " + deviation);
		redisCache.put(ConstantUtil.CacheKey.DEVIATION_LIST_KEY, ConstantUtil.CacheKey.DEVIATION_ALL, JSON.toJSONString(deviation));
		
		paramDeviation.setIs_often(1 + "");
		LogUtil.i(TAG, "findDeviation start...param = " + paramDeviation);
		List<Deviation> oftenDeviation = deviationMapper.findDeviation(paramDeviation);
		LogUtil.i(TAG, "findDeviation start...result = " + oftenDeviation);
		redisCache.put(ConstantUtil.CacheKey.DEVIATION_LIST_KEY, ConstantUtil.CacheKey.DEVIATION_OFTEN, JSON.toJSONString(oftenDeviation));
		
		LogUtil.i(TAG, "initDeviation end...");
	}
}
