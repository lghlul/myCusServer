package com.answer.service;

import com.answer.domain.TQuestion;
import com.answer.domain.query.QuestionQuery;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;


public interface ITQuestionService extends IBaseService<TQuestion>{
    PageInfo<TQuestion> list(QuestionQuery questionQuery);

    void insertQues(MultipartFile file, Long typeID);
}
