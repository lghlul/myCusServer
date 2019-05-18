package com.answer.domain.query;

import com.answer.common.PageQuery;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/4/3 11:04
 * @Modified By：
 */
public class ActivityQuery extends PageQuery {

    private String activityName;

    private Byte activityStatus;

    public Byte getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(Byte activityStatus) {
        this.activityStatus = activityStatus;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}
