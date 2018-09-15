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
import java.util.HashMap;
import java.util.Map;
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
        Map<String , Object> map = new HashMap<String , Object>();
        map.put("userAccount",userAccount);
        int count = this.userService.searchCount(map);
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
        //校验账号是否重复
        Map<String , Object> map = new HashMap<String , Object>();
        map.put("userAccount",user.getUserAccount());
        int count = this.userService.searchCount(map);
        if(count > 0){
            result.setCode(ResultCode.ACCOUNT_REPEAT);
            return result;
        }
        //校验手机是否重复
        if(user.getPhone() != null && !"".equals(user.getPhone())){
            map.clear();
            map.put("phone",user.getPhone());
            count = this.userService.searchCount(map);
            if(count > 0){
                result.setCode(ResultCode.PHONE_REPEAT);
                return result;
            }
        }
        if(user.getEmail() != null && !"".equals(user.getEmail())){
            //校验邮箱是否重复
            map.clear();
            map.put("email",user.getEmail());
            count = this.userService.searchCount(map);
            if(count > 0){
                result.setCode(ResultCode.EMAIL_REPEAT);
                return result;
            }
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
