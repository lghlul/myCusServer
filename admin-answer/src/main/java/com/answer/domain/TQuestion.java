package com.answer.domain;

public class TQuestion extends BaseDomain{

    /**
     * 主键iD
     */
    private Long quesID;

    /**
     * 题干
     */
    private String quesDesc;

    /**
     * 题目类型
     */
    private Long typeID;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 创建人
     */
    private Long creater;

    /**
     * 答案
     */
    private String rightAnswerID;

    /**
     * 1 单选2 多选 3判断
     */
    private Byte quesType;

    public Long getQuesID(){
        return this.quesID;
    }

    public void setQuesID(Long quesID){
        this.quesID = quesID;
    }

    public String getQuesDesc(){
        return this.quesDesc;
    }

    public void setQuesDesc(String quesDesc){
        this.quesDesc = quesDesc;
    }

    public Long getTypeID(){
        return this.typeID;
    }

    public void setTypeID(Long typeID){
        this.typeID = typeID;
    }

    public Long getCreateTime(){
        return this.createTime;
    }

    public void setCreateTime(Long createTime){
        this.createTime = createTime;
    }

    public Long getCreater(){
        return this.creater;
    }

    public void setCreater(Long creater){
        this.creater = creater;
    }

    public String getRightAnswerID(){
        return this.rightAnswerID;
    }

    public void setRightAnswerID(String rightAnswerID){
        this.rightAnswerID = rightAnswerID;
    }

    public Byte getQuesType(){
        return this.quesType;
    }

    public void setQuesType(Byte quesType){
        this.quesType = quesType;
    }

}