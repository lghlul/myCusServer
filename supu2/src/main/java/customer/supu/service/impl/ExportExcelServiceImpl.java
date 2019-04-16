package customer.supu.service.impl;

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
import org.springframework.stereotype.Service;

import customer.supu.common.utils.DateTimeUtil;
import customer.supu.common.utils.ExcelUtil;
import customer.supu.dao.EmployeeAppointCourseDao;
import customer.supu.dto.EmployeeAppointCourseDto;
import customer.supu.jenum.CourseTypeEnum;
import customer.supu.jenum.DataValidEnum;

import customer.supu.service.EmployeeAppointCourseService;
import customer.supu.service.ExportExcelService;

@Service
public class ExportExcelServiceImpl implements ExportExcelService {
	@Autowired
	private EmployeeAppointCourseDao employeeAppointCourseDao;

	@Autowired
	private EmployeeAppointCourseService employeeAppointCourseService;

	/**
	 * 选中的 数据并导出
	 *
	 * @param ids
	 *            预约的id
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> exportExcel(String ids,
			HttpServletResponse response) throws IOException {
		String fileName = new Date().getTime() + ".xls";
		// 填充projects数据
		List<EmployeeAppointCourseDto> projects = createData(ids);

		List<Map<String, Object>> list = createExcelRecord(projects);
		String columnNames[] = { "用户账号", "课程名称", "课程类型", "教练名称", "门店名称", "预约日期","开始时间","结束时间","状态" };// 列名
		String keys[] = {"username", "coursename", "courseTypeName", "coachnames","storename","appointtime","starttime","endtime","courseStatus"};// map中的key

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ExcelUtil.createWorkBook(list, keys, columnNames).write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] content = os.toByteArray();
		InputStream is = new ByteArrayInputStream(content);
		// 设置response参数，可以打开下载页面
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ new String(fileName.getBytes(), "iso-8859-1"));
		ServletOutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;
			// Simple read/write loop.
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (final IOException e) {
			throw e;
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
		return null;
	}


	private List<EmployeeAppointCourseDto> createData(String ids) { // 自己实现

		//查出需要导出的数据
		List<EmployeeAppointCourseDto> list = null;
		Map<String,Object> map=new HashMap<String,Object>();


		List<String>  id_list=new ArrayList<String>();
		//spilt  传入的主键id
		String id[]=ids.split("[,，]");
		if(id!=null){
			for(int i=0;i<id.length;i++){
				id_list.add(id[i]);
			}
		}

		//主键id拼接成list,查询出需要导出的数据
		map.put("ids", id_list);

		try {
			list=employeeAppointCourseDao.selectEmpAppCourseByList(map);
			//循环list
			for (int i = 0; i < list.size(); i++) {
				EmployeeAppointCourseDto appointCourseDto=list.get(i);
				appointCourseDto.setCoachnames(employeeAppointCourseService.selectCourseCoachByCid(appointCourseDto.getCourseid(),appointCourseDto.getType()));
				appointCourseDto.setCourseTypeName(CourseTypeEnum.getName(appointCourseDto.getType()));
				appointCourseDto.setCourseStatus(appointCourseDto.getStatus()==DataValidEnum.NO_EFFECT.getCode()?"取消":"预约");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return list;
	}

	private List<Map<String, Object>> createExcelRecord(
			List<EmployeeAppointCourseDto> projects) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		map.put("sheetName", "sheet1");
		listmap.add(map);
		EmployeeAppointCourseDto project;
		for (int j = 0; j < projects.size(); j++) {
			project = projects.get(j);
			Map<String, Object> mapValue = new HashMap<>();
			mapValue.put("addtime", project.getAddtime());
			mapValue.put("courseId", project.getCourseid());
			mapValue.put("username", project.getUsername());
			mapValue.put("coursename", project.getCoursename());
			mapValue.put("courseTypeName", project.getCourseTypeName());
			mapValue.put("coachnames", project.getCoachnames());
			mapValue.put("storename", project.getStorename());
			mapValue.put("appointtime", DateTimeUtil.getDateWithoutTime(project.getAppointtime()));
			mapValue.put("starttime", project.getStarttime());
			mapValue.put("endtime", project.getEndtime());
			mapValue.put("courseStatus", project.getCourseStatus());
			listmap.add(mapValue);
		}
		return listmap;
	}



	//导出数据
/*	$('#dc').click(function(){
		alert(1);
		window.location.href=baseUrl+"/exportExcel?ids=1";


	});*/
	/*
	 * 在jsp页面中添加 <input type="button" value="导出数据" onclick="download()"/> js中添加
	 * function download(){ var url="download_customer.do"; window.open(url); }
	 */
}
