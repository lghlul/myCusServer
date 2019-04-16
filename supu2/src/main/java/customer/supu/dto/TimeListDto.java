package customer.supu.dto;

public class TimeListDto {

	//时间
	private String time;
	
	
	//当前时间预约次数
	private Integer count;

	//是否选中
	private boolean checked=false;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
