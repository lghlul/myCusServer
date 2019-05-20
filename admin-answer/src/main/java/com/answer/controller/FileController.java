package com.answer.controller;

import com.answer.common.CommonConfig;
import com.answer.common.ResultCodeEnum;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/5/20 14:33
 * @Modified By：
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private Logger logger = Logger.getLogger(FileController.class);

    @PostMapping("/uploadImg")
    public String uploadImg(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String originalFilename = file.getOriginalFilename();
        if(originalFilename.contains("png") || originalFilename.contains("jpg") || originalFilename.contains("bmp")){
            String fileName = System.currentTimeMillis() + "." + originalFilename.split("\\.")[1];
            String filePath = CommonConfig.FILE_SAVE_PATH;
            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
                return ResultCodeEnum.SUCCESS.getResponse(CommonConfig.SERVER_HOST + fileName);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
            return ResultCodeEnum.FAIL.getResponse();
        }else{
            return ResultCodeEnum.FILE_FORMAT_ERROR.getResponse();
        }

    }
}
