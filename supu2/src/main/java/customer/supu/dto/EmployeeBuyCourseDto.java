package customer.supu.dto;

import customer.supu.common.utils.StringUtils;
import customer.supu.po.EmployeeBuyCourse;

public class EmployeeBuyCourseDto extends EmployeeBuyCourse{

	//教练名字
	private String coachname;

	//教练昵称
	private String nickname;

	//次私教课已经预约次数
	private Integer appointCount;

	//教练id
	private Integer coachs;

	//教练照片1
	private String coachimg1;

	//教练照片2
	private String coachimg2;

	//教练照片3
	private String coachimg3;

	//教练照片4
	private String coachimg4;

	//教练照片5
	private String coachimg5;

	//获取图片
	private String image;

	//结束时间
	private String endtime;

	//教练电话
	private String phonenumber;

	//私教课名称
	private String coursename;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public Integer getCoachs() {
		return coachs;
	}

	public void setCoachs(Integer coachs) {
		this.coachs = coachs;
	}

	public Integer getAppointCount() {
		return appointCount;
	}

	public void setAppointCount(Integer appointCount) {
		this.appointCount = appointCount;
	}

	public String getCoachname() {
		return coachname;
	}

	public void setCoachname(String coachname) {
		this.coachname = coachname;
	}

	public String getCoachimg1() {
		return coachimg1;
	}

	public void setCoachimg1(String coachimg1) {
		this.coachimg1 = coachimg1;
	}

	public String getCoachimg2() {
		return coachimg2;
	}

	public void setCoachimg2(String coachimg2) {
		this.coachimg2 = coachimg2;
	}

	public String getCoachimg3() {
		return coachimg3;
	}

	public void setCoachimg3(String coachimg3) {
		this.coachimg3 = coachimg3;
	}

	public String getCoachimg4() {
		return coachimg4;
	}

	public void setCoachimg4(String coachimg4) {
		this.coachimg4 = coachimg4;
	}

	public String getCoachimg5() {
		return coachimg5;
	}

	public void setCoachimg5(String coachimg5) {
		this.coachimg5 = coachimg5;
	}

	public String getImage() {
		if(StringUtils.hasText(getCoachimg1())){
			return getCoachimg1();
		}else{
			if(StringUtils.hasText(getCoachimg2())){
				return getCoachimg2();
			}else{
				if(StringUtils.hasText(getCoachimg3())){
					return getCoachimg3();
				}else{
					if(StringUtils.hasText(getCoachimg4())){
						return getCoachimg4();
					}else{
						if(StringUtils.hasText(getCoachimg5())){
							return getCoachimg5();
						}
					}
				}
			}
		}
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
