package customer.supu.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customer.supu.exception.IncorrectCaptchaException;
import customer.supu.service.*;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSON;

import customer.supu.common.po.PageResponse;
import customer.supu.common.utils.VerificationCode;
import customer.supu.jenum.ESmsType;
import customer.supu.jenum.ResultCodeEnum;
import customer.supu.po.Employee;

@Controller
@RequestMapping("")
public class F_LoginController {

	private Logger logger = Logger.getLogger(F_LoginController.class);

	@Autowired
	private F_LoginService f_LoginService;
	
	@Autowired
	private F_PersonalService f_PersonalService;

	@Autowired
	private MemberCardService memberCardService;

	@Autowired
	private SmsLogService smsLogService;





	/*绑定手机
	 *
	 *
	 */
	@RequestMapping(value="/outside/bindMobile",method=RequestMethod.GET)
	public String bindMobile(HttpServletRequest request,String type) throws UnsupportedEncodingException {

		return "/outside/login/loginmsg";
	}

//	/**
//	 * 外部用户登陆
//	 * @return
//	 * @throws UnsupportedEncodingException
//	 */
//	@RequestMapping(value="/outside/login",method=RequestMethod.GET)
//	public String outsidelogin(HttpServletRequest request,String type) throws UnsupportedEncodingException{
//
//	return "/outside/login/index";
////		if("1".equals(type)){//用户名密码登陆
////			return "/outside/login/loginpasswd";
////
////		}else if("2".equals(type)){//用户名短信登陆
////			return "/outside/login/loginmsg";
////		}
////		String retUrl = request.getHeader("Referer");
////		System.out.println(retUrl);
////		String message=new String(SpringPropertyResourceReader.getProperty("appoint.course.msg").getBytes("ISO8859-1"),"utf-8");
////	    String content= MessageFormat.format(message,"111","22");
////
//////		默认用户短信登陆
////		return "/outside/login/loginmsg";
//
//	}

	@RequestMapping(value="/outside/getCode",method=RequestMethod.GET)
	public String outsideGetCode(HttpServletRequest request,String type) throws UnsupportedEncodingException{

		return "/outside/login/getCode";
//		if("1".equals(type)){//用户名密码登陆
//			return "/outside/login/loginpasswd";
//
//		}else if("2".equals(type)){//用户名短信登陆
//			return "/outside/login/loginmsg";
//		}
		//String retUrl = request.getHeader("Referer");
		//System.out.println(retUrl);
		//String message=new String(SpringPropertyResourceReader.getProperty("appoint.course.msg").getBytes("ISO8859-1"),"utf-8");
		//String content=MessageFormat.format(message,"111","22");

		//默认用户短信登陆
//		return "/outside/login/loginmsg";

	}

	/**
	 * 外部用户登陆
	 * @param session
	 * @param type 1;代表用户名密码登陆  2：代表用户名短信登陆
	 * @param username 用户名
	 * @param password  密码
	 * @param captcha 验证码
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/outside/login",method=RequestMethod.POST)
	public String outsideloginSuc(HttpSession session,@RequestParam(value="type")String type,
			 @RequestParam(value="username")String username
			,@RequestParam(value="openid")String openid
			,@RequestParam(value="password")String password,String captcha,
			HttpServletRequest request,HttpServletResponse response,RedirectAttributes model) {
		Integer count = 0;
//		try {
		//获取登陆次数
//		    count=f_LoginService.LoginCount(request);
            //验证对错
        Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组
        if (null==cookies) {
            System.out.println("没有cookie=========");
        } else {
            for(Cookie cookie : cookies){
                if("openid".equals(cookie.getName())){


                    request.getSession().setAttribute("openId",openid);
                }
                if("nickName".equals(cookie.getName())){
                    String nickName = cookie.getValue();
                    try{
                        nickName = URLDecoder.decode(cookie.getValue(),"utf-8");
                    }catch (Exception e){

                    }
                    request.getSession().setAttribute("nickName", nickName);
                }
                if("headimgurl".equals(cookie.getName())){
                    String headimgurl = cookie.getValue();
                    request.getSession().setAttribute("headimgurl", headimgurl);
                }

            }
        }
		try {
            smsLogService.doValidMobileCode(username, password, ESmsType.LOGIN);
            Employee employee = new Employee();
            employee.setUsername(username);
            String nickname = (String) request.getSession().getAttribute("nickName");
            String heaimgurl = (String) request.getSession().getAttribute("headimgurl");
            employee.setMobilephone(username);
            employee.setOpenid(openid);
            employee.setHead(heaimgurl);
            employee.setFlag(1);
            nickname = filterEmoji(nickname," ");
            employee.setCnname(nickname);

            try {
                int i = f_LoginService.selectByMobile(employee);
                Integer employid;
                Employee eploe = memberCardService.selectEmployeeByOpenId(openid);
                if (eploe==null) {
                	if(i==1)
                        employid  =   f_LoginService.addOutsideEmployee(employee, request);
                    else{
                        employid = i;
                        employee.setEmployeeid(employid);
                        f_LoginService.updateByPrimaryKeySelective(employee);
                    }
				} else {
					employid = eploe.getEmployeeid();
					employee.setEmployeeid(employid);
					f_LoginService.updateByMobile(employee);
				}
                session.setAttribute("employeeId",  employid);

            } catch (Exception e) {
                e.printStackTrace();
            }
			return "redirect:/outside/aboutClass/listPage";

		} catch(Exception e) {
        	System.out.print(e.getMessage());
            request.setAttribute("username", username);
            request.setAttribute("count", count);
            request.setAttribute("error", e.getMessage());
            return "/outside/login/loginmsg";
        }
	}

//
//			}else{
//				throw new Exception("基础数据错误");
//			}

//			request.getSession().setAttribute("username", username);
			//request.getSession().setAttribute("userId", username);

//	                      }


	/**
	 * 判断账号是否存在
	 */
	@RequestMapping(value="/isExist",method=RequestMethod.GET)
	@ResponseBody
	public PageResponse isExist(Employee employee,HttpServletRequest request){
		PageResponse response=new PageResponse();
		try {
			response.setResultCode(f_LoginService.isExist(employee,request));

		} catch (Exception e) {

			e.printStackTrace();
		}
		return response;

	}


	/**
	 * 退出
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/outside/loginout",method=RequestMethod.GET)
	public String outsideloginOut(HttpServletRequest request){
		//String username=(String) request.getSession().getAttribute("username");
		request.getSession().removeAttribute("username");
		request.getSession().removeAttribute("employeeId");
		//清除sessionid
		//SessionIdStaticData.getSessionIDMap().remove(username);
		return "redirect:/outside/login";
	}





	/**
	 * 外部用户登陆
	 * @return
	 */
	@RequestMapping(value="/outside/register",method=RequestMethod.GET)
	public String outsideregister(){
		return "/outside/register/register";
	}



	/**
	 * 提交注册表单
	 */
	@RequestMapping(value="/addregister",method=RequestMethod.POST)
	public String addregister(@RequestParam(value="mobile")String mobile,@RequestParam(value="password")String password,
			@RequestParam(value="shortMessage")String shortMessage,RedirectAttributes model,HttpServletRequest request){
		Employee employee=new Employee();
		try {
			employee.setUsername(mobile);
			employee.setPassword(password);
			//插入数据库
			smsLogService.doValidMobileCode(mobile, shortMessage,ESmsType.REGISTER);
			f_LoginService.addOutsideEmployee(employee,request);
		} catch (Exception e) {
			model.addFlashAttribute("register_error", e.getMessage());
			model.addFlashAttribute("employee", employee);
			return "redirect:/outside/register";
		}

		return "redirect:/outside/login";

	}


	/**注册
	 * 发送验证码  返回mobile
	 */
	@RequestMapping(value="/getMobileCode",method=RequestMethod.GET)
	@ResponseBody
	public PageResponse getMobileCode(@RequestParam(value="mobile")String mobile,HttpServletRequest request){
		PageResponse response=new PageResponse();
		try {

			//发送6位随机数字
			f_LoginService.getRegisterMobileCode(mobile,"SMS_105945072",request);

			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());

		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}
		return response;

	}

	/**
	 * 获取图形图形验证码-验证数据放到session
	 * @param mobile
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/outside/getimgverify")//,method=RequestMethod.GET
	@ResponseBody
	public String getimgverify(//@RequestParam(value = "mobile") String mobile, 
			HttpServletRequest request, HttpServletResponse response){
		
		VerificationCode verificationCode = new VerificationCode();
        //获取验证码图片
        BufferedImage image = verificationCode.getImage();
        //获取验证码内容
        String text = verificationCode.getText();
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
        StringBuffer randomCode = new StringBuffer();
        randomCode.append(text);
        // 将验证码保存到Session中
        HttpSession session = request.getSession();
        session.setAttribute("imgsessiontext", randomCode.toString());
        session.setMaxInactiveInterval(60);
        System.out.println("session-signcode==>"+randomCode.toString());
        // 禁止图像缓存。
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/octet-stream");
        
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        // 将图像输出到Servlet输出流中。
//        ServletOutputStream sos = response.getOutputStream();
//        ImageIO.write(image, "jpeg", sos);
//        sos.flush();
//        sos.close();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();   
        try {
			ImageIO.write(image, "jpeg", baos);
		} catch (IOException e) {
			e.printStackTrace();
		}   
//        ServletOutputStream out = response.getOutputStream();
//        FileInputStream in = new FileInputStream(filePath);
//        try {
//            int len;
//            byte[] buffer = new byte[1024];
//            while ((len = in.read(buffer)) != -1) {
//                out.write(buffer, 0, len);
//            }
//            out.flush();
//        }
//        
        
        byte[] bytes = baos.toByteArray();
        return JSON.toJSONString(bytes).toString();

	}
	/**
	 * 发送登录验证码
	 * @param mobile
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getLoginMobileCode",method=RequestMethod.GET)
	@ResponseBody
	public PageResponse getLoginMobileCode(@RequestParam(value = "mobile") String mobile,
			@RequestParam(value = "imgvetext") String imgvetext, HttpServletRequest request){
		PageResponse response=new PageResponse();
		
		HttpSession session =request.getSession();//没有session的话就返回null
		String imgtext = (String)session.getAttribute("imgsessiontext");
		if(!imgvetext.equals(imgtext)) {//验证输入验证码和session验证是否一致
			response.setMessage("图形验证码错误");
			response.setResultCode(401);
			return response;
		}
		
		try {
			Employee employee = new Employee();
			employee.setMobilephone(mobile);
			Integer	isExistOpenid =  f_LoginService.isExistOpenid(employee, request);
			if(isExistOpenid == 0){
				System.out.println("该手机号已被绑定");
				response.setResultCode(ResultCodeEnum.isBinded.getCode());
				response.setMessage(ResultCodeEnum.isBinded.getDesc());
				return response;
			}
			//发送6位随机数字
			f_LoginService.getLoginMobileCode(mobile);
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
            System.out.println("异常"+ e.getMessage());
			response.setMessage(e.getMessage());
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}
		return response;

	}

	/**
	 **判断openId是否绑定手机号
	 * @param mobile
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/isbind",method=RequestMethod.GET)
//	@ResponseBody
	public String isbind(@RequestParam(value = "openid") String openid,HttpServletRequest request, HttpServletResponse response , String realPath) {
		logger.info("isbind start...openid=" + openid + ",realPath=" + realPath);
        try {
		   Employee  employee   =  memberCardService.selectEmployeeByOpenId(openid);
			System.out.println(employee);
            if(employee != null && StringUtils.isNotEmpty(employee.getMobilephone())){
                //			request.getSession().setAttribute("username", username);
                //request.getSession().setAttribute("userId", username);
            	request.getSession().setAttribute("employeeId",employee.getEmployeeid());
                request.getSession().setAttribute("username", employee.getUsername());
                String redirectUrl = "/outside/aboutClass/listPage";
                if(realPath != null){
					redirectUrl = realPath;
				}
				logger.info("isbind end...redirectUrl=" + redirectUrl);
				return "redirect:" + redirectUrl;
            }
            else {
				return "redirect:/outside/bindMobile";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return "1";
	}

	public static String filterEmoji(String source,String slipStr) {
		if(StringUtils.isNotBlank(source)){
			return source.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", slipStr);
		}else{
			return source;
		}
	}


}
