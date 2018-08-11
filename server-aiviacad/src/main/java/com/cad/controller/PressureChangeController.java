package com.cad.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.cad.domain.PressureChange;
import com.cad.domain.Result;
import com.cad.service.IPressureChangeService;
import com.cad.service.IVisitService;
import com.cad.utils.DataFormatUtil;

/**
 * 
 * @author Lu
 * @Description: 压力转换
 * @Package com.cad.controller
 * @date 2017年4月19日 下午10:14:06 
 * @version V1.0
 */
@Controller
@RequestMapping("/pressureChange")
public class PressureChangeController extends BaseController{

	@Autowired
	private IPressureChangeService pressureChangeService;

	@Autowired
	private IVisitService visitService;
	
	/**
	 * 
	* @Title: toIndex 
	* @Description: 压力转换页面
	* @param @param pressureChange
	* @param @param model
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("/toIndex.do")
	public String toIndex(PressureChange pressureChange,Model model) {
		//访问数量
		model.addAttribute("visitCount", DataFormatUtil.intFarmat(this.visitService.getVisitCount()));
		return "pressureChange";
	}

	/**
	 * 
	* @Title: change 
	* @Description: 转换
	* @param @param pressureChange
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping("/pressureChange.do")
	public String change(PressureChange pressureChange) {
		Result result = new Result();
		result.setResultData(this.pressureChangeService.change(pressureChange));
		//访问数量
		result.setVisitNum(DataFormatUtil.intFarmat(this.visitService.getVisitCount()));
		return JSON.toJSONString(result);
	}
}
