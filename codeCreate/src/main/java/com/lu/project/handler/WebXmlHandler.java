package com.lu.project.handler;

import com.lu.tag.web.InitParam;
import com.lu.tag.web.Servlet;
import com.lu.tag.web.ServletMapping;
import com.lu.tag.web.WebApp;
import com.lu.utils.XmlUtil;


/**
 * @CLassName WebXmlHandler
 * @Description web.xml生成
 * @Author ll
 * @Date 2018/9/21 16:07
 **/
public class WebXmlHandler {


    private  String rootTag = "web-app";

    private String path;

    private String projectName;

    public WebXmlHandler(String path , String projectName){
        this.path = path;
        this.projectName = projectName;
    }

    /*
     * @author ll
     * @Description 获取wen.xml 根节点
     * @date 2018/9/25 16:43
     * @param [projectName]
     * @return com.lu.tag.web.WebApp
     */
    private WebApp getWebApp(){
        WebApp webApp = new WebApp();
        webApp.setDisplay4name(projectName);
        webApp.setServlet(getServlet());
        webApp.setServlet4mapping(getServletMapping());
        return webApp;
    }
    /*
     * @author ll
     * @Description 获取servlet标签
     * @date 2018/9/25 16:46
     * @param []
     * @return com.lu.tag.web.Servlet
     */
    private Servlet getServlet(){
        Servlet servlet = new Servlet();
        servlet.setServletName("dispatcherServlet");
        servlet.setServletClass("org.springframework.web.servlet.DispatcherServlet");
        servlet.setLoad4on4startup("1");

        InitParam initParam = new InitParam();
        initParam.setParam4name("contextConfigLocation");
        initParam.setParam4value("classpath*:spring/spring.xml");

        servlet.setInit4param(initParam);
        return servlet;
    }
    /*
     * @author ll
     * @Description 获取servlet-mapping标签
     * @date 2018/9/25 16:48
     * @param []
     * @return com.lu.tag.web.ServletMapping
     */
    private ServletMapping getServletMapping(){
        ServletMapping servletMapping = new ServletMapping();
        servletMapping.setServlet4name("dispatcherServlet");
        servletMapping.setUrl4pattern("/");
        return servletMapping;
    }

    /*
     * @author ll
     * @Description 写 web.xml 文件
     * @date 2018/9/25 16:49
     * @param [path, projectName]
     * @return void
     */
    public void writeWebXml(){
        WebApp webApp = getWebApp();
        XmlUtil.writeXml(path ,webApp , rootTag );
    }

}
