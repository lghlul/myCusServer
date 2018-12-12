package com.answer.service;

import com.answer.domain.OrgCount;
import com.answer.domain.TUserAnswer;

import java.util.List;

public interface ITUserAnswerService extends IBaseService<TUserAnswer>{
    public List<OrgCount> indexOrgCount(Long startTime , Long endTime);
}
