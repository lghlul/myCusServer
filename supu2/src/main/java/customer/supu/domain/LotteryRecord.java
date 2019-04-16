package customer.supu.domain;

/**
 * @CLassName LotteryRecord
 * @Description TODO
 * @Author ll
 * @Date 2018/10/29 17:42
 **/
public class LotteryRecord {
    private Long id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 奖品id
     */
    private Integer prizeId;
    /**
     * -1 异常抽奖 0 未中奖 1 中奖 2 已兑奖
     */
    private Integer status;
    /**
     * 创建时间
     */
    private String createDate;
    /**
     * 最后修改时间
     */
    private String lastModifiedDate;
    /**
     * 最后修改人
     */
    private Integer lastModifiedBy;

    private String mobilePhone;

    private String name;

    private String path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Integer getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Integer lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}
