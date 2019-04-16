package customer.supu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import customer.supu.common.utils.wx.util.WXAuthUtil;
import customer.supu.service.F_LoginService;
import customer.supu.service.MemberCardService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import org.apache.log4j.Logger;
//import com.wxutil.auth.SHA1;
//import com.wxutil.auth.WXAuthUtil;



/**
 * @author  lbh
 * @date 创建时间：2018年1月18日 下午12:35:11
 * @version 1.0
 * @parameter
 * @since
 * @return
 */


@Controller
@RequestMapping("/wx")
public class WXLoginController {

    private Logger logger = Logger.getLogger(WXLoginController.class);

    @Autowired
    private F_LoginService f_LoginService;
    private MemberCardService memberCardService;
//    private static final Logger logger = Logger.getLogger(WXLoginController.class);
    /**
     * 公众号微信登录授权
     * @param request
     * @param response
     * @return
     * @throws ParseException
     * @author  lbh
     * @date 创建时间：2018年1月18日 下午7:33:59
     * @parameter
     */
    @RequestMapping( value = "/wxLogin", method = RequestMethod.GET)
    public String wxLogin( HttpServletRequest request,HttpSession session,
                          HttpServletResponse response , String realPath)
            throws ParseException {

        //logger.info("wxLogin start...realPath=" + realPath);
        //清楚缓存后，重新授权，拦截器里有判断手机号是否绑定
//        Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组
//        if (null==cookies) {
//            System.out.println("WX没有cookie=========");
//
//
//        } else {
//            for(Cookie cookie : cookies){
//                System.out.println("name:"+cookie.getName()+",value:"+ cookie.getValue());
//              if("openid".equals(cookie.getName())){
//                    String openid = cookie.getValue();
//                    session.setAttribute("openId",openid);
////                  session.setAttribute("nickName", nickName);
////                  session.setAttribute("headimgurl", headImg);
//                  System.out.println("wx-sibind:"+cookie.getName()+",value:"+ cookie.getValue());
//                  return "redirect:"+"/isbind?openid="+openid;
//              }
//
//            }
//        }
        //这个url的域名必须要进行再公众号中进行注册验证，这个地址是成功后的回调地址
        //    String backUrl="http://n1987212y0.51mypc.cn/wx/callBack";
//        String backUrl="http://lghll.vicp.cc/wx/callBack";
      String backUrl =WXAuthUtil.redirect_uri;
      if(realPath != null){
          backUrl += "?realPath=" + realPath;
      }

//    String backUrl="http://m.lghll.com/supu/wx/callBack";
        // 第一步：用户同意授权，获取code
        String url ="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+WXAuthUtil.APPID
                + "&redirect_uri="+URLEncoder.encode(backUrl)
                + "&response_type=code"
                + "&scope=snsapi_userinfo"
                + "&state=STATE"
                + "&connect_redirect=1"
                +"#wechat_redirect";

//        logger.info("forward重定向地址{" + url + "}");
//        try {
//            response.sendRedirect(url);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("hahahhahaha"+url);
//        return "haha";
        //logger.info("wxLogin end...url=" + url);
    return "redirect:"+url;//必须重定向，否则不能成功
    }
    /**
     * 公众号微信登录授权回调函数
     * @param modelMap
     * @param req
     * @param resp
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     * @author  lbh
     * @date 创建时间：2018年1月18日 下午7:33:53
     * @parameter
     *
     */
    @RequestMapping(value = "/callBack", method = RequestMethod.GET)
    public String callBack(ModelMap modelMap, HttpServletRequest req, HttpServletResponse resp, HttpSession session, HttpServletResponse response,String realPath) throws Exception {
        logger.info("callBack start...realPath=" + realPath);
        /*
         * start 获取微信用户基本信息
         */
        String code =req.getParameter("code");
        //第二步：通过code换取网页授权access_token
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+WXAuthUtil.APPID
                + "&secret="+ WXAuthUtil.APPSECRET
                + "&code="+code
                + "&grant_type=authorization_code";

        System.out.println("url:"+url);
        JSONObject jsonObject = WXAuthUtil.doGetJson(url);
        /*
         { "access_token":"ACCESS_TOKEN",
            "expires_in":7200,
            "refresh_token":"REFRESH_TOKEN",
            "openid":"OPENID",
            "scope":"SCOPE"
           }
         */
        String openid = jsonObject.getString("openid");
        String access_token = jsonObject.getString("access_token");
        String refresh_token = jsonObject.getString("refresh_token");
        //第五步验证access_token是否失效；展示都不需要
        String chickUrl="https://api.weixin.qq.com/sns/auth?access_token="+access_token+"&openid="+openid;

        JSONObject chickuserInfo = WXAuthUtil.doGetJson(chickUrl);
        System.out.println(chickuserInfo.toString());
        if(!"0".equals(chickuserInfo.getString("errcode"))){
            // 第三步：刷新access_token（如果需要）-----暂时没有使用,参考文档https://mp.weixin.qq.com/wiki，
            String refreshTokenUrl="https://api.weixin.qq.com/sns/oauth2/refresh_token?appid="+openid+"&grant_type=refresh_token&refresh_token="+refresh_token;

            JSONObject refreshInfo = WXAuthUtil.doGetJson(refreshTokenUrl);
            /*
             * { "access_token":"ACCESS_TOKEN",
                "expires_in":7200,
                "refresh_token":"REFRESH_TOKEN",
                "openid":"OPENID",
                "scope":"SCOPE" }
             */
            System.out.println(refreshInfo.toString());
            access_token=refreshInfo.getString("access_token");
        }

        // 第四步：拉取用户信息(需scope为 snsapi_userinfo)
        String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token="+access_token
                + "&openid="+openid
                + "&lang=zh_CN";
        System.out.println("infoUrl:"+infoUrl);
        JSONObject userInfo = WXAuthUtil.doGetJson(infoUrl);
        /*
         {    "openid":" OPENID",
            " nickname": NICKNAME,
            "sex":"1",
            "province":"PROVINCE"
            "city":"CITY",
            "country":"COUNTRY",
            "headimgurl":    "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/46",
            "privilege":[ "PRIVILEGE1" "PRIVILEGE2"     ],
            "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL"
            }
         */
        if(userInfo.getInteger("errcode")!=null&&userInfo.getInteger("errcode").intValue()==40001){
            System.out.println("不知道为什么超时了只能先规避掉-----");
            userInfo.put("openid",openid);
            userInfo.put("nickname","速扑健身");
            userInfo.put("headimgurl","");
        }
        System.out.println("JSON-----"+userInfo.toString());
        System.out.println("名字-----"+userInfo.getString("nickname"));
        System.out.println("头像-----"+userInfo.getString("headimgurl"));
        /*
         * end 获取微信用户基本信息
         */
        //获取到用户信息后就可以进行重定向，走自己的业务逻辑了。。。。。。
        //接来的逻辑就是你系统逻辑了，请自由发挥
        modelMap.addAttribute("userInfo" , userInfo);


        String openId = userInfo.getString("openid");
        String nickName = userInfo.getString("nickname");
        String headImg = userInfo.getString("headimgurl");
        nickName = filterEmoji(nickName);

        session.setAttribute("openId", openId);
        session.setAttribute("nickName", nickName);
        session.setAttribute("headimgurl", headImg);
        String cnname = URLEncoder.encode(nickName,"utf-8");
        Cookie cookie1 = new Cookie("nickName", cnname);
        cookie1.setMaxAge(30 * 60);// 设置为30min
        cookie1.setPath("/");
        System.out.println("已添加昵称到cookie==============="+cnname);
        response.addCookie(cookie1);
        Cookie cookie2 = new Cookie("headimgurl", headImg);
        cookie2.setMaxAge(30 * 60);// 设置为30min
       cookie2.setPath("/");
        System.out.println("已添加头像到cookie===============");
        response.addCookie(cookie2);
        Cookie cookie = new Cookie("openid", openId);
        cookie.setMaxAge(30 * 60);// 设置为30min
        cookie.setPath("/");
        System.out.println("已添加openid到cookie===============");
        response.addCookie(cookie);

//        req.getSession().setAttribute("openId", openId);
//        req.getSession().setAttribute("nickName", nickName);
//        req.getSession().setAttribute("headimgurl", headImg);
        String userInfoStr = JSON.toJSONString(userInfo);
        String redirectUrl = "/isbind?openid="+openid;
        if(realPath != null){
            redirectUrl += "&realPath=" + realPath;
        }
        logger.info("claaback end...redirectUrl=" + redirectUrl);
       return "redirect:"+ redirectUrl;
    }

    /**
     **判断openId是否绑定手机号
     * @param mobile
     * @return
     */
//    @RequestMapping(value="/isbind",method=RequestMethod.GET)
//    @ResponseBody
//    public String isbind(String openid) {
//        try {
//            Employee employee =  memberCardService.selectEmployeeByOpenId(openid);
//
//            if(employee.getMobilephone() != null){
//
//                return "1";//已绑定
////                return "redirect:"+"/outside/aboutClass/listPage";
//            }
//            else{
//                return "0";//未绑定
////                return "redirect:"+"/outside/bindMobile";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
////        return openid;
//    }

//    public static String filterEmoji(String source) {
//        if (source == null) {
//            return source;
//        }
//        Pattern emoji = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",
//                Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
//        Matcher emojiMatcher = emoji.matcher(source);
//        if (emojiMatcher.find()) {
//            source = emojiMatcher.replaceAll("*");
//            return source;
//        }
//        return source;
//    }
    private static boolean isEmojiCharacter(char codePoint) {
        return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA)
                || (codePoint == 0xD)
                || ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
                || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
                || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
    }
    /**
     * 过滤emoji 或者 其他非文字类型的字符
     *
     * @param source
     * @return
     */
    public static String filterEmoji(String source) {
        if (source==null||source.equals("")) {
            return source;
        }
        StringBuilder buf = null;
        int len = source.length();
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            if (isEmojiCharacter(codePoint)) {
                if (buf == null) {
                    buf = new StringBuilder(source.length());
                }
                buf.append(codePoint);
            }
        }
        if (buf == null) {
            return source;
        } else {
            if (buf.length() == len) {
                buf = null;
                return source;
            } else {
                return buf.toString();
            }
        }
    }
}