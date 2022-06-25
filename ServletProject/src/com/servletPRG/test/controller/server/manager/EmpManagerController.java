package com.servletPRG.test.controller.server.manager;

import com.servletPRG.test.entity.EmpManager;
import com.servletPRG.test.service.impl.EmpManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/** 管理员登录接口 */
@WebServlet(name = "EmpManagerController",value = "/login")
public class EmpManagerController extends HttpServlet {

    private EmpManagerServiceImpl empManagerService = new EmpManagerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /** 管理员登录*/
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        EmpManager manager = new EmpManager(name,password);
        boolean isValid = empManagerService.isManager(manager);
        PrintWriter writer = response.getWriter();
        if (isValid == true){

            HttpSession session = request.getSession();
            session.setAttribute("manager",manager);
            writer.println("欢迎你：\n"+name);

        }else {

            writer.println("登录失败，未找到管理员信息");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
