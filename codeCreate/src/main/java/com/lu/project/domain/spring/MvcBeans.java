package com.lu.project.domain.spring;

import java.util.List;

/**
 * @CLassName MvcBeans
 * @Description TODO
 * @Author ll
 * @Date 2018/9/21 17:06
 **/
public class MvcBeans {

    private List<MvcBean> bean;

    private String mvc3annotation4driven;



    private String mvc3resources;


    public List<MvcBean> getBean() {
        return bean;
    }

    public void setBean(List<MvcBean> bean) {
        this.bean = bean;
    }

    public String getMvc3annotation4driven() {
        return mvc3annotation4driven;
    }

    public void setMvc3annotation4driven(String mvc3annotation4driven) {
        this.mvc3annotation4driven = mvc3annotation4driven;
    }

    public String getMvc3resources() {
        return mvc3resources;
    }

    public void setMvc3resources(String mvc3resources) {
        this.mvc3resources = mvc3resources;
    }
}
