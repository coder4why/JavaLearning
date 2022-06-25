package com.servletPRG.test.controller.common;

import com.servletPRG.test.entity.Employee;
import com.servletPRG.test.service.impl.EmpServiceApiImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class ServerUtils {

    public enum ServerType {
        TYPE_ADD,TYPE_DELETE,TYPE_UPDATE,TYPE_SELECT,TYPE_SELECT_ALL
    }
    private EmpServiceApiImpl serviceApi = new EmpServiceApiImpl();
    public int doCommonServer(HttpServletRequest request, HttpServletResponse response,ServerType type) throws ServletException, IOException {

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String empID = request.getParameter("empID");
        String salary = request.getParameter("salary");
        Employee employee = new Employee(name,Integer.valueOf(age),Double.valueOf(salary),empID);

        int result = 0;
        switch(type){
            case TYPE_ADD:
                result = serviceApi.registerEmp(employee);
                break;
            case TYPE_DELETE:
                result = serviceApi.deleteEmp(employee);
                break;
            case TYPE_UPDATE:
                result = serviceApi.updateEmp(employee);
                break;
            default :
                break;
        }

        return result;

    }

    public Employee doSelect(HttpServletRequest request, HttpServletResponse response, ServerType type) throws ServletException, IOException {

        String empID = request.getParameter("empID");
        switch(type){
            case TYPE_SELECT:
                 return serviceApi.selectEmp(empID);
            default :
                break;
        }
        return null;

    }

    public List<Employee> doSelectAll(HttpServletRequest request, HttpServletResponse response, ServerType type) throws ServletException, IOException {

        switch(type){
            case TYPE_SELECT_ALL:
                return serviceApi.selectAll();
            default :
                break;
        }
        return null;

    }

}
