package com.lu.tag.spring.mvc;

import com.lu.annotation.Attribute;
import com.lu.annotation.NameSpace;
import com.lu.annotation.NameSpaceUri;
import com.lu.tag.spring.base.Bean;

import java.util.List;

/**
 * @CLassName MvcBeans
 * @Description spring-mvc.xml 根标签
 * @Author ll
 * @Date 2018/9/21 17:06
 **/
@Attribute(attrName = "xsi:schemaLocation" ,
        attrValue = "http://www.springframework.org/schema/beans " +
                "http://www.springframework.org/schema/beans/spring-beans-4.1.xsd " +
                "http://www.springframework.org/schema/mvc " +
                 "http://www.springframework.org/schema/mvc/spring-mvc-4.1.xsd ")
@NameSpace(spaceName = {"xsi" , "mvc" } , spaceValue = {"http://www.w3.org/2001/XMLSchema-instance" , "http://www.springframework.org/schema/mvc"})
@NameSpaceUri(uriName = "http://www.springframework.org/schema/beans")
public class MvcBeans {

    private List<Bean> bean;

    private String mvc3annotation4driven;

    private MvcResources mvc3resources;

    public String getMvc3annotation4driven() {
        return mvc3annotation4driven;
    }

    public void setMvc3annotation4driven(String mvc3annotation4driven) {
        this.mvc3annotation4driven = mvc3annotation4driven;
    }

    public MvcResources getMvc3resources() {
        return mvc3resources;
    }

    public void setMvc3resources(MvcResources mvc3resources) {
        this.mvc3resources = mvc3resources;
    }


    public List<Bean> getBean() {
        return bean;
    }

    public void setBean(List<Bean> bean) {
        this.bean = bean;
    }

}
