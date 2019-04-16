package customer.supu.common.po;

public class Page {
	private String limit="20";
	private String offset="0";
	private Integer pageindex;
	private Integer pageSize;
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	public String getOffset() {
		return offset;
	}
	public void setOffset(String offset) {
		this.offset = offset;
	}
	public Integer getPageindex() {
		return pageindex;
	}
	public void setPageindex(Integer pageindex) {
		this.pageindex = pageindex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


}
