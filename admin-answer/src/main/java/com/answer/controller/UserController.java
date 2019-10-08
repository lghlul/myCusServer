package com.answer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.answer.CacheHelper;
import com.answer.common.PageResult;
import com.answer.common.ResultCodeEnum;
import com.answer.domain.AnswerDetailParam;
import com.answer.domain.TOrganization;
import com.answer.domain.TUser;
import com.answer.domain.query.UserQuery;
import com.answer.service.ITOrganizationService;
import com.answer.service.ITUserAnswerService;
import com.answer.service.ITUserService;
import com.answer.service.ITWrongRecordService;
import com.answer.service.impl.TWrongRecordServiceImpl;
import com.github.pagehelper.PageInfo;
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

    @Autowired
    private ITUserAnswerService userAnswerService;

    @Autowired
    private ITOrganizationService organizationService;

    @Autowired
    private ITWrongRecordService wrongRecordService;

    @Autowired
    private CacheHelper cacheHelper;

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
        if(user.getOrgID() != null){
            map.put("orgID" , user.getOrgID());
        }
        user.pageHandler();
        map.put("offSet" , user.getOffSet());
        map.put("limit" , user.getLimit());
        List<TUser> users = userService.answerCount(map);
        if(users != null && users.size() > 0){
            for(TUser u : users){
                TOrganization org = cacheHelper.getOrg(u.getOrgID());
                if(org != null){
                    u.setOrgName(org.getOrgName());
                }
            }
        }
        int pageCount = userService.queryPageCounteByMap(map);
        int totalPage = pageCount % user.getLimit() == 0?pageCount / user.getLimit() : pageCount / user.getLimit() + 1;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("items", users);
        jsonObject.put("totalPage", totalPage);
        jsonObject.put("pageCount", pageCount);
        logger.debug("list end...pages=" + jsonObject);
        return ResultCodeEnum.SUCCESS.getResponse(jsonObject);
    }


    @GetMapping("/orgList")
    public Object orgList(){
        List<TOrganization> tOrganizationList = organizationService.query(null);
        return ResultCodeEnum.SUCCESS.getResponse(tOrganizationList);
    }


    @GetMapping("/answerDetail")
    public Object answerDetail(AnswerDetailParam answerDetailParam){
        answerDetailParam.pageHandler();
        Map<String, Object> answerDetailPage = userAnswerService.getAnswerDetailPage(answerDetailParam);
        return ResultCodeEnum.SUCCESS.getResponse(answerDetailPage);
    }




    @GetMapping("/listReport")
    public Object listReport(UserQuery userQuery){
        PageInfo<TUser> page = userService.listReport(userQuery);
        PageResult pageResult = new PageResult();
        pageResult.setTotalCount(page.getTotal());
        pageResult.setTotalPage(page.getPages());
        pageResult.setList(page.getList());
        return ResultCodeEnum.SUCCESS.getResponse(pageResult);
    }

    @GetMapping("/initUseAnswer")
    public Object initUseAnswer(String openID , Long typeID){
        userAnswerService.deleteByOpenIdAndTypeId(openID , typeID);
        wrongRecordService.deleteByOpenIdAndTypeId(openID , typeID);
        return ResultCodeEnum.SUCCESS.getResponse();
    }
}
