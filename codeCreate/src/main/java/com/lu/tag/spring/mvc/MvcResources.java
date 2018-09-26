package com.lu.tag.spring.mvc;

import com.lu.tag.XmlAttr;

import java.util.List;

/**
 * @CLassName MvcResources
 * @Description TODO
 * @Author ll
 * @Date 2018/9/25 14:50
 **/
public class MvcResources {


    public MvcResources(){

    }

    public MvcResources(List<XmlAttr> attrList){
        this.attrList = attrList;
    }

    private List<XmlAttr> attrList;

    public List<XmlAttr> getAttrList() {
        return attrList;
    }

    public void setAttrList(List<XmlAttr> attrList) {
        this.attrList = attrList;
    }
}
