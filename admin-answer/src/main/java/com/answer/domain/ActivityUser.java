package com.answer.domain;

import com.answer.common.PageQuery;

/**
 * @Author: nhsoft.ll
 * @Description: 活动人员
 * @Date:Create：2019/4/3 11:04
 * @Modified By：
 */
public class ActivityUser extends PageQuery {
    private String openID;

    private Long createTime;

    private Integer rightNum;

    private Long orgID;

    private String realName;

    private String orgName;

    public String getOpenID() {
        return openID;
    }

    public void setOpenID(String openID) {
        this.openID = openID;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getRightNum() {
        return rightNum;
    }

    public void setRightNum(Integer rightNum) {
        this.rightNum = rightNum;
    }

    public Long getOrgID() {
        return orgID;
    }

    public void setOrgID(Long orgID) {
        this.orgID = orgID;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
