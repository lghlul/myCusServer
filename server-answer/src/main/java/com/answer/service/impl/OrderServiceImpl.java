package com.answer.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.answer.cache.CacheHelper;
import com.answer.domain.Goods;
import com.answer.domain.Order;
import com.answer.domain.Result;
import com.answer.domain.User;
import com.answer.domain.WXSessionCache;
import com.answer.mapper.GoodsMapper;
import com.answer.mapper.OrderMapper;
import com.answer.mapper.UserMapper;
import com.answer.service.IOrderService;
import com.answer.utils.CommonUtil;
import com.answer.utils.Constant;
import com.answer.utils.DateUtil;
import com.answer.utils.Log4jUtil;

@Service
public class OrderServiceImpl implements IOrderService {
	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private CacheHelper cacheHelper;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public Result addOrder(String wxSession, long goodsID) {
		Result result = new Result();
		WXSessionCache session = this.cacheHelper.getSession(wxSession);
		float score = userMapper.queryScore(session.getOpenID());
		Goods goods = goodsMapper.queryGoodsByID(goodsID);
		if (goods == null) {
			// 商品不存在
			result.setResultCode(Constant.returnCode.NOT_EXIST);
			return result;
		}
		if (goods.getGoodsScore() > score) {
			// 积分不够
			result.setResultCode(Constant.returnCode.SCORE_NOT_ENOUGH);
			return result;
		}
		boolean isExist = true;
		String orderNo = "";
		while (isExist) {
			// 生成编号
			orderNo = CommonUtil.createRandom(false, 20);
			// 验证编号是够存在
			int i = this.orderMapper.queryCountByNo(orderNo);
			if (i < 1) {
				isExist = false;
			}
		}
		Order order = new Order();
		order.setCreateTime(System.currentTimeMillis());
		order.setGoodsID(goodsID);
		order.setOpenID(session.getOpenID());
		order.setOrderNo(orderNo);
		Log4jUtil.info("addOrder start...order=" + JSON.toJSONString(order));
		this.orderMapper.addOrder(order);
		//减去积分
		User user = new User();
		user.setOpenID(session.getOpenID());
		user.setScore(-goods.getGoodsScore());
		user.setUsedScore(goods.getGoodsScore());
		Log4jUtil.info("updateUser start...user=" + JSON.toJSONString(user));
		userMapper.updateUser(user);
		
		Map<String , Object> resultMap = new HashMap<>();
		resultMap.put("orderNo", orderNo);
		result.setResultData(resultMap);
		return result;
	}

	@Override
	public Result getOrderList(String wxSession, int pageNo, int pageSize) {
		Result result = new Result();
		Map<String , Object> map = new HashMap<>();
		map.put("start", (pageNo - 1)*pageSize);
		map.put("pageSize", pageSize);
		WXSessionCache session = this.cacheHelper.getSession(wxSession);
		map.put("openID", session.getOpenID());
		int totalCount = orderMapper.queryOrderCount(map);
		Log4jUtil.info("getOrderList...totalCount=" + totalCount);
		if(totalCount < 1){
			result.setResultCode(Constant.returnCode.NO_DATA);
			return result;
		}else{
			Map<String , Object> resultMap = new HashMap<>();
			List<Order> list = orderMapper.queryOrderPage(map);
			if(list != null){
				for(Order order : list){
					order.setTimeStr(DateUtil.convertByLong(order.getCreateTime()));
				}
			}
			resultMap.put("list", list);
			resultMap.put("totalCount", totalCount);
			int pageCount = totalCount%pageSize == 0?totalCount/pageSize : (totalCount/pageSize + 1);
			resultMap.put("pageCount", pageCount);
			result.setResultData(resultMap);
			return result;
		}
	}
}
