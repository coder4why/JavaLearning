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
import java.util.List;

@WebServlet(name = "SessionB",value = "/sessionB")
public class SessionB extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /** 获取一次会话的Session */
        HttpSession session = request.getSession();

        response.setContentType("application/json;charset=utf-8");

        /** 获取Session中保存的数据 */
        List<University> universities = (List<University>) session.getAttribute("universities");
        if (universities != null){

            response.getWriter().println(JSONObject.toJSONString(universities));

            /** 移除Session中保存的数据 */
            session.removeAttribute("universities");

        }else {
            response.getWriter().println("数据已删除");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
