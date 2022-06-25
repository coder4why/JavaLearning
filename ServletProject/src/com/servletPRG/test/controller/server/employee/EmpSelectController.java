package com.servletPRG.test.controller.server.employee;

import com.alibaba.fastjson.JSON;
import com.servletPRG.test.controller.common.ServerUtils;
import com.servletPRG.test.entity.EmpManager;
import com.servletPRG.test.entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EmpSelectController",value = "/select")
public class EmpSelectController extends HttpServlet {

    private ServerUtils serverUtils = new ServerUtils();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Employee employee = serverUtils.doSelect(request,response, ServerUtils.ServerType.TYPE_SELECT);
        PrintWriter writer = response.getWriter();
        if (employee != null){
            writer.println(JSON.toJSONString(employee));
        }else {
            writer.println("员工信息不存在");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
