package com.lu.tag.spring.dao;

import com.lu.tag.XmlAttr;
import com.lu.tag.spring.base.Value;

import java.util.List;

/**
 * @CLassName PropertyProperty
 * @Description TODO
 * @Author ll
 * @Date 2018/9/25 15:07
 **/
public class PropertyProperty {

    private List<Value> list;

    private List<XmlAttr> attrList;


    public List<XmlAttr> getAttrList() {
        return attrList;
    }

    public void setAttrList(List<XmlAttr> attrList) {
        this.attrList = attrList;
    }

    public List<Value> getList() {
        return list;
    }

    public void setList(List<Value> list) {
        this.list = list;
    }
}
