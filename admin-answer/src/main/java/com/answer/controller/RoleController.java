package com.answer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.answer.common.Forward;
import com.answer.common.ResultCodeEnum;
import com.answer.common.StrConstant;
import com.answer.domain.TRole;
import com.answer.service.ITRoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController  {

    private Logger logger = Logger.getLogger(RoleController.class);

    @Autowired
    private ITRoleService rolesService;

    @RequestMapping(value = "/listPage")
    public String roleList( ModelMap map){
        logger.info("listPage start...");
        map.put(StrConstant.PAGE, Forward.AjaxPage.ROLE_LIST_PAGE);
        logger.info("listPage end...");
        return Forward.ActionPage.PUBLIC;
    }

    @ResponseBody
    @RequestMapping(value = "/listData")
    public Object roleTable(Integer iDisplayStart, Integer iDisplayLength, Integer sEcho, TRole role) throws Exception{
        logger.info("listData start...role=" + JSON.toJSONString(role));
        role.setOffSet(iDisplayStart);
        role.setLimit(iDisplayLength);
        List<TRole> roles = rolesService.queryPage(role);
        int pageCount = rolesService.queryPageCount(role);
        int totalPage = pageCount % iDisplayLength == 0?pageCount / iDisplayLength : pageCount / iDisplayLength + 1;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("aaData", roles);
        jsonObject.put("sEcho", sEcho);
        jsonObject.put("iDisplayStart", iDisplayStart);
        jsonObject.put("iDisplayLength", iDisplayLength);
        jsonObject.put("iTotalDisplayRecords", totalPage);
        jsonObject.put("iTotalRecords", pageCount);
        logger.debug("listData end...pages=" + jsonObject);
        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/updateRoleStatus")
    public Object updateRoleStatus(TRole role) throws Exception{
        logger.info("updateRoleStatus start...role=" + JSON.toJSONString(role));
        int i = rolesService.edit(role);
        logger.debug("updateRoleStatus end...pages=" + i);
        return ResultCodeEnum.SUCCESS.getResponse();
    }
}
