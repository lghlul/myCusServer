package com.lu.enums;


import com.lu.domain.ResultBean;

import java.net.ConnectException;

public enum CodeConstant {

    SUCCESS(0 , "成功"),
    FAIL(-1 , "失败"),
    EXCEPTION(-2 , "服务器异常"),
    SQL_EXCEPTION(-3,"SQLException"),
    UNKNOWNHOST_EXCEPTION(-4,"UnknownHostException"),
    MYSQLSYNTAXERROR_EXCEPTION(-5 , "MySQLSyntaxErrorException"),
    CONNECT_EXCEPTION(-6 , "ConnectException"),
    COMMUNICATIONS_EXCEPTION(-7 , "CommunicationsException"),
    PERSISTENCE_EXCEPTION(-7 , "PersistenceException");

    private int code;
    private String msg;

    private CodeConstant(int code , String msg){
        this.code = code;
        this.msg = msg;
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


    public ResultBean getResultBean(Object data){
        return new ResultBean(this.code , this.msg , data);
    }

    public ResultBean getResultBean(){
        return new ResultBean(this.code , this.msg , null);
    }

}
