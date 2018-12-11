package com.answer.controller;

import com.answer.service.ITMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * Title: MenuController
 * Description:   菜单控制器
 * @author ll
 * @date 2018年4月19日
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private ITMenuService menuService;

}
