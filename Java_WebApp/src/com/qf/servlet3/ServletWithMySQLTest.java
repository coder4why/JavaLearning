package com.qf.servlet3;

import www.vip.com.MySQL.MySQLTool;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

@WebServlet(value = {"/register", "/reg"}, loadOnStartup = 0)
public class ServletWithMySQLTest extends HttpServlet {

    private boolean registerUserToMySQL(String name, String age) throws Exception {

        Object[] objects = MySQLTool.getMySqlObj();
        Statement statement = (Statement) objects[0];

        /** 创建数据表*/
        String createSQL = "create table if not exists RegisterUser(" +
                "id int unsigned auto_increment," +
                "name varchar(20) unique not null," +
                "age varchar(3) not null," +
                "primary key(id)" +
                ")engine=InnoDB default charset=utf8";
        statement.execute(createSQL);

        String queryString = "select * from RegisterUser where name = '"+name+"'";
        ResultSet resultSet = statement.executeQuery(queryString);
        while (resultSet.next()){
            resultSet.close();
            statement.close();
            System.out.println("该用户已存在！");
            return false;
        }

        String insertUser = "insert into RegisterUser(name,age)values('" + name + "','" + age + "')";
        statement.execute(insertUser);
        statement.close();
        System.out.println("数据库操作结束！");
        return true;

    }

    private void sendResponse(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        /** 1.获取入参*/
        String name = req.getParameter("name");
        String age = req.getParameter("age");

        req.setCharacterEncoding("utf-8");
        boolean isSuccess = registerUserToMySQL(name, age);

        System.out.println(isSuccess);

        /* 返回报文：
             {
                "code": 0,
                "msg": null,
                "data": {
                    "id": "1295560375043493890",
                    "type": "2",
                    "oldName": "",
                    "newName": "f57b7cb871084ac0a6e335321873a022.",
                    "path": "/2/202008/f57b7cb871084ac0a6e335321873a022.",
                    "url": null,
                    "position": null,
                    "thumbnailUrl": null
                }
            }
         */

        //设置响应头
        //Date date = new Date(0);
        //resp.addHeader("name", "xuefu");
        //resp.addIntHeader("age", 18);
        //resp.addDateHeader("birthday",date.getTime());
        //resp.addHeader("name", "xueli");
        //resp.setIntHeader("age", 20);

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id", "1295560375043493890");
        dataMap.put("type", "2");
        dataMap.put("oldName", "");
        dataMap.put("newName", "f57b7cb871084ac0a6e335321873a022");
        dataMap.put("path", "/2/202008/f57b7cb871084ac0a6e335321873a022.");
        dataMap.put("url", "www.baidu.com");
        dataMap.put("position", "上海市徐汇区");
        dataMap.put("thumbnailUrl", "www.baidu.com?picUrl=index.png");

        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        Map<String, Object> response = new HashMap<>();
        response.put("code", "200");
        response.put("msg", isSuccess?"注册成功":"用户已存在");
        response.put("data", isSuccess?dataMap:"");
        printWriter.println(JSONObject.toJSONString(response));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            sendResponse(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            sendResponse(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
