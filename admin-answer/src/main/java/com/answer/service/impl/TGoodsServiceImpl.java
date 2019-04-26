package com.answer.service.impl;

import com.answer.domain.TGoods;
import com.answer.domain.TQuestion;
import com.answer.domain.query.GoodsQuery;
import com.answer.mapper.TGoodsMapper;
import com.answer.service.ITGoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TGoodsServiceImpl extends BaseServiceImpl<TGoods> implements ITGoodsService{

    @Autowired
    private TGoodsMapper goodsMapper;

    @Override
    public PageInfo<TGoods> list(GoodsQuery goodsQuery) {
        PageHelper.startPage(goodsQuery.getOffset(), goodsQuery.getLimit());
        if (goodsQuery.getSortField() != null) {
            PageHelper.orderBy(goodsQuery.getSortField() + " " + goodsQuery.getSortDir());
        }
        List<TGoods> goodsList = goodsMapper.list(goodsQuery);
        //得到分页的结果对象
        PageInfo<TGoods> pageInfo = new PageInfo<>(goodsList);
        return pageInfo;
    }
}
