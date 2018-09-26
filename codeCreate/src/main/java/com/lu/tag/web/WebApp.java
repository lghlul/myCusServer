package com.lu.tag.web;

import com.lu.annotation.Attribute;
import com.lu.annotation.NameSpaceUri;

/**
 * @CLassName WebApp
 * @Description TODO
 * @Author ll
 * @Date 2018/9/25 16:32
 **/
@Attribute(attrName =  {"id" , "version"} ,
        attrValue = {"WebApp_ID" , "3.0"})
@NameSpaceUri(uriName = "http://java.sun.com/xml/ns/javaee")
public class WebApp {
    private String display4name;

    private Servlet servlet;

    private ServletMapping servlet4mapping;

    public String getDisplay4name() {
        return display4name;
    }

    public void setDisplay4name(String display4name) {
        this.display4name = display4name;
    }

    public Servlet getServlet() {
        return servlet;
    }

    public void setServlet(Servlet servlet) {
        this.servlet = servlet;
    }

    public ServletMapping getServlet4mapping() {
        return servlet4mapping;
    }

    public void setServlet4mapping(ServletMapping servlet4mapping) {
        this.servlet4mapping = servlet4mapping;
    }
}
