package com.answer.domain;

public class JobNumBean {
	private long id;
	private String jobNum;
	/**
	 * 状态1整除2已使用
	 */
	private byte status;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	public String getJobNum() {
		return jobNum;
	}
	public void setJobNum(String jobNum) {
		this.jobNum = jobNum;
	}
	
	
}
