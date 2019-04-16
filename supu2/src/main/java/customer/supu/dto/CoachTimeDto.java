package customer.supu.dto;

import java.util.List;

import customer.supu.po.Coach;
import customer.supu.po.CoachTime;

public class CoachTimeDto extends CoachTime{
	//教练
	private List<Coach> coachs;

	//时间list
	private List<CoachTimeDetailDto> coachTimeList;

	private String coachname;
	private String coachId;

	public String getCoachname() {
		return coachname;
	}

	public void setCoachname(String coachname) {
		this.coachname = coachname;
	}

	public String getCoachId() {
		return coachId;
	}

	public void setCoachId(String coachId) {
		this.coachId = coachId;
	}

	public List<Coach> getCoachs() {
		return coachs;
	}

	public void setCoachs(List<Coach> coachs) {
		this.coachs = coachs;
	}

	public List<CoachTimeDetailDto> getCoachTimeList() {
		return coachTimeList;
	}

	public void setCoachTimeList(List<CoachTimeDetailDto> coachTimeList) {
		this.coachTimeList = coachTimeList;
	}

}
