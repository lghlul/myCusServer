package com.lu.tag;

import java.util.List;

/**
 * @CLassName BaseTag
 * @Description TODO
 * @Author ll
 * @Date 2018/9/28 17:08
 **/
public class BaseTag {

    public BaseTag(){

    }

    public BaseTag(List<XmlAttr> attrList){
        this.attrList = attrList;
    }

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
