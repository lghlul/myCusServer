package com.lu.project;

import com.lu.project.domain.XmlAttr;
import com.lu.project.domain.pom.*;
import com.lu.project.domain.pom.Properties;
import com.lu.utils.PropertiesUtil;
import com.lu.utils.XmlUtil;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;
import java.io.*;
import java.util.*;

/**
 * @CLassName PomXmlHandler
 * @Description pom.xml工具类
 * @Author ll
 * @Date 2018/9/17 18:18
 **/
public class PomXmlHandler {
    /*
     * @author ll
     * @Description pom.xml Dependency属性
     * @date 2018/9/18 17:42
     * @param []
     * @return java.util.List<com.lu.project.domain.pom.Dependency>
     */
    private static List<Dependencys> getDependecys(){
        List<Dependencys> dependencies = new ArrayList<>();
        String[] groupIdArr = PropertiesUtil.GROUPIDS.split(";");
        String[] artifactIdArr = PropertiesUtil.ARTIFACTIDS.split(";");
        String[] versionArr = PropertiesUtil.VERSIONS.split(";");
        for(int i = 0 ; i < versionArr.length ; i++){
            Dependency dependency = new Dependency(groupIdArr[i] ,artifactIdArr[i], versionArr[i]);
            Dependencys ds = new Dependencys(dependency);
            dependencies.add(ds);
        }
        return dependencies;
    }

    /*
     * @author ll
     * @Description pom.xml project属性
     * @date 2018/9/18 18:19
     * @param []
     * @return com.lu.project.domain.pom.Project
     */
    private static Project getProject(){
        Project project = new Project();
        project.setModelVersion("4.0.0");
        project.setGroupId("com.lu");
        project.setArtifactId("codeCreate");
        project.setVersion("1.0-SNAPSHOT");
        project.setPackaging("war");
        Properties properties = new Properties("UTF-8","1.8","1.8","4.3.13.RELEASE");
        project.setProperties(properties);
        List<Dependencys> dependecys = getDependecys();
        project.setDependencies(dependecys);
        Build build = new Build("codeCreate");
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
    public static void writePomXml(String path){
        String rootName = "project";
        Project p = getProject();
        Map<String , String> spaceMap = new HashMap<>();
        spaceMap.put("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
        Map<String , String> attrMap = new HashMap<>();
        attrMap.put("xsi:schemaLocation","http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd");
        XmlUtil.writeXml(path ,p ,spaceMap,attrMap , rootName);
    }
}
