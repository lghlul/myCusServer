package com.lu.tag.spring.mvc;

import com.lu.tag.spring.Bean;
import com.lu.tag.spring.base.WithValueProperty;

import java.util.List;

/**
 * @CLassName ConverterBean
 * @Description TODO
 * @Author ll
 * @Date 2018/10/9 14:51
 **/
public class ConverterBean extends Bean {

    private WithValueProperty property;

    public WithValueProperty getProperty() {
        return property;
    }

    public void setProperty(WithValueProperty property) {
        this.property = property;
    }
}
