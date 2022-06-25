package com.servletPRG.test.controller.server.employee;

import com.servletPRG.test.controller.common.ServerUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/** 管理员登录后，写入一条员工信息 */
@WebServlet(name = "EmpRgsController",value = "/register")
public class EmpRgsController extends HttpServlet {

    private ServerUtils serverUtils = new ServerUtils();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int add = serverUtils.doCommonServer(request,response, ServerUtils.ServerType.TYPE_ADD);
        PrintWriter writer = response.getWriter();
        if (add == 1){
            writer.println("员工信息录入成功");
        }else {
            writer.println("员工信息不存在");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
