package com.answer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.answer.common.ResultCodeEnum;
import com.answer.domain.TUser;
import com.answer.service.ITUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @CLassName UserController
 * @Description TODO
 * @Author ll
 * @Date 2018/12/13 18:02
 **/
@RestController
@RequestMapping("user")
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private ITUserService userService;

    @GetMapping("/list")
    public Object list(TUser user , Long startTime , Long endTime){
        logger.info("list start...user=" + JSON.toJSONString(user));
        Map<String , Object> map = new HashMap<>();
        if(startTime != null){
            map.put("startTime" , startTime);
        }
        if(endTime != null){
            map.put("endTime" , endTime);
        }
        if(user.getJobNum() != null){
            map.put("jobNum" , user.getJobNum());
        }
        if(user.getRealName() != null){
            map.put("realName" , user.getRealName());
        }
        user.pageHandler();
        map.put("offSet" , user.getOffSet());
        map.put("limit" , user.getLimit());
        List<TUser> users = userService.answerCount(map);
        int pageCount = userService.queryPageCounteByMap(map);
        int totalPage = pageCount % user.getLimit() == 0?pageCount / user.getLimit() : pageCount / user.getLimit() + 1;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("items", users);
        jsonObject.put("totalPage", totalPage);
        jsonObject.put("pageCount", pageCount);
        logger.debug("list end...pages=" + jsonObject);
        return ResultCodeEnum.SUCCESS.getResponse(jsonObject);
    }
}
