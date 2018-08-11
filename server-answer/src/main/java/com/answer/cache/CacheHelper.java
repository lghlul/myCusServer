package com.answer.cache;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.answer.domain.Room;
import com.answer.domain.WXSessionCache;

@Component
public class CacheHelper {
	@Resource(name = "redisTemplate")
	private ValueOperations<String, String> redisCacheValue;
	@Resource(name = "redisTemplate")
	public RedisTemplate<String, String> template;
	/*******************************用户session******************************************/
	public void setSession(WXSessionCache wx) {
		this.redisCacheValue.set(wx.getWxSession(), JSON.toJSONString(wx));
		//30天session失效
		this.template.expire(wx.getWxSession(), 30, TimeUnit.DAYS);
		//测试1天失效
		//this.template.expire(wx.getWxSession(), 1, TimeUnit.DAYS);
	}

	public WXSessionCache getSession(String wxSession) {
		WXSessionCache session = new WXSessionCache();
		String str = this.redisCacheValue.get(wxSession);
		if (str != null) {
			session = JSON.parseObject(str, WXSessionCache.class);
		}
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
}
