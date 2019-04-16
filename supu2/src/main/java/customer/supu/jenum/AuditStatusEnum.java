package customer.supu.jenum;

/**
 * 数据有效性枚举类
 *
 * @author luyujian
 * @version C01 2015-2-26
 * @since JESHING
 */
public enum AuditStatusEnum
{

    /**
     * 0：删除
     */
	DELETE(0, "删除"),
    /**
     * 1有效
     */
	EFFECTG(1, "有效"),

	 /**
     * 2：待审核
     */
    WAIT(2, "待审核"),
	 /**
     * 3：审核不通过
     */
    NOTPASS(3, "审核不通过");




    /**
     * 编号
     */
    private Integer code;

    /**
     * 描述
     */
    private String desc;

    private AuditStatusEnum(Integer code, String desc)
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
        for (AuditStatusEnum c : AuditStatusEnum.values())
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
