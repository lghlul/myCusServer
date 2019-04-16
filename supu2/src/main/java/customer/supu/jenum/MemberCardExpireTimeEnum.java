package customer.supu.jenum;

/**
 * 会员卡的  有效时间
 *
 * @author luyujian
 * @version C01 2015-2-26
 * @since JESHING
 */
public enum MemberCardExpireTimeEnum
{

	/**
	 * 月度  ：一个月
	 */
	MONTH(1, 1),


	/**
	 * 季度  ：三个月
	 */
	QUARTER(2,3),

	/**
	 * 半年 ：6个月
	 */
	HALFYEAR(3,6),


	/**
	 * 一年 ：12个月
	 */
	YEAR(4,12),

	/**
	 * 两年：24个月
	 */
	TWOYEAR(5,24),


	/**
	 * 三年：36个月
	 */
	THREEYEAR(6,36);



    private Integer code;

    /**
     * 描述
     */
    private Integer desc;

    private MemberCardExpireTimeEnum(Integer code, Integer desc)
    {
        this.code = code;
        this.desc = desc;
    }



    /**
     * 根据code获取月份
     * @param code
     * @return
     */
    public static Integer getMonth(Integer code){
    	for (MemberCardExpireTimeEnum c : MemberCardExpireTimeEnum.values())
        {
            if (c.code == code)
            {
                return c.getDesc();
            }
        }
        return -1;

    }
    public Integer getCode()
    {
        return code;
    }

    public void setCode(Integer code)
    {
        this.code = code;
    }

    public Integer getDesc()
    {
        return desc;
    }

    public void setDesc(Integer desc)
    {
        this.desc = desc;
    }
    // 覆盖方法
    @Override
    public String toString() {
        return String.valueOf(this.code);
    }

}
