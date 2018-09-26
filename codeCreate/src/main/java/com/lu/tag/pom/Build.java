package com.lu.tag.pom;

/**
 * @CLassName Build
 * @Description pom.xml build属性
 * @Author ll
 * @Date 2018/9/17 18:29
 **/
public class Build {
    private String finalName;


    public Build(){

    }
    public Build(String finalName){
        this.finalName = finalName;
    }


    public String getFinalName() {
        return finalName;
    }

    public void setFinalName(String finalName) {
        this.finalName = finalName;
    }
}
