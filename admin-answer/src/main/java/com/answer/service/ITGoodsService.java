package com.answer.service;

import com.answer.domain.TGoods;
import com.answer.domain.query.GoodsQuery;
import com.github.pagehelper.PageInfo;

public interface ITGoodsService extends IBaseService<TGoods>{
    PageInfo<TGoods> list(GoodsQuery goodsQuery);

}
