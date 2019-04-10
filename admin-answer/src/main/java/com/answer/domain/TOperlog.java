package com.answer.domain;

public class TOperlog extends BaseDomain {

    private Long logId;

    private String adminIp;

    private Long operTime;

    private String description;

    private Long adminId;

    public Long getLogId(){
        return this.logId;
    }

    public void setLogId(Long logId){
        this.logId = logId;
    }

    public String getAdminIp(){
        return this.adminIp;
    }

    public void setAdminIp(String adminIp){
        this.adminIp = adminIp;
    }

    public Long getOperTime(){
        return this.operTime;
    }

    public void setOperTime(Long operTime){
        this.operTime = operTime;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Long getAdminId(){
        return this.adminId;
    }

    public void setAdminId(Long adminId){
        this.adminId = adminId;
    }

}