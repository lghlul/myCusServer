package com.answer.domain;

public class User {
	private long userID;
	private String openID;
	private long createTime;
	private float score;
	private float usedScore;
	private String userImg;
	private String jobNum;
	private String userName;
	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getJobNum() {
		return jobNum;
	}

	public void setJobNum(String jobNum) {
		this.jobNum = jobNum;
	}



	public long getUserID() {
		return this.userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getOpenID() {
		return this.openID;
	}

	public void setOpenID(String openID) {
		this.openID = openID;
	}

	public long getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public float getUsedScore() {
		return usedScore;
	}

	public void setUsedScore(float usedScore) {
		this.usedScore = usedScore;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public String toString() {
		return "User [userID=" + this.userID + ", openID=" + this.openID + ", createTime=" + this.createTime
				+ ", score=" + this.score + "]";
	}
}
