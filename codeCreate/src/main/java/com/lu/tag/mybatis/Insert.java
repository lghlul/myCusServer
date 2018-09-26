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

    private Trim trim;

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

    public Trim getTrim() {
        return trim;
    }

    public void setTrim(Trim trim) {
        this.trim = trim;
    }
}
