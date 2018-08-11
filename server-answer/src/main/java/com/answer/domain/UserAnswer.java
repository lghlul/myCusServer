package com.answer.domain;

/**
 * 
 * @author Lu
 *
 */
public class UserAnswer {
	
	private long id;
	/**
	 * 用户标识
	 */
	private String openID;
	/**
	 * 题id
	 */
	private long questionID;
	/**
	 * 类型id
	 */
	private long typeID;
	/**
	 * 用户回答的答案id
	 */
	private String answerID;
	/**
	 * 是否正确
	 */
	private byte isRight;
	/**
	 * 1未记分2已计分
	 */
	private byte status;
	
	private long createTime;
	
	
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOpenID() {
		return openID;
	}
	public void setOpenID(String openID) {
		this.openID = openID;
	}
	public long getQuestionID() {
		return questionID;
	}
	public void setQuestionID(long questionID) {
		this.questionID = questionID;
	}
	public long getTypeID() {
		return typeID;
	}
	public void setTypeID(long typeID) {
		this.typeID = typeID;
	}
	public byte getIsRight() {
		return isRight;
	}
	public void setIsRight(byte isRight) {
		this.isRight = isRight;
	}
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	public String getAnswerID() {
		return answerID;
	}
	public void setAnswerID(String answerID) {
		this.answerID = answerID;
	}
	
	
	

}
