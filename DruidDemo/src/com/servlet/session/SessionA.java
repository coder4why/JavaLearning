package com.servlet.session;

import com.alibaba.fastjson.JSONObject;
import com.dao.druid.entity.University;
import com.dao.druid.service.UniversityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/** Session对象【重点】 */

/**
 *  Session概述：
 *          在Session用于记录用户的状态。session指的是在一段时间内，单个客户端与
 *      web服务器的一连串相关的交互过程；
 *          在一个Session中，客户可能会多次请求访问同一个资源，也有可能请求访问各种不同的服务器资源；
 *
 *  Session原理：
 *      服务器会为每一个会话分配一个Session对象；
 *      同一个浏览器发起的多次请求，同属于一次会话（Session）；
 *      首次使用到Session时，服务器会自动创建session，并创建cookie存储sessionid发送回客户端；
 *
 *  Session是由服务器创建的；
 *
 *  Session的使用：
 *      Session的作用域：
 *          拥有存储数据的空间，作用范围是一次会话有效；
 *      一次会话是使用同一浏览器发送的多次请求，一旦浏览器关闭，则结束会话；
 *      可以将数据存入session中，在一次会话的任意位置进行获取；
 *      可传递任何数据（基本数据类型、对象、集合、数组）；
 */
/**
 *  Session结束的三种方式：
 *      1.设置session的有效期：超过有效期，session失效，再次请求，将生成一个新的session;
 *          session.setMaxInactiveInterval(10);
 *      2.session立即失效:
 *          session.invalidate();
 *      3.关闭浏览器；
 */

@WebServlet(value = "/sessionA")
public class SessionA extends HttpServlet {

    private static UniversityServiceImpl service = new UniversityServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /** 获取一次请求Session的会话ID */
        /** 浏览器未关闭的情况下，发起多次请求，获取的sessionID保持不变 */
        HttpSession session = req.getSession();
        System.out.println(session.getId());

//        /** session结束的三种方式：*/
//        /** 设置session的有效期：超过有效期，session失效，再次请求，将生成一个新的session */
//        session.setMaxInactiveInterval(10); /** 单位为s*/
//        /** session立即失效 */
//        session.invalidate();

        List<University> universities = service.selectAll();
        if (universities != null){
            /** 保存数据到session */
            session.setAttribute("universities", universities);
        }
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("Session数据保存成功");

    }
}
