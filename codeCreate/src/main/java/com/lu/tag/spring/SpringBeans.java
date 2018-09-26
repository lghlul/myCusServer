package com.lu.tag.spring;

import com.lu.annotation.Attribute;
import com.lu.annotation.NameSpace;
import com.lu.annotation.NameSpaceUri;

import java.util.List;

/**
 * @CLassName SpringBeans
 * @Description spring.xml root标签
 * @Author ll
 * @Date 2018/9/21 15:58
 **/

@Attribute(attrName =  "xsi:schemaLocation" ,
        attrValue = "http://www.springframework.org/schema/beans " +
                "http://www.springframework.org/schema/beans/spring-beans.xsd " +
                "http://www.springframework.org/schema/context " +
                "http://www.springframework.org/schema/context/spring-context-4.1.xsd ")
@NameSpace(spaceName = {"xsi" , "context"} ,
        spaceValue = {"http://www.w3.org/2001/XMLSchema-instance" , "http://www.springframework.org/schema/context"})
@NameSpaceUri(uriName = "http://www.springframework.org/schema/beans")
public class SpringBeans {
    private List<Import> import2;

    private String context3annotation4config ;

    private ContextComponentScan context3component4scan;



    public List<Import> getImport2() {
        return import2;
    }

    public void setImport2(List<Import> import2) {
        this.import2 = import2;
    }

    public String getContext3annotation4config() {
        return context3annotation4config;
    }

    public void setContext3annotation4config(String context3annotation4config) {
        this.context3annotation4config = context3annotation4config;
    }

    public ContextComponentScan getContext3component4scan() {
        return context3component4scan;
    }

    public void setContext3component4scan(ContextComponentScan context3component4scan) {
        this.context3component4scan = context3component4scan;
    }
}
