package customer.supu.common.utils.wx.entity;

import java.util.Map;

/**
 * 微信服务URL实体类
 * @author clq
 *
 */
public class WechatServiceUrlEntity {
	
	/** 
	 * 基本url标示，从配置文件中获取。
	 * 默认为"baseUrl"
	 */
	private String webFlag;
	
	/** 操作名称
	 *  操作类的微信服务请求需要设置操作名称
	 *  如果create add updata等
	 *  拼接到微信服务url中
	 */
	private String opName;
	
	/**
	 * 根据微信官方提供的文档描述，
	 * 各个服务请求划分不同的请求服务名称
	 * 如果用户分组管理类请求: groups
	 */
	private String serviceName;
	
	/**
	 * url后面拼接的参数
	 * 参数名称均需要根据官方提供文档描述的方式书写
	 */
	private Map<String, String> paramMap;

	public String getWebFlag() {
		if (("").equals(this.webFlag) || null == this.webFlag){
			return "baseUrl";
		}
		return webFlag;
	}
	
	public void setWebFlag(String webFlag) {
		this.webFlag = webFlag;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getOpName() {
		return opName;
	}

	public void setOpName(String opName) {
		this.opName = opName;
	}

	public Map<String, String> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String, String> paramMap) {
		this.paramMap = paramMap;
	}

}
