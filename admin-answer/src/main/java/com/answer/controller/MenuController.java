package com.answer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.answer.common.CommonConstant;
import com.answer.common.ResultCodeEnum;
import com.answer.domain.TRole;
import com.answer.service.ITMenuService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * Title: MenuController
 * Description:   菜单控制器
 * @author ll
 * @date 2018年4月19日
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    private Logger logger = Logger.getLogger(MenuController.class);
    @Autowired
    private ITMenuService menuService;


}
