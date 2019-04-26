package com.answer.controller;

import com.answer.common.PageResult;
import com.answer.common.ResultCodeEnum;
import com.answer.domain.Activity;
import com.answer.domain.TAnswer;
import com.answer.domain.TQuestion;
import com.answer.domain.query.QuestionQuery;
import com.answer.service.ITAnswerService;
import com.answer.service.ITQuestionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/4/3 11:36
 * @Modified By：
 */
@RestController
@RequestMapping("/question")
public class QuestionController {


    @Autowired
    private ITQuestionService questionService;

    @Autowired
    private ITAnswerService answerService;

    @GetMapping("list")
    public Object list(QuestionQuery questionQuery) {
        PageInfo<TQuestion> page = questionService.list(questionQuery);
        PageResult pageResult = new PageResult();
        pageResult.setTotalCount(page.getTotal());
        pageResult.setTotalPage(page.getPages());
        pageResult.setList(page.getList());
        return ResultCodeEnum.SUCCESS.getResponse(pageResult);
    }



    @GetMapping("listAnswer")
    public Object listAnswer(Long quesID) {
        List<TAnswer> tAnswers = answerService.listByQuesID(quesID);
        return ResultCodeEnum.SUCCESS.getResponse(tAnswers);
    }


}
