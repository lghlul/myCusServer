package com.lu.tag.mybatis;


import com.lu.annotation.Attribute;

/**
 * @CLassName Mapper
 * @Description mapper 标签
 * @Author ll
 * @Date 2018/9/26 15:51
 **/
@Attribute(attrName = {"namespace"} , attrValue = {})
public class Mapper {
    private Insert insert;


    public Insert getInsert() {
        return insert;
    }

    public void setInsert(Insert insert) {
        this.insert = insert;
    }
}
