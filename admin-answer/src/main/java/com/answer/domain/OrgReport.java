package com.answer.domain;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/4/21 16:14
 * @Modified By：
 */
public class OrgReport {
    private Long activityID;

    private String activityName;

    private Long orgID;


    private String orgName;


    private Integer rightNum;


    private Integer quesNum;

    private Integer joinNum;

    public Integer getJoinNum() {
        return joinNum;
    }

    public void setJoinNum(Integer joinNum) {
        this.joinNum = joinNum;
    }

    public Integer getQuesNum() {
        if(quesNum == null){
            return 0;
        }
        return quesNum;
    }

    public void setQuesNum(Integer quesNum) {
        this.quesNum = quesNum;
    }

    public Long getActivityID() {
        return activityID;
    }

    public void setActivityID(Long activityID) {
        this.activityID = activityID;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Long getOrgID() {
        return orgID;
    }

    public void setOrgID(Long orgID) {
        this.orgID = orgID;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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
}
