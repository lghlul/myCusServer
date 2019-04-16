package customer.supu.dto;

import java.util.List;

import customer.supu.po.CourseExcGroupWithBLOBs;
import customer.supu.po.CoursePriCoach;

public class CourseAllDto {
	//精品团课
	private CourseExcGroupWithBLOBs courseExcGroup;

	//私教课
	private CoursePriCoach  coursePriCoach;


	//课程标签 当type=1时  有课程标签
	private List<CourseDes> courseDes;


	public CourseExcGroupWithBLOBs getCourseExcGroup() {
		return courseExcGroup;
	}


	public void setCourseExcGroup(CourseExcGroupWithBLOBs courseExcGroup) {
		this.courseExcGroup = courseExcGroup;
	}


	public CoursePriCoach getCoursePriCoach() {
		return coursePriCoach;
	}


	public void setCoursePriCoach(CoursePriCoach coursePriCoach) {
		this.coursePriCoach = coursePriCoach;
	}


	public List<CourseDes> getCourseDes() {
		return courseDes;
	}


	public void setCourseDes(List<CourseDes> courseDes) {
		this.courseDes = courseDes;
	}

}
