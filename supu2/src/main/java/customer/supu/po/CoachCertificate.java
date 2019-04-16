package customer.supu.po;

public class CoachCertificate {
    private Integer id;

    private Integer coachid;

    private String name;

    private String certificateimg;

    private Integer status;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCertificateimg() {
        return certificateimg;
    }

    public void setCertificateimg(String certificateimg) {
        this.certificateimg = certificateimg == null ? null : certificateimg.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}