package com.lu.tag.spring.dao;

import com.lu.tag.XmlAttr;
import com.lu.tag.spring.base.Bean;

import java.util.List;

/**
 * @CLassName NonValuePropertyBean
 * @Description TODO
 * @Author ll
 * @Date 2018/9/25 15:06
 **/
public class PropertyBean extends Bean {

    private PropertyProperty property;

    private List<XmlAttr> attrList;

    public List<XmlAttr> getAttrList() {
        return attrList;
    }

    public void setAttrList(List<XmlAttr> attrList) {
        this.attrList = attrList;
    }

    public PropertyProperty getProperty() {
        return property;
    }

    public void setProperty(PropertyProperty property) {
        this.property = property;
    }
}
