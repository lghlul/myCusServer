package com.answer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.answer.common.CommonConstant;
import com.answer.common.ResultCodeEnum;
import com.answer.domain.TAdmin;
import com.answer.domain.TMenu;
import com.answer.domain.TRole;
import com.answer.service.ITMenuService;
import com.answer.service.ITRoleMenuService;
import com.answer.service.ITRoleService;
import com.answer.utils.CommonUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController  {

    private Logger logger = Logger.getLogger(RoleController.class);

    @Autowired
    private ITRoleService rolesService;
    @Autowired
    private ITMenuService menuService;


    @GetMapping("/list")
    public Object list(TRole role){
        logger.info("list start...role=" + JSON.toJSONString(role));
        CommonConstant.pageHandler(role);
        List<TRole> roles = rolesService.queryPage(role);
        int pageCount = rolesService.queryPageCount(role);
        int totalPage = pageCount % role.getLimit() == 0?pageCount / role.getLimit() : pageCount / role.getLimit() + 1;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("items", roles);
        jsonObject.put("totalPage", totalPage);
        jsonObject.put("pageCount", pageCount);
        logger.debug("list end...pages=" + jsonObject);
        return ResultCodeEnum.SUCCESS.getResponse(jsonObject);
    }

    @GetMapping("/menuList")
    public Object menuList(HttpServletRequest request){
        // todo 测试使用
        TAdmin admin = (TAdmin) CommonUtil.getSessionObj(request,
                CommonConstant.Str.ADMIN);
        logger.info("menuList start...role=" + JSON.toJSONString(admin));
        if(admin == null){
            admin = new TAdmin();
            admin.setRoleId(1l);
        }
        List<TMenu> tMenus = menuService.queryAdminMenu(admin.getRoleId());
        logger.debug("menuList end...pages=" + JSON.toJSONString(tMenus));
        return ResultCodeEnum.SUCCESS.getResponse(tMenus);
    }

    @PostMapping("/updateStatus")
    public Object updateStatus(TRole role){
        logger.info("updateStatus start...role=" + JSON.toJSONString(role));
        int i = rolesService.edit(role);
        logger.debug("updateStatus end...pages=" + i);
        return ResultCodeEnum.SUCCESS.getResponse();
    }
}
