package com.cad.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.cad.domain.ProjectMaterial;
import com.cad.domain.Result;
import com.cad.service.IProjectMaterialService;
import com.cad.service.IVisitService;
import com.cad.utils.DataFormatUtil;

/**
 * 
 * @author Lu
 * @Description: 工程材料
 * @Package com.cad.controller
 * @date 2017年4月23日 下午10:08:22 
 * @version V1.0
 */
@Controller
@RequestMapping("/projectMaterial")
public class ProjectMaterialController extends BaseController{

	@Autowired
	private IProjectMaterialService projectMaterialService;
	
	
	@Autowired
	private IVisitService visitService;

	/**
	 * 
	* @Title: toIndex 
	* @Description: 工程材料主页
	* @param @param model
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("/toIndex.do")
	public String toIndex(Model model) {
		//国家
		 List<List<ProjectMaterial>> lists = this.projectMaterialService.getProjectMaterial();
		 for(int i = 0 ; i < lists.size() ; i++){
			 model.addAttribute("list_" + i, lists.get(i));
		 }
		 
		 model.addAttribute("pm", this.projectMaterialService.getProjectMaterialValue(9));
		//访问数量
		model.addAttribute("visitCount", DataFormatUtil.intFarmat(this.visitService.getVisitCount()));
		return "projectMaterial";
	}
	
	/**
	 * 
	* @Title: getValue 
	* @Description: 工程材料值
	* @param @param model
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping("/getValue.do")
	public String getValue(int pm_id) {
		Result result = new Result();
		result.setResultData(this.projectMaterialService.getProjectMaterialValue(pm_id));
		//访问数量
		result.setVisitNum(DataFormatUtil.intFarmat(this.visitService.getVisitCount()));
		return JSON.toJSONString(result);
	}

}