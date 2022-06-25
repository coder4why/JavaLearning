package com.servlet.session;

import com.dao.druid.entity.University;
import com.dao.druid.service.UniversityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/** 浏览器禁用Cookie的解决方法 */

/**
 * 浏览器禁用Cookie的后果：
 *       服务器在默认情况下，会使用Cookie的方式将sessionID发送给浏览器，如果用户
 *    禁止Cookie，则sessionID不会被浏览器保存，此时，服务器可以使用如URL重写这样
 *    的方式来发送sessionID；
 *
 * URL重写：
 *       浏览器在访问服务器上的某一个地址时，不再使用原来的那个地址，而是使用经过改
 *    写的地址（即在原来的地址后面加上了SessionID）；
 *
 * 实现URL重写：
 *      response.encodeRedirectURL(String url)生成重写的URL；
 */

@WebServlet(name = "SessionForbiddenA",value = "/forbidA")
public class SessionForbiddenA extends HttpServlet {

    private static UniversityServiceImpl service = new UniversityServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        List<University> universities = service.selectAll();
        session.setAttribute("universities",universities);

        /** 如果浏览器未禁用Cookie，encodeRedirectURL()无效 */
        String newURL = response.encodeRedirectURL("/servlet/forbidB");
        System.out.println(newURL);

        response.sendRedirect(newURL);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
