package com.answer.controller;
import com.answer.common.CommonConstant;
import com.answer.common.PageResult;
import com.answer.common.ResultCodeEnum;
import com.answer.domain.Activity;
import com.answer.domain.TAdmin;
import com.answer.domain.query.ActivityQuery;
import com.answer.domain.query.AdminQuery;
import com.answer.service.ITAdminService;
import com.answer.utils.CommonUtil;
import com.answer.utils.MD5Util;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * 账号管理
 * 
 * @author chenyagang
 * 
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ITAdminService adminService;

    @PostMapping("save")
    public Object save(TAdmin admin , HttpServletRequest request) {
        AdminQuery adminQuery = new AdminQuery();
        adminQuery.setAdminName(admin.getAdminName());
        PageInfo<TAdmin> list = adminService.list(adminQuery);
        if(list.getList() != null && list.getSize() > 0){
            return ResultCodeEnum.ADMIN_NAME_REPEAT.getResponse();
        }
        TAdmin currentAdmin = (TAdmin) CommonUtil.getSessionObj(request,
                CommonConstant.Str.ADMIN);
        if(currentAdmin != null){
            admin.setCreater(currentAdmin.getAdminId());
        }

        admin.setAdminPwd(MD5Util.md5Password(admin.getAdminPwd()));
        admin.setCreateTime(System.currentTimeMillis());
        adminService.add(admin);
        return ResultCodeEnum.SUCCESS.getResponse();
    }


    @GetMapping("list")
    public Object list(AdminQuery adminQuery) {
        PageInfo<TAdmin> page = adminService.list(adminQuery);
        PageResult pageResult = new PageResult();
        pageResult.setTotalCount(page.getTotal());
        pageResult.setTotalPage(page.getPages());
        pageResult.setList(page.getList());
        return ResultCodeEnum.SUCCESS.getResponse(pageResult);
    }


    @PostMapping("update")
    public Object update(TAdmin admin , HttpServletRequest request) {
        AdminQuery adminQuery = new AdminQuery();
        if(StringUtils.isNotEmpty(admin.getAdminName())){
            adminQuery.setAdminName(admin.getAdminName());
            PageInfo<TAdmin> list = adminService.list(adminQuery);
            if(list.getList() != null && list.getSize() > 0 ){
                if(list.getList().get(0).getAdminId() != admin.getAdminId()){
                    return ResultCodeEnum.ADMIN_NAME_REPEAT.getResponse();
                }
            }
        }

        if(StringUtils.isNotEmpty(admin.getAdminPwd())){
            admin.setAdminPwd(MD5Util.md5Password(admin.getAdminPwd()));
        }
        adminService.edit(admin);
        admin.setCreateTime(System.currentTimeMillis());
        return ResultCodeEnum.SUCCESS.getResponse();
    }

}
