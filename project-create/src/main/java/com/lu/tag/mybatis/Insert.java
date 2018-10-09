package com.lu.tag.mybatis;

import com.lu.tag.BaseTag;

import java.util.List;

/**
 * @CLassName Insert
 * @Description insert 标签
 * @Author ll
 * @Date 2018/9/26 15:48
 **/
public class Insert extends BaseTag {

    private String nonTag;

    private List<Trim> trim;


    public List<Trim> getTrim() {
        return trim;
    }

    public void setTrim(List<Trim> trim) {
        this.trim = trim;
    }

    public String getNonTag() {
        return nonTag;
    }

    public void setNonTag(String nonTag) {
        this.nonTag = nonTag;
    }
}
