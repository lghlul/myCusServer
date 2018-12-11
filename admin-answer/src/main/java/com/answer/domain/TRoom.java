package com.answer.domain;

public class TRoom extends BaseDomain{

    private Long roomID;

    /**
     * 创建人openid
     */
    private String createOpenID;

    /**
     * 被邀请人openid
     */
    private String openID;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 加入时间
     */
    private Long joinTime;

    /**
     * 题型
     */
    private Long typeID;

    /**
     * 状态1未积分2已计分
     */
    private Byte status;

    public Long getRoomID(){
        return this.roomID;
    }

    public void setRoomID(Long roomID){
        this.roomID = roomID;
    }

    public String getCreateOpenID(){
        return this.createOpenID;
    }

    public void setCreateOpenID(String createOpenID){
        this.createOpenID = createOpenID;
    }

    public String getOpenID(){
        return this.openID;
    }

    public void setOpenID(String openID){
        this.openID = openID;
    }

    public Long getCreateTime(){
        return this.createTime;
    }

    public void setCreateTime(Long createTime){
        this.createTime = createTime;
    }

    public Long getJoinTime(){
        return this.joinTime;
    }

    public void setJoinTime(Long joinTime){
        this.joinTime = joinTime;
    }

    public Long getTypeID(){
        return this.typeID;
    }

    public void setTypeID(Long typeID){
        this.typeID = typeID;
    }

    public Byte getStatus(){
        return this.status;
    }

    public void setStatus(Byte status){
        this.status = status;
    }

}