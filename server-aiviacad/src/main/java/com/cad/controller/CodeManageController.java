package com.cad.controller;

import com.alibaba.fastjson.JSON;
import com.cad.constant.ResultCode;
import com.cad.domain.CodeManage;
import com.cad.domain.Result;
import com.cad.domain.User;
import com.cad.service.ICodeManageService;
import com.cad.service.IVisitService;
import com.cad.utils.CodeUtil;
import com.cad.utils.ConstantUtil;
import com.cad.utils.DataFormatUtil;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
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
	public String toIndex(Model model, HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute(ConstantUtil.SESSION_USER);
		if(user == null){
			return "index";
		}
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

		map.put("codeName" , codeManage.getCodeName());
		if(codeManageService.checkCodeExist(map)){
			result.setCode(ResultCode.CODE_NAME_REPEAT);
			return JSON.toJSONString(result);
		}
		map.clear();
		map.put("codeValue" , codeManage.getCodeValue());
		if(codeManageService.checkCodeExist(map)){
			result.setCode(ResultCode.CODE_VALUE_REPEAT);
			return JSON.toJSONString(result);
		}
		codeManageService.addCodeManage(codeManage);
		result.setCode(ResultCode.SUCCESS);
		return JSON.toJSONString(result);
	}

	@ResponseBody
	@RequestMapping("/codeList.do")
	public String codeList(String keyWord) {
		Result result = new Result();
		Map<String ,Object> map = new HashMap<String, Object>();
		map.put("keyWord" , keyWord);
		result.setCode(ResultCode.SUCCESS);
		result.setResultData(codeManageService.query(map));
		return JSON.toJSONString(result);
	}


	@RequestMapping("/export.do")
	public void export(HttpServletResponse response) {
		List<CodeManage> codeManages = codeManageService.query(null);
		try{
			response.reset();
			response.setContentType("application/vnd.ms-excel");
			String fileName = new String("编码列表".getBytes("gb2312"), "ISO-8859-1");
			response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xls");
			// 第一步，创建一个workbook，对应一个Excel文件
			HSSFWorkbook workbook = new HSSFWorkbook();

			// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
			HSSFSheet hssfSheet = workbook.createSheet("sheet1");

			// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short

			HSSFRow row = hssfSheet.createRow(0);
			// 第四步，创建单元格，并设置值表头 设置表头居中
			HSSFCellStyle hssfCellStyle = workbook.createCellStyle();

			//居中样式
			hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

			String[]  titles = {"No.","编码序号","编码名称"};
			HSSFCell hssfCell = null;
			for (int i = 0; i < titles.length; i++) {
				hssfCell = row.createCell(i);//列索引从0开始
				hssfCell.setCellValue(titles[i]);//列名1
				hssfCell.setCellStyle(hssfCellStyle);//列居中显示
			}


			for (int i = 0; i < codeManages.size(); i++) {
				row = hssfSheet.createRow(i+1);
				CodeManage codeManage = codeManages.get(i);

				// 第六步，创建单元格，并设置值
				row.createCell(0).setCellValue(i + 1);
				row.createCell(1).setCellValue(codeManage.getCodeValue());
				row.createCell(2).setCellValue(codeManage.getCodeName());
			}

			// 第七步，将文件输出到客户端浏览器
			try {
				ServletOutputStream out=response.getOutputStream();
				workbook.write(out);
				out.flush();
				out.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}