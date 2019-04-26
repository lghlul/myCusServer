package com.answer.mapper;

import com.answer.domain.TGoods;
import com.answer.domain.query.GoodsQuery;

import java.util.List;

public interface TGoodsMapper extends BaseMapper<TGoods>{

    List<TGoods> list(GoodsQuery goodsQuery);

}