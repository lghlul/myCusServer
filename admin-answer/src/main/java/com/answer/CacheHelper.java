package com.answer;

import com.alibaba.fastjson.JSON;
import com.answer.domain.TJobnum;
import com.answer.domain.TOrganization;
import com.answer.domain.TUser;
import com.answer.mapper.TJobnumMapper;
import com.answer.mapper.TOrganizationMapper;
import com.answer.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

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
    private TJobnumMapper jobnumMapper;

    @Autowired
    private TOrganizationMapper organizationMapper;

    @Autowired
    private TUserMapper userMapper;

    public TUser getUser(String openID){
        TUser user = null;
        String userStr = valueOperations.get(openID);
        if(userStr == null){
            user = userMapper.selectByOpenID(openID);
            valueOperations.set(openID , JSON.toJSONString(user));
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
            valueOperations.set(orgID + "" , JSON.toJSONString(org));
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
            valueOperations.set(jobNum , JSON.toJSONString(jobnum));
        }else{
            jobnum = JSON.parseObject(jobnumStr , TJobnum.class);
        }
        return jobnum;
    }
}
