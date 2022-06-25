package com.servlet.session.practise.controller;

import com.servlet.session.practise.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginSuccessController",value = "/loginSuccess")
public class LoginSuccessController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        if (user != null){
            printWriter.println("欢迎你，"+user.getName());
        }else{
            printWriter.println("登录后可查看");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
