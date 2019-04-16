package customer.supu.dto;



import customer.supu.po.CourseStudioTime;

public class CourseStudioTimeDto extends CourseStudioTime{

	//编辑
	private Boolean isEdit;

	//是否选中
	private boolean checked=true;

	//工作室一天中  所有上课时间列表
	private String timelist;


	public String getTimelist() {
		return timelist;
	}

	public void setTimelist(String timelist) {
		this.timelist = timelist;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}


}
