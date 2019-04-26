package com.answer.domain.query;

import com.answer.common.PageQuery;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/4/26 17:43
 * @Modified By：
 */
public class OrgReportQuery extends PageQuery {
    private Long orgID;

    private String activityName;

    public Long getOrgID() {
        return orgID;
    }

    public void setOrgID(Long orgID) {
        this.orgID = orgID;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}
