package com.answer.domain;

public class TRole extends BaseDomain{

    private Long roleId;

    private String roleName;

    private Byte roleStatus;

    private Long creater;

    private Long createTime;

    public Long getRoleId(){
        return this.roleId;
    }

    public void setRoleId(Long roleId){
        this.roleId = roleId;
    }

    public String getRoleName(){
        return this.roleName;
    }

    public void setRoleName(String roleName){
        this.roleName = roleName;
    }

    public Byte getRoleStatus(){
        return this.roleStatus;
    }

    public void setRoleStatus(Byte roleStatus){
        this.roleStatus = roleStatus;
    }

    public Long getCreater(){
        return this.creater;
    }

    public void setCreater(Long creater){
        this.creater = creater;
    }

    public Long getCreateTime(){
        return this.createTime;
    }

    public void setCreateTime(Long createTime){
        this.createTime = createTime;
    }

}