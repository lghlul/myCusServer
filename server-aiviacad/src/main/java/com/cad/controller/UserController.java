package com.cad.controller;

import com.alibaba.fastjson.JSON;
import com.cad.Constant.ResultCode;
import com.cad.domain.Result;
import com.cad.domain.User;
import com.cad.service.IUserService;
import org.aspectj.apache.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping("/register")
    public String register(User user){
        this.userService.register(user);
        return null;
    }


    @RequestMapping("/checkAccount")
    public String checkAccount(String userAccount){
        int count = this.userService.queryAccountCount(userAccount);
        Result result = new Result();
        if(count > 0){
            result.setCode(ResultCode.SUCCESS);
        }else{
            result.setCode(ResultCode.ACCOUNT_REPEAT);
        }
        return JSON.toJSONString(result);
    }
}
