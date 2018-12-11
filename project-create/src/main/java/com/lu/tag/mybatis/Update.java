package com.lu.tag.mybatis;

import com.lu.tag.BaseTag;

import java.util.List;

/**
 * @CLassName Update
 * @Description TODO
 * @Author ll
 * @Date 2018/11/12 17:09
 **/
public class Update extends BaseTag {
    private String nonTag;

    private Set set;

    private List<If> if2;

    public List<If> getIf2() {
        return if2;
    }

    public void setIf2(List<If> if2) {
        this.if2 = if2;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public String getNonTag() {
        return nonTag;
    }

    public void setNonTag(String nonTag) {
        this.nonTag = nonTag;
    }
}
