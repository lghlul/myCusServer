package com.lu.tag.mybatis;

import com.lu.tag.BaseTag;
import com.lu.tag.XmlAttr;

import java.util.List;

/**
 * @CLassName SelectWithTag
 * @Description 带子标签的select标签
 * @Author ll
 * @Date 2018/9/28 16:35
 **/
public class SelectWithTag extends Select {

    public SelectWithTag(List<XmlAttr> attrList){
        super(attrList);
    }

    private Where where;

    private List<If> if2;

    public Where getWhere() {
        return where;
    }

    public void setWhere(Where where) {
        this.where = where;
    }

    public List<If> getIf2() {
        return if2;
    }

    public void setIf2(List<If> if2) {
        this.if2 = if2;
    }
}
