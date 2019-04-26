package com.answer.mapper;

import com.answer.domain.TAnswer;

import java.util.List;

public interface TAnswerMapper extends BaseMapper<TAnswer>{

    List<TAnswer> listByAnsID(Long quesID);

}