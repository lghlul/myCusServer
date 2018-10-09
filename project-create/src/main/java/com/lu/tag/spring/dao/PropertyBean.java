package com.lu.tag.spring.dao;

import com.lu.tag.spring.Bean;


/**
 * @CLassName NonValuePropertyBean
 * @Description TODO
 * @Author ll
 * @Date 2018/9/25 15:06
 **/
public class PropertyBean extends Bean {

    private PropertyProperty property;



    public PropertyProperty getProperty() {
        return property;
    }

    public void setProperty(PropertyProperty property) {
        this.property = property;
    }
}
