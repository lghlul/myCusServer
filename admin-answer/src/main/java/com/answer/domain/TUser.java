package com.answer.domain;

public class TUser extends BaseDomain{

    /**
     * 自增id
     */
    private Long userID;

    /**
     * 微信openID
     */
    private String openID;

    /**
     * 第一次进入时间
     */
    private Long createTime;

    /**
     * 分数
     */
    private Float score;

    /**
     * 已经使用过的积分
     */
    private Float usedScore;

    /**
     * 工号
     */
    private String jobNum;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userImg;

    public Long getUserID(){
        return this.userID;
    }

    public void setUserID(Long userID){
        this.userID = userID;
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

    public Float getScore(){
        return this.score;
    }

    public void setScore(Float score){
        this.score = score;
    }

    public Float getUsedScore(){
        return this.usedScore;
    }

    public void setUsedScore(Float usedScore){
        this.usedScore = usedScore;
    }

    public String getJobNum(){
        return this.jobNum;
    }

    public void setJobNum(String jobNum){
        this.jobNum = jobNum;
    }

    public String getUserName(){
        return this.userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserImg(){
        return this.userImg;
    }

    public void setUserImg(String userImg){
        this.userImg = userImg;
    }

}