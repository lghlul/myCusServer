package com.answer.cache;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import com.answer.domain.*;
import com.answer.mapper.ConfigMapper;
import com.answer.mapper.JobNumMapper;
import com.answer.mapper.OrganizationMapper;
import com.answer.mapper.UserMapper;
import com.answer.websocket.WebSocketServer;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@Component
public class CacheHelper {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CacheHelper.class);
	@Autowired
	private ValueOperations<String, String> redisCacheValue;

	@Autowired
	public RedisTemplate<String, String> template;


	@Autowired
	private ConfigMapper configMapper;

	private final Integer EXPIRE_TIME = 10;

	private final Integer SESSION_EXPIRE_TIME = 10;


	public void delete(String key){
		template.delete(key);
	}
	/*******************************用户session******************************************/
	public void setSession(WXSessionCache wx) {
		this.redisCacheValue.set(wx.getWxSession(), JSON.toJSONString(wx));
		//30天session失效
		this.template.expire(wx.getWxSession(), SESSION_EXPIRE_TIME, TimeUnit.DAYS);
		//测试1天失效
		//this.template.expire(wx.getWxSession(), 1, TimeUnit.DAYS);
	}

	public WXSessionCache getSession(String wxSession) {
		WXSessionCache session = new WXSessionCache();
		String str = this.redisCacheValue.get(wxSession);
		if (str != null) {
			session = JSON.parseObject(str, WXSessionCache.class);
		}
        logger.info("getSession wxSession=" + wxSession + ",session=" + JSON.toJSONString(session));
		return session;
	}
	
	/***************************************对战答题房间***********************************************/
	public void setRoom(Room room){
		this.redisCacheValue.set(this.getRoomKey(room.getRoomID()), JSON.toJSONString(room));
		//房间30分钟后失效
		this.template.expire(this.getRoomKey(room.getRoomID()), 30, TimeUnit.MINUTES);
	}
	
	private String getRoomKey(long roomID){
		return "room_" + roomID;
	}
	
	public Room getRoom(long roomID) {
		String str = this.redisCacheValue.get(this.getRoomKey(roomID));
		if (str != null) {
			Room room = JSON.parseObject(str, Room.class);
			return room;
		}
		return null;
	}


	/******************************组织  用户   工号*****************************************/
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private JobNumMapper jobNumMapper;

	@Autowired
	private OrganizationMapper organizationMapper;

	public User getUser(String openID){
		User user = null;
		String userStr = redisCacheValue.get(openID);
		if(userStr == null){
			user = userMapper.queryUserByOpenID(openID);
			redisCacheValue.set(openID , JSON.toJSONString(user) , EXPIRE_TIME, TimeUnit.DAYS);
		}else{
			user = JSON.parseObject(userStr , User.class);
		}
		return user;
	}

	public Organization getOrg(Long orgID){
		Organization org = null;
		String orgStr = redisCacheValue.get(orgID + "");
		if(orgStr == null){
			org = organizationMapper.read(orgID + "");
			redisCacheValue.set(orgID + "" , JSON.toJSONString(org) , EXPIRE_TIME, TimeUnit.DAYS);
		}else{
			org = JSON.parseObject(orgStr , Organization.class);
		}
		return org;
	}

	public JobNumBean getJobNum(String jobNum){
		JobNumBean jobnum = null;
		String jobnumStr = redisCacheValue.get(jobNum);
		if(jobnumStr == null){
			jobnum = jobNumMapper.queryJobNumByID(jobNum);
			redisCacheValue.set(jobNum , JSON.toJSONString(jobnum) , EXPIRE_TIME, TimeUnit.DAYS);
		}else{
			jobnum = JSON.parseObject(jobnumStr , JobNumBean.class);
		}
		return jobnum;
	}



	public Config getConfig(String key){
		Config config = null;
		String configStr = redisCacheValue.get(key);
		if(configStr == null){
			config = configMapper.readByKey(key);
			redisCacheValue.set(key , JSON.toJSONString(config) , EXPIRE_TIME , TimeUnit.DAYS);
		}else{
			config = JSON.parseObject(configStr , Config.class);
		}
		return config;
	}


	/************************对战答题************************/
	public void set(String key , String value){
		redisCacheValue.set(key , value);

	}

	public String get(String key){
		return redisCacheValue.get(key);
	}

	public void expire(String key , long timeout, TimeUnit unit){
		template.expire(key , timeout , unit);
	}
}
