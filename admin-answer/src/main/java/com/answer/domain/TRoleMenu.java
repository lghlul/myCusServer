package com.answer.domain;

public class TRoleMenu extends BaseDomain {

    private Integer id;

    /**
     * 菜单ID
     */
    private Long menuId;

    /**
     * 角色ID
     */
    private Long roleId;

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Long getMenuId(){
        return this.menuId;
    }

    public void setMenuId(Long menuId){
        this.menuId = menuId;
    }

    public Long getRoleId(){
        return this.roleId;
    }

    public void setRoleId(Long roleId){
        this.roleId = roleId;
    }

}