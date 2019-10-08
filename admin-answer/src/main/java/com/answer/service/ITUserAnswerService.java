package com.answer.service;

import com.answer.domain.AnswerDetailParam;
import com.answer.domain.OrgCount;
import com.answer.domain.TUserAnswer;

import java.util.List;
import java.util.Map;

public interface ITUserAnswerService extends IBaseService<TUserAnswer>{
    List<OrgCount> indexOrgCount(Long startTime , Long endTime);

    Map<String , Object> getAnswerDetailPage(AnswerDetailParam answerDetailParam);

    int deleteByOpenIdAndTypeId(String openID , Long typeID);
}
