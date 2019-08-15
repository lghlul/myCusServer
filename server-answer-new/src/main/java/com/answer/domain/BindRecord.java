package com.answer.domain;

public class BindRecord {
	private long id;
	private String jobNum;
	private String openID;
	private int operYear;
	private int operMonth;
	private int operDay;
	private long operTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJobNum() {
		return jobNum;
	}

	public void setJobNum(String jobNum) {
		this.jobNum = jobNum;
	}

	public String getOpenID() {
		return openID;
	}

	public void setOpenID(String openID) {
		this.openID = openID;
	}

	public int getOperYear() {
		return operYear;
	}

	public void setOperYear(int operYear) {
		this.operYear = operYear;
	}

	public int getOperMonth() {
		return operMonth;
	}

	public void setOperMonth(int operMonth) {
		this.operMonth = operMonth;
	}

	public int getOperDay() {
		return operDay;
	}

	public void setOperDay(int operDay) {
		this.operDay = operDay;
	}

	public long getOperTime() {
		return operTime;
	}

	public void setOperTime(long operTime) {
		this.operTime = operTime;
	}

}
