package customer.supu.domain;

/**
 * @CLassName StoreBean
 * @Description 门店
 * @Author ll
 * @Date 2018/8/28 15:36
 **/
public class StoreBean {
    /**
     * 门店主键id
     */
    private Integer id;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 门店图片
     */
    private String storeImg;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String region;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 状态：1：筹备中  2：开业  3：暂停营业   4：关闭
     */
    private Integer status;
    /**
     * 发布时间
     */
    private String realseTime;
    /**
     * 发布人
     */
    private String realsePeople;
    /**
     * 添加时间
     */
    private String addTime;
    /**
     * 添加人
     */
    private String addPeople;
    /**
     * 门店纬度
     */
    private String latitude;
    /**
     * 门店经度
     */
    private String longitude;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreImg() {
        return storeImg;
    }

    public void setStoreImg(String storeImg) {
        this.storeImg = storeImg;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRealseTime() {
        return realseTime;
    }

    public void setRealseTime(String realseTime) {
        this.realseTime = realseTime;
    }

    public String getRealsePeople() {
        return realsePeople;
    }

    public void setRealsePeople(String realsePeople) {
        this.realsePeople = realsePeople;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getAddPeople() {
        return addPeople;
    }

    public void setAddPeople(String addPeople) {
        this.addPeople = addPeople;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
