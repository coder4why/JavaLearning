package com.servletPRG.test.controller.server.employee;

import com.alibaba.fastjson.JSON;
import com.servletPRG.test.controller.common.ServerUtils;
import com.servletPRG.test.entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "EmpSelectAllController",value = "/selectAll")
public class EmpSelectAllController extends HttpServlet {
    private ServerUtils serverUtils = new ServerUtils();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Employee> employees = serverUtils.doSelectAll(request,response, ServerUtils.ServerType.TYPE_SELECT_ALL);
        PrintWriter writer = response.getWriter();
        if (employees.isEmpty() == false && employees.size()>0){
            writer.println(JSON.toJSONString(employees));
        }else {
            writer.println("没有找到任何员工信息");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
