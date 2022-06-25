package com.qf.servlet2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 接口调用方法：
 *      http://localhost:8080/servlet/login?name=huxiansheng&age=10
 */
@WebServlet(value = {"/login","/log"},loadOnStartup = 0)
public class BaseHttpServletTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        /**
         * getQueryString()：获取GET请求参数
         */
//        System.out.println("GET请求参数---"+req.getQueryString());
//        System.out.println("GET请求URL---"+req.getRequestURI());

        /** 获取请求参数 */
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        System.out.println("提交GET的数据为\n"+"name:"+name+"\n"+"age:"+age);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        System.out.println("这个是POST请求"+req.getQueryString());
        req.setCharacterEncoding("utf-8"); //设置字符编码，防止乱码；
        /** 1、获取请求参数 */
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        System.out.println("提交POST的数据为\n"+"name:"+name+"\n"+"age:"+age);

        /**
         * 设置服务器端的编码格式（setContentType()）：
         *      在getWriter()获取流之前设置
         */
//        resp.setCharacterEncoding("utf-8");
//        resp.setHeader("Content-Type","application/json;charset=UTF-8");
        resp.setContentType("application/json;charset=UTF-8");
        /** 2、响应数据给客户端 **/
        PrintWriter printWriter = resp.getWriter();
        Map<String,Object> response = new HashMap<>();
        response.put("code","200");
        response.put("msg","请求成功");
        response.put("body","账号密码注册成功");

        printWriter.println(response);


    }
}
