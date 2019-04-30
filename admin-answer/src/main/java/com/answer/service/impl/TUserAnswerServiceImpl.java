package com.answer.service.impl;

import com.answer.domain.AnswerDetailParam;
import com.answer.domain.OrgCount;
import com.answer.domain.TUserAnswer;
import com.answer.mapper.TUserAnswerMapper;
import com.answer.service.ITUserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Transactional
@Service
public class TUserAnswerServiceImpl extends BaseServiceImpl<TUserAnswer> implements ITUserAnswerService{

    @Autowired
    private TUserAnswerMapper userAnswerMapper;

    public List<OrgCount> indexOrgCount(Long startTime , Long endTime){

        /*if(startTime == null || endTime == null){
             endTime = System.currentTimeMillis();
             startTime = endTime/(1000*3600*24)*(1000*3600*24) - TimeZone.getDefault().getRawOffset();
        }*/

        Map<String , Object> map = new HashMap<>();
        map.put("startTime" , startTime);
        map.put("endTime" , endTime);
        List<OrgCount> orgCounts = userAnswerMapper.selectOrgCount(map);
        map.put("isRight" , 1);
        List<OrgCount> rightCounts = userAnswerMapper.selectOrgCount(map);
        Map<Long , OrgCount> rightMap = new HashMap<>();
        if(rightCounts != null){
            for(OrgCount oc : rightCounts){
                rightMap.put(oc.getOrgID() , oc);
            }
        }
        if(orgCounts != null){
            for(OrgCount oc : orgCounts){
                if( oc.getCountNum() == 0){
                    oc.setRightPercent("0.00%");
                }else{
                    double countNum = oc.getCountNum();
                    oc.setRightNum( rightMap.get(oc.getOrgID()) == null ? 0 :  rightMap.get(oc.getOrgID()).getRightNum());
                    double rightNum = oc.getRightNum();
                    DecimalFormat df = new DecimalFormat("######0.00");
                    String  percent = df.format(rightNum/countNum * 100) + "%";
                    oc.setRightPercent(percent);
                }
            }
        }
        return orgCounts;
    }


    @Override
    public Map<String, Object> getAnswerDetailPage(AnswerDetailParam answerDetailParam) {
        List<TUserAnswer> users = userAnswerMapper.answerDetailPage(answerDetailParam);
        int pageCount = userAnswerMapper.answerDetailCount(answerDetailParam);
        int totalPage = pageCount % answerDetailParam.getLimit() == 0?pageCount / answerDetailParam.getLimit() : pageCount / answerDetailParam.getLimit() + 1;
        Map<String, Object> map = new HashMap<>();
        map.put("items", users);
        map.put("totalPage", totalPage);
        map.put("pageCount", pageCount);
        return map;
    }
}
