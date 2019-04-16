package customer.supu.jenum;

import customer.supu.common.po.PageResponse;

/**
 * 数据有效性枚举类
 *
 * @author luyujian
 * @version C01 2015-2-26
 * @since JESHING
 */
public enum ResultCodeEnum
{

	 /**
     * 200：成功
     */
    SUCCESS(200, "成功"),


    /**
     * 400：失败
     */
    FAIL(400, "失败"),

    isBinded(666, "手机号已被绑定"),
    UN_BIND_PHONE(667, "没有绑定手机"),
    OUT_NUMBER(668, "超出抽奖数量"),
    OUT_TIME(669, "不在活动时间范围内"),
    PRI_NOT_WORK(670, "私教不在工作时间"),
    PRI_TIME_CONFLICT(671, "私教时间已经被预约"),
    NOT_BUY_PRI(672, "没有购买私教"),
    NOT_APPOINT_PRI(673, "没有预约私教课"),
    NOT_CANCEL_APPOINT(674, "超过取消时间"),
    PRI_COURSE_OVER(675, "私教课已经结束"),
    STARTTIME_NOT_ALLOW(676, "开始时间不合法");

    /**
     * 编号
     */
    private Integer code;

    /**
     * 描述
     */
    private String desc;

    private ResultCodeEnum(Integer code, String desc)
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


    public PageResponse getResponse(Object object){
        return new PageResponse(code , desc , object);
    }
    public PageResponse getResponse(){
        return new PageResponse(code , desc  );
    }


}
