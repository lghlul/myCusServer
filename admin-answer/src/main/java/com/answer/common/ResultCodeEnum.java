package com.answer.common;


import com.alibaba.fastjson.JSON;


public enum ResultCodeEnum {

    SUCCESS(1, "成功"),
    FAIL(-1, "失败"),
    PWD_ERROR(1000, "密码错误"),
    NAME_ERROR(1001, "账号错误"),
    NOT_LOGIN(1002, "尚未登录"),
    ACTIVITY_START(1003,"活动已经开始,不能修改"),
    FILE_FORMAT_ERROR(1004,"文件格式错误"),
    QUES_NUM_ZERO(1005,"题数为0不能开始"),
    JOBNUM_REPEAT(1006,"工号重复"),
    ROLE_STATUS_FORBIDDEN(1007,"角色已被禁用"),
    ADMIN_NAME_REPEAT(1008,"账号重复"),
    ROLE_NAME_REPEAT(1009,"角色重复"),
    ADMIN_STATUS_FORBIDDEN(1010,"账号已被禁用"),
    ACTIVITY_BEGINING(1011,"活动正在进行，不能删除"),
    FILE_QUESTION_FORMAT_ERROR(1012,"导入格式错误，请按照模板填写"),;

    /**
     * 编号
     */
    private Integer code;

    /**
     * 描述
     */
    private String desc;

    private ResultCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public String getResponse(Object object) {
        return JSON.toJSONString(new ResultBean(code, desc, object));
    }

    public String getResponse() {
        return JSON.toJSONString(new ResultBean(code, desc));
    }


}
