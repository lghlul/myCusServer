package customer.supu.po;

import java.util.Date;

public class CoachTime {
    private Integer id;

    private Integer coachid;

    private Integer type;

    private String selectymonth;

    private String starttime;

    private String endtime;

    private String day;

    private Integer status;

    private Date addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCoachid() {
        return coachid;
    }

    public void setCoachid(Integer coachid) {
        this.coachid = coachid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSelectymonth() {
        return selectymonth;
    }

    public void setSelectymonth(String selectymonth) {
        this.selectymonth = selectymonth == null ? null : selectymonth.trim();
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day == null ? null : day.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
}