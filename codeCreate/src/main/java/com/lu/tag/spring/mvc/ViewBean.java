package com.lu.tag.spring.mvc;

import com.lu.tag.XmlAttr;
import com.lu.tag.spring.base.Bean;
import com.lu.tag.spring.base.NonValueProperty;

import java.util.List;

/**
 * @CLassName MvcBeans
 * @Description TODO
 * @Author ll
 * @Date 2018/9/21 17:06
 **/
public class ViewBean extends Bean {

    private List<NonValueProperty> propertyList;

    private List<XmlAttr> attrList;

    public List<NonValueProperty> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<NonValueProperty> propertyList) {
        this.propertyList = propertyList;
    }

    public List<XmlAttr> getAttrList() {
        return attrList;
    }

    public void setAttrList(List<XmlAttr> attrList) {
        this.attrList = attrList;
    }
}
