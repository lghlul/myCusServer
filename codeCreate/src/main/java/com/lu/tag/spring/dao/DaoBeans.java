package com.lu.tag.spring.dao;

import com.lu.annotation.Attribute;
import com.lu.annotation.NameSpace;
import com.lu.annotation.NameSpaceUri;
import com.lu.tag.spring.base.Bean;

import java.util.List;

/**
 * @CLassName DaoBeans
 * @Description beans 标签
 * @Author ll
 * @Date 2018/9/25 9:55
 **/
@Attribute(attrName = "xsi:schemaLocation" ,
        attrValue = "http://www.springframework.org/schema/beans " +
                "    http://www.springframework.org/schema/beans/spring-beans-4.1.xsd " +
                "     http://www.springframework.org/schema/tx " +
                "    http://www.springframework.org/schema/tx/spring-tx-4.1.xsd")
@NameSpace(spaceName = {"xsi" , "tx" } , spaceValue = {"http://www.w3.org/2001/XMLSchema-instance" , "http://www.springframework.org/schema/tx"})
@NameSpaceUri(uriName = "http://www.springframework.org/schema/beans")
public class DaoBeans {

    private List<Bean> bean;

    public List<Bean> getBean() {
        return bean;
    }

    public void setBean(List<Bean> bean) {
        this.bean = bean;
    }
}
