package com.answer.domain;

/**
 * @CLassName Train
 * @Description TODO
 * @Author ll
 * @Date 2019/3/15 11:51
 **/
public class Train {
    private Long trainID;

    private String creater;

    private Long createTime;

    private Long typeID;


    private Byte trainStatus;

    private Long finishTime;


    private Integer quesNum;

    private Integer rightNum;

    public Integer getQuesNum() {
        if(quesNum == null){
            return 0;
        }
        return quesNum;
    }

    public void setQuesNum(Integer quesNum) {
        this.quesNum = quesNum;
    }

    public Integer getRightNum() {
        if(rightNum == null){
            return 0;
        }
        return rightNum;
    }

    public void setRightNum(Integer rightNum) {
        this.rightNum = rightNum;
    }

    public Byte getTrainStatus() {
        return trainStatus;
    }

    public void setTrainStatus(Byte trainStatus) {
        this.trainStatus = trainStatus;
    }

    public Long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Long finishTime) {
        this.finishTime = finishTime;
    }

    public Long getTrainID() {
        return trainID;
    }

    public void setTrainID(Long trainID) {
        this.trainID = trainID;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getTypeID() {
        return typeID;
    }

    public void setTypeID(Long typeID) {
        this.typeID = typeID;
    }
}
