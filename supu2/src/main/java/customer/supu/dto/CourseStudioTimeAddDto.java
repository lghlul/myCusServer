package customer.supu.dto;

import java.util.List;

import customer.supu.po.CourseStudioTime;

public class CourseStudioTimeAddDto {

	//工作室排期list
	private List<CourseStudioTime> addCourseStudio;

	public List<CourseStudioTime> getAddCourseStudio() {
		return addCourseStudio;
	}

	public void setAddCourseStudio(List<CourseStudioTime> addCourseStudio) {
		this.addCourseStudio = addCourseStudio;
	}


}
