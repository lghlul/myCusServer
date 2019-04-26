package com.answer.service.impl;

import com.answer.CacheHelper;
import com.answer.domain.OrgCount;
import com.answer.domain.OrgReport;
import com.answer.domain.TOrganization;
import com.answer.domain.TUser;
import com.answer.domain.query.UserQuery;
import com.answer.mapper.TUserMapper;
import com.answer.service.ITUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

@Service
public class TUserServiceImpl extends BaseServiceImpl<TUser> implements ITUserService{

    @Autowired
    private TUserMapper userMapper;

    @Autowired
    private CacheHelper cacheHelper;

    @Override
    public List<TUser> answerCount(Map<String , Object> map) {

        List<TUser> counts = userMapper.selectAnswerCount(map);
        map.put("isRight" , 1);
        List<TUser> rightCounts = userMapper.selectAnswerCount(map);
        Map<Long , TUser> rightMap = new HashMap<>();
        if(rightCounts != null){
            for(TUser u : rightCounts){
                rightMap.put(u.getUserID() , u);
            }
        }
        if(counts != null){
            for(TUser u : counts){
                if( u.getCountNum() == 0){
                    u.setRightPercent("0.00%");
                }else{
                    double countNum = u.getCountNum();
                    u.setRightNum( rightMap.get(u.getUserID()) == null ? 0 :  rightMap.get(u.getUserID()).getRightNum());
                    double rightNum = u.getRightNum();
                    DecimalFormat df = new DecimalFormat("######0.00");
                    String  percent = df.format(rightNum/countNum * 100) + "%";
                    u.setRightPercent(percent);
                }
            }
        }
        return counts;
    }


    @Override
    public PageInfo<TUser> listReport(UserQuery userQuery) {
        PageHelper.startPage(userQuery.getOffset(), userQuery.getLimit());
        if (userQuery.getSortField() != null) {
            PageHelper.orderBy(userQuery.getSortField() + " " + userQuery.getSortDir());
        }
        List<TUser> users = this.userMapper.list(userQuery );
        List<TUser> answerCounts = this.userMapper.listAnswerCount(users , userQuery.getStartTime() , userQuery.getEndTime());
        Map<String , TUser> userMap = new HashMap<>();
        if(answerCounts != null){
            for(TUser user : answerCounts){
                userMap.put(user.getOpenID() , user);
            }
        }
        PageInfo<TUser> pageInfo = new PageInfo<>(users);
        if (pageInfo.getList() != null) {
            for(TUser user : pageInfo.getList()){

                TOrganization org = cacheHelper.getOrg(user.getOrgID());
                if(org != null){
                    user.setOrgName(org.getOrgName());
                }
                TUser u = userMap.get(user.getOpenID());
                if(u != null){
                    user.setRightNum(u.getRightNum());
                    user.setCountNum(u.getCountNum());
                }

                if( user.getCountNum() == 0){
                    user.setRightPercent("0.00%");
                }else{
                    double countNum = user.getCountNum();
                    double rightNum = user.getRightNum();
                    DecimalFormat df = new DecimalFormat("######0.00");
                    String  percent = df.format(rightNum/countNum * 100) + "%";
                    user.setRightPercent(percent);
                }

            }
        }
        return pageInfo;
    }
}
