package com.answer.mapper;

import com.answer.domain.TQuestion;
import com.answer.domain.query.QuestionQuery;

import java.util.List;

public interface TQuestionMapper extends BaseMapper<TQuestion>{
    List<TQuestion> list(QuestionQuery questionQuery);
}