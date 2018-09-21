package com.lu.domain;

/**
 * 课程管理
 * 
 * @author admin
 *
 */
public class PTrain {
	private Long trainId;
	private String trainName;
	private String trainInfo;
	private Long trainIstest;
	private Long trainStarttime;
	private Long trainEndtime;
	private String testInfo;
	private Long testStarttime;
	private String testStarttimeStr;
	private Long testEndtime;
	private String testEndtimeStr;
	private Long trainCreater;
	private Long trainCreattime;// 后端创建
	private Integer trainStatus;// 课程状态：创建时后端默认值
	private String orgId;// 组织机构
	private String testName;// 考试名称
	private Integer testMark;// 考试及格线
	// 考试状态 1.有未批阅考卷、2.未设置及格线、3.已设置及格线
	private Integer testStatus;// 考试
	private String userName;// 课程的创建人姓名



	/**
	 * 考试是否结束1否2是
	 */
	private int testIsFinish;

	public int getTestIsFinish() {
		return testIsFinish;
	}

	public void setTestIsFinish(int testIsFinish) {
		this.testIsFinish = testIsFinish;
	}

	public PTrain() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PTrain [trainId=" + trainId + ", trainName=" + trainName + ", trainInfo=" + trainInfo + ", trainIstest="
				+ trainIstest + ", trainStarttime=" + trainStarttime + ", trainEndtime=" + trainEndtime + ", testInfo="
				+ testInfo + ", testStarttime=" + testStarttime + ", testStarttimeStr=" + testStarttimeStr
				+ ", testEndtime=" + testEndtime + ", testEndtimeStr=" + testEndtimeStr + ", trainCreater="
				+ trainCreater + ", trainCreattime=" + trainCreattime + ", trainStatus=" + trainStatus + ", orgId="
				+ orgId + ", testName=" + testName + ", testMark=" + testMark + ", testStatus=" + testStatus
				+ ", userName=" + userName + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public PTrain(Long trainId, String trainName, String trainInfo, Long trainIstest, Long trainStarttime,
                  Long trainEndtime, String testInfo, Long testStarttime, String testStarttimeStr, Long testEndtime,
                  String testEndtimeStr, Long trainCreater, Long trainCreattime, Integer trainStatus, String orgId,
                  String testName, Integer testMark, Integer testStatus, String userName) {
		super();
		this.trainId = trainId;
		this.trainName = trainName;
		this.trainInfo = trainInfo;
		this.trainIstest = trainIstest;
		this.trainStarttime = trainStarttime;
		this.trainEndtime = trainEndtime;
		this.testInfo = testInfo;
		this.testStarttime = testStarttime;
		this.testStarttimeStr = testStarttimeStr;
		this.testEndtime = testEndtime;
		this.testEndtimeStr = testEndtimeStr;
		this.trainCreater = trainCreater;
		this.trainCreattime = trainCreattime;
		this.trainStatus = trainStatus;
		this.orgId = orgId;
		this.testName = testName;
		this.testMark = testMark;
		this.testStatus = testStatus;
		this.userName = userName;
	}

	public Integer getTestMark() {
		return testMark;
	}

	public void setTestMark(Integer testMark) {
		this.testMark = testMark;
	}

	public Long getTrainId() {
		return trainId;
	}

	public void setTrainId(Long trainId) {
		this.trainId = trainId;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getTrainInfo() {
		return trainInfo;
	}

	public void setTrainInfo(String trainInfo) {
		this.trainInfo = trainInfo;
	}

	public Long getTrainIstest() {
		return trainIstest;
	}

	public void setTrainIstest(Long trainIstest) {
		this.trainIstest = trainIstest;
	}

	public Long getTrainStarttime() {
		return trainStarttime;
	}

	public void setTrainStarttime(Long trainStarttime) {
		this.trainStarttime = trainStarttime;
	}

	public Long getTrainEndtime() {
		return trainEndtime;
	}

	public void setTrainEndtime(Long trainEndtime) {
		this.trainEndtime = trainEndtime;
	}

	public String getTestInfo() {
		return testInfo;
	}

	public void setTestInfo(String testInfo) {
		this.testInfo = testInfo;
	}

	public Long getTestStarttime() {
		return testStarttime;
	}

	public void setTestStarttime(Long testStarttime) {
		this.testStarttime = testStarttime;
	}

	public Long getTestEndtime() {
		return testEndtime;
	}

	public void setTestEndtime(Long testEndtime) {
		this.testEndtime = testEndtime;
	}

	public Long getTrainCreater() {
		return trainCreater;
	}

	public void setTrainCreater(Long trainCreater) {
		this.trainCreater = trainCreater;
	}

	public Long getTrainCreattime() {
		return trainCreattime;
	}

	public void setTrainCreattime(Long trainCreattime) {
		this.trainCreattime = trainCreattime;
	}

	public Integer getTrainStatus() {
		return trainStatus;
	}

	public void setTrainStatus(Integer trainStatus) {
		this.trainStatus = trainStatus;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestStarttimeStr() {
		return testStarttimeStr;
	}

	public void setTestStarttimeStr(String testStarttimeStr) {
		this.testStarttimeStr = testStarttimeStr;
	}

	public String getTestEndtimeStr() {
		return testEndtimeStr;
	}

	public void setTestEndtimeStr(String testEndtimeStr) {
		this.testEndtimeStr = testEndtimeStr;
	}

	public Integer getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(Integer testStatus) {
		this.testStatus = testStatus;
	}

}
