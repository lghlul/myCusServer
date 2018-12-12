package com.answer.controller;

import com.answer.common.ResultCodeEnum;
import com.answer.domain.OrgCount;
import com.answer.service.ITUserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @CLassName AnswerController
 * @Description TODO
 * @Author ll
 * @Date 2018/12/12 20:56
 **/
@RestController
@RequestMapping("answer")
public class AnswerController {

    @Autowired
    private ITUserAnswerService userAnswerService;

    @GetMapping("orgCount")
    public String orgCount(Long startTime , Long endTime){
        List<OrgCount> orgCounts = userAnswerService.indexOrgCount(startTime, endTime);
        return ResultCodeEnum.SUCCESS.getResponse(orgCounts);
    }
}
