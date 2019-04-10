package com.answer.domain;

public class TType extends BaseDomain {

    private Long typeID;

    private Long parentID;

    private String typeName;

    private Long createTime;

    /**
     * 1正常2禁用
     */
    private Byte typeStatus;

    /**
     * 类型图片
     */
    private String typeImg;

    public Long getTypeID(){
        return this.typeID;
    }

    public void setTypeID(Long typeID){
        this.typeID = typeID;
    }

    public Long getParentID(){
        return this.parentID;
    }

    public void setParentID(Long parentID){
        this.parentID = parentID;
    }

    public String getTypeName(){
        return this.typeName;
    }

    public void setTypeName(String typeName){
        this.typeName = typeName;
    }

    public Long getCreateTime(){
        return this.createTime;
    }

    public void setCreateTime(Long createTime){
        this.createTime = createTime;
    }

    public Byte getTypeStatus(){
        return this.typeStatus;
    }

    public void setTypeStatus(Byte typeStatus){
        this.typeStatus = typeStatus;
    }

    public String getTypeImg(){
        return this.typeImg;
    }

    public void setTypeImg(String typeImg){
        this.typeImg = typeImg;
    }

}