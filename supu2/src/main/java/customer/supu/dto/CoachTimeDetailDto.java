package customer.supu.dto;

import java.util.Date;

import customer.supu.po.CoachTime;

public class CoachTimeDetailDto {


	//指定事件类型
	private Integer type;


	//教练id
	private Integer coachId;


	//当选择时间为 每周的时候
	private Integer week;



	//当选择时间  为 指定日期的时候有
	private String day;


	//开始时间
	private String startTime;

	//结束时间
	private String endTime;

	private Date addTime;

	//选择年月
	private String selectYmonth;


	public String getSelectYmonth() {
		return selectYmonth;
	}

	public void setSelectYmonth(String selectYmonth) {
		this.selectYmonth = selectYmonth;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getCoachId() {
		return coachId;
	}

	public void setCoachId(Integer coachId) {
		this.coachId = coachId;
	}

	public Integer getWeek() {
		return week;
	}

	public void setWeek(Integer week) {
		this.week = week;
	}



	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
