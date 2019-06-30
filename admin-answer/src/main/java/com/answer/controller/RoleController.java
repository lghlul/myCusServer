package com.answer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.answer.common.CommonConstant;
import com.answer.common.PageResult;
import com.answer.common.ResultCodeEnum;
import com.answer.domain.TAdmin;
import com.answer.domain.TMenu;
import com.answer.domain.TRole;
import com.answer.domain.query.RoleQuery;
import com.answer.service.ITMenuService;
import com.answer.service.ITRoleService;
import com.answer.utils.CommonUtil;
import com.answer.utils.MD5Util;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController  {

    private Logger logger = Logger.getLogger(RoleController.class);

    @Autowired
    private ITRoleService roleService;
    @Autowired
    private ITMenuService menuService;


    @GetMapping("/list")
    public Object list(RoleQuery roleQuery){
        logger.info("list start...role=" + JSON.toJSONString(roleQuery));
        PageInfo<TRole> page = roleService.list(roleQuery);
        PageResult pageResult = new PageResult();
        pageResult.setTotalCount(page.getTotal());
        pageResult.setTotalPage(page.getPages());
        pageResult.setList(page.getList());
        logger.info("list end...pages=" + pageResult);
        return ResultCodeEnum.SUCCESS.getResponse(pageResult);
    }

    @GetMapping("/menuList")
    public Object menuList(HttpServletRequest request){
        TAdmin admin = (TAdmin) CommonUtil.getSessionObj(request,
                CommonConstant.Str.ADMIN);
        logger.info("menuList start...role=" + JSON.toJSONString(admin));
    /*    if(admin == null){
            admin = new TAdmin();
            admin.setRoleId(1l);
        }*/
        List<TMenu> tMenus = menuService.queryAdminMenu(admin.getRoleId());
        logger.debug("menuList end...pages=" + JSON.toJSONString(tMenus));
        return ResultCodeEnum.SUCCESS.getResponse(tMenus);
    }

    @PostMapping("/update")
    public Object update(@RequestBody  TRole role){
        logger.info("updateStatus start...role=" + JSON.toJSONString(role));
        int i = 0;
        if(role.getRoleId() > 0){
            i = roleService.edit(role);
        }
        logger.debug("updateStatus end...pages=" + i);
        return ResultCodeEnum.SUCCESS.getResponse();
    }

    @PostMapping("/save")
    public Object save(@RequestBody TRole role , HttpServletRequest request){
        logger.info("updateStatus start...role=" + JSON.toJSONString(role));
        TRole tRole = roleService.readByName(role.getRoleName());
        if(tRole != null){
            return ResultCodeEnum.ROLE_NAME_REPEAT.getResponse();
        }
        TAdmin currentAdmin = (TAdmin) CommonUtil.getSessionObj(request,
                CommonConstant.Str.ADMIN);
        if(currentAdmin != null){
            role.setCreater(currentAdmin.getAdminId());
        }

        role.setCreateTime(System.currentTimeMillis());
        int i = roleService.add(role);
        logger.debug("updateStatus end...pages=" + i);
        return ResultCodeEnum.SUCCESS.getResponse();
    }
}
