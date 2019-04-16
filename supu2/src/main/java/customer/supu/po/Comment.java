package customer.supu.po;

import java.util.Date;

public class Comment {
    private Integer id;

    private String appraisercode;

    private String stores;

    private String coachs;

    private String coursetype;

    private Integer startlevel;

    private Integer status;

    private Date addtime;

    private Date audittime;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppraisercode() {
        return appraisercode;
    }

    public void setAppraisercode(String appraisercode) {
        this.appraisercode = appraisercode == null ? null : appraisercode.trim();
    }

    public String getStores() {
        return stores;
    }

    public void setStores(String stores) {
        this.stores = stores == null ? null : stores.trim();
    }

    public String getCoachs() {
        return coachs;
    }

    public void setCoachs(String coachs) {
        this.coachs = coachs == null ? null : coachs.trim();
    }

    public String getCoursetype() {
        return coursetype;
    }

    public void setCoursetype(String coursetype) {
        this.coursetype = coursetype == null ? null : coursetype.trim();
    }

    public Integer getStartlevel() {
        return startlevel;
    }

    public void setStartlevel(Integer startlevel) {
        this.startlevel = startlevel;
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

    public Date getAudittime() {
        return audittime;
    }

    public void setAudittime(Date audittime) {
        this.audittime = audittime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}