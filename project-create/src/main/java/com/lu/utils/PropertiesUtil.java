package com.lu.utils;


import com.lu.tag.pom.Project;

import java.io.*;
import java.util.Properties;

/**
 * @CLassName PropertiesUtil
 * @Description 配置文件读取
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

    /**
     *  BaseResultMap名称
     */
    public static  String BASE_RESULTMAP;

    /**
     * BaseService 方法
     */
    public static String BASESERVICE_METHOD;

    /**
     * BaseService import
     */
    public static String BASESERVICE_IMPORT;

    /**
     *  @Service
     */
    public static String SPRING_SERVICE;
    /**
     * 	@Autowired
     */
    public static String SPRING_AUTOWIRED;
    /**
     * @controller
     */
    public static String SPRING_CONTROLLER;

    /**
     * @ModelAttribute
     */
    public static String SPRING_MODELATTRIBUTE;
    /**
     * @RequestMapping
     */
    public static String SPRING_REQUESTMAPPING;

    /**
     * @ResponseBody
     */
    public static String SPRING_RESPONSEBODY;




    public static String CLASS_BASE_DOMAIN;

    public static String CLASS_BASE_MAPPER;

    public static String CLASS_IBASE_SERVICE;

    public static String CLASS_BASE_SERVICE_IMPL;

    public static String CLASS_CONTROLLER;

    public static String SERVICE_IMPL_MAPPER_METHOD;

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
        BASEPATH = properties.getProperty("base.path");
        WEBPATH = properties.getProperty("path.web");
        SPRINGPATH = properties.getProperty("path.spring");
        SPRINGDAOPATH = properties.getProperty("path.spring-dao");
        SPRINGMVCPATH = properties.getProperty("path.spring-mvc");
        LOG4JPATH = properties.getProperty("path.log4j");
        MANIFESTPATH = properties.getProperty("path.MANIFEST");
        MYBATISPATH = properties.getProperty("path.mybatis");
        JDBCPATH = properties.getProperty("path.jdbc");
        GROUPIDS = properties.getProperty("dependency.groupId");
        ARTIFACTIDS = properties.getProperty("dependency.artifactId");
        VERSIONS = properties.getProperty("dependency.version");
        NAMESPACEURL = properties.getProperty("namespace.url");
        BASEMAPPER_METHOD = properties.getProperty("baseMapper.method");
        BASEMAPPER_IMPORT = properties.getProperty("baseMapper.import");
        BASESERVICE_METHOD = properties.getProperty("baseService.method");
        BASESERVICE_IMPORT = properties.getProperty("baseService.import");
        PACKAGE_DOMAIN = properties.getProperty("package.domain");
        PACKAGE_MAPPER = properties.getProperty("package.mapper");
        PACKAGE_CONTROLLER = properties.getProperty("package.controller");
        PACKAGE_SERVICE = properties.getProperty("package.service");
        PACKAGE_SERVICE_IMPL = properties.getProperty("package.service.impl");
        BASE_RESULTMAP = properties.getProperty("mapper.baseResultName");

        SPRING_SERVICE = properties.getProperty("annotation.service");
        SPRING_AUTOWIRED = properties.getProperty("annotation.autowired");
        SPRING_CONTROLLER = properties.getProperty("annotation.controller");
        SPRING_MODELATTRIBUTE = properties.getProperty("annotation.modelAttribute");
        SPRING_REQUESTMAPPING = properties.getProperty("annotation.requestMapping");
        SPRING_RESPONSEBODY = properties.getProperty("annotation.responseBody");

        CLASS_BASE_DOMAIN = properties.getProperty("class.baseDomain");
        CLASS_BASE_MAPPER = properties.getProperty("class.baseMapper");
        CLASS_IBASE_SERVICE = properties.getProperty("class.ibaseService");
        CLASS_BASE_SERVICE_IMPL = properties.getProperty("class.baseServiceImpl");
        CLASS_CONTROLLER = properties.getProperty("class.baseController");

        SERVICE_IMPL_MAPPER_METHOD = properties.getProperty("baseServiceImpl.mapper.method");
    }

}
