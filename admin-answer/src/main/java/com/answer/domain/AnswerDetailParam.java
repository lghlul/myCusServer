package com.answer.domain;

/**
 * @CLassName AnswerDetailParam
 * @Description TODO
 * @Author ll
 * @Date 2018/12/14 16:49
 **/
public class AnswerDetailParam extends BaseDomain {

    private String openID;

    private Integer isRight;

    private String quesDesc;

    private Long startTime;

    private Long endTime;

    public String getOpenID() {
        return openID;
    }

    public void setOpenID(String openID) {
        this.openID = openID;
    }

    public Integer getIsRight() {
        return isRight;
    }

    public void setIsRight(Integer isRight) {
        this.isRight = isRight;
    }

    public String getQuesDesc() {
        return quesDesc;
    }

    public void setQuesDesc(String quesDesc) {
        this.quesDesc = quesDesc;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }
}
