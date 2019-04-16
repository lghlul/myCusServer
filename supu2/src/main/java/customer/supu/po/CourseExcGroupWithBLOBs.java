package customer.supu.po;

public class CourseExcGroupWithBLOBs extends CourseExcGroup {
    private String coursedetail;

    private String tabdetail;

    public String getCoursedetail() {
        return coursedetail;
    }

    public void setCoursedetail(String coursedetail) {
        this.coursedetail = coursedetail == null ? null : coursedetail.trim();
    }

    public String getTabdetail() {
        return tabdetail;
    }

    public void setTabdetail(String tabdetail) {
        this.tabdetail = tabdetail == null ? null : tabdetail.trim();
    }
}