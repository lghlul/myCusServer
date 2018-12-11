package com.answer.common;


import com.alibaba.fastjson.JSON;

/**
 * 数据有效性枚举类
 *
 * @author luyujian
 * @version C01 2015-2-26
 * @since JESHING
 */
public enum ResultCodeEnum
{

    SUCCESS(1, "成功"),
    FAIL(-1, "失败"),
    PWD_ERROR(1000, "密码错误"),
    NAME_ERROR(1001, "账号错误"),
    NOT_LOGIN(1002, "尚未登录");

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


    public String getResponse(Object object){
        return  JSON.toJSONString(new ResultBean(code , desc , object));
    }
    public String getResponse(){
        return JSON.toJSONString( new ResultBean(code , desc ));
    }


}
