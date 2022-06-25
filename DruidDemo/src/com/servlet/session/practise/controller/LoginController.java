package com.servlet.session.practise.controller;

import com.servlet.session.practise.entity.User;
import com.servlet.session.practise.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginController",value = "/login")
public class LoginController extends HttpServlet {

    private LoginServiceImpl loginService = new LoginServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        /** 1.获取request参数*/
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        User user = loginService.select(name,password);
        if (user != null){
            /** 登录成功，重定向到LoginSuccessController */
            /** 2.保存账号密码到Session */
            HttpSession session = request.getSession();
            session.setAttribute("user",user);

            /** 添加防Cookie禁用 */
            response.encodeRedirectURL("/servlet/loginSuccess");

            response.sendRedirect("/servlet/loginSuccess");

        }else {
            /** 登录失败，重定向到LoginFailedController */
            response.sendRedirect("/servlet/loginFailed");
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
