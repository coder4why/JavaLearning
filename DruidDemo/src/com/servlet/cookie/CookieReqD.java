package com.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

/** Cookie的编解码问题：
 *      Cookie默认不支持中文字符,只能包含ASCII码字符，所以需要对Cookie字符进行编码，否则会出现乱码；
 *      1.编码：
 *           使用java.net.URLEncoder类的encode(String str,String encoding)方法；
 *      2.解码：
 *          使用java.net.URLDecoder类的decode(String str,String encoding)方法；
 *
 */
@WebServlet(value = "/cookieD")
public class CookieReqD extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /** 1、Cookie编码*/
        String nameKey = URLEncoder.encode("姓名","UTF-8");
        String nameValue = URLEncoder.encode("阿里巴巴","UTF-8");
        String passwordKey = URLEncoder.encode("密码","UTF-8");
        String passwordValue = URLEncoder.encode("哦买噶","UTF-8");

        Cookie name = new Cookie(nameKey,nameValue);
        Cookie password = new Cookie(passwordKey,passwordValue);

        name.setMaxAge(10000);
        password.setMaxAge(10000);

        name.setPath("/servlet/cookieB");
        password.setPath("/servlet/cookieB");

        resp.addCookie(name);
        resp.addCookie(password);

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("Cookie的编解码问题");

    }
}
