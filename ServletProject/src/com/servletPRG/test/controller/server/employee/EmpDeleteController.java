package com.servletPRG.test.controller.server.employee;

import com.servletPRG.test.controller.common.ServerUtils;
import com.servletPRG.test.entity.Employee;
import com.servletPRG.test.service.impl.EmpServiceApiImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EmpDeleteController",value = "/delete")
public class EmpDeleteController extends HttpServlet {

    private ServerUtils serverUtils = new ServerUtils();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int delete = serverUtils.doCommonServer(request,response, ServerUtils.ServerType.TYPE_DELETE);
        PrintWriter writer = response.getWriter();
        if (delete == 1){
            writer.println("员工信息删除成功");
        }else {
            writer.println("员工信息不存在");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
