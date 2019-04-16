package customer.supu.service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import customer.supu.common.utils.SpringPropertyResourceReader;
import customer.supu.dto.FileInfo;
import customer.supu.service.FileImgUploadService;



@Service
public class FileImgUploadServiceImpl implements FileImgUploadService{

	/**
	 * 图片上传
	 * @throws UnsupportedEncodingException
	 * @throws Exception
	 */
	@Override
	public FileInfo upload(int type, HttpServletRequest request) throws Exception  {

		  String fileName = "";
	        String rfileName = "";
	        long fileSize = 0;
	        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

	        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
	        String realPath =SpringPropertyResourceReader.getProperty("img.upload.url");
	        File targetFile = new File(realPath);

	        if (!targetFile.exists()) {
	            targetFile.mkdirs();
	        }
	        MultipartFile mf=null;
	        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
	            mf = entity.getValue();
	            String str = mf.getOriginalFilename();
	            rfileName = new String(str.getBytes("iso8859-1"),"UTF-8"); //转换编码格式   所有上传的文件的编码格式都是iso8859-1
	            fileName = new Date().getTime()
	                    + rfileName.substring(rfileName.lastIndexOf("."),
	                            rfileName.length());
	            File uploadFile = new File(realPath, fileName);
	            fileSize =  mf.getSize();
	            try {
	                FileCopyUtils.copy(mf.getBytes(), uploadFile);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        FileInfo fileInfo =initUploadInfo(fileName, rfileName, fileSize);


	        return fileInfo;

	        //阿里云上传  图片  (之前是用来上传富文本图片)
	       /* MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

	        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
	        MultipartFile mf=null;
	        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
	            mf = entity.getValue();
	        }
	        FileInfo fileInfo =new FileInfo();
			OSSClientUtil ossClientUtil=new OSSClientUtil();

			String imgName=ossClientUtil.uploadImg2Oss(mf);

			String url= ossClientUtil.getImgUrl(imgName);
			fileInfo.setUrl(url);
	        return fileInfo;*/
	}


	/**
	 * 上传主图
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public FileInfo uploadMainFigure(MultipartFile file) throws Exception{

		 String fileName = "";
	        String rfileName = "";
	        long fileSize = 0;
	     //   MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

	       // Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
	        String realPath =SpringPropertyResourceReader.getProperty("img.upload.url");
	        File targetFile = new File(realPath);

	        if (!targetFile.exists()) {
	            targetFile.mkdirs();
	        }
	      //  MultipartFile mf=null;
	      //  for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
	           // mf = entity.getValue();
	            String str = file.getOriginalFilename();
	            rfileName = new String(str.getBytes("iso8859-1"),"UTF-8"); //转换编码格式   所有上传的文件的编码格式都是iso8859-1
	            fileName = new Date().getTime()
	                    + rfileName.substring(rfileName.lastIndexOf("."),
	                            rfileName.length());
	            File uploadFile = new File(realPath, fileName);
	            fileSize =  file.getSize();
	            try {
	                FileCopyUtils.copy(file.getBytes(), uploadFile);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	       // }
	        FileInfo fileInfo =initUploadInfo(fileName, rfileName, fileSize);


	        return fileInfo;



		//上传阿里云

	/*     FileInfo fileInfo =new FileInfo();
		 OSSClientUtil ossClientUtil=new OSSClientUtil();
		 String imgName=ossClientUtil.uploadImg2Oss(file);
		 String url= ossClientUtil.getImgUrl(imgName);
		 fileInfo.setUrl(url);
		 return fileInfo;*/
	}

	/**
     * 初始化文件信息对象的值
     * @param fileName
     * @param rfileName
     * @param fileSize
     * @param path
     * @return
     */
   public FileInfo initUploadInfo(String fileName, String rfileName,
            long fileSize) {//, String path
        FileInfo fileInfo = new FileInfo();
        fileInfo.setReportName(fileName);
        fileInfo.setrReportName(rfileName);
        fileInfo.setFileSize(fileSize);
        fileInfo.setUrl(SpringPropertyResourceReader.getProperty("img.visit.mapp.url")+fileName);
        return fileInfo;
    }

}
