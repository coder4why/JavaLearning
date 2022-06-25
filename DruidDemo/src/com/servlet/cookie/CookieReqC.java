package com.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *  Cookie的修改：
 *     新建一个Cookie，保证Cookie的名和访问路径与之前创建的Cookie一致即可修改；
 *     (如果改变Cookie的name和有效路径会新建Cookie，而改变Cookie的值和有效期会覆盖原来的Cookie)
 */
@WebServlet(value = "/cookieC")
public class CookieReqC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = new Cookie("username","alibaba");
        cookie.setPath("/servlet/cookieB");
        cookie.setMaxAge(1000);

        resp.addCookie(cookie);

        PrintWriter printWriter = resp.getWriter();
        printWriter.println("Cookie覆盖，修改成功");

    }
}
