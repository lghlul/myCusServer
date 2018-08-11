package com.answer.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.answer.domain.Goods;
import com.answer.domain.Result;
import com.answer.mapper.GoodsMapper;
import com.answer.service.IGoodsService;
import com.answer.utils.Constant;

@Service
public class GoodsServiceImpl implements IGoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
	@Override
	public Result getGoodsList(int pageNo, int pageSize) {
		Result result = new Result();
		Map<String , Object> map = new HashMap<>();
		map.put("start", (pageNo - 1)*pageSize);
		map.put("pageSize", pageSize);
		int totalCount = goodsMapper.queryGoodsCount(map);
		if(totalCount < 1){
			result.setResultCode(Constant.returnCode.NO_DATA);
			return result;
		}else{
			Map<String , Object> resultMap = new HashMap<>();
			List<Goods> list = goodsMapper.queryGoodsPage(map);
			resultMap.put("list", list);
			resultMap.put("totalCount", totalCount);
			int pageCount = totalCount%pageSize == 0?totalCount/pageSize : (totalCount/pageSize + 1);
			resultMap.put("pageCount", pageCount);
			result.setResultData(resultMap);
			return result;
		}
	}
	@Override
	public Result getGoodsByID(long goodsID) {
		Result result = new Result();
		Goods goods = this.goodsMapper.queryGoodsByID(goodsID);
		result.setResultData(goods);
		return result;
	}
}
