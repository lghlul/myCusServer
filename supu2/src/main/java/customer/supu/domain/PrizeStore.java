package customer.supu.domain;

/**
 * @CLassName PrizeStore
 * @Description TODO
 * @Author ll
 * @Date 2018/10/29 17:37
 **/
public class PrizeStore {
    private Integer id;
    /**
     * 奖品名称
     */
    private String name;
    /**
     * 图片
     */
    private String path;
    /**
     * 奖品剩余
     */
    private Integer stock;
    /**
     * 概率 /100
     */
    private Integer probability;
    /**
     * 活动id
     */
    private Integer activityId;
    /**
     * 奖品数量
     */
    private Integer max;
    /**
     * 0  禁用 1 启动
     */
    private Integer status;

    private Integer limit;

    private Integer offset;

    /**
     * 1真实奖品2谢谢参与
     */
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getProbability() {
        return probability;
    }

    public void setProbability(Integer probability) {
        this.probability = probability;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
}
