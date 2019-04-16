package customer.supu.po;

import java.util.Date;

public class EmployeeBuyCourse {
    private Integer id;

    private Integer userid;

    private Integer courseid;

    private Integer coursetype;

    private Integer totalclass;

    private Date buytime;

    private Integer status;

    private Integer isexperience;

    private Date startdate;

    private Date enddate;

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

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getCoursetype() {
        return coursetype;
    }

    public void setCoursetype(Integer coursetype) {
        this.coursetype = coursetype;
    }

    public Integer getTotalclass() {
        return totalclass;
    }

    public void setTotalclass(Integer totalclass) {
        this.totalclass = totalclass;
    }

    public Date getBuytime() {
        return buytime;
    }

    public void setBuytime(Date buytime) {
        this.buytime = buytime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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