package customer.supu.domain;

/**
 * @CLassName EmployeeBuyPri
 * @Description 购买的私教课程
 * @Author ll
 * @Date 2018/8/29 16:47
 **/
public class EmployeeBuyPri {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 私教课程ID
     */
    private Integer courseId;
    /**
     * 私教ID
     */
    private Integer coachId;
    /**
     * 购买的课程数量
     */
    private Integer totalClass;
    /**
     * 购买时间
     */
    private Long buyTime;
    /**
     * 状态 1 未完成 2已完成
     */
    private Byte status;

    private Integer pageNo;

    private Integer pageSize;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public Integer getTotalClass() {
        return totalClass;
    }

    public void setTotalClass(Integer totalClass) {
        this.totalClass = totalClass;
    }

    public Long getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Long buyTime) {
        this.buyTime = buyTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
