package com.answer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @CLassName PageController
 * @Description TODO
 * @Author ll
 * @Date 2018/12/15 17:47
 **/
@Controller
public class PageController {

    @RequestMapping("toPage")
    public String toPage(String page){
        return page;
    }

    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }
}
