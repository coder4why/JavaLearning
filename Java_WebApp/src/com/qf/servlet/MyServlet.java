package com.qf.servlet;
import  javax.servlet.*;
import java.io.IOException;

//http://localhost:8080/Java_WebApp_war_exploded/myservlet
public class MyServlet implements Servlet {

    public static void main(String[] args) {}

    /** Servlet接口必须实现的方法 **/
    @Override
    public void init(ServletConfig servletConfig)
            throws ServletException {
        System.out.println("MyServlet--加载完成---👍");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {
        System.out.println("我的第一个Servlet工程文件！");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
