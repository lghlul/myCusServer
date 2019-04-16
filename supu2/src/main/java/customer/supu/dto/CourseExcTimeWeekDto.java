package customer.supu.dto;

import java.util.List;

import customer.supu.po.CourseExcTime;

public class CourseExcTimeWeekDto {
	//周一
	private CourseExcTime list_mon;

	//周二
	private CourseExcTime list_tue;

    //三
	private CourseExcTime list_wed;

	//四
	private CourseExcTime list_ths;
	//五
	private CourseExcTime list_fri;

	//六
	private CourseExcTime list_sat;

	//日
	private CourseExcTime list_sun;

	public CourseExcTime getList_mon() {
		return list_mon;
	}

	public void setList_mon(CourseExcTime list_mon) {
		this.list_mon = list_mon;
	}



	public CourseExcTime getList_tue() {
		return list_tue;
	}

	public void setList_tue(CourseExcTime list_tue) {
		this.list_tue = list_tue;
	}

	public CourseExcTime getList_wed() {
		return list_wed;
	}

	public void setList_wed(CourseExcTime list_wed) {
		this.list_wed = list_wed;
	}

	public CourseExcTime getList_ths() {
		return list_ths;
	}

	public void setList_ths(CourseExcTime list_ths) {
		this.list_ths = list_ths;
	}

	public CourseExcTime getList_fri() {
		return list_fri;
	}

	public void setList_fri(CourseExcTime list_fri) {
		this.list_fri = list_fri;
	}

	public CourseExcTime getList_sat() {
		return list_sat;
	}

	public void setList_sat(CourseExcTime list_sat) {
		this.list_sat = list_sat;
	}

	public CourseExcTime getList_sun() {
		return list_sun;
	}

	public void setList_sun(CourseExcTime list_sun) {
		this.list_sun = list_sun;
	}



}
