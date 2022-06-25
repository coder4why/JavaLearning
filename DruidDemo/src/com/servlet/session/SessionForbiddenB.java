package com.servlet.session;

import com.alibaba.fastjson.JSONObject;
import com.dao.druid.entity.University;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SessionForbiddenB",value = "/forbidB")
public class SessionForbiddenB extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        System.out.println("URL重写接收的sessionID"+session.getId());

        response.setContentType("application/json;charset=utf-8");
        List<University> universities = (List<University>) session.getAttribute("universities");
        PrintWriter printWriter = response.getWriter();
        if (universities != null){
            printWriter.println(JSONObject.toJSONString(universities));
        }else {
            printWriter.println("未查询到数据");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
