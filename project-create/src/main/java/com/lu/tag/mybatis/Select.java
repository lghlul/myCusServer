package com.lu.tag.mybatis;

import com.lu.tag.BaseTag;
import com.lu.tag.XmlAttr;

import java.util.List;

/**
 * @CLassName Select
 * @Description TODO
 * @Author ll
 * @Date 2018/9/28 15:54
 **/
public class Select extends BaseTag {

    private String nonTag;

    public Select(){

    }

    public Select(List<XmlAttr> attrList){
        super(attrList);
    }

    public String getNonTag() {
        return nonTag;
    }

    public void setNonTag(String nonTag) {
        this.nonTag = nonTag;
    }
}
