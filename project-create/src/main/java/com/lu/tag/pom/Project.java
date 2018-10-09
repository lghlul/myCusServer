package com.lu.tag.pom;

import com.lu.annotation.Attribute;
import com.lu.annotation.NameSpace;
import com.lu.annotation.NameSpaceUri;

/**
 * @CLassName Project
 * @Description Project 标签   pom.xml 根节点
 * @Author ll
 * @Date 2018/9/17 18:27
 **/
@Attribute(attrName = "xsi:schemaLocation" , attrValue =  "http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd")
@NameSpace(spaceName = "xsi" , spaceValue = "http://www.w3.org/2001/XMLSchema-instance")
@NameSpaceUri(uriName = "http://maven.apache.org/POM/4.0.0")
public class Project{
    private String modelVersion;
    private String groupId;
    private String artifactId;
    private String version;
    private String packaging;
    private Properties properties;
    private Dependencys dependencies;
    private Build build;


    public String getModelVersion() {
        return modelVersion;
    }

    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Build getBuild() {
        return build;
    }

    public void setBuild(Build build) {
        this.build = build;
    }

    public Dependencys getDependencies() {
        return dependencies;
    }

    public void setDependencies(Dependencys dependencies) {
        this.dependencies = dependencies;
    }
}
