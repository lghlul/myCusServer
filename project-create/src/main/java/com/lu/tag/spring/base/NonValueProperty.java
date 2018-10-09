package com.lu.tag.spring.base;

import com.lu.tag.BaseTag;
import com.lu.tag.XmlAttr;

import java.util.List;

/**
 * @CLassName NonValueProperty
 * @Description Property标签 (只有属性的property)
 * @Author ll
 * @Date 2018/9/25 9:56
 **/
public class NonValueProperty extends BaseTag {

    public NonValueProperty(){

    }

    public NonValueProperty(List<XmlAttr> attrList){
        super(attrList);
    }
}
