package customer.supu.domain;

import java.util.List;

/**
 * @CLassName Activity
 * @Description TODO
 * @Author ll
 * @Date 2018/10/29 17:34
 **/
public class Activity {
    private Integer activityId;
    /**
     * 标题
     */
    private String title;
    /**
     * 活动开始时间
     */
    private String startDate;
    /**
     * 活动结束时间
     */
    private String endDate;
    /**
     * 创建时间
     */
    private String createDate;
    /**
     * 最后修改时间
     */
    private String lastModifiedDate;
    /**
     * 修改人
     */
    private String lastModifiedBy;
    /**
     * 介绍
     */
    private String introduce;
    /**
     * 参与次数
     */
    private Integer description;

    /**
     * 参与次数
     */
    private Integer useNum;

    /**
     * 联系方式
     */
    private String contact;

    /**
     * 1上架2下架
     */
    private Integer status;

    private Integer limit;

    private Integer offset;

    private List<PrizeStore> prizeStores;

    public List<PrizeStore> getPrizeStores() {
        return prizeStores;
    }

    public Integer getUseNum() {
        return useNum;
    }

    public void setUseNum(Integer useNum) {
        this.useNum = useNum;
    }

    public void setPrizeStores(List<PrizeStore> prizeStores) {
        this.prizeStores = prizeStores;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Integer getDescription() {
        return description;
    }

    public void setDescription(Integer description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
