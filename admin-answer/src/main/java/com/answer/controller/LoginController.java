package com.answer.controller;

import com.alibaba.fastjson.JSON;
import com.answer.common.CommonConstant;
import com.answer.common.ResultCodeEnum;
import com.answer.domain.TAdmin;
import com.answer.domain.TMenu;
import com.answer.domain.TRole;
import com.answer.service.ITAdminService;
import com.answer.service.ITMenuService;
import com.answer.service.ITRoleService;
import com.answer.utils.CommonUtil;
import com.answer.utils.MD5Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @CLassName LoginController
 * @Description TODO
 * @Author ll
 * @Date 2018/12/3 16:58
 **/
@RestController
public class LoginController {
    private Logger logger = Logger.getLogger(AdminController.class);

    @Autowired
    private ITAdminService adminService;


    @Autowired
    private ITRoleService roleService;


    @PostMapping("login")
    public Object login(HttpServletRequest request, TAdmin admin) throws Exception{
        logger.info("login start...admin=" + JSON.toJSONString(admin));

        TAdmin a = new TAdmin();
        a.setAdminName(admin.getAdminName());
        //校验管理员
        List<TAdmin> admins = adminService.query(a);
        if(admins.size() > 0){
            TAdmin tAdmin = admins.get(0);
            if(tAdmin.getAdminStatus().equals(CommonConstant.Common.DEL_STATUS)){
                return ResultCodeEnum.ADMIN_STATUS_FORBIDDEN.getResponse(tAdmin);
            }

            if(tAdmin.getAdminPwd().equals(MD5Util.md5Password(admin.getAdminPwd()))){

                TRole tRole = roleService.queryById(tAdmin.getRoleId() + "");
                if(tRole.getRoleStatus() == CommonConstant.Common.DEL_STATUS){
                    return ResultCodeEnum.ROLE_STATUS_FORBIDDEN.getResponse(tAdmin);
                }

                //查询出角色菜单
                //List<TMenu> menuList = menuService.queryAdminMenu(tAdmin.getRoleId());
                CommonUtil.setSession(request ,CommonConstant.Str.ADMIN ,admins.get(0));
                Map<String , Object> map = new HashMap<>();
                tAdmin.setAdminPwd(null);
                map.put("admin" , tAdmin);
                //map.put("menuList" , menuList);
                return ResultCodeEnum.SUCCESS.getResponse(tAdmin);
            }else{
                //密码不正确
                return ResultCodeEnum.PWD_ERROR.getResponse();
            }
        }else{
            //账号不存在
            return ResultCodeEnum.NAME_ERROR.getResponse();
        }
    }

    @PostMapping("logout")
    public Object exitLogin(HttpServletRequest request) throws Exception{
        logger.debug("exitLogin start...");
        CommonUtil.removeSession(request, CommonConstant.Str.ADMIN);
        logger.debug("exitLogin end...");
        return ResultCodeEnum.SUCCESS.getResponse();
    }
}
