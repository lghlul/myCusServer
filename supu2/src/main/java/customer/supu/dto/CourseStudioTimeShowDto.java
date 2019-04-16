package customer.supu.dto;

import java.util.List;

import customer.supu.po.CourseStudioTime;

public class CourseStudioTimeShowDto {


	//是否可以编辑
	private boolean isedit;



	//天
	private String day;


	//当天的工作室排期
	private List<CourseStudioTimeDto> courseStudioTime;




	public List<CourseStudioTimeDto> getCourseStudioTime() {
		return courseStudioTime;
	}


	public void setCourseStudioTime(List<CourseStudioTimeDto> courseStudioTime) {
		this.courseStudioTime = courseStudioTime;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public boolean isIsedit() {
		return isedit;
	}


	public void setIsedit(boolean isedit) {
		this.isedit = isedit;
	}



}
