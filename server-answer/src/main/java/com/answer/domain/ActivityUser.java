package com.answer.domain;

import com.answer.common.PageQuery;

/**
 * @Author: nhsoft.ll
 * @Description: 活动实体
 * @Date:Create：2019/4/3 11:04
 * @Modified By：
 */
public class ActivityUser{
    private Long activityID;

    private String openID;

    private Byte activityStatus;

    private Integer rightNum;

    private Long createTime;


    public Long getActivityID() {
        return activityID;
    }

    public void setActivityID(Long activityID) {
        this.activityID = activityID;
    }

    public String getOpenID() {
        return openID;
    }

    public void setOpenID(String openID) {
        this.openID = openID;
    }

    public Byte getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(Byte activityStatus) {
        this.activityStatus = activityStatus;
    }

    public Integer getRightNum() {
        return rightNum;
    }

    public void setRightNum(Integer rightNum) {
        this.rightNum = rightNum;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
