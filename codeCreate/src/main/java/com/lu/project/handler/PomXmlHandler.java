package com.lu.project.handler;

import com.lu.tag.pom.*;
import com.lu.tag.pom.Properties;
import com.lu.utils.PropertiesUtil;
import com.lu.utils.XmlUtil;

import java.util.*;

/**
 * @CLassName PomXmlHandler
 * @Description pom.xml工具类
 * @Author ll
 * @Date 2018/9/17 18:18
 **/
public class PomXmlHandler {

    private String path;

    private String projectName;

    private String basePackage;

    private String rootTag = "project";

    public PomXmlHandler(String path, String projectName,String basePackage) {
        this.path = path;
        this.projectName = projectName;
        this.basePackage = basePackage;
    }

    /*
     * @author ll
     * @Description pom.xml Dependency属性
     * @date 2018/9/18 17:42
     * @param []
     * @return java.util.PropertyList<com.lu.tag.pom.Dependency>
     */
    private Dependencys getDependecys() {
        Dependencys dependencys = new Dependencys();
        List<Dependency> dependencies = new ArrayList<>();
        String[] groupIdArr = PropertiesUtil.GROUPIDS.split(";");
        String[] artifactIdArr = PropertiesUtil.ARTIFACTIDS.split(";");
        String[] versionArr = PropertiesUtil.VERSIONS.split(";");
        for (int i = 0; i < versionArr.length; i++) {
            Dependency dependency = new Dependency(groupIdArr[i], artifactIdArr[i], versionArr[i]);
            dependencies.add(dependency);
        }
        dependencys.setDependency(dependencies);
        return dependencys;
    }

    /*
     * @author ll
     * @Description pom.xml project属性
     * @date 2018/9/18 18:19
     * @param []
     * @return com.lu.tag.pom.Project
     */
    private Project getProject() {
        Project project = new Project();
        project.setModelVersion("4.0.0");
        project.setGroupId(basePackage);
        project.setArtifactId(projectName);
        project.setVersion("1.0-SNAPSHOT");
        project.setPackaging("war");
        Properties properties = new Properties("UTF-8", "1.8", "1.8", "4.3.13.RELEASE","2.8.5");
        project.setProperties(properties);
        Dependencys dependecys = getDependecys();
        project.setDependencies(dependecys);
        Build build = new Build(projectName);
        project.setBuild(build);
        return project;
    }


    /*
     * @author ll
     * @Description 写入pom.xml文件
     * @date 2018/9/18 18:19
     * @param [path]
     * @return void
     */
    public void writePomXml() {
        Project project = getProject();
        XmlUtil.writeXml(path, project, rootTag);
    }
}
