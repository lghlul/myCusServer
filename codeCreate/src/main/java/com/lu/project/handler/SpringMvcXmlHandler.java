package com.lu.project.handler;

import com.lu.tag.XmlAttr;
import com.lu.tag.spring.Bean;
import com.lu.tag.spring.base.NonValueProperty;
import com.lu.tag.spring.mvc.*;
import com.lu.utils.XmlUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * @CLassName SpringXmlHandler
 * @Description spring-mvc.xml生成
 * @Author ll
 * @Date 2018/9/21 16:07
 **/
public class SpringMvcXmlHandler {

    private String rootTag = "beans";

    private String path;

    public SpringMvcXmlHandler(String path) {
        this.path = path;
    }


    /*
     * @author ll
     * @Description 获取根节点
     * @date 2018/9/25 14:54
     * @param []
     * @return com.lu.tag.spring.mvc.MvcBeans
     */
    private MvcBeans getMvcBeans() {
        MvcBeans beans = new MvcBeans();
        List<Bean> beanList = new ArrayList<>();
        beanList.add(getViewBean());
        beans.setBean(beanList);
        List<XmlAttr> mvcResourcesAttrList = new ArrayList<>();
        mvcResourcesAttrList.add(new XmlAttr("mapping", "/resource/**"));
        mvcResourcesAttrList.add(new XmlAttr("location", "/resource/"));
        beans.setMvc3resources(new MvcResources(mvcResourcesAttrList));
        return beans;
    }

    /*
     * @author ll
     * @Description 获取视图解析器标签
     * @date 2018/9/25 14:54
     * @param []
     * @return com.lu.tag.spring.Bean
     */
    private Bean getViewBean() {
        Bean bean = new ViewBean();
        List<NonValueProperty> properties = new ArrayList<>();
        // 视图解析器  property
        NonValueProperty viewProperty = new NonValueProperty();
        List<XmlAttr> viewAttrList = new ArrayList<>();
        viewAttrList.add(new XmlAttr("name", "viewClass"));
        viewAttrList.add(new XmlAttr("value", "org.springframework.web.servlet.view.InternalResourceView"));
        viewProperty.setAttrList(viewAttrList);
        properties.add(viewProperty);

        List<XmlAttr> prefixAttrList = new ArrayList<>();
        prefixAttrList.add(new XmlAttr("name", "prefix"));
        prefixAttrList.add(new XmlAttr("value", "/WEB-INF/pages/"));
        NonValueProperty prefixProperty = new NonValueProperty();
        prefixProperty.setAttrList(prefixAttrList);
        properties.add(prefixProperty);

        List<XmlAttr> suffixAttrList = new ArrayList<>();
        suffixAttrList.add(new XmlAttr("name", "suffix"));
        suffixAttrList.add(new XmlAttr("value", ".jsp"));
        NonValueProperty suffixProperty = new NonValueProperty();
        suffixProperty.setAttrList(suffixAttrList);
        properties.add(suffixProperty);

        ((ViewBean) bean).setProperty(properties);
        List<XmlAttr> beanAttrList = new ArrayList<>();
        beanAttrList.add(new XmlAttr("id", "viewResolver"));
        beanAttrList.add(new XmlAttr("class", "org.springframework.web.servlet.view.InternalResourceViewResolver"));
        ((ViewBean) bean).setAttrList(beanAttrList);

        return bean;
    }


    /*
     * @author ll
     * @Description 写spring-mvc.xml文件
     * @date 2018/9/25 14:54
     * @param [path]
     * @return void
     */
    public void writeSpringMvcXml() {
        MvcBeans mvcBeans = getMvcBeans();
        XmlUtil.writeXml(path, mvcBeans, rootTag);
    }

}
