package com.cad.constant;

public interface ResultCode {

    public static final int SUCCESS = 0;
    public static final int FAIL = -1;
    /**
     * 账号重复
     */
    public static final int ACCOUNT_REPEAT = 999;
    /**
     * 手机重复
     */
    public static final int PHONE_REPEAT = 998;
    /**
     * 邮箱重复
     */
    public static final int EMAIL_REPEAT = 997;
}
