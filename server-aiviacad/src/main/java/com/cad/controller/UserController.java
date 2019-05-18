package com.cad.controller;

import com.alibaba.fastjson.JSON;
import com.cad.cache.RedisHelper;
import com.cad.constant.ResultCode;
import com.cad.domain.Result;
import com.cad.domain.User;
import com.cad.domain.VerifyCode;
import com.cad.service.IUserService;
import com.cad.service.IVerifyCodeService;
import com.cad.utils.ConstantUtil;
import com.cad.utils.LogUtil;
import com.cad.utils.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    private static final String TAG = UserController.class.getName();

    @Autowired
    IUserService userService;


    @Autowired
    RedisHelper redisHelper;

    @Autowired
    IVerifyCodeService verifyCodeService;


    @RequestMapping("/toLogin")
    public String toLogin(String flag , Model model){
        model.addAttribute("flag" , flag);
        return ConstantUtil.Page.LOGIN;
    }

    @RequestMapping("/toResetPwd")
    public String toResetPwd(){
        return ConstantUtil.Page.USER;
    }

    @ResponseBody
    @RequestMapping("/resetPwd")
    public Object resetPwd(String userId , String userOldPwd , String userPwd){
        int code = this.userService.updatePwd(userId , userOldPwd ,userPwd );
        Result result = new Result();
        result.setCode(code);
        return result;
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

        if(user.getUserCode() != null && !"".equals(user.getUserCode())){
            //校验用户编码是否重复
            map.clear();
            map.put("userCode",user.getEmail());
            count = this.userService.searchCount(map);
            if(count > 0){
                result.setCode(ResultCode.CODE_VALUE_REPEAT);
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


    /*
     * @author ll
     * @Description 发送邮件验证码  用于找回密码
     * @date 2019/3/4 11:13
     * @param [email]
     * @return java.lang.Object
     */
    @ResponseBody
    @RequestMapping("/sendEmailCode")
    public Object sendEmailCode( String email){
        LogUtil.i(TAG, "sendEmailCode start...email=" + email);
        Result result = new Result();
        //校验邮箱是否注册

        Map<String , Object> map = new HashMap<String, Object>();
        map.put("email", email);
        List<User> users = userService.searchByMap(map);
        if(users == null || users.size() < 1){
            result.setCode(ResultCode.EMAIL_EXIST);
            return result;
        }

        Random r = new Random();
        int emailCode = r.nextInt(899999) + 100000;
        LogUtil.i(TAG, "sendEmailCode...emailCode=" + emailCode);
        MailUtil.sendMailCode(email ,"找回密码" , "感谢关注matlacdom，您的验证码是" + emailCode + ",验证码有效期10分钟!");
        redisHelper.set(email , emailCode + "" , 10*60);
        VerifyCode verifyCode = new VerifyCode();
        verifyCode.setVerifyCode(emailCode + "");
        verifyCode.setSource(email);
        verifyCode.setCreateTime(System.currentTimeMillis());
        // 1表示邮箱验证码
        verifyCode.setCodeType((byte)1);
        verifyCodeService.add(verifyCode);
        result.setCode(ResultCode.SUCCESS);
        LogUtil.i(TAG, "sendEmailCode start...result=" + JSON.toJSONString(result));
        return result;
    }


    @ResponseBody
    @RequestMapping("/findPwd")
    public Object findPwd( String email ,String emailCode , String userPwd){
        LogUtil.i(TAG, "findPwd start...email=" + email + ",emailCode=" + emailCode + ",userPwd=" + userPwd);
        Result result = new Result();

        String code = redisHelper.get(email);
        if(code != null && code.equals(emailCode)){
            //验证通过
            userService.updatePwdByEmail(email , userPwd);
            result.setCode(ResultCode.SUCCESS);
            redisHelper.delete(email);
        }else{
            //验证码无效或者过期
            result.setCode(ResultCode.CODE_NOT_EFFECT);
        }
        LogUtil.i(TAG, "findPwd end...result=" + JSON.toJSONString(result));
        return result;
    }

}
