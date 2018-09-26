package com.lu.tag.mybatis;

import com.lu.tag.XmlAttr;

import java.util.List;

/**
 * @CLassName If
 * @Description TODO
 * @Author ll
 * @Date 2018/9/26 17:28
 **/
public class If {


    public If(){

    }

    public If(String nonTag){
        this.nonTag = nonTag;
    }

    private String nonTag;

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

    public String getNonTag() {
        return nonTag;
    }

    public void setNonTag(String nonTag) {
        this.nonTag = nonTag;
    }
}
