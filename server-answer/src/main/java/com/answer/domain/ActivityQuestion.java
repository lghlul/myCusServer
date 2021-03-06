package com.answer.domain;

import java.util.List;

public class ActivityQuestion{

    /**
     * 主键iD
     */
    private Long quesID;

    /**
     * 题干
     */
    private String quesDesc;

    /**
     * 活动ID
     */
    private Long activityID;

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
    /**
     * 用户答案
     */
    private String answerID;


    private Byte isRight;

    public Byte getIsRight() {
        return isRight;
    }

    public void setIsRight(Byte isRight) {
        this.isRight = isRight;
    }

    private List<ActivityAnswer> answerList;


    public String getAnswerID() {
        return answerID;
    }

    public void setAnswerID(String answerID) {
        this.answerID = answerID;
    }


    public List<ActivityAnswer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<ActivityAnswer> answerList) {
        this.answerList = answerList;
    }

    public Long getQuesID() {
        return quesID;
    }

    public void setQuesID(Long quesID) {
        this.quesID = quesID;
    }

    public String getQuesDesc() {
        return quesDesc;
    }

    public void setQuesDesc(String quesDesc) {
        this.quesDesc = quesDesc;
    }

    public Long getActivityID() {
        return activityID;
    }

    public void setActivityID(Long activityID) {
        this.activityID = activityID;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public String getRightAnswerID() {
        return rightAnswerID;
    }

    public void setRightAnswerID(String rightAnswerID) {
        this.rightAnswerID = rightAnswerID;
    }

    public Byte getQuesType() {
        return quesType;
    }

    public void setQuesType(Byte quesType) {
        this.quesType = quesType;
    }
}