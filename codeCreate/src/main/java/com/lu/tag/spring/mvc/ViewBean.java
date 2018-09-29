package com.lu.tag.spring.mvc;

import com.lu.tag.spring.Bean;
import com.lu.tag.spring.base.NonValueProperty;

import java.util.List;

/**
 * @CLassName MvcBeans
 * @Description TODO
 * @Author ll
 * @Date 2018/9/21 17:06
 **/
public class ViewBean extends Bean  {

    private List<NonValueProperty> propertyList;


    public List<NonValueProperty> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<NonValueProperty> propertyList) {
        this.propertyList = propertyList;
    }

}
