package com.lu.tag.mybatis;

import com.lu.tag.XmlAttr;

import java.util.List;

/**
 * @CLassName Insert
 * @Description insert 标签
 * @Author ll
 * @Date 2018/9/26 15:48
 **/
public class Insert {

    private String nonTag;

    private List<Trim> trim;

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

    public List<Trim> getTrim() {
        return trim;
    }

    public void setTrim(List<Trim> trim) {
        this.trim = trim;
    }

    public String getNonTag() {
        return nonTag;
    }

    public void setNonTag(String nonTag) {
        this.nonTag = nonTag;
    }
}
