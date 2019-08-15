package com.answer.service;

import com.answer.domain.Result;

public interface IOrderService {
	public Result addOrder(String wxSession , long goodsID);
	public Result getOrderList(String wxSession , int pageNo , int pageSize);
}
