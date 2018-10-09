package com.lu.project.handler;

import com.lu.tag.XmlAttr;
import com.lu.tag.spring.ContextComponentScan;
import com.lu.tag.spring.SpringBeans;
import com.lu.tag.spring.Import;
import com.lu.utils.XmlUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * @CLassName SpringXmlHandler
 * @Description spring.xml生成
 * @Author ll
 * @Date 2018/9/21 16:07
 **/
public class SpringXmlHandler {

    private String path ;

    private String basePackage;

    private String rootTag = "beans";

    public SpringXmlHandler(String path , String basePackage){
        this.path = path;
        this.basePackage = basePackage;
    }

    /*
     * @author ll
     * @Description 获取import标签
     * @date 2018/9/21 16:24
     * @param []
     * @return com.lu.tag.spring.Import
     */
    private List<Import> getImportList(){
        List<Import> importList = new ArrayList<>();
        List<XmlAttr> attrList = new ArrayList<>();
        attrList.add(new XmlAttr("resource" , "spring-mvc.xml"));
        Import importMvc = new Import();
        importMvc.setAttrList(attrList);
        importList.add(importMvc);

        List<XmlAttr> attrList2 = new ArrayList<>();
        attrList2.add(new XmlAttr("resource" , "spring-dao.xml"));
        Import importDao = new Import();
        importDao.setAttrList(attrList2);
        importList.add(importDao);
        return importList;
    }

    /*
     * @author ll
     * @Description 获取getContextComponentScan标签
     * @date 2018/9/21 17:17
     * @param [basePackage]
     * @return com.lu.tag.spring.ContextComponentScan
     */
    private ContextComponentScan getContextComponentScan(){
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
     * @return com.lu.tag.spring.SpringBeans
     */
    private SpringBeans getContextBeans(){
        SpringBeans beans = new SpringBeans();
        beans.setImport2(getImportList());
        beans.setContext3component4scan(getContextComponentScan());
        return beans;
    }

    /*
     * @author ll
     * @Description 写入applicationContext.xml
     * @date 2018/9/21 16:25
     * @param [path]
     * @return void
     */
    public void writeSpringXml(){
        SpringBeans contextBeans = getContextBeans();
        XmlUtil.writeXml(path ,contextBeans , rootTag );
    }
}
