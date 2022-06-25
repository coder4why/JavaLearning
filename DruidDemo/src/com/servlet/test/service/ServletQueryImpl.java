package com.servlet.test.service;

import com.alibaba.fastjson.JSONObject;
import com.dao.druid.entity.University;
import com.dao.druid.service.UniversityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(value = {"/query"})
public class ServletQueryImpl extends HttpServlet {

    private static UniversityServiceImpl service = new UniversityServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("查询所有大学信息");
        List<University> universities = service.selectAll();
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(JSONObject.toJSONString(universities));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}