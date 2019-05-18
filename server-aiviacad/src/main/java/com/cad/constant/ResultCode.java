package com.cad.constant;

public interface ResultCode {

    int SUCCESS = 0;
    int FAIL = -1;
    /**
     * 账号重复
     */
    int ACCOUNT_REPEAT = 999;
    /**
     * 手机重复
     */
    int PHONE_REPEAT = 998;
    /**
     * 邮箱重复
     */
    int EMAIL_REPEAT = 997;
    /**
     * 编码重复
     */
    int CODE_VALUE_REPEAT = 996;
    /**
     * 当前密码错误
     */
    int OLD_PWD_ERROR = 995;

    /**
     * 邮箱不存在
     */
    int EMAIL_EXIST = 994;

    /**
     * 验证码无效
     */
    int CODE_NOT_EFFECT = 993;
    /**
     * 编码名称重复
     */
    int CODE_NAME_REPEAT = 992;
}
