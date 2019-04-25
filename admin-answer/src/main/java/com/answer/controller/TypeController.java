package com.answer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.answer.common.CommonConstant;
import com.answer.common.ResultCodeEnum;
import com.answer.domain.*;
import com.answer.service.ITOrganizationService;
import com.answer.service.ITTypeService;
import com.answer.service.ITUserAnswerService;
import com.answer.service.ITUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("type")
public class TypeController {

    private Logger logger = Logger.getLogger(TypeController.class);

    @Autowired
    private ITTypeService typeService;

    @GetMapping("list")
    public Object list() {
        TType tType = new TType();
        tType.setParentID(0L);
        List<TType> types = typeService.query(tType);
        return ResultCodeEnum.SUCCESS.getResponse(types);
    }


    @PostMapping("save")
    public Object save(TType type) {
        if(type.getParentID() == null || type.getParentID() == 0){
            type.setParentID(0L);
            type.setTypeImg("https://www.zgshnj.com/file/classify3Icon.png");
        }
        type.setCreateTime(System.currentTimeMillis());
        type.setTypeStatus(CommonConstant.Common.NORMAL_STATUS);
        typeService.add(type);
        return ResultCodeEnum.SUCCESS.getResponse();
    }

    @PostMapping("delete")
    public Object delete(Long typeID) {
        TType tType = new TType();
        tType.setTypeID(typeID);
        tType.setTypeStatus(CommonConstant.Common.DEL_STATUS);
        typeService.edit(tType);
        return ResultCodeEnum.SUCCESS.getResponse();
    }

    @PostMapping("update")
    public Object update(TType type) {
        typeService.edit(type);
        return ResultCodeEnum.SUCCESS.getResponse();
    }

}
