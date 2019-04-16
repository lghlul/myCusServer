package customer.supu.common.utils.pay.pay.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.alibaba.fastjson.JSON;
import customer.supu.common.utils.DateTimeUtil;
import customer.supu.common.utils.StringUtils;
import customer.supu.common.utils.pay.pay.utils.GetWxOrderno;
import customer.supu.common.utils.pay.pay.utils.RequestHandler;
import customer.supu.common.utils.pay.pay.utils.Sha1Util;
import customer.supu.common.utils.pay.pay.utils.TenpayUtil;
import customer.supu.controller.F_PersonalController;
import customer.supu.jenum.DataValidEnum;
import customer.supu.po.MemberCard;
import customer.supu.po.Order;
import customer.supu.service.MemberCardService;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;




public class TopayServlet extends HttpServlet {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MemberCardService memberCardService;
	private Logger logger = Logger.getLogger(TopayServlet.class);
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 *
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获取ServletContext 再获取 WebApplicationContextUtils
        ServletContext servletContext = this.getServletContext();
        WebApplicationContext context =
                WebApplicationContextUtils.getWebApplicationContext(servletContext);
        memberCardService = (MemberCardService) context.getBean("memberCardService");


	  //  double money = 1;

		//以下这四个参数，以你们实际参数为准
		String appid = "wxf807c2429fa726f8";    //公众号appid
		String appsecret = "87c12b7bbb15fa8b5ab50db00c6a6eb0"; //公众号appsecret
		String mch_id = "1487838702";  //商户号
		String partnerkey = "87c12b7bbb15fa8b5ab50db00c6a6eb1";  //支付平台设置的支付秘钥

		String openId = request.getParameter("openid");

		String currTime = TenpayUtil.getCurrTime();
		//获取订单号
		String order_id = request.getParameter("order_id");
		Random random = new Random();
		String result="";
		for(int i=0;i<9;i++){
			result+=random.nextInt(9);
		}



		//购买会员卡前   判断是否已经购买了会员卡
	/*	if(hasBuyCard(userId,mCardId)){
			throw new Exception("你已经购买了同类型的会员卡");
		}*/
		String mCardId = request.getParameter("cid");
		MemberCard memberCard = null;
		try {
			memberCard = memberCardService.selecMemberCardInfoById(Integer.parseInt(mCardId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("memberCard=" + JSON.toJSONString(memberCard));
		//float sessionmoney = Float.parseFloat(request.getParameter("total_fee"));
		float sessionmoney = Float.parseFloat(memberCard.getAmountmoney() + "");
		String finalmoney = String.format("%.2f", sessionmoney);
		finalmoney = finalmoney.replace(".", "");

		int intMoney = Integer.parseInt(finalmoney);


		int total_fee = intMoney;

		//订单号有值
		if(!StringUtils.hasText(order_id)){
			//根据订单号查询
			order_id=result;
			Order record=new Order();
			record.setUserid((Integer) request.getSession().getAttribute("employeeId"));
			record.setCid(Integer.valueOf(request.getParameter("cid")));//购买类型主键id:当type=0表示会员卡id   当type=1表示私教课   2：精品团课
			record.setIssuccess(DataValidEnum.NO_EFFECT.getCode());//是否支付成功  0：不成功  1：成功
			record.setOrdernumber(order_id);
			int type = Integer.valueOf(request.getParameter("type"));
			record.setType(type);
			//私教课
			if(type == 1){
				int coachId = Integer.valueOf(request.getParameter("coachId"));
				record.setCoachId(coachId);
			}
			String isexperience=  request.getParameter("isexperience");

			if(StringUtils.hasText(isexperience)){//私教课   是否为体验课
				record.setIsexperience(Integer.valueOf(isexperience));
			}
			String totalClass=request.getParameter("totalClass");
			if(StringUtils.hasText(totalClass)){//当订单为私教课或 工作室的时候，有值
				record.setTotalclass(Integer.valueOf(totalClass));
			}

			//开始日期 （只有训练营时候有）
			String startDate=request.getParameter("startDate");
			if(StringUtils.hasText(startDate)){
				record.setStartdate(DateTimeUtil.getDateWithoutTime(startDate));
			}

			//结束日期 （只有训练营时候有）
			String endDate=request.getParameter("endDate");
			System.out.println("endDate="+endDate);

			if(StringUtils.hasText(endDate)){
				System.out.println("endDate有值了");
				record.setEnddate(DateTimeUtil.getDateWithoutTime(endDate));

			}
			System.out.println("total_fee=="+request.getParameter("total_fee"));
			//record.setAmount(Double.valueOf(request.getParameter("total_fee")));
			record.setAmount(Double.valueOf(memberCard.getAmountmoney() + ""));
			try {
				memberCardService.addOrder(record);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}



		System.out.println(openId);

		//金额
		System.out.println(request.getParameter("total_fee"));




		String nonce_str = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);

		// String body = describe;


		//String body = "支付";
		String body="body";

		String attach = "attach";



		String spbill_create_ip = request.getRemoteAddr();

		//String notify_url = "域名"+"/notifyServlet"
		String notify_url = "http://www.spartner.cn/notifyServlet";  //支付回调地址  NotifyServlet.java
		//String notify_url = "/jzweb/notifyServlet";
		String trade_type = "JSAPI";//固定不变
		String openid = openId;

		// String product_id = "";
		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		packageParams.put("appid", appid);//公众号appid
		packageParams.put("attach", attach);
		packageParams.put("body", body);
		packageParams.put("mch_id", mch_id);//商户号
		packageParams.put("nonce_str", nonce_str);

		packageParams.put("openid", openid);
		packageParams.put("out_trade_no", order_id+"_"+currTime); //前端传过来的订单号，内部订单号  201708081009

		packageParams.put("spbill_create_ip", spbill_create_ip);
	    packageParams.put("total_fee", String.valueOf(total_fee)); //支付金额，单位 ：分
	    packageParams.put("trade_type", trade_type);
		packageParams.put("notify_url", notify_url);


		RequestHandler reqHandler = new RequestHandler(request, response);
		reqHandler.init(appid, appsecret, partnerkey);

		String sign = reqHandler.createSign(packageParams);
		String xml = "<xml>" +
		"<appid>" + appid + "</appid>" +
		"<attach>" + attach+ "</attach>"+
	    "<body>" + body + "</body>" +
		"<mch_id>"+ mch_id + "</mch_id>" +
		"<nonce_str>" + nonce_str+ "</nonce_str>" +
		"<notify_url>" + notify_url + "</notify_url>"+
		"<openid>" + openid + "</openid>" +
		"<out_trade_no>"+ order_id+"_"+currTime + "</out_trade_no>"+//前端传过来的订单号，内部订单号
		"<sign>" + sign + "</sign>"+
		"<spbill_create_ip>" + spbill_create_ip + "</spbill_create_ip>"+
		"<total_fee>"+ String.valueOf(total_fee)+ "</total_fee>"+
		"<trade_type>" + trade_type + "</trade_type>" + "</xml>";
		System.out.println("xml : " +xml);

		//转换成
		//xml=new String(xml.toString().getBytes(), "ISO8859-1");  ;

		String allParameters = "";
		try {
			System.out.println("11111111111");
//			allParameters = reqHandler.genPackage(packageParams);
			System.out.println("allParameters  : "  + allParameters);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String createOrderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder"; //固定不变
		String prepay_id = "";
		try {
			System.out.println("begin get prepay_id.........................");
			prepay_id = new GetWxOrderno().getPayNo(createOrderURL, xml);
			System.out.println("end get prepay_id : " + prepay_id);
			if (!StringUtils.hasText(prepay_id)) {//prepay_id.equals("")
				request.setAttribute("ErrorMsg", "");
//				response.sendRedirect("error.jsp");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		SortedMap<String, String> finalpackage = new TreeMap<String, String>();
		String appid2 = appid;
		String timestamp = Sha1Util.getTimeStamp();
		String nonceStr2 = nonce_str;
		String prepay_id2 = "prepay_id=" + prepay_id;
		System.out.println("prepay_id2 : " + prepay_id2);
		String packages = prepay_id2;
		finalpackage.put("appId", appid2);
		finalpackage.put("timeStamp", timestamp);
		finalpackage.put("nonceStr", nonceStr2);
		finalpackage.put("package", packages);
		finalpackage.put("signType", "MD5");
		System.out.println("begin finalsign...........................");
		String finalsign = reqHandler.createSign(finalpackage);
		System.out.println("end finalsign : " + finalsign);
		System.out.println("wechat_pay.html?appid=" + appid2 + "&timeStamp="
				+ timestamp + "&nonceStr=" + nonceStr2 + "&package=" + packages
				+ "&sign=" + finalsign);




		JSONObject json = new JSONObject();
		json.put("appid", appid2);
		json.put("timeStamp", timestamp);
		json.put("nonceStr", nonceStr2);
		json.put("package", packages);
		json.put("sign", finalsign);
		json.put("order_id", order_id);

		json.put("code", 1);



		PrintWriter out = response.getWriter();
        out.write(json.toString());

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 *
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public static void main(String[] args) {
		Calendar c=Calendar.getInstance();
		System.out.println(c.getTimeInMillis());
		//System.out.println(c.getTime());
	}


}
