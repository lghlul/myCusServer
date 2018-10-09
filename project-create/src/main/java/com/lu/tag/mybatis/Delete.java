package com.lu.tag.mybatis;

import com.lu.tag.BaseTag;
import com.lu.tag.XmlAttr;

import java.util.List;

/**
 * @CLassName Delete
 * @Description TODO
 * @Author ll
 * @Date 2018/9/28 18:40
 **/
public class Delete extends BaseTag {
    private String nonTag;

    public Delete(){

    }

    public Delete(List<XmlAttr> attrList){
        super(attrList);
    }

    public String getNonTag() {
        return nonTag;
    }

    public void setNonTag(String nonTag) {
        this.nonTag = nonTag;
    }
}
