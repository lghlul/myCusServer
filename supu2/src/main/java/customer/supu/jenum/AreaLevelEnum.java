package customer.supu.jenum;

/**
 * 数据有效性枚举类
 *
 * @author luyujian
 * @version C01 2015-2-26
 * @since JESHING
 */
public enum AreaLevelEnum
{

    /**
     * 1, "省"
     */
	PROVINCE(1, "省"),
    /**
     *2, "市"
     */
	CITY(2, "市"),

	 /**
     * 3, "区"
     */
	REGION(3, "区");


    /**
     * 编号
     */
    private Integer code;

    /**
     * 描述
     */
    private String desc;

    private AreaLevelEnum(Integer code, String desc)
    {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 根据code获取描述
     *
     * @author 陆玉健
     * @param code
     * @return
     */
    public static String getName(Integer code)
    {
        for (AreaLevelEnum c : AreaLevelEnum.values())
        {
            if (c.code == code)
            {
                return c.desc;
            }
        }
        return null;
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
    // 覆盖方法
    @Override
    public String toString() {
        return String.valueOf(this.code);
    }

}
