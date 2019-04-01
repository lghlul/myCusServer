package com.cad.cache;

import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @CLassName RedisHelper
 * @Description TODO
 * @Author ll
 * @Date 2019/3/4 11:08
 **/
@Component
public class RedisHelper {
    @Resource(name="redisTemplate")
    private ValueOperations<String , String> valueOperations;

    public void set(String key , String value , long time){
        valueOperations.set(key , value);
        valueOperations.getOperations().expire(key , time , TimeUnit.SECONDS);
    }

    public String get(String key){
        return valueOperations.get(key);
    }

    public void delete(String key){
        valueOperations.getOperations().delete(key);
    }
}
