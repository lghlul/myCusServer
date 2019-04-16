package customer.supu.po;

import java.util.Date;

public class MemberCard {
    private Integer id;

    private String membername;

    private String proinfo;

    private String mcardimg;

    private Integer cardtype;

    private Integer timelong;

    private Double amountmoney;

    private Integer isuse;

    private String stores;

    private Date addtime;

    private String addpeople;

    private Date realsetime;

    private String realsepeople;

    private String memberrights;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername == null ? null : membername.trim();
    }

    public String getProinfo() {
        return proinfo;
    }

    public void setProinfo(String proinfo) {
        this.proinfo = proinfo == null ? null : proinfo.trim();
    }

    public String getMcardimg() {
        return mcardimg;
    }

    public void setMcardimg(String mcardimg) {
        this.mcardimg = mcardimg == null ? null : mcardimg.trim();
    }

    public Integer getCardtype() {
        return cardtype;
    }

    public void setCardtype(Integer cardtype) {
        this.cardtype = cardtype;
    }

    public Integer getTimelong() {
        return timelong;
    }

    public void setTimelong(Integer timelong) {
        this.timelong = timelong;
    }

    public Double getAmountmoney() {
        return amountmoney;
    }

    public void setAmountmoney(Double amountmoney) {
        this.amountmoney = amountmoney;
    }

    public Integer getIsuse() {
        return isuse;
    }

    public void setIsuse(Integer isuse) {
        this.isuse = isuse;
    }

    public String getStores() {
        return stores;
    }

    public void setStores(String stores) {
        this.stores = stores == null ? null : stores.trim();
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

    public String getMemberrights() {
        return memberrights;
    }

    public void setMemberrights(String memberrights) {
        this.memberrights = memberrights == null ? null : memberrights.trim();
    }
}