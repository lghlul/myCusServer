package com.lu.project.domain.spring;

import com.lu.project.domain.XmlAttr;

import java.util.List;

/**
 * @CLassName Import
 * @Description TODO
 * @Author ll
 * @Date 2018/9/21 15:59
 **/
public class Import  {
    /**
     * 属性列表
     */
    private List<XmlAttr> attrList;

    public List<XmlAttr> getAttrList() {
        return attrList;
    }

    public void setAttrList(List<XmlAttr> attrList) {
        this.attrList = attrList;
    }
}
