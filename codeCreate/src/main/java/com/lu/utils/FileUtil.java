package com.lu.utils;

import java.io.FileWriter;

/**
 * @CLassName FileUtil
 * @Description TODO
 * @Author ll
 * @Date 2018/9/26 14:44
 **/
public class FileUtil {

    /*
     * @author ll
     * @Description 将字符串写入文件
     * @date 2018/9/26 14:45
     * @param [str, path]
     * @return void
     */
    public static void writeFileByStr(String str , String path){
        try{
            FileWriter writer = new FileWriter(path);
            writer.write(str);
            writer.flush();
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
