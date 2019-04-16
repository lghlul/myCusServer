package customer.supu.dto;

import java.util.List;

import customer.supu.po.BasicData;


public class BasicDataCheckDto extends BasicData{

	private boolean checked=false;

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
