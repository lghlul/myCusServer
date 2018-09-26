package com.lu.utils;


import java.io.*;
import java.util.Properties;

/**
 * @CLassName PropertiesUtil
 * @Description TODO
 * @Author ll
 * @Date 2018/8/30 11:20
 **/
public class PropertiesUtil {

    /**
     * 项目保存的路径
     */
    public static String BASEPATH;
    /**
     * web.xml文件路径
     */
    public static String WEBPATH;
    /**
     * spring配置文件路径
     */
    public static String SPRINGPATH;
    /**
     * spring-dao.xml文件路径
     */
    public static String SPRINGDAOPATH;
    /**
     * spring-mvc.xml文件路径
     */
    public static String SPRINGMVCPATH;
    /**
     * mainifest路径
     */
    public static String MANIFESTPATH;
    /**
     * LOG4J文件路径
     */
    public static String LOG4JPATH;
    /**
     * mybatis文件路径
     */
    public static String MYBATISPATH;
    /**
     * jdbc配置文件路径
     */
    public static String JDBCPATH;


    /**
     * pom.xml 需要的jar包 groupId
     */
    public static String GROUPIDS;
    /**
     * pom.xml 需要jar包 artifactId
     */
    public static String ARTIFACTIDS;
    /**
     * pom.xml 需要jar包 version
     */
    public static String VERSIONS;

    /**
     * spring xml 命名空间
     */
    public static String NAMESPACEURL;


    /**
     * domain 包名
     */
    public static String PACKAGE_DOMAIN;

    /**
     * mapper 包名
     */
    public static String PACKAGE_MAPPER;
    /**
     * controller 包名
     */
    public static String PACKAGE_CONTROLLER;
    /**
     *  service 包名
     */
    public static String PACKAGE_SERVICE;
    /**
     * service.impl 包名
     */
    public static String PACKAGE_SERVICE_IMPL;

    /**
     * BaseMapper.java 需要的方法
     */
    public static String BASEMAPPER_METHOD;

    /**
     * BaseMapper.java 需要引用的包
     */
    public static String BASEMAPPER_IMPORT;

    /*
     * @author ll
     * @Description 初始化配置文件信息
     * @date 2018/9/18 17:35
     * @param []
     * @return void
     */
    public static void initProperties() {
        Properties properties = new Properties();
        // 使用ClassLoader加载properties配置文件生成对应的输入流
        InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream("config/config.properties");
        // 使用properties对象加载输入流
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取key对应的value值
        PropertiesUtil.BASEPATH = properties.getProperty("base.path");
        PropertiesUtil.WEBPATH = properties.getProperty("path.web");
        PropertiesUtil.SPRINGPATH = properties.getProperty("path.spring");
        PropertiesUtil.SPRINGDAOPATH = properties.getProperty("path.spring-dao");
        PropertiesUtil.SPRINGMVCPATH = properties.getProperty("path.spring-mvc");
        PropertiesUtil.LOG4JPATH = properties.getProperty("path.log4j");
        PropertiesUtil.MANIFESTPATH = properties.getProperty("path.MANIFEST");
        PropertiesUtil.MYBATISPATH = properties.getProperty("path.mybatis");
        PropertiesUtil.JDBCPATH = properties.getProperty("path.jdbc");
        PropertiesUtil.GROUPIDS = properties.getProperty("dependency.groupId");
        PropertiesUtil.ARTIFACTIDS = properties.getProperty("dependency.artifactId");
        PropertiesUtil.VERSIONS = properties.getProperty("dependency.version");
        PropertiesUtil.NAMESPACEURL = properties.getProperty("namespace.url");

        PropertiesUtil.BASEMAPPER_METHOD = properties.getProperty("baseMapper.method");
        PropertiesUtil.BASEMAPPER_IMPORT = properties.getProperty("baseMapper.import");


        PropertiesUtil.PACKAGE_DOMAIN = properties.getProperty("package.domain");
        PropertiesUtil.PACKAGE_MAPPER = properties.getProperty("package.mapper");
        PropertiesUtil.PACKAGE_CONTROLLER = properties.getProperty("package.controller");
        PropertiesUtil.PACKAGE_SERVICE = properties.getProperty("package.service");
        PropertiesUtil.PACKAGE_SERVICE_IMPL = properties.getProperty("package.service.impl");
    }

}
