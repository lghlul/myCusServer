package com.answer.domain;

public class TJobnumCopy extends BaseDomain{

    private Long id;

    /**
     * 工号
     */
    private String jobNum;

    /**
     * 状态1整除2已使用
     */
    private Byte status;

    /**
     * 性别1男2女
     */
    private Byte sex;

    /**
     * 真是姓名
     */
    private String realName;

    /**
     * 部门
     */
    private String orgName;

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getJobNum(){
        return this.jobNum;
    }

    public void setJobNum(String jobNum){
        this.jobNum = jobNum;
    }

    public Byte getStatus(){
        return this.status;
    }

    public void setStatus(Byte status){
        this.status = status;
    }

    public Byte getSex(){
        return this.sex;
    }

    public void setSex(Byte sex){
        this.sex = sex;
    }

    public String getRealName(){
        return this.realName;
    }

    public void setRealName(String realName){
        this.realName = realName;
    }

    public String getOrgName(){
        return this.orgName;
    }

    public void setOrgName(String orgName){
        this.orgName = orgName;
    }

}