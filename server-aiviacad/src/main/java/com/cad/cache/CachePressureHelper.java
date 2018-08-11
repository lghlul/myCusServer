package com.cad.cache;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.cad.domain.Pressure;
import com.cad.mapper.PressureMapper;
import com.cad.utils.ConstantUtil;
import com.cad.utils.LogUtil;

/**
 * 
 * @author Lu
 * @Description: 气缸压力缓存
 * @Package com.cad.cache
 * @date 2017年5月6日 下午9:47:18 
 * @version V1.0
 */
@Component
public class CachePressureHelper{
	
	private static final String TAG = CachePressureHelper.class.getName();
	
	@Resource(name="redisTemplate")
	private HashOperations<String, String, String> redisCache;
	
	@Autowired
	private PressureMapper pressureMapper;
	
	/**
	 * 
	* @Title: getPressureValue 
	* @Description: 从缓存中获取伸缩压力
	* @param @param pressure
	* @param @return    设定文件 
	* @return List<Pressure>    返回类型 
	* @throws
	 */
	public List<Pressure> getPressureValue(Pressure pressure){
		LogUtil.i(TAG, "getPressureValue start...param = " + pressure);
		List<Pressure> valueList = new ArrayList<Pressure>();
		pressure.setDirection_type(1);
		LogUtil.i(TAG, "redisCache.get start...param = " + pressure);
		String value_one = redisCache.get(ConstantUtil.CacheKey.PRESSURE_VALUE_KEY, this.getPressureValueKey(pressure));
		LogUtil.i(TAG, "redisCache.get end...result " + value_one);
		pressure.setDirection_type(2);
		LogUtil.i(TAG, "redisCache.get start...param = " + pressure);
		String value_two = redisCache.get(ConstantUtil.CacheKey.PRESSURE_VALUE_KEY, this.getPressureValueKey(pressure));
		LogUtil.i(TAG, "redisCache.get end...result " + value_two);
		valueList.add(JSON.parseObject(value_one, Pressure.class));
		valueList.add(JSON.parseObject(value_two, Pressure.class));
		
		if(valueList == null || valueList.size() == 0){
			LogUtil.i(TAG, "pressureMapper.findValue start...param " + pressure);
			valueList = pressureMapper.findValue(pressure);
			LogUtil.i(TAG, "pressureMapper.findValue end...result " + valueList);
		}
		LogUtil.i(TAG, "getPressureValue end...result = " + valueList);
		return valueList;
	}
	
	/**
	 * 
	* @Title: getBoreSize 
	* @Description: 从缓存中获取缸径
	* @param @return    设定文件 
	* @return List<Pressure>    返回类型 
	* @throws
	 */
	public List<Pressure> getBoreSize(){
		LogUtil.i(TAG, "getPressureValue start...");
		List<Pressure> boreList = new ArrayList<Pressure>();
		LogUtil.i(TAG, "redisCache.get start..." );
		String boreStr = redisCache.get(ConstantUtil.CacheKey.PRESSURE_LIST_KEY, ConstantUtil.CacheKey.BORE_SIZE);
		LogUtil.i(TAG, "redisCache.get end...result " + boreStr);
		boreList = JSON.parseArray(boreStr, Pressure.class);
		if(boreList == null || boreList.size() == 0){
			LogUtil.i(TAG, "pressureMapper.findBoreSize start...");
			boreList = pressureMapper.findBoreSize();
			LogUtil.i(TAG, "pressureMapper.findBoreSize end...result " + boreList);
		}
		
		LogUtil.i(TAG, "getPressureValue end...result = " + boreList);
		return boreList;
	}
	
	/**
	 * 
	* @Title: getPressureSize 
	* @Description: 从缓存中获取压力值
	* @param @return    设定文件 
	* @return List<Pressure>    返回类型 
	* @throws
	 */
	public List<Pressure> getPressureSize(){
		LogUtil.i(TAG, "getPressureValue start...");
		List<Pressure> sizeList = new ArrayList<Pressure>();
		LogUtil.i(TAG, "redisCache.get start..." );
		String sizeStr = redisCache.get(ConstantUtil.CacheKey.PRESSURE_LIST_KEY, ConstantUtil.CacheKey.PRESSURE_SIZE);
		LogUtil.i(TAG, "redisCache.get end...result " + sizeList);
		sizeList = JSON.parseArray(sizeStr, Pressure.class);
		
		if(sizeList == null || sizeList.size() == 0){
			LogUtil.i(TAG, "pressureMapper.findPressureSize start...");
			sizeList = pressureMapper.findPressureSize();
			LogUtil.i(TAG, "pressureMapper.findPressureSize end...result " + sizeList);
		}
		
		LogUtil.i(TAG, "getPressureValue end...result = " + sizeList);
		return sizeList;
	}
	
	/**
	 * 
	* @Title: getPressureValueKey 
	* @Description: 获取缓存field
	* @param @param pressure
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	private String getPressureValueKey(Pressure pressure){
		return pressure.getBore_size() + "_" + pressure.getPressure_size() + "_" + pressure.getDirection_type();
	}
	
	/**
	 * 
	* @Title: initPressure 
	* @Description: 初始化气缸压力
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void initPressure(){
		LogUtil.i(TAG, "initPressure start...");
		
		LogUtil.i(TAG, "findDeviation start... ");
		List<Pressure> boreList = pressureMapper.findBoreSize();
		LogUtil.i(TAG, "findDeviation end...result = " + boreList);
		redisCache.put(ConstantUtil.CacheKey.PRESSURE_LIST_KEY, ConstantUtil.CacheKey.BORE_SIZE, JSON.toJSONString(boreList));
		LogUtil.i(TAG, "findDeviation start...");
		List<Pressure> sizeList = pressureMapper.findPressureSize();
		LogUtil.i(TAG, "findDeviation end... result = " + sizeList);
		redisCache.put(ConstantUtil.CacheKey.PRESSURE_LIST_KEY, ConstantUtil.CacheKey.PRESSURE_SIZE, JSON.toJSONString(sizeList));
		LogUtil.i(TAG, "findAllValue start...");
		List<Pressure> pressureList = pressureMapper.findAllValue();
		LogUtil.i(TAG, "findAllValue end...result = " + pressureList);
		String pressureKey = "";
		for (Pressure p : pressureList) {
			pressureKey = this.getPressureValueKey(p);
			redisCache.put(ConstantUtil.CacheKey.PRESSURE_VALUE_KEY, pressureKey, JSON.toJSONString(p));
		}
		LogUtil.i(TAG, "initPressure end...");
	}
	
	


}
