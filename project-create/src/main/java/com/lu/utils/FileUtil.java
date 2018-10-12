package com.lu.utils;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @CLassName FileUtil
 * @Description TODO
 * @Author ll
 * @Date 2018/9/26 14:44
 **/
public class FileUtil {


    /**
     * 使用UTF-8编码可以避免压缩中文文件名乱码
     */
    private static final String CHINESE_CHARSET = "UTF-8";

    /**
     * 文件读取缓冲区大小
     */
    private static final int CACHE_SIZE = 1024;

    /*
     * @author ll
     * @Description 将字符串写入文件
     * @date 2018/9/26 14:45
     * @param [str, path]
     * @return void
     */
    public static void writeFileByStr(String str, String path) {
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(str);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }





    public static void zip(String sourceFolder, String zipFilePath) throws Exception {
        OutputStream out = new FileOutputStream(zipFilePath);
        BufferedOutputStream bos = new BufferedOutputStream(out);
        ZipOutputStream zos = new ZipOutputStream(bos);
        // 解决中文文件名乱码
        File file = new File(sourceFolder);
        String basePath = null;
       /* if (file.isDirectory()) {
            basePath = file.getParent();
        } else {
            basePath = file.getParent();
        }*/
        basePath = file.getParent();
        zipFile(file, basePath, zos);
        zos.closeEntry();
        zos.close();
        bos.close();
        out.close();
    }


    private static void zipFile(File parentFile, String basePath, ZipOutputStream zos) throws Exception {
        File[] files = new File[0];
        if (parentFile.isDirectory()) {
            files = parentFile.listFiles();
        } else {
            files = new File[1];
            files[0] = parentFile;
        }
        String pathName;
        InputStream is;
        BufferedInputStream bis;
        byte[] cache = new byte[CACHE_SIZE];
        for (File file : files) {
            if (file.isDirectory()) {
                basePath = basePath.replace('\\', '/');
                if(basePath.substring(basePath.length()-1).equals("/")){
                    pathName = file.getPath().substring(basePath.length()) + "/";
                }else{
                    pathName = file.getPath().substring(basePath.length() + 1) + "/";
                }

                zos.putNextEntry(new ZipEntry(pathName));
                zipFile(file, basePath, zos);
            } else {
                pathName = file.getPath().substring(basePath.length()) ;
                pathName = pathName.replace('\\', '/');
                if(pathName.substring(0,1).equals("/")){
                    pathName = pathName.substring(1);
                }

                is = new FileInputStream(file);
                bis = new BufferedInputStream(is);
                zos.putNextEntry(new ZipEntry(pathName));
                int nRead = 0;
                while ((nRead = bis.read(cache, 0, CACHE_SIZE)) != -1) {
                    zos.write(cache, 0, nRead);
                }
                bis.close();
                is.close();
            }
        }
    }


   /* public static void main(String[] args) throws Exception{
        FileUtil.zip("F:/project/demo-project" , "F:/project/demo-project3.zip");
    }*/
}
