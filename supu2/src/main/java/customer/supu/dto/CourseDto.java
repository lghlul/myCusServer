package customer.supu.dto;

public class CourseDto {
	//主键编号
	private Integer id;
	//课程名称
	private String coursename;
	//课程ID
	private Integer courseid;
	//课程类型
	private Integer coursetype;
	//课程状态
	private Integer status;

	//预约时间
	private String appointtime;

	//门店名称
	private String storename;

	//预约开始时间
	private String starttime;

	//预约结束时间
	private String endtime;

	//团课类型
	private Integer type;

	//教练
	private String coachs;

	//教练名字
	private String coachname;

	//是否为体验课
	private Integer isexperience;

	public Integer getIsexperience() {
		return isexperience;
	}
	public void setIsexperience(Integer isexperience) {
		this.isexperience = isexperience;
	}
	public String getCoachs() {
		return coachs;
	}
	public void setCoachs(String coachs) {
		this.coachs = coachs;
	}
	public String getCoachname() {
		return coachname;
	}
	public void setCoachname(String coachname) {
		this.coachname = coachname;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getAppointtime() {
		return appointtime;
	}
	public void setAppointtime(String appointtime) {
		this.appointtime = appointtime;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
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


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public Integer getCoursetype() {
		return coursetype;
	}
	public void setCoursetype(Integer coursetype) {
		this.coursetype = coursetype;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getCourseid() {
		return courseid;
	}
	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}

	
	

}
