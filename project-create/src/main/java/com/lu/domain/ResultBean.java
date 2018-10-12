package com.lu.domain;

/**
 * @CLassName ResultBean
 * @Description TODO
 * @Author ll
 * @Date 2018/9/18 14:35
 **/
public class ResultBean {

    private int code;
    private String msg;
    private Object data;

    public ResultBean(){

    }

    public ResultBean(int code , String msg){
        this.code = code;
        this.msg = msg;
    }

    public ResultBean(int code , String msg , Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
