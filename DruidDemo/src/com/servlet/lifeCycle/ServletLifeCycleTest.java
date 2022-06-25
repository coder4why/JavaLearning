package com.servlet.lifeCycle;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(value = "/cycle")
public class ServletLifeCycleTest implements Servlet {

    public ServletLifeCycleTest(){
        super();
        System.out.println("1、构造对象");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2、初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3、Request请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4、Servlet销毁");

    }
}
