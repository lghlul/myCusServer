package com.lu.tag.web;

/**
 * @CLassName Servlet
 * @Description TODO
 * @Author ll
 * @Date 2018/9/25 16:33
 **/
public class Servlet {

    private String servletName;

    private String servletClass;

    private String load4on4startup;

    private InitParam init4param;


    public String getServletName() {
        return servletName;
    }

    public void setServletName(String servletName) {
        this.servletName = servletName;
    }

    public String getServletClass() {
        return servletClass;
    }

    public void setServletClass(String servletClass) {
        this.servletClass = servletClass;
    }

    public String getLoad4on4startup() {
        return load4on4startup;
    }

    public void setLoad4on4startup(String load4on4startup) {
        this.load4on4startup = load4on4startup;
    }

    public InitParam getInit4param() {
        return init4param;
    }

    public void setInit4param(InitParam init4param) {
        this.init4param = init4param;
    }
}
