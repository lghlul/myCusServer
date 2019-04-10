package com.answer.domain;

public class TGoods extends BaseDomain {

    private Long goodsID;

    /**
     * 图标
     */
    private String goodsIcon;

    /**
     * 大图
     */
    private String goodsImg;

    /**
     * 描述
     */
    private String goodsDesc;

    /**
     * 排序
     */
    private Integer goodsSort;

    /**
     * 所需积分
     */
    private Float goodsScore;

    /**
     * 状态 1上架2下架
     */
    private Byte goodsStatus;

    /**
     * 商品名称
     */
    private String goodsName;

    public Long getGoodsID(){
        return this.goodsID;
    }

    public void setGoodsID(Long goodsID){
        this.goodsID = goodsID;
    }

    public String getGoodsIcon(){
        return this.goodsIcon;
    }

    public void setGoodsIcon(String goodsIcon){
        this.goodsIcon = goodsIcon;
    }

    public String getGoodsImg(){
        return this.goodsImg;
    }

    public void setGoodsImg(String goodsImg){
        this.goodsImg = goodsImg;
    }

    public String getGoodsDesc(){
        return this.goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc){
        this.goodsDesc = goodsDesc;
    }

    public Integer getGoodsSort(){
        return this.goodsSort;
    }

    public void setGoodsSort(Integer goodsSort){
        this.goodsSort = goodsSort;
    }

    public Float getGoodsScore(){
        return this.goodsScore;
    }

    public void setGoodsScore(Float goodsScore){
        this.goodsScore = goodsScore;
    }

    public Byte getGoodsStatus(){
        return this.goodsStatus;
    }

    public void setGoodsStatus(Byte goodsStatus){
        this.goodsStatus = goodsStatus;
    }

    public String getGoodsName(){
        return this.goodsName;
    }

    public void setGoodsName(String goodsName){
        this.goodsName = goodsName;
    }

}