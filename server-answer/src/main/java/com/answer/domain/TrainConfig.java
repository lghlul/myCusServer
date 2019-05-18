package com.answer.domain;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/3/27 8:59
 * @Modified By：
 */
public class TrainConfig {
    private Long typeID;
    private Integer quesNum;
    private Long trainTime;
    private Float score;
    private Integer rightNum;

    public Integer getRightNum() {
        return rightNum;
    }

    public void setRightNum(Integer rightNum) {
        this.rightNum = rightNum;
    }

    public Long getTypeID() {
        return typeID;
    }

    public void setTypeID(Long typeID) {
        this.typeID = typeID;
    }

    public Integer getQuesNum() {
        return quesNum;
    }

    public void setQuesNum(Integer quesNum) {
        this.quesNum = quesNum;
    }

    public Long getTrainTime() {
        return trainTime;
    }

    public void setTrainTime(Long trainTime) {
        this.trainTime = trainTime;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}
