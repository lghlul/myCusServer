package com.lu.tag.spring.dao;

import com.lu.tag.spring.Bean;
import com.lu.tag.spring.base.NonValueProperty;

import java.util.List;

/**
 * @CLassName DataSourceBean
 * @Description TODO
 * @Author ll
 * @Date 2018/9/25 15:32
 **/
public class DataSourceBean extends Bean {
    private List<NonValueProperty> property;


    public List<NonValueProperty> getProperty() {
        return property;
    }

    public void setProperty(List<NonValueProperty> property) {
        this.property = property;
    }
}
