package com.lu.project.handler;

import com.lu.tag.XmlAttr;
import com.lu.tag.spring.base.Bean;
import com.lu.tag.spring.base.NonValueProperty;
import com.lu.tag.spring.base.Value;
import com.lu.tag.spring.dao.*;
import com.lu.utils.PropertiesUtil;
import com.lu.utils.XmlUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @CLassName SpringDaoXmlHandler
 * @Description spring-dao.xml 文件
 * @Author ll
 * @Date 2018/9/25 9:52
 **/
public class SpringDaoXmlHandler {


    private String path;

    private String basePackage;

    private String rootTag = "beans";

    public SpringDaoXmlHandler(String path, String basePackage) {
        this.path = path;
        this.basePackage = basePackage;

    }

    private DaoBeans getDaoBeans() {
        DaoBeans daoBeans = new DaoBeans();
        List<Bean> beanList = new ArrayList<>();
        // 读取配置文件 bean
        beanList.add(getPropertyBean());
        // 数据源 dataSource bean
        beanList.add(getDataSourceBean());
        // sqlSessionFactory bean
        beanList.add(getFactoryBean());
        //mapperConfig bean
        beanList.add(getMapperConfigBean());

        daoBeans.setBean(beanList);
        return daoBeans;
    }

    /*
     * @author ll
     * @Description 获取读取配置文件 .properties bean
     * @date 2018/9/25 15:34
     * @param []
     * @return com.lu.tag.spring.dao.NonValuePropertyBean
     */
    private PropertyBean getPropertyBean() {
        PropertyBean propertyBean = new PropertyBean();
        PropertyProperty property = new PropertyProperty();

        List<XmlAttr> propertyAttrList = new ArrayList<>();
        propertyAttrList.add(new XmlAttr("name", "locations"));
        property.setAttrList(propertyAttrList);

        List<Value> valueList = new ArrayList<>();
        valueList.add(new Value("classpath*:datasource/jdbc.properties"));
        property.setList(valueList);
        propertyBean.setProperty(property);

        List<XmlAttr> beanAttrList = new ArrayList<>();
        beanAttrList.add(new XmlAttr("class", "org.springframework.beans.factory.config.PropertyPlaceholderConfigurer"));
        propertyBean.setAttrList(beanAttrList);
        return propertyBean;
    }

    /*
     * @author ll
     * @Description 获取dataSource bean
     * @date 2018/9/25 15:48
     * @param []
     * @return com.lu.tag.spring.dao.DataSourceBean
     */
    private DataSourceBean getDataSourceBean() {
        DataSourceBean dataSourceBean = new DataSourceBean();
        List<NonValueProperty> propertyList = new ArrayList<>();

        List<XmlAttr> attrList1 = new ArrayList<>();
        attrList1.add(new XmlAttr("url", "${jdbc.url}"));
        propertyList.add(new NonValueProperty(attrList1));

        List<XmlAttr> attrList2 = new ArrayList<>();
        attrList2.add(new XmlAttr("username", "${jdbc.username}"));
        propertyList.add(new NonValueProperty(attrList2));

        List<XmlAttr> attrList3 = new ArrayList<>();
        attrList3.add(new XmlAttr("password", "${jdbc.password}"));
        propertyList.add(new NonValueProperty(attrList3));

        List<XmlAttr> attrList4 = new ArrayList<>();
        attrList4.add(new XmlAttr("driverClassName", "${jdbc.driverClassName}"));
        propertyList.add(new NonValueProperty(attrList4));

        dataSourceBean.setProperty(propertyList);

        List<XmlAttr> beanAttrList = new ArrayList<>();
        beanAttrList.add(new XmlAttr("id", "dataSource"));
        beanAttrList.add(new XmlAttr("class", "com.alibaba.druid.pool.DruidDataSource"));
        beanAttrList.add(new XmlAttr("init-method", "init"));
        beanAttrList.add(new XmlAttr("destroy-method", "close"));
        dataSourceBean.setAttrList(beanAttrList);

        return dataSourceBean;
    }

    /*
     * @author ll
     * @Description 获取sqlSessionFactory bean
     * @date 2018/9/25 16:17
     * @param [domainPackage]
     * @return com.lu.tag.spring.dao.FactoryBean
     */
    private FactoryBean getFactoryBean() {
        FactoryBean factoryBean = new FactoryBean();
        List<NonValueProperty> propertyList = new ArrayList<>();

        List<XmlAttr> attrList1 = new ArrayList<>();
        attrList1.add(new XmlAttr("name", "dataSource"));
        attrList1.add(new XmlAttr("ref", "dataSource"));
        propertyList.add(new NonValueProperty(attrList1));

        List<XmlAttr> attrList2 = new ArrayList<>();
        attrList2.add(new XmlAttr("name", "configLocation"));
        attrList2.add(new XmlAttr("value", "classpath:datasource/sqlMapConfig.xml"));
        propertyList.add(new NonValueProperty(attrList2));


        List<XmlAttr> attrList3 = new ArrayList<>();
        attrList3.add(new XmlAttr("name", "typeAliasesPackage"));
        attrList3.add(new XmlAttr("value", basePackage + "." + PropertiesUtil.PACKAGE_DOMAIN));
        propertyList.add(new NonValueProperty(attrList3));

        List<XmlAttr> attrList4 = new ArrayList<>();
        attrList4.add(new XmlAttr("name", "mapperLocations"));
        attrList4.add(new XmlAttr("value", "classpath:datasource/sql/*.xml"));
        propertyList.add(new NonValueProperty(attrList4));

        factoryBean.setProperty(propertyList);

        List<XmlAttr> beanAttrList = new ArrayList<>();
        beanAttrList.add(new XmlAttr("id", "sqlSessionFactory"));
        beanAttrList.add(new XmlAttr("class", "org.mybatis.spring.SqlSessionFactoryBean"));
        factoryBean.setAttrList(beanAttrList);
        return factoryBean;
    }

    /*
     * @author ll
     * @Description 获取 MapperScannerConfigurer bean
     * @date 2018/9/25 16:28
     * @param [basePackage]
     * @return com.lu.tag.spring.dao.MapperConfigBean
     */
    private MapperConfigBean getMapperConfigBean() {
        MapperConfigBean mapperConfigBean = new MapperConfigBean();
        List<NonValueProperty> propertyList = new ArrayList<>();

        List<XmlAttr> attrList1 = new ArrayList<>();
        attrList1.add(new XmlAttr("name", "basePackage"));
        attrList1.add(new XmlAttr("value", basePackage + "." + PropertiesUtil.PACKAGE_MAPPER));
        propertyList.add(new NonValueProperty(attrList1));

        List<XmlAttr> attrList2 = new ArrayList<>();
        attrList2.add(new XmlAttr("name", "sqlSessionFactoryBeanName"));
        attrList2.add(new XmlAttr("value", "sqlSessionFactory"));
        propertyList.add(new NonValueProperty(attrList2));

        mapperConfigBean.setProperty(propertyList);

        List<XmlAttr> beanAttrList = new ArrayList<>();
        beanAttrList.add(new XmlAttr("class", "org.mybatis.spring.mapper.MapperScannerConfigurer"));
        mapperConfigBean.setAttrList(beanAttrList);
        return mapperConfigBean;
    }

    /*
     * @author ll
     * @Description 写入 spring-dao.xml 文件
     * @date 2018/9/26 18:47
     * @param []
     * @return void
     */
    public void writeSpringDaoXml() {
        DaoBeans mvcBeans = getDaoBeans();
        XmlUtil.writeXml(path, mvcBeans, rootTag);
    }
}
