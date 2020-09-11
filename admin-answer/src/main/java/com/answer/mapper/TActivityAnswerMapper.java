package com.answer.mapper;

import com.answer.domain.TActivityAnswer;

public interface TActivityAnswerMapper extends BaseMapper<TActivityAnswer>{
    int deleteByActivityID(Long activityID);

}