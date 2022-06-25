package com.qf.servlet3;

import com.alibaba.fastjson.JSONObject;
import www.vip.com.MySQL.MySQLTool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(value = {"/query","/getUsers"})
public class ServletQueryTest extends HttpServlet {

    private void queryRegisterUsers(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        Object[] objects = MySQLTool.getMySqlObj();
        Statement statement = (Statement)objects[0];
        Connection connection = (Connection) objects[1];
        String queryString = "select * from RegisterUser";
        ResultSet resultSet = statement.executeQuery(queryString);
        ArrayList users = new ArrayList<>();
        while (resultSet.next()){
            String name = resultSet.getString("name");
            String age = resultSet.getString("age");
            Map<String,Object> user = new HashMap<>();
            user.put("name",name);
            user.put("age",age);
            users.add(user);
        }
        resultSet.close();
        statement.close();
        connection.close();

        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        Map<String,Object> response = new HashMap<>();
        response.put("code","200");
        response.put("msg","查询成功");
        response.put("data",users);

        printWriter.println(JSONObject.toJSONString(response));


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            queryRegisterUsers(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            queryRegisterUsers(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
