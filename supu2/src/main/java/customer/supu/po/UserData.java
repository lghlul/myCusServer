package customer.supu.po;

import java.util.Date;

public class UserData {

    private Integer org;//区分用户会
    private String id;//用户ID
    private String userid;//用户ID
	private String phone;//手机号
	private String name;//姓名
	private Integer limitStart;//分页数据开始位置
	private Integer limitEnd;//分页步长
	
	private String mCardId;//会员类型
	private Date buyTime;//购卡时间
	private Date expireTime;//到期时间
	private String idNumber;//身份证号
	private String storeId;//会员卡ID
	private String membername; //会员姓名
	private String membertype;//
	public UserData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public UserData(Integer org, String id, String userid, String phone, String name, Integer limitStart,
			Integer limitEnd, String mCardId, Date buyTime, Date expireTime, String idNumber, String storeId,
			String membername, String membertype) {
		super();
		this.org = org;
		this.id = id;
		this.userid = userid;
		this.phone = phone;
		this.name = name;
		this.limitStart = limitStart;
		this.limitEnd = limitEnd;
		this.mCardId = mCardId;
		this.buyTime = buyTime;
		this.expireTime = expireTime;
		this.idNumber = idNumber;
		this.storeId = storeId;
		this.membername = membername;
		this.membertype = membertype;
	}



	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public Integer getOrg() {
		return org;
	}

	public void setOrg(Integer org) {
		this.org = org;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLimitStart() {
		return limitStart;
	}
	public void setLimitStart(Integer limitStart) {
		this.limitStart = limitStart;
	}
	public Integer getLimitEnd() {
		return limitEnd;
	}
	public void setLimitEnd(Integer limitEnd) {
		this.limitEnd = limitEnd;
	}
	public String getmCardId() {
		return mCardId;
	}
	public void setmCardId(String mCardId) {
		this.mCardId = mCardId;
	}
	public Date getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}
	public Date getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getMembertype() {
		return membertype;
	}
	public void setMembertype(String membertype) {
		this.membertype = membertype;
	}
	


	
    
    
}
