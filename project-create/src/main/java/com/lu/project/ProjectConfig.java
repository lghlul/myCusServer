package com.lu.project;

/**
 * @CLassName ProjectConfig
 * @Description 项目配置
 * @Author ll
 * @Date 2018/10/8 11:52
 **/
public class ProjectConfig {

    private String drivenClass;

    private String database;

    private String username;

    private String password;

    private String projectName ;

    private String basePackage;

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDrivenClass() {
        return drivenClass;
    }

    public void setDrivenClass(String drivenClass) {
        this.drivenClass = drivenClass;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }
}
