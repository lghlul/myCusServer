package customer.supu.common.utils.wx.impl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import customer.supu.common.utils.DateTimeUtil;
import customer.supu.common.utils.exception.ServiceException;
import customer.supu.common.utils.wx.BaseWechatRquest;
import customer.supu.common.utils.wx.common.Constant;
import customer.supu.common.utils.wx.entity.WechatServiceUrlEntity;
import customer.supu.common.utils.wx.entity.WxOrderInfoEntity;
import customer.supu.common.utils.wx.util.MD5SignUtil;
import customer.supu.common.utils.wx.util.MD5Util;
import customer.supu.common.utils.wx.util.MessageUtil;
import customer.supu.common.utils.wx.util.SDKRuntimeException;




/**
 * 微信服务(CMS)基础请求服务接口实现类
 * 包含两个基础服务请求：
 * 1.获取access_token
 * 2.获取微信服务器IP地址
 * @author clq
 *
 */
public class BaseWechatRquestImpl extends BaseRequest implements BaseWechatRquest{

	private Logger log = LoggerFactory.getLogger(BaseWechatRquestImpl.class);
	
	
	
	public BaseWechatRquestImpl() {
		super(null);
		we = new WechatServiceUrlEntity();
	}

	@Override
	public String getAccessToken(String appid, String secret) {
		we.setServiceName(Constant.wechatServiceName.TOKEN);
		Map<String, String> paramMap = new HashMap<String, String>();
		//access_token=ACCESS_TOKEN
		paramMap.put("appid", appid);
		paramMap.put("secret", secret);
		paramMap.put("grant_type", "client_credential");
		we.setParamMap(paramMap);
		String url = this.getUrl(we);
		String jsonStr = null;
		try {
			jsonStr = httpClientUtil.postData(url);

		} catch (ServiceException e) {
			e.printStackTrace();
			
		}

		System.out.println(jsonStr);
		return jsonStr;
	}

	/**
	 * https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN
	 */
	@Override
	public String getWechatServierIp(String aToken) {
		
		this.setAccessToken(aToken);
		we.setServiceName(Constant.wechatServiceName.GETCALLBACKIP);
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("access_token", this.accessToken);
		we.setParamMap(paramMap);
		
		String url = this.getUrl(we);
		String jsonStr = null;
		
		try {
			jsonStr = httpClientUtil.postData(url);
		} catch (ServiceException e) {
			log.error(e.getMsg());
			e.printStackTrace();
			
		}
		
		return jsonStr;
	}
	
	/**
	 * https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi
	 */
	@Override
	public String getJsapiTicket(String aToken) {
		this.setAccessToken(aToken);
		we.setServiceName(Constant.wechatServiceName.TICKET);
		we.setOpName(Constant.wechatOpName.GETTICKET);
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("access_token", this.accessToken);
		paramMap.put("type", "jsapi");
		System.out.println(paramMap);
		we.setParamMap(paramMap);
		
		String url = this.getUrl(we);
		
		String jsonStr = null;
		try {
			jsonStr = httpClientUtil.postData(url);
		} catch (ServiceException e) {
			e.printStackTrace();
			
		}
		System.out.println(jsonStr);
		return jsonStr;
	}
	
	// https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
	public String getOpenIdByCode(String code, String appid, String secret){
		we.setWebFlag("oauth2");
		we.setServiceName(Constant.wechatServiceName.ACCESS_TOKEN);
		Map<String, String> paramMap = new HashMap<String, String>();
		//access_token=ACCESS_TOKEN
		paramMap.put("appid", appid);
		paramMap.put("secret", secret);
		paramMap.put("code", code);
		paramMap.put("grant_type", "authorization_code");
		we.setParamMap(paramMap);
		String url = this.getUrl(we);
		String jsonStr = null;
		try {
			jsonStr = httpClientUtil.postData(url);

		} catch (ServiceException e) {
			e.printStackTrace();
			
		}

		//String url = 
		return jsonStr;
	}
	
	@Override
	// https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
	public String getFansInfo(String openId, String aToken) {
		this.setAccessToken(aToken);
		we.setServiceName(Constant.wechatServiceName.USER);
		we.setOpName(Constant.wechatOpName.INFO);
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("access_token", this.accessToken);
		paramMap.put("openid", openId);
		paramMap.put("lang", "zh_CN");
		we.setParamMap(paramMap);
		String url = this.getUrl(we);
		String jsonStr = null;
		try {
			jsonStr = httpClientUtil.postData(url);

		} catch (ServiceException e) {
			e.printStackTrace();
			
		}

		return jsonStr;
	}

	
	// test
	public static void main(String[] args) {
		String stringA = "appid=wxd930ea5d5a258f4f&body=test&device_info=1000&mch_id=10000100&nonce_str=ibuaiVcKdpRxkhJA";
		String key = "192006250b4c09247ec02edce69f6a2d";
		String stringSignTemp=stringA+"&key=" + key;
		
		String aa = "appid=wxbbdc4a1c1f7c053&body=test&device_info=WEB&mch_id=1263327701&nonce_str=2VqWubUwWdK7QhhE&key=QWERTYUIOPlkjhgfdsaZXCVBNM123456";
		
		try {
			System.out.println(MD5SignUtil.Sign(stringA, key));
			System.out.println(MD5Util.MD5(aa).toUpperCase());
		} catch (SDKRuntimeException e) {
			e.printStackTrace();
		}
		
	}

	//pay/unifiedorder UNIFIEDORDER
	@Override
	public String getOrderSignKey(WxOrderInfoEntity wxOrderInfoEntity) {
		String orderXml = MessageUtil.messageToXML(wxOrderInfoEntity);
		orderXml = orderXml.replace("__", "_");
		/*orderXml = orderXml.replace("<![CDATA[", "");
		orderXml = orderXml.replace("]]>", "");*/
		//return orderXml;
		 try {
			 orderXml =  new String(orderXml.toString().getBytes(), "ISO8859-1");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
		
		we.setWebFlag("order_sign_Url");
		we.setServiceName(Constant.wechatServiceName.PAY);
		we.setOpName(Constant.wechatOpName.UNIFIEDORDER);
		
		String content = orderXml;
		String url = this.getUrl(we);
		String jsonStr = null;
		try {
			jsonStr = httpClientUtil.postJSONData(url, content);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		return jsonStr;
	}
	
	
	public String createPackageValue(String appid, String appKey, String prepay_id,String nonce_str)  {
		SortedMap<String, String> nativeObj = new TreeMap<String, String>();
		nativeObj.put("appId", appid);
		nativeObj.put("timeStamp", String.valueOf(DateTimeUtil.getTimestamp(null)));
		nativeObj.put("nonceStr", nonce_str);
		nativeObj.put("package", "prepay_id=" + prepay_id);
		nativeObj.put("signType", "MD5");
		nativeObj.put("paySign", createSign(nativeObj, appKey));
		System.out.println(JSONObject.fromObject(nativeObj).toString());
		return JSONObject.fromObject(nativeObj).toString();
	}
	
	/**
	 * 创建md5摘要,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
	 */
	public String createSign(SortedMap<String, String> packageParams, String AppKey) {
		StringBuffer sb = new StringBuffer();
		Set es = packageParams.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + AppKey);
		String sign = MD5Util.MD5Encode(sb.toString(), "UTF-8").toUpperCase();
		return sign;
	}

}
