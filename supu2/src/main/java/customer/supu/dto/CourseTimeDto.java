package customer.supu.dto;

import java.util.List;

import customer.supu.po.CoachTime;
import customer.supu.po.EmployeeAppointCourse;

public class CourseTimeDto {

	//简写日期
	private String simpleDte;

	//星期
	private String week;

	//教练时间集合
	private List<CoachTime> coachTimes;

	//预约日期
	private String appointTime;

	private List<EmployeeAppointCourse> employeeAppointCourses;

	//工作室课程id
	private Integer courseid;
	


	public List<EmployeeAppointCourse> getEmployeeAppointCourses() {
		return employeeAppointCourses;
	}

	public void setEmployeeAppointCourses(
			List<EmployeeAppointCourse> employeeAppointCourses) {
		this.employeeAppointCourses = employeeAppointCourses;
	}

	public Integer getCourseid() {
		return courseid;
	}

	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}

	public String getAppointTime() {
		return appointTime;
	}

	public void setAppointTime(String appointTime) {
		this.appointTime = appointTime;
	}

	//教练可选时间集合
	private List<TimeListDto> timeListDtos;

	//工作室可选时间
	private List<CourseStudioTimeDto> courseStudioTimeDtos;

	public List<CourseStudioTimeDto> getCourseStudioTimeDtos() {
		return courseStudioTimeDtos;
	}

	public void setCourseStudioTimeDtos(
			List<CourseStudioTimeDto> courseStudioTimeDtos) {
		this.courseStudioTimeDtos = courseStudioTimeDtos;
	}

	public String getSimpleDte() {
		return simpleDte;
	}

	public void setSimpleDte(String simpleDte) {
		this.simpleDte = simpleDte;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public List<CoachTime> getCoachTimes() {
		return coachTimes;
	}

	public void setCoachTimes(List<CoachTime> coachTimes) {
		this.coachTimes = coachTimes;
	}

	public List<TimeListDto> getTimeListDtos() {
		return timeListDtos;
	}

	public void setTimeListDtos(List<TimeListDto> timeListDtos) {
		this.timeListDtos = timeListDtos;
	}

}
