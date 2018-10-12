package com.lu.tag.spring.base;

import com.lu.tag.BaseTag;
import com.lu.tag.XmlAttr;

import java.util.List;

/**
 * @CLassName NonValueProperty
 * @Description Property标签 (有值的property)
 * @Author ll
 * @Date 2018/9/25 9:56
 **/
public class WithValueProperty<T> extends BaseTag {

    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public WithValueProperty(){

    }

    public WithValueProperty(List<XmlAttr> attrList){
        super(attrList);
    }
}
