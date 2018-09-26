package com.lu.project;


import com.lu.utils.PropertiesUtil;

/**
 * @CLassName PathConfig
 * @Description TODO
 * @Author ll
 * @Date 2018/8/30 14:23
 **/
public class PathConfig {

    private String projectName;

    private String projectPath;

    private String pomFilePath;

    private String srcPath;

    private String mainPath;

    private String testPath;

    private String javaPath;

    private String resourcesPath;

    private String webappPath;

    private String basePackagePath;

    private String basePackage;

    private String manifestPath;

    private String manifestFilePath;

    private String libPath ;

    private String webFilePath;

    private String controllerPath;

    private String domainPah;

    private String serviceImplPath;

    private String servicePath;

    private String javaMapperPath;

    private String configPath;

    private String xmlMapperPath;

    private String springPath;

    private String springFilePath;

    private String springMvcFilePath;

    private String springDaoFilePath;

    private String jdbcFilePath;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getSpringPath() {
        return springPath;
    }

    public void setSpringPath(String springPath) {
        this.springPath = springPath;
    }


    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    public String getPomFilePath() {
        return pomFilePath;
    }

    public void setPomFilePath(String pomFilePath) {
        this.pomFilePath = pomFilePath;
    }

    public String getSrcPath() {
        return srcPath;
    }

    public void setSrcPath(String srcPath) {
        this.srcPath = srcPath;
    }

    public String getMainPath() {
        return mainPath;
    }

    public void setMainPath(String mainPath) {
        this.mainPath = mainPath;
    }

    public String getTestPath() {
        return testPath;
    }

    public void setTestPath(String testPath) {
        this.testPath = testPath;
    }

    public String getJavaPath() {
        return javaPath;
    }

    public void setJavaPath(String javaPath) {
        this.javaPath = javaPath;
    }

    public String getResourcesPath() {
        return resourcesPath;
    }

    public void setResourcesPath(String resourcesPath) {
        this.resourcesPath = resourcesPath;
    }

    public String getWebappPath() {
        return webappPath;
    }

    public void setWebappPath(String webappPath) {
        this.webappPath = webappPath;
    }

    public String getBasePackagePath() {
        return basePackagePath;
    }

    public void setBasePackagePath(String basePackagePath) {
        this.basePackagePath = basePackagePath;
    }

    public String getManifestPath() {
        return manifestPath;
    }

    public void setManifestPath(String manifestPath) {
        this.manifestPath = manifestPath;
    }

    public String getManifestFilePath() {
        return manifestFilePath;
    }

    public void setManifestFilePath(String manifestFilePath) {
        this.manifestFilePath = manifestFilePath;
    }

    public String getLibPath() {
        return libPath;
    }

    public void setLibPath(String libPath) {
        this.libPath = libPath;
    }

    public String getWebFilePath() {
        return webFilePath;
    }

    public void setWebFilePath(String webFilePath) {
        this.webFilePath = webFilePath;
    }

    public String getControllerPath() {
        return controllerPath;
    }

    public void setControllerPath(String controllerPath) {
        this.controllerPath = controllerPath;
    }

    public String getDomainPah() {
        return domainPah;
    }

    public void setDomainPah(String domainPah) {
        this.domainPah = domainPah;
    }

    public String getServiceImplPath() {
        return serviceImplPath;
    }

    public void setServiceImplPath(String serviceImplPath) {
        this.serviceImplPath = serviceImplPath;
    }

    public String getJavaMapperPath() {
        return javaMapperPath;
    }

    public void setJavaMapperPath(String javaMapperPath) {
        this.javaMapperPath = javaMapperPath;
    }

    public String getConfigPath() {
        return configPath;
    }

    public void setConfigPath(String configPath) {
        this.configPath = configPath;
    }

    public String getXmlMapperPath() {
        return xmlMapperPath;
    }

    public void setXmlMapperPath(String xmlMapperPath) {
        this.xmlMapperPath = xmlMapperPath;
    }

    public String getServicePath() {
        return servicePath;
    }

    public void setServicePath(String servicePath) {
        this.servicePath = servicePath;
    }

    public void initPath(String basePath , String projectName) {
        this.projectName = projectName;
        projectPath = basePath + projectName;
        pomFilePath = projectPath + "/pom.xml";
        srcPath = projectPath + "/src";
        mainPath = srcPath + "/main";
        javaPath = mainPath + "/java";
        resourcesPath = mainPath + "/resources";
        webappPath = mainPath + "/webapp";
        testPath = srcPath + "/test";
        manifestPath = webappPath + "/META-INF";
        manifestFilePath = manifestPath + "/MANIFEST.MF";
        libPath = webappPath + "/WEB-INF/lib";
        webFilePath = webappPath + "/WEB-INF/web.xml";
        springPath = resourcesPath + "/spring";
        configPath = resourcesPath + "/config";
        xmlMapperPath = resourcesPath + "/mapper";
        springFilePath = springPath + "/spring.xml";
        springDaoFilePath = springPath  + "/spring-dao.xml";
        springMvcFilePath = springPath  + "/spring-mvc.xml";
        jdbcFilePath = configPath + "/jdbc.properties";
    }

    public void initPackagePath(String basePackage){
        this.basePackage = basePackage;
        String basePackagePath = basePackage.replaceAll("\\." , "/");
        basePackagePath = this.javaPath + "/" + basePackagePath;
        controllerPath = basePackagePath + "/controller";
        domainPah = basePackagePath + "/tag";
        servicePath = basePackagePath + "/service";
        serviceImplPath = servicePath + "/service/impl";
        javaMapperPath = basePackagePath + "/mapper";
    }

    public String getSpringFilePath() {
        return springFilePath;
    }

    public void setSpringFilePath(String springFilePath) {
        this.springFilePath = springFilePath;
    }

    public String getSpringMvcFilePath() {
        return springMvcFilePath;
    }

    public void setSpringMvcFilePath(String springMvcFilePath) {
        this.springMvcFilePath = springMvcFilePath;
    }

    public String getSpringDaoFilePath() {
        return springDaoFilePath;
    }

    public void setSpringDaoFilePath(String springDaoFilePath) {
        this.springDaoFilePath = springDaoFilePath;
    }

    public String getJdbcFilePath() {
        return jdbcFilePath;
    }

    public void setJdbcFilePath(String jdbcFilePath) {
        this.jdbcFilePath = jdbcFilePath;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }


    /*
     * @author ll
     * @Description 初始化各路径
     * @date 2018/9/21 17:49
     * @param [projectName, basePackage]
     * @return void
     */
    public void initPathConfig(String projectName , String basePackage){
        //初始化项目各目录路径
        this.initPath(PropertiesUtil.BASEPATH,projectName);
        //初始化包路径
        this.initPackagePath(basePackage);
    }
}

