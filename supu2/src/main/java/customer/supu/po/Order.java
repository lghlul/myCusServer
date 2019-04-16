package customer.supu.po;

import java.util.Date;

public class Order {
    private Integer id;

    private Integer userid;

    private Integer type;

    private Integer cid;

    private Date buytime;

    private Double amount;

    private String ordernumber;

    private String returncode;

    private Integer issuccess;

    private Integer totalclass;

    private Integer isexperience;

    private Date startdate;

    private Date enddate;

    private Integer coachId;

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Date getBuytime() {
        return buytime;
    }

    public void setBuytime(Date buytime) {
        this.buytime = buytime;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber == null ? null : ordernumber.trim();
    }

    public String getReturncode() {
        return returncode;
    }

    public void setReturncode(String returncode) {
        this.returncode = returncode == null ? null : returncode.trim();
    }

    public Integer getIssuccess() {
        return issuccess;
    }

    public void setIssuccess(Integer issuccess) {
        this.issuccess = issuccess;
    }

    public Integer getTotalclass() {
        return totalclass;
    }

    public void setTotalclass(Integer totalclass) {
        this.totalclass = totalclass;
    }

    public Integer getIsexperience() {
        return isexperience;
    }

    public void setIsexperience(Integer isexperience) {
        this.isexperience = isexperience;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }
}