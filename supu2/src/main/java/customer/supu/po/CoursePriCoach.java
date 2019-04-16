package customer.supu.po;

import java.util.Date;

public class CoursePriCoach {
    private Integer id;

    private Integer coursetype;

    private String fitdemand;

    private String coursename;

    private String stores;

    private Double courseamount;

    private Double totalhours;

    private String courseimg;

    private String coursetitle;

    private String coachs;

    private Integer status;

    private Date realsetime;

    private String realsepeople;

    private Date addtime;

    private String addpeople;

    private Integer isexperience;
    
    private Integer ispopular;

    private String coursedetail;

    private String orderNum;

    private String price;

    private Long courseEndTime;

    private String courseEndTimeStr;

    private Integer commentCount;

    private Integer totalStar;

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getTotalStar() {
        return totalStar;
    }

    public void setTotalStar(Integer totalStar) {
        this.totalStar = totalStar;
    }

    public String getCourseEndTimeStr() {
        return courseEndTimeStr;
    }

    public void setCourseEndTimeStr(String courseEndTimeStr) {
        this.courseEndTimeStr = courseEndTimeStr;
    }

    public Long getCourseEndTime() {
        return courseEndTime;
    }

    public void setCourseEndTime(Long courseEndTime) {
        this.courseEndTime = courseEndTime;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCoursetype() {
        return coursetype;
    }

    public void setCoursetype(Integer coursetype) {
        this.coursetype = coursetype;
    }

    public String getFitdemand() {
        return fitdemand;
    }

    public void setFitdemand(String fitdemand) {
        this.fitdemand = fitdemand == null ? null : fitdemand.trim();
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
    }

    public String getStores() {
        return stores;
    }

    public void setStores(String stores) {
        this.stores = stores == null ? null : stores.trim();
    }

    public Double getCourseamount() {
        return courseamount;
    }

    public void setCourseamount(Double courseamount) {
        this.courseamount = courseamount;
    }

    public Double getTotalhours() {
        return totalhours;
    }

    public void setTotalhours(Double totalhours) {
        this.totalhours = totalhours;
    }

    public String getCourseimg() {
        return courseimg;
    }

    public void setCourseimg(String courseimg) {
        this.courseimg = courseimg == null ? null : courseimg.trim();
    }

    public String getCoursetitle() {
        return coursetitle;
    }

    public void setCoursetitle(String coursetitle) {
        this.coursetitle = coursetitle == null ? null : coursetitle.trim();
    }

    public String getCoachs() {
        return coachs;
    }

    public void setCoachs(String coachs) {
        this.coachs = coachs == null ? null : coachs.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getRealsetime() {
        return realsetime;
    }

    public void setRealsetime(Date realsetime) {
        this.realsetime = realsetime;
    }

    public String getRealsepeople() {
        return realsepeople;
    }

    public void setRealsepeople(String realsepeople) {
        this.realsepeople = realsepeople == null ? null : realsepeople.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getAddpeople() {
        return addpeople;
    }

    public void setAddpeople(String addpeople) {
        this.addpeople = addpeople == null ? null : addpeople.trim();
    }

    public Integer getIsexperience() {
        return isexperience;
    }

    public void setIsexperience(Integer isexperience) {
        this.isexperience = isexperience;
    }

    public Integer getIspopular() {
		return ispopular;
	}

	public void setIspopular(Integer ispopular) {
		this.ispopular = ispopular;
	}

	public String getCoursedetail() {
        return coursedetail;
    }

    public void setCoursedetail(String coursedetail) {
        this.coursedetail = coursedetail == null ? null : coursedetail.trim();
    }
}