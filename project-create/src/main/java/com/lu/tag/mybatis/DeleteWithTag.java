package com.lu.tag.mybatis;

import com.lu.tag.XmlAttr;

import java.util.List;

/**
 * @CLassName DeleteWithTag
 * @Description TODO
 * @Author ll
 * @Date 2018/9/28 18:57
 **/
public class DeleteWithTag extends Delete{
    public DeleteWithTag(List<XmlAttr> attrList){
        super(attrList);
    }

    private Where where;


    public Where getWhere() {
        return where;
    }

    public void setWhere(Where where) {
        this.where = where;
    }

}
