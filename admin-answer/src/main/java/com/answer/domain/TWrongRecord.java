package com.answer.domain;

public class TWrongRecord extends BaseDomain{

    private Long id;

    /**
     * 题目iD
     */
    private Long questionID;

    /**
     * openID
     */
    private String openID;

    /**
     * 回答id
     */
    private String answerID;

    private Long createTime;

    private Long typeID;

    /**
     * 1正常2删除
     */
    private Byte status;

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getQuestionID(){
        return this.questionID;
    }

    public void setQuestionID(Long questionID){
        this.questionID = questionID;
    }

    public String getOpenID(){
        return this.openID;
    }

    public void setOpenID(String openID){
        this.openID = openID;
    }

    public String getAnswerID(){
        return this.answerID;
    }

    public void setAnswerID(String answerID){
        this.answerID = answerID;
    }

    public Long getCreateTime(){
        return this.createTime;
    }

    public void setCreateTime(Long createTime){
        this.createTime = createTime;
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