package com.answer.service;

import com.answer.domain.TAnswer;

import java.util.List;

public interface ITAnswerService extends IBaseService<TAnswer>{
    List<TAnswer> listByQuesID(Long quesID);
}
