package com.lu.project;

import com.lu.project.domain.XmlAttr;
import com.lu.project.domain.spring.ContextComponentScan;
import com.lu.project.domain.spring.SpringBeans;
import com.lu.project.domain.spring.Import;
import com.lu.utils.XmlUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @CLassName SpringXmlHandler
 * @Description spring.xml生成
 * @Author ll
 * @Date 2018/9/21 16:07
 **/
public class SpringXmlHandler {

    /*
     * @author ll
     * @Description 获取import标签
     * @date 2018/9/21 16:24
     * @param []
     * @return com.lu.project.domain.spring.Import
     */
    private static List<Import> getImportList(){
        List<Import> importList = new ArrayList<>();
        List<XmlAttr> attrList = new ArrayList<>();
        attrList.add(new XmlAttr("resource" , "spring-mvc.xml"));
        Import importMvc = new Import();
        importMvc.setAttrList(attrList);
        importList.add(importMvc);

        attrList.clear();
        attrList.add(new XmlAttr("resource" , "spring-dao.xml"));
        Import importDao = new Import();
        importDao.setAttrList(attrList);
        importList.add(importDao);
        return importList;
    }

    /*
     * @author ll
     * @Description 获取getContextComponentScan标签
     * @date 2018/9/21 17:17
     * @param [basePackage]
     * @return com.lu.project.domain.spring.ContextComponentScan
     */
    private static ContextComponentScan getContextComponentScan(String basePackage){
        ContextComponentScan contextComponentScan = new ContextComponentScan();
        List<XmlAttr> attrList = new ArrayList<>();
        attrList.add(new XmlAttr("base-package" , basePackage));
        contextComponentScan.setAttrList(attrList);
        return contextComponentScan;
    }

    /*
     * @author ll
     * @Description 获取bean标签
     * @date 2018/9/21 16:24
     * @param []
     * @return com.lu.project.domain.spring.SpringBeans
     */
    private static SpringBeans getContextBeans(String basePackage){
        SpringBeans beans = new SpringBeans();
        beans.setImport2(getImportList());
        beans.setContext3component4scan(getContextComponentScan(basePackage));
        return beans;
    }

    /*
     * @author ll
     * @Description 写入applicationContext.xml
     * @date 2018/9/21 16:25
     * @param [path]
     * @return void
     */
    public static void writeSpringXml(String path , String basePackage){
        String rootName = "beans";
        SpringBeans contextBeans = getContextBeans(basePackage);
        Map<String , String> spaceMap = new HashMap<>();
        spaceMap.put("xsi","http://www.w3.org/2001/XMLSchema-instance");
        spaceMap.put("context" , "http://www.springframework.org/schema/context");
        Map<String , String> attrMap = new HashMap<>();
        attrMap.put("xsi:schemaLocation","http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.1.xsd");
        XmlUtil.writeXml(path ,contextBeans ,spaceMap,attrMap , rootName);
    }
}
