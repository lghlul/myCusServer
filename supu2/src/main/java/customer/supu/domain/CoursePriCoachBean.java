package customer.supu.domain;

import java.util.List;
import java.util.Map;

/**
 * @CLassName CoursePriCoachBean
 * @Description 私教课
 * @Author ll
 * @Date 2018/8/28 14:44
 **/
public class CoursePriCoachBean {
    /**
     * 课程表主键
     */
    private Integer id;
    /**
     * 课程类型 1:团课
     */
    private Integer courseType;
    /**
     * 课程健身需求
     */
    private String fitDemand;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 适用门店
     */
    private String stores;


    /**
     * 课程金额
     */
    private String courseAmount;
    /**
     * 起售课时
     */
    private Double totalHours;
    /**
     * 课程图片
     */
    private String courseImg;
    /**
     * 课程标题
     */
    private String courseTitle;
    /**
     * 课程详情
     */
    private String courseDetail;
    /**
     * 状态：0：删除   1：有效
     */
    private Integer status;

    private String realseTime;
    /**
     * 发布人
     */
    private String realsePeople;
    private String addTime;
    private String addPeople;
    /**
     * 是否为体验课：0不是；1:是 (私教课)
     */
    private Integer isExperience;
    /**
     * 是否为推荐课程
     */
    private Integer isPopular;
    /**
     * 教练列表
     */
    private List<CoachBean> coachList;
    /**
     * 门店列表
     */
    private List<StoreBean> storeList;

    /**
     * 课程结束时间
     */
    private Long courseEndTime;


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

    public Long getCourseEndTime() {
        return courseEndTime;
    }

    public void setCourseEndTime(Long courseEndTime) {
        this.courseEndTime = courseEndTime;
    }

    public List<StoreBean> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<StoreBean> storeList) {
        this.storeList = storeList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public String getFitDemand() {
        return fitDemand;
    }

    public void setFitDemand(String fitDemand) {
        this.fitDemand = fitDemand;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStores() {
        return stores;
    }

    public void setStores(String stores) {
        this.stores = stores;
    }

    public String getCourseAmount() {
        return courseAmount;
    }

    public void setCourseAmount(String courseAmount) {
        this.courseAmount = courseAmount;
    }

    public Double getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(Double totalHours) {
        this.totalHours = totalHours;
    }

    public String getCourseImg() {
        return courseImg;
    }

    public void setCourseImg(String courseImg) {
        this.courseImg = courseImg;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseDetail() {
        return courseDetail;
    }

    public void setCourseDetail(String courseDetail) {
        this.courseDetail = courseDetail;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRealseTime() {
        return realseTime;
    }

    public void setRealseTime(String realseTime) {
        this.realseTime = realseTime;
    }

    public String getRealsePeople() {
        return realsePeople;
    }

    public void setRealsePeople(String realsePeople) {
        this.realsePeople = realsePeople;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getAddPeople() {
        return addPeople;
    }

    public void setAddPeople(String addPeople) {
        this.addPeople = addPeople;
    }

    public Integer getIsExperience() {
        return isExperience;
    }

    public void setIsExperience(Integer isExperience) {
        this.isExperience = isExperience;
    }

    public Integer getIsPopular() {
        return isPopular;
    }

    public void setIsPopular(Integer isPopular) {
        this.isPopular = isPopular;
    }

    public List<CoachBean> getCoachList() {
        return coachList;
    }

    public void setCoachList(List<CoachBean> coachList) {
        this.coachList = coachList;
    }

}
