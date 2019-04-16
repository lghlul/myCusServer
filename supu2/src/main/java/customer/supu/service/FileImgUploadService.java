package customer.supu.service;


import javax.servlet.http.HttpServletRequest;


import org.springframework.web.multipart.MultipartFile;

import customer.supu.dto.FileInfo;


public interface FileImgUploadService {
	/**
     * 图片上传
     * @param file
     * @param request
     */
    public FileInfo upload(int type, HttpServletRequest request) throws Exception;

    /**
	 * 上传主图
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public FileInfo uploadMainFigure(MultipartFile file) throws Exception;
}
