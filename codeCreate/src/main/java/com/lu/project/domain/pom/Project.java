package com.lu.project.domain.pom;

import java.util.List;

/**
 * @CLassName Project
 * @Description TODO
 * @Author ll
 * @Date 2018/9/17 18:27
 **/
public class Project{
    private String modelVersion;
    private String groupId;
    private String artifactId;
    private String version;
    private String packaging;
    private Properties properties;
    private List<Dependencys> dependencies;
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

    public List<Dependencys> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<Dependencys> dependencies) {
        this.dependencies = dependencies;
    }

    public Build getBuild() {
        return build;
    }

    public void setBuild(Build build) {
        this.build = build;
    }
}
