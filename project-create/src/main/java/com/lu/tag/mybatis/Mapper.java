package com.lu.tag.mybatis;


import com.lu.annotation.Attribute;

import java.util.List;

/**
 * @CLassName Mapper
 * @Description mapper 标签
 * @Author ll
 * @Date 2018/9/26 15:51
 **/
@Attribute(attrName = {"namespace"} , attrValue = {})
public class Mapper {

    private ResultMap resultMap;

    private List<Select> select;

    private List<Insert> insert;

    private List<Delete> delete;

    private List<Update> update;

    public List<Update> getUpdate() {
        return update;
    }

    public void setUpdate(List<Update> update) {
        this.update = update;
    }

    public List<Delete> getDelete() {
        return delete;
    }

    public void setDelete(List<Delete> delete) {
        this.delete = delete;
    }

    public List<Select> getSelect() {
        return select;
    }

    public void setSelect(List<Select> select) {
        this.select = select;
    }

    public List<Insert> getInsert() {
        return insert;
    }

    public void setInsert(List<Insert> insert) {
        this.insert = insert;
    }

    public ResultMap getResultMap() {
        return resultMap;
    }

    public void setResultMap(ResultMap resultMap) {
        this.resultMap = resultMap;
    }
}
