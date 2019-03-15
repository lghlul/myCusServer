package com.answer.domain;

/**
 * @CLassName Train
 * @Description TODO
 * @Author ll
 * @Date 2019/3/15 11:51
 **/
public class TrainQuestion {
    private Long trainID;

    private Long quesID;

    private Long answerID;

    public Long getTrainID() {
        return trainID;
    }

    public void setTrainID(Long trainID) {
        this.trainID = trainID;
    }

    public Long getQuesID() {
        return quesID;
    }

    public void setQuesID(Long quesID) {
        this.quesID = quesID;
    }

    public Long getAnswerID() {
        return answerID;
    }

    public void setAnswerID(Long answerID) {
        this.answerID = answerID;
    }
}
