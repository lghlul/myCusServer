package customer.supu.po;

public class BasicData {
    private Integer basicdataid;

    private String basictype;

    private String title;

    private String basicvalue;

    private String description;

    private Integer flag;

    private Integer vorder;

    public Integer getBasicdataid() {
        return basicdataid;
    }

    public void setBasicdataid(Integer basicdataid) {
        this.basicdataid = basicdataid;
    }

    public String getBasictype() {
        return basictype;
    }

    public void setBasictype(String basictype) {
        this.basictype = basictype == null ? null : basictype.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getBasicvalue() {
        return basicvalue;
    }

    public void setBasicvalue(String basicvalue) {
        this.basicvalue = basicvalue == null ? null : basicvalue.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getVorder() {
        return vorder;
    }

    public void setVorder(Integer vorder) {
        this.vorder = vorder;
    }
}