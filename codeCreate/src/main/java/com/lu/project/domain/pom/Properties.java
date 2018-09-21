package com.lu.project.domain.pom;

/**
 * @CLassName Properties
 * @Description pom.xml Properties 属性
 * @Author ll
 * @Date 2018/9/17 18:24
 **/
public class Properties {
    private String project_build_sourceEncoding;
    private String maven_compiler_source;
    private String maven_compiler_target;
    private String spring_version;


    public Properties(){

    }

    public Properties(String project_build_sourceEncoding , String maven_compiler_source , String maven_compiler_target , String spring_version){
        this.project_build_sourceEncoding = project_build_sourceEncoding;
        this.maven_compiler_source = maven_compiler_source;
        this.maven_compiler_target = maven_compiler_target;
        this.spring_version = spring_version;
    }


    public String getProject_build_sourceEncoding() {
        return project_build_sourceEncoding;
    }

    public void setProject_build_sourceEncoding(String project_build_sourceEncoding) {
        this.project_build_sourceEncoding = project_build_sourceEncoding;
    }

    public String getMaven_compiler_source() {
        return maven_compiler_source;
    }

    public void setMaven_compiler_source(String maven_compiler_source) {
        this.maven_compiler_source = maven_compiler_source;
    }

    public String getMaven_compiler_target() {
        return maven_compiler_target;
    }

    public void setMaven_compiler_target(String maven_compiler_target) {
        this.maven_compiler_target = maven_compiler_target;
    }

    public String getSpring_version() {
        return spring_version;
    }

    public void setSpring_version(String spring_version) {
        this.spring_version = spring_version;
    }
}
