package com.answer.domain;

public class ActivityUserAnswer {
    private String openID;

    private Long activityID;

    private Long quesID;

    private String answerID;

    private Byte isRight;


    public String getOpenID() {
        return openID;
    }

    public void setOpenID(String openID) {
        this.openID = openID;
    }

    public Long getActivityID() {
        return activityID;
    }

    public void setActivityID(Long activityID) {
        this.activityID = activityID;
    }

    public Long getQuesID() {
        return quesID;
    }

    public void setQuesID(Long quesID) {
        this.quesID = quesID;
    }

    public String getAnswerID() {
        return answerID;
    }

    public void setAnswerID(String answerID) {
        this.answerID = answerID;
    }

    public Byte getIsRight() {
        return isRight;
    }

    public void setIsRight(Byte isRight) {
        this.isRight = isRight;
    }
}
