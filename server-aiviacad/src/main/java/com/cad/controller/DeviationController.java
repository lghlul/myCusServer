package com.cad.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.cad.domain.Deviation;
import com.cad.domain.Result;
import com.cad.service.IDeviationService;
import com.cad.service.IVisitService;
import com.cad.utils.DataFormatUtil;
/**
 * 
 * @author Lu
 * @Description: 公差查询
 * @Package com.cad.controller
 * @date 2017年4月19日 下午10:12:42 
 * @version V1.0
 */
@Controller
public class DeviationController extends BaseController{

	@Autowired
	private IDeviationService deviationService;
	
	
	@Autowired
	private IVisitService visitService;

	/**
	 * 
	* @Title: getDeviation 
	* @Description: 获取公差列表
	* @param @param deviation
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping("/getDeviation.do")
	public String getDeviation(Deviation deviation,HttpServletRequest request) {
		List<Deviation> list = this.deviationService.getDeviation(deviation);
		Result result = new Result();
		result.setResultData(list);
		
		//访问数量
		result.setVisitNum(DataFormatUtil.intFarmat(this.visitService.getVisitCount()));
		return JSON.toJSONString(result);
	}

	/**
	 * 
	* @Title: getDeviationValue 
	* @Description: 获取公差值
	* @param @param deviation
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping("/getDeviationValue.do")
	public String getDeviationValue(Deviation deviation) {
		Deviation deviationValue = this.deviationService.getDeviationValue(deviation);
		Result result = new Result();
		result.setResultData(deviationValue);
		
		//访问数量
		result.setVisitNum(DataFormatUtil.intFarmat(this.visitService.getVisitCount()));
		return JSON.toJSONString(result);
	}
}