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

    private String answerID;

    /**
     * 是否正确 1正确 2错误
     */
    private Byte isRight;

    public Byte getIsRight() {
        return isRight;
    }

    public void setIsRight(Byte isRight) {
        this.isRight = isRight;
    }

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

    public String getAnswerID() {
        return answerID;
    }

    public void setAnswerID(String answerID) {
        this.answerID = answerID;
    }
}
