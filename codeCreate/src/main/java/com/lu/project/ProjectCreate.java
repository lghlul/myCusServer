package com.lu.project;

import com.lu.project.handler.*;
import com.lu.utils.PropertiesUtil;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @CLassName ProjectCreate
 * @Description 创建项目
 * @Author ll
 * @Date 2018/8/30 11:12
 **/
public class ProjectCreate {


    private PathConfig pathConfig;

    public PathConfig getPathConfig() {
        return pathConfig;
    }

    public void setPathConfig(PathConfig pathConfig) {
        this.pathConfig = pathConfig;
    }

    /*
     * @author ll
     * @Description 建目录 建包
     * @date 2018/9/21 17:52
     * @param [projectName, basePackage]
     * @return void
     */
    public void create(){
        createProject();
        createPackage();
    }

    /*
     * @author ll
     * @Description 初始化配置
     * @date 2018/9/25 18:32
     * @param [projectName, basePackage]
     * @return void
     */
    public void init(String projectName , String basePackage){
        pathConfig = new PathConfig();
        pathConfig.initPathConfig(projectName, basePackage);
    }

    /*
     * @author ll
     * @Description 创建项目
     * @date 2018/8/30 15:36
     * @param [projectName]
     * @return void
     */
    private void createProject() {
        //创建test目录
        folderCreate(pathConfig.getTestPath());
        //创建resources目录
        folderCreate(pathConfig.getResourcesPath());
        //创建lib目录
        folderCreate(pathConfig.getLibPath());
        //创建META-INF目录
        folderCreate(pathConfig.getManifestPath());
        //复制MANIFEST.MF模板
        this.fileCopy(PropertiesUtil.MANIFESTPATH , pathConfig.getManifestFilePath());
        //web.xml
        WebXmlHandler webXmlHandler = new WebXmlHandler(pathConfig.getWebFilePath() ,pathConfig.getProjectName());
        webXmlHandler.writeWebXml();


        //pom.xml文件
        PomXmlHandler pomXmlHandler = new PomXmlHandler(pathConfig.getPomFilePath() , pathConfig.getProjectName());
        pomXmlHandler.writePomXml();


        //spring配置文件目录
        folderCreate(pathConfig.getSpringPath());
        //spring相关配置文件
        SpringXmlHandler springXmlHandler = new SpringXmlHandler(pathConfig.getSpringFilePath() , pathConfig.getBasePackage());
        springXmlHandler.writeSpringXml();
        SpringMvcXmlHandler springMvcXmlHandler = new SpringMvcXmlHandler(pathConfig.getSpringMvcFilePath());
        springMvcXmlHandler.writeSpringMvcXml();
        SpringDaoXmlHandler springDaoXmlHandler = new SpringDaoXmlHandler(pathConfig.getSpringDaoFilePath() , pathConfig.getBasePackage());
        springDaoXmlHandler.writeSpringDaoXml();

        //mapper.xml目录
        folderCreate(pathConfig.getXmlMapperPath() );
        //配置文件目录
        folderCreate(pathConfig.getConfigPath());
        this.fileCopy(PropertiesUtil.JDBCPATH , pathConfig.getJdbcFilePath());
    }

    /*
     * @author ll
     * @Description 建包
     * @date 2018/8/30 15:36
     * @param [basePackage]
     * @return void
     */
    private void createPackage() {
        //controller包
        folderCreate(pathConfig.getControllerPath());
        //domain包
        folderCreate(pathConfig.getDomainPah());
        //service.impl包
        folderCreate(pathConfig.getServiceImplPath());
        //mapper接口包
        folderCreate(pathConfig.getJavaMapperPath());
    }

    /*
     * @author ll
     * @Description 复制文件
     * @date 2018/8/30 15:37
     * @param [sourcePath, targetPath]
     * @return void
     */
    private void fileCopy(String sourcePath , String targetPath){
        try {
            File source =  new File(sourcePath);
            File target = new File(targetPath);
            if(target.exists()){
                target.delete();
            }
            Files.copy(source.toPath() ,target.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
     * @author ll
     * @Description 创建文件夹
     * @date 2018/8/30 15:37
     * @param [path]
     * @return void
     */
    private void folderCreate(String path ) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }


    public static void main(String[] args) {
        PropertiesUtil.initProperties();
        ProjectCreate projectHandler = new ProjectCreate();
        projectHandler.init("testOne4", "com.lu.code");
        projectHandler.create();
    }
}
