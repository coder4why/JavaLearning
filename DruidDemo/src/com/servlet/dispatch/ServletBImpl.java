package com.servlet.dispatch;

import com.alibaba.fastjson.JSONObject;
import com.dao.druid.entity.University;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(value = "/shwoResponse")
public class ServletBImpl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /** 数据读取*/
        List<University> universities = (List<University>) req.getAttribute("universities");
        resp.setContentType("application/json;charset=utf8");
        /** 数据输出展示*/
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(JSONObject.toJSONString(universities));

//        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
//        String method = req.getParameter("method");
//        System.out.println("重定向参数:"+method);
//        /** 数据输出展示*/
//        PrintWriter printWriter = resp.getWriter();
//        printWriter.println(method);

    }
}
