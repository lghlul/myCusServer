package com.answer.mapper;

import java.util.List;
import java.util.Map;

import com.answer.domain.Order;

public interface OrderMapper {
	public List<Order> queryOrderPage(Map<String , Object> map);
	public int queryOrderCount(Map<String , Object> map);
	public int queryCountByNo(String orderNo);
	public int addOrder(Order order);
	public int updateOrder(Map<String , Object> map);
}
