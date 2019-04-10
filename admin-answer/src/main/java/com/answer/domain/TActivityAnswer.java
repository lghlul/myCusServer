package com.answer.domain;

public class TActivityAnswer extends BaseDomain {

    /**
     * 主键id
     */
    private Long ansID;

    /**
     * 答案
     */
    private String ansDesc;

    /**
     * 问题ID
     */
    private Long quesID;

    /**
     * 创建时间
     */
    private Long createTime;


    private Long activityID;

    public Long getActivityID() {
        return activityID;
    }

    public void setActivityID(Long activityID) {
        this.activityID = activityID;
    }

    public Long getAnsID() {
        return ansID;
    }

    public void setAnsID(Long ansID) {
        this.ansID = ansID;
    }

    public String getAnsDesc(){
        return this.ansDesc;
    }

    public void setAnsDesc(String ansDesc){
        this.ansDesc = ansDesc;
    }

    public Long getQuesID(){
        return this.quesID;
    }

    public void setQuesID(Long quesID){
        this.quesID = quesID;
    }

    public Long getCreateTime(){
        return this.createTime;
    }

    public void setCreateTime(Long createTime){
        this.createTime = createTime;
    }

}