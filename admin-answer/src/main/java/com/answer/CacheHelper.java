package com.answer;

import com.alibaba.fastjson.JSON;
import com.answer.domain.Config;
import com.answer.domain.TJobnum;
import com.answer.domain.TOrganization;
import com.answer.domain.TUser;
import com.answer.mapper.TConfigMapper;
import com.answer.mapper.TJobnumMapper;
import com.answer.mapper.TOrganizationMapper;
import com.answer.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/4/21 14:10
 * @Modified By：
 */
@Component
public class CacheHelper {

    @Autowired
    private ValueOperations<String, String> valueOperations;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private TJobnumMapper jobnumMapper;

    @Autowired
    private TOrganizationMapper organizationMapper;

    @Autowired
    private TUserMapper userMapper;

    @Autowired
    private TConfigMapper configMapper;

    private final Integer EXPIRE_TIME = 10;


    public void delete(String key){
        redisTemplate.delete(key);
    }

    public TUser getUser(String openID){
        TUser user = null;
        String userStr = valueOperations.get(openID);
        if(userStr == null){
            user = userMapper.selectByOpenID(openID);
            valueOperations.set(openID , JSON.toJSONString(user) , EXPIRE_TIME  , TimeUnit.DAYS);
        }else{
            user = JSON.parseObject(userStr , TUser.class);
        }
        return user;
    }

    public TOrganization getOrg(Long orgID){
        TOrganization org = null;
        String orgStr = valueOperations.get(orgID + "");
        if(orgStr == null){
            org = organizationMapper.selectById(orgID + "");
            valueOperations.set(orgID + "" , JSON.toJSONString(org) , EXPIRE_TIME  , TimeUnit.DAYS);
        }else{
            org = JSON.parseObject(orgStr , TOrganization.class);
        }
        return org;
    }

    public TJobnum getJobNum(String jobNum){
        TJobnum jobnum = null;
        String jobnumStr = valueOperations.get(jobNum);
        if(jobnumStr == null){
            jobnum = jobnumMapper.selectByJobNum(jobNum);
            valueOperations.set(jobNum , JSON.toJSONString(jobnum) , EXPIRE_TIME  , TimeUnit.DAYS);
        }else{
            jobnum = JSON.parseObject(jobnumStr , TJobnum.class);
        }
        return jobnum;
    }


    public Config getConfig(String key){
        Config config = null;
        String configStr = valueOperations.get(key);
        if(configStr == null){
            config = configMapper.readByKey(key);
            valueOperations.set(key , JSON.toJSONString(config) , EXPIRE_TIME , TimeUnit.DAYS);
        }else{
            config = JSON.parseObject(configStr , Config.class);
        }
        return config;
    }
}
