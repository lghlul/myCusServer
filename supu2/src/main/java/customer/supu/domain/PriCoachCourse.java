package customer.supu.domain;

/**
 * @CLassName PriCoachCourse
 * @Description TODO
 * @Author ll
 * @Date 2018/11/6 14:21
 **/
public class PriCoachCourse {
    private Integer id;

    private Integer userId;

    private Integer courseId;

    private Integer coachId;

    private Integer totalClass;

    private Long buyTime;

    private Integer status;

    private String coachName;

    private Integer sex;

    private String phoneNumber;

    private String headImg;

    private String courseName;

    private String courseTitle;

    private String courseEndTime;

    private String amount;

    private int useClass;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseEndTime() {
        return courseEndTime;
    }

    public void setCourseEndTime(String courseEndTime) {
        this.courseEndTime = courseEndTime;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getUseClass() {
        return useClass;
    }

    public void setUseClass(int useClass) {
        this.useClass = useClass;
    }
}
