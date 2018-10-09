package com.lu.tag.spring.dao;

import com.lu.tag.BaseTag;
import com.lu.tag.spring.base.Value;

import java.util.List;

/**
 * @CLassName PropertyProperty
 * @Description TODO
 * @Author ll
 * @Date 2018/9/25 15:07
 **/
public class PropertyProperty extends BaseTag {

    private List<Value> list;


    public List<Value> getList() {
        return list;
    }

    public void setList(List<Value> list) {
        this.list = list;
    }
}
