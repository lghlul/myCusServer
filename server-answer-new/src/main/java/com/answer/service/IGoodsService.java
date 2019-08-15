package com.answer.service;

import com.answer.domain.Result;

public interface IGoodsService {
	
	public Result getGoodsList(int pageNo,int pageSize);
	
	
	public Result getGoodsByID(long goodsID);
}
