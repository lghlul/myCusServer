package com.lu.tag.pom;

/**
 * @CLassName Properties
 * @Description pom.xml Properties 属性
 * @Author ll
 * @Date 2018/9/17 18:24
 **/
public class Properties {
    private String project1build1sourceEncoding;
    private String maven1compiler1source;
    private String maven1compiler1target;
    private String spring1version;
    private String jackson1version;




    public Properties(){

    }

    public Properties(String project1build1sourceEncoding , String maven1compiler1source , String maven1compiler1target , String spring1version , String jackson1version){
        this.project1build1sourceEncoding = project1build1sourceEncoding;
        this.maven1compiler1source = maven1compiler1source;
        this.maven1compiler1target = maven1compiler1target;
        this.spring1version = spring1version;
        this.jackson1version = jackson1version;
    }

    public String getJackson1version() {
        return jackson1version;
    }

    public void setJackson1version(String jackson1version) {
        this.jackson1version = jackson1version;
    }

    public String getProject1build1sourceEncoding() {
        return project1build1sourceEncoding;
    }

    public void setProject1build1sourceEncoding(String project1build1sourceEncoding) {
        this.project1build1sourceEncoding = project1build1sourceEncoding;
    }

    public String getMaven1compiler1source() {
        return maven1compiler1source;
    }

    public void setMaven1compiler1source(String maven1compiler1source) {
        this.maven1compiler1source = maven1compiler1source;
    }

    public String getMaven1compiler1target() {
        return maven1compiler1target;
    }

    public void setMaven1compiler1target(String maven1compiler1target) {
        this.maven1compiler1target = maven1compiler1target;
    }

    public String getSpring1version() {
        return spring1version;
    }

    public void setSpring1version(String spring1version) {
        this.spring1version = spring1version;
    }
}
