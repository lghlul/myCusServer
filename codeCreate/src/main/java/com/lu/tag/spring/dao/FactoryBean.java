package com.lu.tag.spring.dao;

import com.lu.tag.XmlAttr;
import com.lu.tag.spring.base.Bean;
import com.lu.tag.spring.base.NonValueProperty;

import java.util.List;

/**
 * @CLassName FactoryBean
 * @Description sqlSessionFactory bean
 * @Author ll
 * @Date 2018/9/25 15:49
 **/
public class FactoryBean extends Bean {
    private List<NonValueProperty> property;

    private List<XmlAttr> attrList;

    public List<XmlAttr> getAttrList() {
        return attrList;
    }

    public void setAttrList(List<XmlAttr> attrList) {
        this.attrList = attrList;
    }


    public List<NonValueProperty> getProperty() {
        return property;
    }

    public void setProperty(List<NonValueProperty> property) {
        this.property = property;
    }
}
