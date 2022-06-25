package com.qf.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class GenericSerletTest extends GenericServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("GenericSerletTest--加载完成---👍");

    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {

        System.out.println("👋--😔-GenericServlet");

    }
}
