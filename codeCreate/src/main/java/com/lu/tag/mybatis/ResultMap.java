package com.lu.tag.mybatis;

import com.lu.tag.BaseTag;

import java.util.List;

/**
 * @CLassName ResultMap
 * @Description TODO
 * @Author ll
 * @Date 2018/9/28 16:09
 **/
public class ResultMap extends BaseTag {

    private Id id;

    private List<Result> result;


    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }
}
