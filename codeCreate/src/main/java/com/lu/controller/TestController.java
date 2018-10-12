package com.lu.controller;

import com.lu.service.ITrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @CLassName TestController
 * @Description TODO
 * @Author ll
 * @Date 2018/8/20 11:14
 **/
@RestController
public class TestController {

    @Autowired
    private ITrainService trainService;

    @ResponseBody
    @RequestMapping("/test")
    public Object test(String id){
        return trainService.selectByPrimaryKey(id);
    }

}
