package com.lu.project.handler;

import com.lu.project.ProjectConfig;
import com.lu.utils.CodeUtil;
import com.lu.utils.FileUtil;

/**
 * @CLassName PropertiesHandler
 * @Description TODO
 * @Author ll
 * @Date 2018/10/8 11:41
 **/
public class PropertiesHandler {

    /*
     * @author ll
     * @Description jdbc.properties 配置文件
     * @date 2018/10/8 11:44
     * @param [driven, url, username, password, path]
     * @return void
     */
    public void writeJdbc(ProjectConfig projectConfig , String path){
        StringBuffer jdbc = new StringBuffer();
        jdbc.append("jdbc.driverClassName=" + projectConfig.getDrivenClass());
        jdbc.append(CodeUtil.getChangeLine(1));
        jdbc.append("jdbc.url=" + projectConfig.getUrl());
        jdbc.append(CodeUtil.getChangeLine(1));
        jdbc.append("jdbc.username=" + projectConfig.getUsername());
        jdbc.append(CodeUtil.getChangeLine(1));
        jdbc.append("jdbc.password=" + projectConfig.getPassword());
        FileUtil.writeFileByStr(jdbc.toString() , path);
    }

    /*
     * @author ll
     * @Description config.properties配置文件
     * @date 2018/10/8 11:44
     * @param [path]
     * @return void
     */
    public void writeConfig(String path){
        StringBuffer jdbc = new StringBuffer();
        FileUtil.writeFileByStr(jdbc.toString() , path);
    }
}
