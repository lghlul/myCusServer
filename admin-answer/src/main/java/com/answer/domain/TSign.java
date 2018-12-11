package com.answer.domain;

public class TSign extends BaseDomain{

    /**
     * 签到id
     */
    private Long signID;

    /**
     * openID
     */
    private String openID;

    /**
     * 签到时间
     */
    private Long signTime;

    public Long getSignID(){
        return this.signID;
    }

    public void setSignID(Long signID){
        this.signID = signID;
    }

    public String getOpenID(){
        return this.openID;
    }

    public void setOpenID(String openID){
        this.openID = openID;
    }

    public Long getSignTime(){
        return this.signTime;
    }

    public void setSignTime(Long signTime){
        this.signTime = signTime;
    }

}