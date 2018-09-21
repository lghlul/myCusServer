package com.lu.project;

import com.lu.project.domain.spring.MvcBean;
import com.lu.project.domain.spring.MvcBeans;
import com.lu.project.domain.spring.SpringBeans;
import com.lu.utils.XmlUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @CLassName SpringXmlHandler
 * @Description spring-mvc.xml生成
 * @Author ll
 * @Date 2018/9/21 16:07
 **/
public class SpringMvcXmlHandler {


    private static MvcBeans getMvcBeans(){
        MvcBeans beans = new MvcBeans();
        List<MvcBean> beanList = new ArrayList<>();
        MvcBean bean = new MvcBean();
        beanList.add(bean);
        beanList.add(bean);
        beanList.add(bean);
        beanList.add(bean);
        beans.setBean(beanList);
        return beans;
    }



    public static void writeSpringMvcXml(String path ){
        String rootName = "project";
        MvcBeans mvcBeans = getMvcBeans();
        Map<String , String> spaceMap = new HashMap<>();
        spaceMap.put("xsi","http://www.w3.org/2001/XMLSchema-instance");
        spaceMap.put("mvc" , "http://www.springframework.org/schema/mvc");
        Map<String , String> attrMap = new HashMap<>();
        attrMap.put("xsi:schemaLocation","http://www.springframework.org/schema/beans\n" +
                "      http://www.springframework.org/schema/beans/spring-beans-4.1.xsd\n" +
                "      http://www.springframework.org/schema/mvc\n" +
                "      http://www.springframework.org/schema/mvc/spring-mvc-4.1.xsd");
        XmlUtil.writeXml(path ,mvcBeans ,spaceMap ,attrMap , rootName);
    }

}
