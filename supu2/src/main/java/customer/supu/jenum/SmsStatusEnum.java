package customer.supu.jenum;

public enum SmsStatusEnum {

	 /**
     * 1：没有对比
     */
    NOCONTRAST(0, "没有对比"),


    /**
     * 1：已经对比
     */
    CONTRASTED(1, "已经对比");


    /**
     * 编号
     */
    private Integer code;

    /**
     * 描述
     */
    private String desc;

    private SmsStatusEnum(Integer code, String desc)
    {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode()
    {
        return code;
    }

    public void setCode(Integer code)
    {
        this.code = code;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }


}
