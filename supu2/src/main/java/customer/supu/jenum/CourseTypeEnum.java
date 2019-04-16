package customer.supu.jenum;

/**
 * 数据有效性枚举类
 *
 * @author luyujian
 * @version C01 2015-2-26
 * @since JESHING
 */
public enum CourseTypeEnum
{

    /**
     * 0：私教
     */
	PRICOACH(0, "私教"),
    /**
     * 1:精品团课或基础团课
     */
	COURSEGROUP(1, "基础团课"),

	/**
	 * 2:工作室
	 */
	STUDIO(2,"工作室");






    /**
     * 编号
     */
    private Integer code;

    /**
     * 描述
     */
    private String desc;

    private CourseTypeEnum(Integer code, String desc)
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
        for (CourseTypeEnum c : CourseTypeEnum.values())
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
