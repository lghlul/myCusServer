package com.answer.controller;

import com.alibaba.fastjson.JSON;
import com.answer.domain.Result;
import com.answer.domain.Train;
import com.answer.domain.TrainQuestion;
import com.answer.service.ITrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @CLassName TrainController
 * @Description 考试控制器
 * @Author ll
 * @Date 2019/3/15 11:09
 **/
@RestController
@RequestMapping("/train")
public class TrainController {

    @Autowired
    ITrainService trainService;

    /*
     * @author ll
     * @Description 开始考试
     * @date 2019/3/15 11:19
     * @param [quesType]
     * @return java.lang.String
     */
    @PostMapping("createTrain")
    public String createTrain(Long typeID){
        Train train = new Train();
        train.setTypeID(typeID);
        Result result = trainService.createTrain(train);
        return JSON.toJSONString(result);
    }


    @PostMapping("finishTrain")
    public String finishTrain(String strList){
        List<TrainQuestion> list = JSON.parseArray(strList, TrainQuestion.class);
        Result result = trainService.finishTrain(list);
        return JSON.toJSONString(result);
    }
}
