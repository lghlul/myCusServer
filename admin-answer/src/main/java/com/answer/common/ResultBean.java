package com.answer.common;

import java.io.Serializable;

public class ResultBean implements Serializable {
    private static final long serialVersionUID = 768549219446295665L;

    private Integer resultCode;//返回码

    private String message;//返回信息

    private Object data;

    public ResultBean() {

    }

    public ResultBean(Integer resultCode, String message, Object data) {
        this.resultCode = resultCode;
        this.message = message;
        this.data = data;
    }

    public ResultBean(Integer resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
