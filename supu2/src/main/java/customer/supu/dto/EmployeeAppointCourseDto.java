package customer.supu.dto;

import customer.supu.po.EmployeeAppointCourse;

public class EmployeeAppointCourseDto extends EmployeeAppointCourse{

	//账号
	private String username;

	//拼接教练名称
	private String coachnames;

	//查询  教练名称
	private Integer coachname;

	//门店名称
	private String storename;

	//课程名称
	private String coursename;

	//课程类型名称  用来导出数据
	private String courseTypeName;


	//课程状态  取消   或预约
	private String courseStatus;


	public String getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}

	public String getCourseTypeName() {
		return courseTypeName;
	}

	public void setCourseTypeName(String courseTypeName) {
		this.courseTypeName = courseTypeName;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCoachnames() {
		return coachnames;
	}

	public void setCoachnames(String coachnames) {
		this.coachnames = coachnames;
	}


	public Integer getCoachname() {
		return coachname;
	}

	public void setCoachname(Integer coachname) {
		this.coachname = coachname;
	}

	public String getStorename() {
		return storename;
	}

	public void setStorename(String storename) {
		this.storename = storename;
	}
}
