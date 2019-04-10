package com.answer.domain;

import java.util.List;

public class TUserAnswer extends BaseDomain {

    private Long id;

    /**
     * 用户标识
     */
    private String openID;

    /**
     * 题id
     */
    private Long questionID;

    /**
     * 类型id
     */
    private Long typeID;

    /**
     * 用户回答的答案id
     */
    private String answerID;

    /**
     * 是否正确 1正确 2错误
     */
    private Byte isRight;

    /**
     * 1未记分2已计分
     */
    private Byte status;

    private Long createTime;

    private String quesDesc;

    private List<TAnswer> answerList;

    public List<TAnswer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<TAnswer> answerList) {
        this.answerList = answerList;
    }

    public String getQuesDesc() {
        return quesDesc;
    }

    public void setQuesDesc(String quesDesc) {
        this.quesDesc = quesDesc;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getOpenID(){
        return this.openID;
    }

    public void setOpenID(String openID){
        this.openID = openID;
    }

    public Long getQuestionID(){
        return this.questionID;
    }

    public void setQuestionID(Long questionID){
        this.questionID = questionID;
    }

    public Long getTypeID(){
        return this.typeID;
    }

    public void setTypeID(Long typeID){
        this.typeID = typeID;
    }

    public String getAnswerID(){
        return this.answerID;
    }

    public void setAnswerID(String answerID){
        this.answerID = answerID;
    }

    public Byte getIsRight(){
        return this.isRight;
    }

    public void setIsRight(Byte isRight){
        this.isRight = isRight;
    }

    public Byte getStatus(){
        return this.status;
    }

    public void setStatus(Byte status){
        this.status = status;
    }

    public Long getCreateTime(){
        return this.createTime;
    }

    public void setCreateTime(Long createTime){
        this.createTime = createTime;
    }

}