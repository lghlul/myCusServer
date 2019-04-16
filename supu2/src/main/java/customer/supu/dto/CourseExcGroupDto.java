package customer.supu.dto;

import java.util.Date;
import java.util.List;

import customer.supu.po.CourseExcGroup;

public class CourseExcGroupDto extends CourseExcGroup{


	//课程开始的年
	private String year;

	//课程开始的月
	private String month;

	//课程开始的日
	private String day;
	//课程开始时间 8：00
	private String startTime;
	//课程结束时间   10：00
	private String endTime;


	//开始日期
	private Date sdate;

	//结束日期
	private Date edate;

	private Integer commentCount;

	private Integer totalStar;

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public Integer getTotalStar() {
		return totalStar;
	}

	public void setTotalStar(Integer totalStar) {
		this.totalStar = totalStar;
	}

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public Date getEdate() {
		return edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	//教练名称
	private String coachnames;

	//课程状态：1可预约  2需排队 3紧张  4临近课程开始时间，不可排队    5课程进行中，不可排队   6:人数已经满  7未开放（三天内的课程可以预约，第四天的课程状态均为未开放）
	private Integer courseStatus=7;

	//约课排队状态
	private Integer queueStatus;


	private String courseStartTime;

	//排期
	private List<CourseExcTimeDto> courseExcTimeDtos;

	public List<CourseExcTimeDto> getCourseExcTimeDtos() {
		return courseExcTimeDtos;
	}

	public void setCourseExcTimeDtos(List<CourseExcTimeDto> courseExcTimeDtos) {
		this.courseExcTimeDtos = courseExcTimeDtos;
	}

	public String getCourseStartTime() {
		return courseStartTime;
	}

	public void setCourseStartTime(String courseStartTime) {
		this.courseStartTime = courseStartTime;
	}

	public Integer getQueueStatus() {
		return queueStatus;
	}

	public void setQueueStatus(Integer queueStatus) {
		this.queueStatus = queueStatus;
	}

	//预约本课程的人数
	private Integer  appointcount;

	//使用门店名称
	private String storename;

	//门店id
	private Integer storeid;

	//教练名称
	private String coachname;

	public String getCoachname() {
		return coachname;
	}

	public void setCoachname(String coachname) {
		this.coachname = coachname;
	}

	public Integer getStoreid() {
		return storeid;
	}

	public void setStoreid(Integer storeid) {
		this.storeid = storeid;
	}

	//团课id
	private Integer courseid;

	//教练电话
	private String phonenumber;



	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
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
	public Integer getCourseid() {
		return courseid;
	}

	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}

	public String getStorename() {
		return storename;
	}

	public void setStorename(String storename) {
		this.storename = storename;
	}

	public Integer getAppointcount() {
		return appointcount;
	}

	public void setAppointcount(Integer appointcount) {
		this.appointcount = appointcount;
	}

	public Integer getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(Integer courseStatus) {
		this.courseStatus = courseStatus;
	}

	public String getCoachnames() {
		return coachnames;
	}

	public void setCoachnames(String coachnames) {
		this.coachnames = coachnames;
	}
}
