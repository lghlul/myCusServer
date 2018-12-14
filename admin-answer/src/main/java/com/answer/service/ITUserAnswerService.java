package com.answer.service;

import com.answer.domain.AnswerDetailParam;
import com.answer.domain.OrgCount;
import com.answer.domain.TUserAnswer;

import java.util.List;
import java.util.Map;

public interface ITUserAnswerService extends IBaseService<TUserAnswer>{
    public List<OrgCount> indexOrgCount(Long startTime , Long endTime);

    public Map<String , Object> getAnswerDetailPage(AnswerDetailParam answerDetailParam);
}
