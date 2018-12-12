package com.answer.domain;

/**
 * @CLassName OrgCount
 * @Description TODO
 * @Author ll
 * @Date 2018/12/12 20:26
 **/
public class OrgCount {

    private Long orgID;


    private String orgName;

    private int countNum;

    private int rightNum;

    private String rightPercent;


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

    public int getCountNum() {
        return countNum;
    }

    public void setCountNum(int countNum) {
        this.countNum = countNum;
    }

    public int getRightNum() {
        return rightNum;
    }

    public void setRightNum(int rightNum) {
        this.rightNum = rightNum;
    }

    public String getRightPercent() {
        return rightPercent;
    }

    public void setRightPercent(String rightPercent) {
        this.rightPercent = rightPercent;
    }
}
