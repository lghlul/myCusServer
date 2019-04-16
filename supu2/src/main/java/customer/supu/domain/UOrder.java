package customer.supu.domain;

public class UOrder{

    private Integer id;

    private Integer userId;

    private Integer type;

    private Integer cid;

    private String buyTime;

    private Double amount;

    private String orderNumber;

    private String returnCode;

    private Integer isSuccess;

    private Integer totalClass;

    private Integer isExperience;

    private String startDate;

    private String endDate;

    private Integer coachId;

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getUserId(){
        return this.userId;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public Integer getType(){
        return this.type;
    }

    public void setType(Integer type){
        this.type = type;
    }

    public Integer getCid(){
        return this.cid;
    }

    public void setCid(Integer cid){
        this.cid = cid;
    }

    public String getBuyTime(){
        return this.buyTime;
    }

    public void setBuyTime(String buyTime){
        this.buyTime = buyTime;
    }

    public Double getAmount(){
        return this.amount;
    }

    public void setAmount(Double amount){
        this.amount = amount;
    }

    public String getOrderNumber(){
        return this.orderNumber;
    }

    public void setOrderNumber(String orderNumber){
        this.orderNumber = orderNumber;
    }

    public String getReturnCode(){
        return this.returnCode;
    }

    public void setReturnCode(String returnCode){
        this.returnCode = returnCode;
    }

    public Integer getIsSuccess(){
        return this.isSuccess;
    }

    public void setIsSuccess(Integer isSuccess){
        this.isSuccess = isSuccess;
    }

    public Integer getTotalClass(){
        return this.totalClass;
    }

    public void setTotalClass(Integer totalClass){
        this.totalClass = totalClass;
    }

    public Integer getIsExperience(){
        return this.isExperience;
    }

    public void setIsExperience(Integer isExperience){
        this.isExperience = isExperience;
    }

    public String getStartDate(){
        return this.startDate;
    }

    public void setStartDate(String startDate){
        this.startDate = startDate;
    }

    public String getEndDate(){
        return this.endDate;
    }

    public void setEndDate(String endDate){
        this.endDate = endDate;
    }

    public Integer getCoachId(){
        return this.coachId;
    }

    public void setCoachId(Integer coachId){
        this.coachId = coachId;
    }

}