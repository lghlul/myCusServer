package com.answer.controller;

import com.answer.common.PageResult;
import com.answer.common.ResultCodeEnum;
import com.answer.domain.TGoods;
import com.answer.domain.TOrder;
import com.answer.domain.TQuestion;
import com.answer.domain.query.GoodsQuery;
import com.answer.domain.query.OrderQuery;
import com.answer.domain.query.QuestionQuery;
import com.answer.service.ITAnswerService;
import com.answer.service.ITGoodsService;
import com.answer.service.ITOrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/4/26 16:23
 * @Modified By：
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private ITGoodsService goodsService;

    @Autowired
    private ITOrderService orderService;

    @GetMapping("list")
    public Object list(GoodsQuery goodsQuery) {
        PageInfo<TGoods> page = goodsService.list(goodsQuery);
        PageResult pageResult = new PageResult();
        pageResult.setTotalCount(page.getTotal());
        pageResult.setTotalPage(page.getPages());
        pageResult.setList(page.getList());
        return ResultCodeEnum.SUCCESS.getResponse(pageResult);
    }

    @PostMapping("update")
    public Object list(TGoods goods) {
        goodsService.edit(goods);
        return ResultCodeEnum.SUCCESS.getResponse();
    }

    @PostMapping("updateOrder")
    public Object updateOrder(TOrder order) {
        orderService.edit(order);
        return ResultCodeEnum.SUCCESS.getResponse();
    }


    @GetMapping("listOrder")
    public Object listOrder(OrderQuery orderQuery) {
        PageInfo<TOrder> page = orderService.list(orderQuery);
        PageResult pageResult = new PageResult();
        pageResult.setTotalCount(page.getTotal());
        pageResult.setTotalPage(page.getPages());
        pageResult.setList(page.getList());
        return ResultCodeEnum.SUCCESS.getResponse(pageResult);
    }
}
