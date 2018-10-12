package com.lu.tag.spring.mvc;

import com.lu.tag.BaseTag;

/**
 * @CLassName Converter
 * @Description TODO
 * @Author ll
 * @Date 2018/10/9 15:15
 **/
public class Converter extends BaseTag {
    private ConverterBean bean;

    public ConverterBean getBean() {
        return bean;
    }

    public void setBean(ConverterBean bean) {
        this.bean = bean;
    }
}
