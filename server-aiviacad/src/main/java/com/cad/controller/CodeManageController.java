package com.cad.controller;

import com.alibaba.fastjson.JSON;
import com.cad.constant.ResultCode;
import com.cad.domain.CodeManage;
import com.cad.domain.Result;
import com.cad.service.ICodeManageService;
import com.cad.service.IVisitService;
import com.cad.utils.CodeUtil;
import com.cad.utils.DataFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


/**
 * 
 * @author Lu
 * @Description: 编码管理
 * @Package com.cad.controller
 * @date 2017年4月19日 下午10:15:48 
 * @version V1.0
 */
@Controller
@RequestMapping("/codeManage")
public class CodeManageController extends BaseController{


	@Autowired
	private ICodeManageService codeManageService;

	@Autowired
	private IVisitService visitService;

	@RequestMapping("/toIndex.do")
	public String toIndex(Model model) {
		//访问数量
		model.addAttribute("visitCount", DataFormatUtil.intFarmat(this.visitService.getVisitCount()));
		return "codeManage";
	}


	@ResponseBody
	@RequestMapping("/getCode.do")
	public String getCode() {
		Result result = new Result();
		result.setResultData(CodeUtil.createCode(9));
		return JSON.toJSONString(result);
	}


	@ResponseBody
	@RequestMapping("/addCode.do")
	public String addCode(CodeManage codeManage) {
		Result result = new Result();
		//校验编码是否存在
		Map<String ,Object> map = new HashMap<String, Object>();
		map.put("codeValue" , codeManage.getCodeValue());
		if(!codeManageService.checkCodeExist(map)){
			codeManageService.addCodeManage(codeManage);
			result.setCode(ResultCode.SUCCESS);
		}else{
			result.setCode(ResultCode.CODE_REPEAT);
		}
		return JSON.toJSONString(result);
	}

	@ResponseBody
	@RequestMapping("/codeList.do")
	public String codeList(CodeManage codeManage) {
		Result result = new Result();
		Map<String ,Object> map = new HashMap<String, Object>();
		map.put("codeType" , codeManage.getCodeType());
		map.put("codeName" , codeManage.getCodeName());
		result.setCode(ResultCode.SUCCESS);
		result.setResultData(codeManageService.query(map));
		return JSON.toJSONString(result);
	}
}