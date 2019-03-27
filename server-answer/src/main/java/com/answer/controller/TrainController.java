package com.answer.controller;

import com.alibaba.fastjson.JSON;
import com.answer.cache.CacheHelper;
import com.answer.domain.Result;
import com.answer.domain.Train;
import com.answer.domain.TrainQuestion;
import com.answer.service.ITrainService;
import com.answer.utils.Log4jUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public String createTrain(Long typeID,String wxSession){
        Log4jUtil.info("createTrain start...typeID=" + typeID + ",wxSession=" + wxSession);
        Train train = new Train();
        train.setTypeID(typeID);
        train.setCreater(wxSession);
        Result result = trainService.createTrain(train);
        Log4jUtil.info("createTrain end...result=" + JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }


    @PostMapping("finishTrain")
    public String finishTrain(Long trainID , String strList){
        Log4jUtil.info("finishTrain start...trainID=" + trainID + ",strList=" + strList);
        List<TrainQuestion> list = JSON.parseArray(strList, TrainQuestion.class);
        Result result = trainService.finishTrain(trainID , list);
        Log4jUtil.info("finishTrain end...result=" + JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @GetMapping("trainList")
    public String trainList(String wxSession,Integer pageNo , Integer pageSize){
        Log4jUtil.info("trainList start...wxSession=" + wxSession + ",pageNo=" + pageNo + ",pageSize=" + pageSize);
        Result result = this.trainService.getTrainList(wxSession, pageNo, pageSize);
        Log4jUtil.info("trainList end...result=" + JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @GetMapping("trainDetail")
    public String trainDetail(String wxSession,Long trainID){
        Log4jUtil.info("trainDetail start...wxSession=" + wxSession + ",trainID=" + trainID);
        Result result = this.trainService.getTrainDetail( wxSession , trainID);
        Log4jUtil.info("trainDetail end...result=" + JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }
}
