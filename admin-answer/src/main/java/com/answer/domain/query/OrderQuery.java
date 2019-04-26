package com.answer.domain.query;

import com.answer.common.PageQuery;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/4/26 16:45
 * @Modified By：
 */
public class OrderQuery extends PageQuery {
    private String realName;

    private String orderNo;

    private Byte orderStatus;

    private String goodsName;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }
}
