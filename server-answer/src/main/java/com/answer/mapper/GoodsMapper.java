package com.answer.mapper;

import java.util.List;
import java.util.Map;

import com.answer.domain.Goods;

public interface GoodsMapper {
	public List<Goods> queryGoodsPage(Map<String,Object> map);
	public int queryGoodsCount(Map<String,Object> map);
	public Goods queryGoodsByID(long goodsID);
}
