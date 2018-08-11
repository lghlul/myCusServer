package com.cad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.cad.domain.Pressure;
import com.cad.domain.Result;
import com.cad.service.IPressureService;
import com.cad.service.IVisitService;
import com.cad.utils.DataFormatUtil;

/**
 * 
 * @author Lu
 * @Description: 气缸压力
 * @Package com.cad.controller
 * @date 2017年4月19日 下午10:15:48 
 * @version V1.0
 */
@Controller
@RequestMapping("/pressure")
public class PressureController extends BaseController{

	@Autowired
	private IPressureService pressureService;

	@Autowired
	private IVisitService visitService;
	
	/**
	 * 
	* @Title: toIndex 
	* @Description: 气缸压力页面
	* @param @param model
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("/toIndex.do")
	public String toIndex(Model model) {
		//缸径
		model.addAttribute("boreSize", this.pressureService.getBoreSize());
		//气压
		model.addAttribute("pressureSize", this.pressureService.getPressureSize());
		//访问数量
		model.addAttribute("visitCount", DataFormatUtil.intFarmat(this.visitService.getVisitCount()));
		return "pressure";
	}

	/**
	 * 
	* @Title: getDeviationValue 
	* @Description: 获取伸缩压力
	* @param @param pressure
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping("/getValue.do")
	public String getDeviationValue(Pressure pressure) {
		//获取压力值
		List<Pressure> value = this.pressureService.getValue(pressure);
		Result result = new Result();
		result.setResultData(value);
		//访问数量
		result.setVisitNum(DataFormatUtil.intFarmat(this.visitService.getVisitCount()));
		return JSON.toJSONString(result);
	}
}