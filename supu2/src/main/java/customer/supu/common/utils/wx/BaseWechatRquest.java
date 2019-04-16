package customer.supu.common.utils.wx;

import java.util.SortedMap;

import customer.supu.common.utils.wx.entity.WxOrderInfoEntity;



/**
 * 微信服务(CMS)基础请求服务接口
 * 包含两个基础服务请求：
 * 1.获取access_token
 * 2.获取微信服务器IP地址
 * @author clq
 */
public interface BaseWechatRquest {

	/**
	 * 获取access_token
	 * @param appid
	 * @param secret
	 * @return
	 */
	String getAccessToken(String appid, String secret);
	
	/**
	 * 获取微信服务器IP地址
	 * @param aToken
	 * @return
	 */
	String getWechatServierIp(String aToken);
	
	/**
	 * 获取jsapi_ticket
	 * @param aToken
	 * @return
	 */
	String getJsapiTicket(String aToken);
	
	String getOpenIdByCode(String code, String appid, String secret);

	String getFansInfo(String openId, String aToken);
	
	String getOrderSignKey(WxOrderInfoEntity wxOrderInfoEntity);
	
	String createPackageValue(String appid, String appKey, String prepay_id,String nonce_str);
	
	String createSign(SortedMap<String, String> packageParams, String AppKey);

}
