package com.answer.domain;

public class TOrder extends BaseDomain {

    private Long orderID;

    /**
     * 编号
     */
    private String orderNo;

    /**
     * 商品名称
     */
    private Long goodsID;

    private String openID;

    /**
     * 订单创建时间
     */
    private Long createTime;

    /**
     * 状态1未领取2已领取
     */
    private Byte orderStatus;

    public Long getOrderID(){
        return this.orderID;
    }

    public void setOrderID(Long orderID){
        this.orderID = orderID;
    }

    public String getOrderNo(){
        return this.orderNo;
    }

    public void setOrderNo(String orderNo){
        this.orderNo = orderNo;
    }

    public Long getGoodsID(){
        return this.goodsID;
    }

    public void setGoodsID(Long goodsID){
        this.goodsID = goodsID;
    }

    public String getOpenID(){
        return this.openID;
    }

    public void setOpenID(String openID){
        this.openID = openID;
    }

    public Long getCreateTime(){
        return this.createTime;
    }

    public void setCreateTime(Long createTime){
        this.createTime = createTime;
    }

    public Byte getOrderStatus(){
        return this.orderStatus;
    }

    public void setOrderStatus(Byte orderStatus){
        this.orderStatus = orderStatus;
    }

}