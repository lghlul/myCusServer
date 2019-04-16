package customer.supu.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import customer.supu.service.ExportExcelService;

@Controller
public class ExportExcelController {

	 @Autowired
	  private ExportExcelService exportExcelService;


	  /**
	   * 根据多选的结算申请导出excel
	   *
	   * @return
	   */
	  @RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
	  @ResponseBody
	  public Map<String, Object> exportExcel(@RequestParam String ids, HttpServletResponse response){
		 try {
			return  exportExcelService.exportExcel(ids, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	  }

	}