package com.lu.tag.mybatis;

import com.lu.tag.BaseTag;
import com.lu.tag.XmlAttr;

import java.util.List;


/**
 * @CLassName If
 * @Description TODO
 * @Author ll
 * @Date 2018/9/26 17:28
 **/
public class If extends BaseTag {


    public If(){

    }

    public If(String nonTag , List<XmlAttr> attrList){
        super(attrList);
        this.nonTag = nonTag;
    }

    private String nonTag;



    public String getNonTag() {
        return nonTag;
    }

    public void setNonTag(String nonTag) {
        this.nonTag = nonTag;
    }
}
