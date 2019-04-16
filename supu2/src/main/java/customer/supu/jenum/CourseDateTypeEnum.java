package customer.supu.jenum;

/**
 * 数据有效性枚举类
 *
 * @author luyujian
 * @version C01 2015-2-26
 * @since JESHING
 */
public enum CourseDateTypeEnum
{
//课程时间类型 1:指定日期  2:每天  3:每周  4 每月


	SPECIFIEDDATE(1, "指定日期"),


    DAY(2, "每天"),

    WEEK(3, "每周"),


    MONTH(4, "每月");


    /**
     * 编号
     */
    private Integer code;

    /**
     * 描述
     */
    private String desc;

    private CourseDateTypeEnum(Integer code, String desc)
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
        for (CourseDateTypeEnum c : CourseDateTypeEnum.values())
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
