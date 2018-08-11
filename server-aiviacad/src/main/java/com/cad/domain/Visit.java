package com.cad.domain;

/**
 * 
 * @author Lu
 * @Description: 访问bean
 * @Package com.cad.domain
 * @date 2017年4月19日 下午10:18:51 
 * @version V1.0
 */
public class Visit {

	/**
	 * 访问者ip
	 */
	private String ip;
	/**
	 * 访问者国家
	 */
	private String country;
	/**
	 * 访问者省
	 */
	private String province;
	/**
	 * 访问者城市
	 */
	private String city;
	/**
	 * 访问的方法
	 */
	private String method;
	
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
