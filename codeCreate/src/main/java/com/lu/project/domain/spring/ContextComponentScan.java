package com.lu.project.domain.spring;

import com.lu.project.domain.XmlAttr;

import java.util.List;

/**
 * @CLassName ContextComponentScan
 * @Description  ContextComponentScan 标签
 * @Author ll
 * @Date 2018/9/21 17:13
 **/
public class ContextComponentScan {
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
