package com.lu.tag.mybatis;

import com.lu.annotation.Attribute;
import com.lu.tag.XmlAttr;

import java.util.List;

/**
 * @CLassName Trim
 * @Description TODO
 * @Author ll
 * @Date 2018/9/26 15:48
 **/
public class Trim {

    private List<If> if2;

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

    public List<If> getIf2() {
        return if2;
    }

    public void setIf2(List<If> if2) {
        this.if2 = if2;
    }
}
