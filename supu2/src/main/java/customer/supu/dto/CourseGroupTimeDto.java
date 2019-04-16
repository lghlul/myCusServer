package customer.supu.dto;

import java.util.List;

import customer.supu.po.CourseGroupTime;

public class CourseGroupTimeDto{

	private String year;

	private String month;

	private Integer courseId;

	private String day;

	private String starttime;

	private String endtime;

	private Integer id;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	//进入边界页面    通过数据库判断是否可以编辑
	private Boolean isEdit;




	/**
	 * 接收  前台传入的 该月的课程安排 时间
	 */
	private List<CourseGroupTime> CourseGroupTimeList;

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}

	public List<CourseGroupTime> getCourseGroupTimeList() {
		return CourseGroupTimeList;
	}

	public void setCourseGroupTimeList(List<CourseGroupTime> courseGroupTimeList) {
		CourseGroupTimeList = courseGroupTimeList;
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
	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
}
