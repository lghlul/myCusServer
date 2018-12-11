package com.answer.domain;

public class TAnswer extends BaseDomain{

    /**
     * 主键id
     */
    private Integer ansID;

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

    public Integer getAnsID(){
        return this.ansID;
    }

    public void setAnsID(Integer ansID){
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