package com.answer.domain;

import java.util.List;

public class TMenu extends BaseDomain{

    /**
     * 菜单ID
     */
    private Long menuId;

    /**
     * 菜单父ID
     */
    private Long parentId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单地址
     */
    private String menuUrl;

    /**
     * 菜单排序
     */
    private Integer menuOrder;

    /**
     * 菜单状态(1启用 2停用)
     */
    private Byte menuStatus;

    /**
     * 菜单描述
     */
    private String menuDesc;

    /**
     * 菜单图标
     */
    private String menuIcon;

    /**
     * 创建时间
     */
    private Long createTime;

    private String creater;

    private List<TMenu> children;

    public List<TMenu> getChildren() {
        return children;
    }

    public void setChildren(List<TMenu> children) {
        this.children = children;
    }

    public Long getMenuId(){
        return this.menuId;
    }

    public void setMenuId(Long menuId){
        this.menuId = menuId;
    }

    public Long getParentId(){
        return this.parentId;
    }

    public void setParentId(Long parentId){
        this.parentId = parentId;
    }

    public String getMenuName(){
        return this.menuName;
    }

    public void setMenuName(String menuName){
        this.menuName = menuName;
    }

    public String getMenuUrl(){
        return this.menuUrl;
    }

    public void setMenuUrl(String menuUrl){
        this.menuUrl = menuUrl;
    }

    public Integer getMenuOrder(){
        return this.menuOrder;
    }

    public void setMenuOrder(Integer menuOrder){
        this.menuOrder = menuOrder;
    }

    public Byte getMenuStatus(){
        return this.menuStatus;
    }

    public void setMenuStatus(Byte menuStatus){
        this.menuStatus = menuStatus;
    }

    public String getMenuDesc(){
        return this.menuDesc;
    }

    public void setMenuDesc(String menuDesc){
        this.menuDesc = menuDesc;
    }

    public String getMenuIcon(){
        return this.menuIcon;
    }

    public void setMenuIcon(String menuIcon){
        this.menuIcon = menuIcon;
    }

    public Long getCreateTime(){
        return this.createTime;
    }

    public void setCreateTime(Long createTime){
        this.createTime = createTime;
    }

    public String getCreater(){
        return this.creater;
    }

    public void setCreater(String creater){
        this.creater = creater;
    }

}