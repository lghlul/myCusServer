package com.answer.domain;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/3/27 8:59
 * @Modified By：
 */
public class TrainConfig {
    private Long typeID;
    private String typeName;
    private Integer quesNum;
    private Long trainTime;
    private Double score;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
