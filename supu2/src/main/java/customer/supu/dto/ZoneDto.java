package customer.supu.dto;

import customer.supu.po.Zone;

public class ZoneDto extends Zone{
	private boolean checked;

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

}
