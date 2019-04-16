package customer.supu.dto;

import customer.supu.po.Order;

public class OrderDto extends Order{

	//客户账号
	private String ecode;

	//订单名称
	private String ordername;

	//开始时间
	private String starttime;

	//结束时间
	private String endtime;

	//coachnames
	private String coachnames;

	public String getCoachnames() {
		return coachnames;
	}

	public void setCoachnames(String coachnames) {
		this.coachnames = coachnames;
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

	public String getEcode() {
		return ecode;
	}

	public void setEcode(String ecode) {
		this.ecode = ecode;
	}

	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}
}
