package customer.supu.dto;

import java.util.List;

import customer.supu.po.Coach;
import customer.supu.po.CoachCertificate;

public class CoachEditNextDto extends Coach{
	private List<CoachCertificate> coachCertificate;

	public List<CoachCertificate> getCoachCertificate() {
		return coachCertificate;
	}

	public void setCoachCertificate(List<CoachCertificate> coachCertificate) {
		this.coachCertificate = coachCertificate;
	}

}
