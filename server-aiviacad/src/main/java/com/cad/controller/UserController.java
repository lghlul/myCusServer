package com.cad.controller;

import com.alibaba.fastjson.JSON;
import com.cad.constant.ResultCode;
import com.cad.domain.Result;
import com.cad.domain.User;
import com.cad.service.IUserService;
import com.cad.utils.ConstantUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.aspectj.apache.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;


@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    IUserService userService;


    @RequestMapping("/toLogin")
    public String toLogin(User user){
        return ConstantUtil.Page.LOGIN;
    }


    @ResponseBody
    @RequestMapping("/checkAccount")
    public Object checkAccount(String userAccount){
        int count = this.userService.queryAccountCount(userAccount);
        Result result = new Result();
        if(count < 1){
            result.setCode(ResultCode.SUCCESS);
        }else{
            result.setCode(ResultCode.ACCOUNT_REPEAT);
        }
        return result;
    }
    @ResponseBody
    @RequestMapping("/login")
    public Object login(String userAccount , String userPwd , HttpServletRequest request){
        User user = this.userService.userLogin(userAccount , userPwd);
        Result result = new Result();
        if(user != null){
            request.getSession().setAttribute(ConstantUtil.SESSION_USER,user);
            result.setCode(ResultCode.SUCCESS);
        }else{
            result.setCode(ResultCode.FAIL);
        }
        return result;
    }
    @ResponseBody
    @RequestMapping("/register")
    public Object register(User user , HttpServletRequest request){
        Result result = new Result();
        int count = this.userService.queryAccountCount(user.getUserAccount());
        if(count > 0){
            result.setCode(ResultCode.ACCOUNT_REPEAT);
            return result;
        }
        user.setUserId(this.getUserId());
        user.setRegisterTime(System.currentTimeMillis());
        if(this.userService.register(user) > 0){
            request.getSession().setAttribute(ConstantUtil.SESSION_USER,user);
            result.setCode(ResultCode.SUCCESS);
        }else{
            result.setCode(ResultCode.FAIL);
        }
        return result;
    }

   /*
    * @author ll
    * @Description 生成18位userId
    * @date 2018/8/14 15:40
    * @param []
    * @return java.lang.String
    */
    private String getUserId(){
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replaceAll("-","");
        uuid = uuid.substring(0,18);
        return uuid;
    }

    @RequestMapping("/logout")
    public Object logout( HttpServletRequest request){
        request.getSession().removeAttribute(ConstantUtil.SESSION_USER);
        return ConstantUtil.Page.LOGIN;
    }

}
