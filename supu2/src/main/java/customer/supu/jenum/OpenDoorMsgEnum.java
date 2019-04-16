package customer.supu.jenum;

/**
 * 开门返回的信息
 * @author Administrator
 *
 */
public enum OpenDoorMsgEnum
{

	FAIL(0, "很遗憾，系统问题导致开门失败，请联系工作人员"),

	SUCCESS(1, "恭喜您，开门成功"),

	STATE2001(2001,"参数错误或账户被禁用"),

	STATE2002(2002,"没有上传设备序列号"),

	STATE2003(2003,"设备序列号错误"),

	STATE2004(2004,"设备不存在"),

	STATE2005(2005,"无权限操作"),

	STATE2006(2006,"连接服务器出错，请重试");



    private Integer code;

    /**
     * 描述
     */
    private String desc;

    private OpenDoorMsgEnum(Integer code, String desc)
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
        for (OpenDoorMsgEnum c : OpenDoorMsgEnum.values())
        {
            if (c.code.equals(code))
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
