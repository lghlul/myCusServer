package customer.supu.jenum;

/**
 * 数据有效性枚举类
 *
 * @author luyujian
 * @version C01 2015-2-26
 * @since JESHING
 */
public enum CourseAppointStatusEnum
{


    RESERVATIONS(1, "可预约"),

    REQQUEUE(2, "需排队"),

    STRAIN(3, "紧张"),

    NOTQUEUE(4, "临近课程开始时间，不可排队"),

   	NOTUEUEING(5, "课程进行中，不可排队"),

	FULL(6, "人数已满"),

	NOTOPEN(7, "未开放"),

	END(8, "已结束");
    /**
     * 编号
     */
    private Integer code;

    /**
     * 描述
     */
    private String desc;

    private CourseAppointStatusEnum(Integer code, String desc)
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
