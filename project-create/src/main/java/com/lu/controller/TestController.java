package com.lu.controller;

import com.lu.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @CLassName TestController
 * @Description TODO
 * @Author ll
 * @Date 2018/8/20 11:14
 **/
@Controller
public class TestController {

    @Autowired
    private IProjectService projectService;

    @ResponseBody
    @RequestMapping("/test")
    public Object test(String id){
        return projectService.selectByPrimaryKey(id);
    }

    @RequestMapping("/testPage")
    public String testPage(){
        return "/page/index.html";
    }

}
