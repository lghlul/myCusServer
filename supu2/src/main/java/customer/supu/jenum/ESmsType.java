package customer.supu.jenum;

public enum ESmsType {

	 /**
     * 1：注册
     */
	REGISTER(1, "注册"),


    /**
     * 2：忘记密码
     */
	MODIFY(2, "忘记密码"),


	   /**
     * 3：登录
     */
	LOGIN(3, "登录"),


    /**
     * 4：预约私教
     */
    MAKE_APPOINT(4, "登录"),


    /**
     * 5：取消预约
     */
    CANCEL_APPOINT(5, "登录");


    /**
     * 编号
     */
    private Integer code;

    /**
     * 描述
     */
    private String desc;

    private ESmsType(Integer code, String desc)
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
