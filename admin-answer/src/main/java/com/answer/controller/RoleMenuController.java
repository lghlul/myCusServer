package com.answer.controller;

import com.alibaba.fastjson.JSON;
import com.answer.common.ResultCodeEnum;
import com.answer.domain.TMenu;
import com.answer.domain.TRoleMenu;
import com.answer.service.ITMenuService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *
 * Title: MenuController
 * Description:   菜单控制器
 * @author ll
 * @date 2018年4月19日
 */
@RestController
@RequestMapping("/roleMenu")
public class RoleMenuController {

    private Logger logger = Logger.getLogger(RoleMenuController.class);
    @Autowired
    private ITMenuService menuService;

    @GetMapping("/list")
    public Object list(Long roleId) {
        logger.info("menuList start...roleId=" + roleId);
        List<TMenu> tMenus = menuService.listByRoleId(roleId);
        logger.info("menuList end...pages=" + JSON.toJSONString(tMenus));
        return ResultCodeEnum.SUCCESS.getResponse(tMenus);
    }


    @PostMapping("/update")
    public Object update(@RequestBody List<TRoleMenu> roleMenus) {
        menuService.updateRoleMenu(roleMenus);
        return ResultCodeEnum.SUCCESS.getResponse();
    }

}
