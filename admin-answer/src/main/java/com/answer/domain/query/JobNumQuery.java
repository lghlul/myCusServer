package com.answer.domain.query;

import com.answer.common.PageQuery;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/4/27 19:45
 * @Modified By：
 */
public class JobNumQuery extends PageQuery {

    private Long orgID;

    private String realName;

    private String jobNum;

    private Byte status;

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getJobNum() {
        return jobNum;
    }

    public void setJobNum(String jobNum) {
        this.jobNum = jobNum;
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
}
