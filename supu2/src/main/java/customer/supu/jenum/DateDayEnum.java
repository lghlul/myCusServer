package customer.supu.jenum;

/**
 * 数据有效性枚举类
 *
 * @author luyujian
 * @version C01 2015-2-26
 * @since JESHING
 */
public enum DateDayEnum
{


	//1号
	First(1, "01"),
	Second(2, "02"),
	Third(3, "03"),
	Fouth(4, "04"),
	Fifth(5, "05"),
	Sixth(6, "06"),
	Seventh(7, "07"),
	Eighth(8, "08"),
	Ninth(9, "09"),
	Tenth(10, "10"),
	Eleventh(11, "11"),
	Twelfth(12, "12"),
	Thirteenth(13, "13"),
	Fourteenth(14, "14"),
	Fifteenth(15, "15"),
	Sixteenth(16, "16"),
	Seventeenth(17, "17"),
	Eighteenth(18, "18"),
	Nineteenth(19, "19"),
	Twentieth(20, "20"),
	Twentyfirst(21, "21"),
	Twentysecond(22, "22"),
	Twentythird(23, "23"),
	Twentyfourth(24, "24"),
	Twentyfifth(25, "25"),
	Twentysixth(26, "26"),
	Twentyeventh(27, "27"),
	Twentyeighth(28, "28"),
	Twentyninth(29, "29"),
	Thirtieth(30, "30"),
	Thirtyfirst(31, "31");





    /**
     * 编号
     */
    private Integer code;

    /**
     * 描述
     */
    private String desc;

    private DateDayEnum(Integer code, String desc)
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
        for (DateDayEnum c : DateDayEnum.values())
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
