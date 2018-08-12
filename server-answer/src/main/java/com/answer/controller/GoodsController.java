package com.answer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.answer.domain.Result;
import com.answer.service.IGoodsService;
import com.answer.utils.Log4jUtil;

@Controller
@RequestMapping("/goods" )
public class GoodsController {
	@Autowired
	private IGoodsService goodsService;


	/**
	 * 商品列表
	 * @param wxSession
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="/goodsList",method=RequestMethod.GET)
	@ResponseBody
	public String goodsList(String wxSession, Integer  pageNo ,Integer  pageSize) {
		Log4jUtil.info("goodsList start...wxSession=" + wxSession + ",pageNo=" +pageNo + ",pageSize=" + pageSize);
		if(pageNo == null){
			pageNo = 1;
		}
		if(pageSize == null){
			pageSize = 10;
		}
		Result result = this.goodsService.getGoodsList(pageNo, pageSize);
		Log4jUtil.info("goodsList end...result=" + JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}

	/**
	 * 商品详情
	 * @param wxSession
	 * @param goodsID
	 * @return
	 */
	@RequestMapping(value="/goodsDetail",method=RequestMethod.GET)
	@ResponseBody
	public String goodsDetail(String wxSession, Long goodsID) {
		Log4jUtil.info("goodsDetail start...wxSession=" + wxSession + ",goodsID=" + goodsID);
		Result result = this.goodsService.getGoodsByID(goodsID);
		Log4jUtil.info("goodsDetail end...result=" + JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}
}
