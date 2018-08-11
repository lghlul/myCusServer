package com.answer.domain;

public class WrongRecord {

	private long id;
	private long questionID;
	private String openID;
	private String answerID;
	private long createTime;
	private String timeStr;
	private long typeID;
	private String typeDesc;
	private String quesDesc;
	
	
	public String getQuesDesc() {
		return quesDesc;
	}
	public void setQuesDesc(String quesDesc) {
		this.quesDesc = quesDesc;
	}
	/**
	 * 1正常2删除
	 */
	private byte status;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getQuestionID() {
		return questionID;
	}
	public void setQuestionID(long questionID) {
		this.questionID = questionID;
	}
	public String getOpenID() {
		return openID;
	}
	public void setOpenID(String openID) {
		this.openID = openID;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public long getTypeID() {
		return typeID;
	}
	public void setTypeID(long typeID) {
		this.typeID = typeID;
	}
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	public String getTypeDesc() {
		return typeDesc;
	}
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
	public String getTimeStr() {
		return timeStr;
	}
	public void setTimeStr(String timeStr) {
		this.timeStr = timeStr;
	}
	public String getAnswerID() {
		return answerID;
	}
	public void setAnswerID(String answerID) {
		this.answerID = answerID;
	}
	
	
	
	
}
