package com.lu.project.domain.pom;

import java.util.List;

/**
 * @CLassName Dependencys
 * @Description TODO
 * @Author ll
 * @Date 2018/9/18 17:59
 **/
public class Dependencys {
    private Dependency dependency;

    public Dependencys(){

    }

    public Dependencys(Dependency dependency){
        this.dependency = dependency;
    }

    public Dependency getDependency() {
        return dependency;
    }

    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }
}
