package customer.supu.domain;

/**
 * @CLassName CoachBean
 * @Description 私教
 * @Author ll
 * @Date 2018/8/28 14:50
 **/
public class CoachBean {
    /**
     * 教练主键id
     */
    private Integer id;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 教练名称
     */
    private String coachName;
    /**
     * 性别:0:女  1:男
     */
    private Integer sex;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机
     */
    private String phoneNumber;
    /**
     * 身份证号
     */
    private String idNumber;
    /**
     * 身份证照片正面
     */
    private String frontIdNumber;
    /**
     * 身份证照片反面
     */
    private String reverseIdNumber;
    /**
     * 所在地
     */
    private String location;
    /**
     * 服务区域
     */
    private String serviceArea;
    /**
     * 毕业院校
     */
    private String graduateColleges;
    /**
     * 曾经就职
     */
    private String everWorked;
    /**
     * 教练等级:1,2 ,3,4等级
     */
    private Integer coachLevel;
    /**
     * 教龄
     */
    private Double teachYears;
    /**
     * 擅长
     */
    private String goodat;
    /**
     * 教练照片1
     */
    private String coachImg1;
    /**
     * 教练照片2
     */
    private String coachImg2;
    /**
     * 教练照片3
     */
    private String coachImg3;
    /**
     * 教练照片4
     */
    private String coachImg4;
    /**
     * 教练照片5
     */
    private String coachImg5;
    /**
     * 是否为人气王 0：不是 1:是
     */
    private Integer isPopular;
    /**
     * 选择门店
     */
    private String stores;
    /**
     * 添加时间
     */
    private String addTime;
    /**
     * 添加人
     */
    private String addPeople;
    /**
     * 发布时间
     */
    private String realseTime;
    /**
     * 发布人
     */
    private String realsePeople;
    /**
     * 状态 ：0：删除 1：合作中  2：合作终止 3:待审核
     */
    private Integer status;
    /**
     * 教练头像
     */
    private String headImg;
    /**
     * 价格
     */
    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getFrontIdNumber() {
        return frontIdNumber;
    }

    public void setFrontIdNumber(String frontIdNumber) {
        this.frontIdNumber = frontIdNumber;
    }

    public String getReverseIdNumber() {
        return reverseIdNumber;
    }

    public void setReverseIdNumber(String reverseIdNumber) {
        this.reverseIdNumber = reverseIdNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public String getGraduateColleges() {
        return graduateColleges;
    }

    public void setGraduateColleges(String graduateColleges) {
        this.graduateColleges = graduateColleges;
    }

    public String getEverWorked() {
        return everWorked;
    }

    public void setEverWorked(String everWorked) {
        this.everWorked = everWorked;
    }

    public Integer getCoachLevel() {
        return coachLevel;
    }

    public void setCoachLevel(Integer coachLevel) {
        this.coachLevel = coachLevel;
    }

    public Double getTeachYears() {
        return teachYears;
    }

    public void setTeachYears(Double teachYears) {
        this.teachYears = teachYears;
    }

    public String getGoodat() {
        return goodat;
    }

    public void setGoodat(String goodat) {
        this.goodat = goodat;
    }

    public String getCoachImg1() {
        return coachImg1;
    }

    public void setCoachImg1(String coachImg1) {
        this.coachImg1 = coachImg1;
    }

    public String getCoachImg2() {
        return coachImg2;
    }

    public void setCoachImg2(String coachImg2) {
        this.coachImg2 = coachImg2;
    }

    public String getCoachImg3() {
        return coachImg3;
    }

    public void setCoachImg3(String coachImg3) {
        this.coachImg3 = coachImg3;
    }

    public String getCoachImg4() {
        return coachImg4;
    }

    public void setCoachImg4(String coachImg4) {
        this.coachImg4 = coachImg4;
    }

    public String getCoachImg5() {
        return coachImg5;
    }

    public void setCoachImg5(String coachImg5) {
        this.coachImg5 = coachImg5;
    }

    public Integer getIsPopular() {
        return isPopular;
    }

    public void setIsPopular(Integer isPopular) {
        this.isPopular = isPopular;
    }

    public String getStores() {
        return stores;
    }

    public void setStores(String stores) {
        this.stores = stores;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
}
