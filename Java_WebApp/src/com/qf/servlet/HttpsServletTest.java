package com.qf.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpsServletTest extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("HttpsServletTest--加载完成---👍");
    }

    //    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
//        System.out.println("👌------👌-----🐷");
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("这个GET请求过来的内容----HttpsServletTest");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("这是POST请求过来的内容----HttpsServletTest");
    }


}
