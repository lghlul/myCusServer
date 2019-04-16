package customer.supu.jenum;


/**
 * 移动端  底部菜单枚举类
 * @author Administrator
 *
 */
public enum MobileBottomEnum
{


	APPOINT(1, "约课"),

	PURCHASE(2, "购买"),

	MYCOURSE(3, "我的课程"),

	PERSONAL(4, "个人中心");

    /**
     * 编号
     */
    private Integer code;

    /**
     * 描述
     */
    private String desc;

    private MobileBottomEnum(Integer code, String desc)
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
        for (MobileBottomEnum c : MobileBottomEnum.values())
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
