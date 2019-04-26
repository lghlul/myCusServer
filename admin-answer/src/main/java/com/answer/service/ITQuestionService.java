package com.answer.service;

import com.answer.domain.TQuestion;
import com.answer.domain.query.QuestionQuery;
import com.github.pagehelper.PageInfo;


public interface ITQuestionService extends IBaseService<TQuestion>{
    PageInfo<TQuestion> list(QuestionQuery questionQuery);
}
