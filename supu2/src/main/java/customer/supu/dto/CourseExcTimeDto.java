package customer.supu.dto;


import java.util.List;

import customer.supu.common.utils.DateTimeUtil;
import customer.supu.common.utils.StringUtils;
import customer.supu.po.CourseExcTime;

public class CourseExcTimeDto extends CourseExcTime{


	//进入边界页面    通过数据库判断是否可以编辑
	private Boolean isEdit;

	//拼接星期
	private String concatweek;

	//星期名称
	private String weekname;

	public String getWeekname() {
		return weekname;
	}



	public void setWeekname(String weekname) {
		this.weekname = weekname;
	}





	public String getConcatweek() {
		StringBuffer buffer=new StringBuffer();
		if(StringUtils.hasText(concatweek)){
			String []concatweeks=concatweek.split("[,，]");
			if(null !=concatweeks ){
				for(int i=0;i<concatweeks.length;i++){
					buffer.append(DateTimeUtil.getWeek(Integer.parseInt(concatweeks[i]))+",");
				}
				concatweek=buffer.substring(0,buffer.length()-1);
			}
		}

		return concatweek;
	}



	public void setConcatweek(String concatweek) {
		this.concatweek = concatweek;
	}





	private List<CourseExcTime> courseExcTimeList;

	public Boolean getIsEdit() {
		return isEdit;
	}



	public List<CourseExcTime> getCourseExcTimeList() {
		return courseExcTimeList;
	}

	public void setCourseExcTimeList(List<CourseExcTime> courseExcTimeList) {
		this.courseExcTimeList = courseExcTimeList;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}



}
