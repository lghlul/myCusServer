package com.answer.service.impl;

import com.answer.domain.TQuestion;
import com.answer.domain.query.QuestionQuery;
import com.answer.mapper.TQuestionMapper;
import com.answer.service.ITQuestionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TQuestionServiceImpl extends BaseServiceImpl<TQuestion> implements ITQuestionService{

    @Autowired
    private TQuestionMapper questionMapper;

    @Override
    public PageInfo<TQuestion> list(QuestionQuery questionQuery) {
        PageHelper.startPage(questionQuery.getOffset(), questionQuery.getLimit());
        if (questionQuery.getSortField() != null) {
            PageHelper.orderBy(questionQuery.getSortField() + " " + questionQuery.getSortDir());
        }
        List<TQuestion> questionList = questionMapper.list(questionQuery);
        //得到分页的结果对象
        PageInfo<TQuestion> pageInfo = new PageInfo<>(questionList);
        return pageInfo;
    }
}
