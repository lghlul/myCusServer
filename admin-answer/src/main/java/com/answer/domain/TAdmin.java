package com.answer.domain;

public class TAdmin extends BaseDomain {

    /**
     * 管理员ID
     */
    private Long adminId;

    /**
     * 用户账号
     */
    private String adminName;

    /**
     * 用户密码
     */
    private String adminPwd;

    /**
     * 用户状态
     */
    private Byte adminStatus;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 创建者
     */
    private Long creater;

    /**
     * 创建时间
     */
    private Long createTime;

    public Long getAdminId(){
        return this.adminId;
    }

    public void setAdminId(Long adminId){
        this.adminId = adminId;
    }

    public String getAdminName(){
        return this.adminName;
    }

    public void setAdminName(String adminName){
        this.adminName = adminName;
    }

    public String getAdminPwd(){
        return this.adminPwd;
    }

    public void setAdminPwd(String adminPwd){
        this.adminPwd = adminPwd;
    }

    public Byte getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(Byte adminStatus) {
        this.adminStatus = adminStatus;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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