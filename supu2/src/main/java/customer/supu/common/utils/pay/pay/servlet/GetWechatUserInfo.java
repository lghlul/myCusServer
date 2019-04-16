package customer.supu.common.utils.pay.pay.servlet;


import customer.supu.jenum.DataValidEnum;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import customer.supu.common.utils.ComUtil;
import customer.supu.common.utils.DateTimeUtil;
import customer.supu.common.utils.JSONutils;
import customer.supu.common.utils.StringUtils;
import customer.supu.common.utils.wx.BaseWechatRquest;
import customer.supu.common.utils.wx.impl.BaseWechatRquestImpl;
import customer.supu.po.Employee;
import customer.supu.service.F_LoginService;
import customer.supu.service.MemberCardService;

/**
 * Created by lenovo on 2016/1/20.
 */
public class GetWechatUserInfo extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MemberCardService memberCardService;
    private F_LoginService f_LoginService;
    private static String aToken;
    private static String tokenTime;

    public GetWechatUserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        WebApplicationContext context =
                WebApplicationContextUtils.getWebApplicationContext(servletContext);
       memberCardService = (MemberCardService) context.getBean("memberCardService");
        f_LoginService = (F_LoginService) context.getBean("f_LoginService");
//
       System.out.println("memberCardService=" + memberCardService);


        String code = request.getParameter("code");
        String redirect_url = request.getParameter("url");
        System.out.println("redirect_url=" + redirect_url);
        response.sendRedirect(redirect_url);
//        System.out.println("code============: " + code);
//        //速扑公众号
//        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxf807c2429fa726f8&secret=87c12b7bbb15fa8b5ab50db00c6a6eb0&code=" + code + "&grant_type=authorization_code&scope=snsapi_userinfo";
//        //测试公众号
////        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx8be994d65a7bc6f0&secret=081a42b9956d5f37662ef65aca618525&code=" + code + "&grant_type=authorization_code&scope=snsapi_userinfo";
//
//        System.out.println("url=============: " + url);
//        HttpURLConnection connection = getHttpUrlConnection(url, "GET");
//        String back = getRetrunString(connection);
//        System.out.println("back=============: " + back);
//        JSONObject jsonObject = JSONObject.fromObject(back);
//        String openid = jsonObject.getString("openid");
//        String access_token = jsonObject.getString("access_token");
//        String refresh_token = jsonObject.getString("refresh_token");
//        String url1 = "https://api.weixin.qq.com/sns/userinfo?access_token="+access_token+"&openid="+openid +"&lang=zh_CN";
//        HttpURLConnection connection1 = getHttpUrlConnection(url1, "GET");
//        String back1 = getRetrunString(connection1);
//        JSONObject jsonObject1 = JSONObject.fromObject(back1);
        //说明 跳转的url地址里已经存在请求参数
       /* if (redirect_url.contains("?")) {
            redirect_url = redirect_url + "&openid=" + openid;
        } else {
            redirect_url = redirect_url + "?openid=" + openid;
        }*/
//        if (redirect_url.contains("stu_index")) {
//            redirect_url = redirect_url + "#/index";
//        }
////        redirect_url = redirect_url + "&openid=" + openid;
//        redirect_url = redirect_url.replace("***", "&");
//        System.out.println("redirect_url = " + redirect_url);

//        if(openddid 没有绑定手机号，去绑定页面){
//
//        }
//        else{
//            进入主页面
//        }
//        HttpSession session = request.getSession();
//        session.setAttribute("openId", openid);
//        response.setContentType("application/json; charset=utf-8");
//        Map<String, Object> maps = JSONutils.parseJSON2Map(jsonObject1.toString());
//        Employee employee = new Employee();
//        employee.setHead(maps.get("headimgurl").toString());
//        employee.setOpenid(maps.get("openid").toString());
//        employee.setFlag(1);
//        String nickname = ComUtil.filterEmoji(maps.get("nickname")
//                    .toString());
//        employee.setCnname(nickname);
//        try {
//            f_LoginService.addOutsideEmployee(employee, request);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
////        if (null != maps.get("subscribe") && maps.get("subscribe").toString().equals("1")) {
//            //customer.setSUBSCRIBE(maps.get("subscribe").toString());
//            //customer.setCOUNTRY(maps.get("country").toString());
//            employee.setHead(maps.get("headimgurl").toString());
//            String nickname = ComUtil.filterEmoji(maps.get("nickname")
//                    .toString());
//            employee.setCnname(nickname);
//            //customer.setSUBSCRIBE_TIME(maps.get("subscribe_time").toString());
//            // customerService.insert(customer);
//            try {
//                f_LoginService.addOutsideEmployee(employee, request);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

//        PrintWriter out = null;
//        try {
//            out = response.getWriter();
//            out.write(jsonObject1.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (out != null) {
//                out.close();
//            }
//        }


//
//        if (StringUtils.hasText(openid)) {
//            //根据openId查询用户信息，有值则不需要再登陆
//            try {
//                Employee employee = memberCardService.selectEmployeeByOpenId(openid);
//
//                if (null != employee) {
//                    if (employee.getMobilephone() != null) {
//                        System.out.println("employeeId登陆" + employee.getEmployeeid());
//                        session.setAttribute("employeeId", employee.getEmployeeid());
//                        session.setAttribute("username", employee.getUsername());
//                    }
//                } else {
//                    String aToken = this.getAccessToken();
//
//                    BaseWechatRquest bRquest = new BaseWechatRquestImpl();
//                    String jsonStr = bRquest.getFansInfo(openid, aToken);
//                    Map<String, Object> maps = JSONutils.parseJSON2Map(jsonStr);
//                    employee = new Employee();
//                    if (null != maps.get("subscribe")
//                            && maps.get("subscribe").toString().equals("1")) {
//                        //customer.setSUBSCRIBE(maps.get("subscribe").toString());
//                        //customer.setCOUNTRY(maps.get("country").toString());
//                        employee.setHead(maps.get("headimgurl").toString());
//                        String nickname = ComUtil.filterEmoji(maps.get("nickname")
//                                .toString());
//                        employee.setCnname(nickname);
//                        //customer.setSUBSCRIBE_TIME(maps.get("subscribe_time").toString());
//                        // customerService.insert(customer);
//                        f_LoginService.addOutsideEmployee(employee, request);
//                    }
//                    //清除缓存
//                    request.getSession().removeAttribute("username");
//                    request.getSession().removeAttribute("employeeId");
//                }
//            } catch (Exception e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//        System.out.println(openid);

//        return openid;
//       response.sendRedirect("supu/outside/login");
        //JSONUtil.jsonToObject(arg0, GetWechatUserInfo.class);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    private static HttpURLConnection getHttpUrlConnection(String url, String method) {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(2000);// 设置连接超时时间，单位毫秒
            connection.setReadTimeout(2000);// 设置读取数据超时时间，单位毫秒
            connection.setDoOutput(true);// 是否打开输出流 true|false
            connection.setDoInput(true);// 是否打开输入流true|false
            connection.setRequestMethod(method);// 提交方法POST|GET
            connection.setUseCaches(false);// 是否缓存true|false
            connection.connect();// 打开连接端口
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public String getAccessToken() {


        long da = DateTimeUtil.getTimestamp(null);

        // 判断ticket是否为空已经是否在有效时间范围内
        if (StringUtils.isEmpty(aToken) || DateTimeUtil.validTime(tokenTime, da)) {

            String appid = "wxf807c2429fa726f8";
            String secret = "87c12b7bbb15fa8b5ab50db00c6a6eb0";
//              String appid = "wx8be994d65a7bc6f0";
//              String secret = "081a42b9956d5f37662ef65aca618525";
            BaseWechatRquest bRquest = new BaseWechatRquestImpl();
            String aTokenTemp = bRquest.getAccessToken(appid, secret);
            // 从微信接口获取jsTicket
            aToken = JSONutils.getJsonStrByKey(aTokenTemp, "access_token");
            tokenTime = Long.toString(da);
            // int i = pubilcAccountService.updatePublicAccount(publicAccountEntity);


            /*
             * if(i==1){ System.out.println("修改成功"); }else{
             * System.out.println("修改失败"); }
             */
        }

        return aToken;

    }

    private static String getRetrunString(HttpURLConnection connection) {
        BufferedReader in = null;
        StringBuilder builder = new StringBuilder();
        try {
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = in.readLine();
            while (null != line) {
                builder.append(line);
                line = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

}
