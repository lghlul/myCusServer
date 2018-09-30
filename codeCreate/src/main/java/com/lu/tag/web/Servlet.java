package com.lu.tag.web;

/**
 * @CLassName Servlet
 * @Description TODO
 * @Author ll
 * @Date 2018/9/25 16:33
 **/
public class Servlet {

    private String servlet4name;

    private String servlet4class;

    private InitParam init4param;

    private String load4on4startup;



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

    public String getServlet4name() {
        return servlet4name;
    }

    public void setServlet4name(String servlet4name) {
        this.servlet4name = servlet4name;
    }

    public String getServlet4class() {
        return servlet4class;
    }

    public void setServlet4class(String servlet4class) {
        this.servlet4class = servlet4class;
    }
}
