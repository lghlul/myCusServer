package com.lu.project.handler;

import com.lu.tag.XmlAttr;
import com.lu.tag.mybatis.Configuration;
import com.lu.tag.mybatis.Setting;
import com.lu.tag.mybatis.Settings;
import com.lu.tag.pom.*;
import com.lu.utils.PropertiesUtil;
import com.lu.utils.XmlUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @CLassName PomXmlHandler
 * @Description mybatis.xml工具类
 * @Author ll
 * @Date 2018/9/17 18:18
 **/
public class MybatisXmlHandler {

    private String path;

    private String rootTag = "configuration";

    public MybatisXmlHandler(String path) {
        this.path = path;
    }


    /*
     * @author ll
     * @Description  Configuration标签
     * @date 2018/10/8 11:35
     * @param []
     * @return com.lu.tag.mybatis.Configuration
     */
    private Configuration getConfiguration(){
        Configuration configuration = new Configuration();
        Settings settings = new Settings();
        List<Setting> settingList = new ArrayList<>();
        List<XmlAttr> attrList = new ArrayList<>();
        attrList.add(new XmlAttr("name" , "logImpl"));
        attrList.add(new XmlAttr("value" , "STDOUT_LOGGING"));
        Setting setting = new Setting(attrList);
        settingList.add(setting);
        settings.setSetting(settingList);
        configuration.setSettings(settings);
        return configuration;
    }

    /*
     * @author ll
     * @Description 写入pom.xml文件
     * @date 2018/9/18 18:19
     * @param [path]
     * @return void
     */
    public void writeMybatisXml() {
        Configuration configuration = getConfiguration();
        XmlUtil.writeXml(path, configuration, rootTag, "configuration", "-//mybatis.org//DTD Config 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-config.dtd", null);
    }
}
