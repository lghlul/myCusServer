package customer.supu.common.utils.wx.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import customer.supu.common.utils.StringUtils;
import customer.supu.common.utils.SystemConfig;
import customer.supu.common.utils.exception.ServiceException;
import customer.supu.common.utils.exception.ServiceExceptionConstants;
import customer.supu.common.utils.wx.entity.WechatServiceUrlEntity;
import customer.supu.common.utils.wx.util.CollectionUtil;
import customer.supu.common.utils.wx.util.HttpClientUtil;



public class BaseRequest {
	
	protected String accessToken;
	
	protected String baseUrl;
	
	protected  HttpClientUtil httpClientUtil;
	
	protected WechatServiceUrlEntity we;
	
	private Logger log = LoggerFactory.getLogger(BaseRequest.class);
	
	
	public BaseRequest(String accessToken){
		this.setAccessToken(accessToken);
		httpClientUtil = new HttpClientUtil();
		httpClientUtil.setHttpclient(new DefaultHttpClient());
		we = new WechatServiceUrlEntity();
	}
	
	/**
	 * 设置accessToken
	 * @param accessToken
	 */
	protected void setAccessToken(String accessToken){
		this.accessToken = accessToken;
	}
	
	/**
	 * 设置微信请求服务的url
	 * 
	 * @param webFlag 
	 * @return
	 * @throws ServiceException 
	 */
	protected void initBaseUrl(String webFlag, String serviceName, String opName) throws ServiceException{
		
		if (StringUtils.isEmpty(serviceName)){
			log.error("serviceName is empty");
			throw new ServiceException(ServiceExceptionConstants.UNKNOWN_SERVICE_ERROR, "getMultipartData exception");
		}
		
		if (null == opName){
			opName = "";
		}else {
			if (opName.indexOf("/") < 0 ){
				opName = "/" + opName;
			}
		}
		this.baseUrl = SystemConfig.readValue(webFlag) + serviceName + opName;
	}
	
	/**
	 * 获取完整的服务请求URL
	 * @param we
	 * @return
	 */
	protected String getUrl(WechatServiceUrlEntity we){
		
		String wechatServiceUrl = null;
		try {
			this.initBaseUrl(we.getWebFlag(),we.getServiceName(), we.getOpName());
			
			wechatServiceUrl = this.baseUrl;
			
			Map<String, String> paramMap = we.getParamMap();
			List<String> paramList = new ArrayList<String>();
			
			if (CollectionUtil.isNotEmpty(paramMap)){
				for(Entry<String, String> entry : paramMap.entrySet()){
					paramList.add(entry.getKey()+"="+entry.getValue());
				}
			}
			
			for(int i = 0; i < paramList.size(); i++){
				if (i == 0){
					wechatServiceUrl = wechatServiceUrl+"?"+paramList.get(i);
				}else{
					wechatServiceUrl = wechatServiceUrl+"&"+paramList.get(i);
				}
			}
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wechatServiceUrl;
		
	}

}
