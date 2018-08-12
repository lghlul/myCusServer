package com.cad.domain;

/**
 * 
 * @author Lu
 * @Description: 返回结果bean
 * @Package com.cad.domain
 * @date 2017年4月19日 下午10:18:34 
 * @version V1.0
 */
public class Result {
	
	/**
	 * 返回的数据
	 */
	private Object resultData;
	/**
	 * 访问数量
	 */
	private String visitNum;


	private int code;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getResultData() {
		return resultData;
	}
	public void setResultData(Object resultData) {
		this.resultData = resultData;
	}
	public String getVisitNum() {
		return visitNum;
	}
	public void setVisitNum(String visitNum) {
		this.visitNum = visitNum;
	}
	
	
	

}
