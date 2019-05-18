package com.answer.controller;

import com.answer.domain.Config;
import com.answer.domain.SignConfig;
import com.answer.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.answer.domain.Result;
import com.answer.service.IOrderService;
import com.answer.utils.Log4jUtil;

@Controller
@RequestMapping("/order" )
public class OrderController {

	@Autowired
	private IOrderService orderService;
	
	/**
	 * 兑换奖品
	 * @param wxSession
	 * @param goodsID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value ="/change", method = RequestMethod.POST )
	@ResponseBody
	public String change(String wxSession , Long goodsID) throws Exception {
		Log4jUtil.info("change start...wxSession=" + wxSession + ",goodsID=" + goodsID);
		Result result = this.orderService.addOrder(wxSession, goodsID);
		Log4jUtil.info("change end...result=" + JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}

	/**
	 * 兑换列表
	 * @param wxSession
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="/orderList",method=RequestMethod.GET )
	@ResponseBody
	public String orderList(String wxSession ,Integer pageNo , Integer pageSize) {
		Log4jUtil.info("orderList start...wxSession=" + wxSession + ",pageNo=" + pageNo + ",pageSize=" + pageSize);
		if(pageNo == null){
			pageNo = 1;
		}
		if(pageSize == null){
			pageNo = 10;
		}
		Result result = this.orderService.getOrderList(wxSession, pageNo, pageSize);
		Log4jUtil.info("orderList end...result=" + JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}
	
}
