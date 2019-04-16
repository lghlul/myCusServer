package customer.supu.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import customer.supu.po.Comment;

public class CommentDto extends Comment{

//--------------作为条件查询
	//开始时间
	private String startTime;

	//结束时间
	private String endTime;

	//开始查询条数
	private Integer start;

	//查询条数
	private Integer end;

	//前端分页查询 评价的来源---评价来源：1私教2课程3门店
	private Integer source;

	//查询来源的ID   私教ID  OR  课程ID  OR  门店ID  
	private Integer sourceID;

	//回答者的姓名
	private String userName;

	//回答者的头像字段传输的是字符串
	private String head;
	
	//用户ID    信息
	private Integer EmployeeId;

	//分页参数
	private Integer limitstart;
	private Integer limitend;

	//门店 私教  课程的评论人数  以及平均分数	
	private Integer count;//平均分数
	private Integer number;//评论人数
	private String  addtimes;//评价添加时间String
	private String audittimes;//评价审核通过时间String

	public void setaddtimes() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.addtimes = simpleDateFormat.format(new Date());
	}
	
	
	public Integer getCount() {
		return count;
	}

	public String getAddtimes() {
		return addtimes;
	}

	public void setAddtimes(String addtimes) {
		this.addtimes = addtimes;
	}

	public String getAudittimes() {
		return audittimes;
	}

	public void setAudittimes(String audittimes) {
		this.audittimes = audittimes;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getLimitstart() {
		return limitstart;
	}

	public void setLimitstart(Integer limitstart) {
		this.limitstart = limitstart;
	}

	public Integer getLimitend() {
		return limitend;
	}

	public void setLimitend(Integer limitend) {
		this.limitend = limitend;
	}

	public Integer getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		EmployeeId = employeeId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public Integer getSourceID() {
		return sourceID;
	}

	public void setSourceID(Integer sourceID) {
		this.sourceID = sourceID;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	//显示-----------------------------------------------
	//评价人名称
	private String appraiserName;

	//教练名称
	private String coachName;

	//评价门店名称
	private String storeName;

	//评价课程类型  的名称
	private String courseTypeName;





	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getAppraiserName() {
		return appraiserName;
	}

	public void setAppraiserName(String appraiserName) {
		this.appraiserName = appraiserName;
	}

	public String getCoachName() {
		return coachName;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getCourseTypeName() {
		return courseTypeName;
	}

	public void setCourseTypeName(String courseTypeName) {
		this.courseTypeName = courseTypeName;
	}



}
