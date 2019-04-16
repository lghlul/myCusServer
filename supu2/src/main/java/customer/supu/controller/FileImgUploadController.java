package customer.supu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import customer.supu.dto.FileInfo;
import customer.supu.service.FileImgUploadService;

@Controller
@RequestMapping("/user")
public class FileImgUploadController {


	@Autowired
	private FileImgUploadService fileImgUploadService;


/*	@RequestMapping(value = "/upImg",method=RequestMethod.POST)
	    @ResponseBody
	    public FileInfo upload(HttpServletRequest request,
	            HttpServletResponse response, ModelMap model) {
	        FileInfo fileInfo = null;
			try {

				fileInfo = fileImgUploadService.upload(-1,request);
			} catch (Exception e) {
				fileInfo.setMessage(e.getMessage());
				return  fileInfo;
			}
	        return fileInfo;
	    }*/


	/**
	 * 上传主图到阿里云
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/uploadMainFigure",method=RequestMethod.POST)
    @ResponseBody
    public FileInfo uploadMainFigure(@RequestParam(value="file")MultipartFile  file) {
        FileInfo fileInfo = null;
		try {

			fileInfo = fileImgUploadService.uploadMainFigure(file);
		} catch (Exception e) {
			fileInfo.setMessage(e.getMessage());
			return  fileInfo;
		}
        return fileInfo;
    }



}
