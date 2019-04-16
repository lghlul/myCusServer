package customer.supu.po;

import java.util.Date;

public class EmployeeBuyCard {
    private Integer id;

    private Integer userid;

    private Integer mcardid;

    private Integer status;

    private Date buytime;

    private Date expiretime;

    private String membername;

    private String phonenumber;

    private String idnumber;

    private Integer membersource;

    private Date addtime;

    private Integer membertype;

    private Integer storeid;

    private Integer org;//用户管理中区分会员和普通用户
    
    
    

	public Integer getOrg() {
		return org;
	}

	public void setOrg(Integer org) {
		this.org = org;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getMcardid() {
        return mcardid;
    }

    public void setMcardid(Integer mcardid) {
        this.mcardid = mcardid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getBuytime() {
        return buytime;
    }

    public void setBuytime(Date buytime) {
        this.buytime = buytime;
    }

    public Date getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(Date expiretime) {
        this.expiretime = expiretime;
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername == null ? null : membername.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber == null ? null : idnumber.trim();
    }

    public Integer getMembersource() {
        return membersource;
    }

    public void setMembersource(Integer membersource) {
        this.membersource = membersource;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Integer getMembertype() {
        return membertype;
    }

    public void setMembertype(Integer membertype) {
        this.membertype = membertype;
    }

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
    }
}