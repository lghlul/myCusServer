package com.lu.tag.pom;

/**
 * @CLassName Dependency
 * @Description pom.xml Dependency属性
 * @Author ll
 * @Date 2018/9/17 18:21
 **/
public class Dependency {

    private String groupId;
    private String artifactId;
    private String version;


    public Dependency() {

    }

    /*
     * @author ll
     * @Description 构造函数
     * @date 2018/9/18 17:27
     * @param [groupId, artifactId, version]
     * @return
     */
    public Dependency(String groupId, String artifactId, String version) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
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
}
