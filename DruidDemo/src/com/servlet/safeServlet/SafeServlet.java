package com.servlet.safeServlet;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/** Servlet线程安全问题 */
@WebServlet(value = "/ss")
public class SafeServlet extends HttpServlet implements SingleThreadModel {

    /** 共享的成员变量*/
    private Integer numbers = 10086;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /** 1.使用synchronized代码块，
         *      加锁保证数据安全，synchronized执行完成，下一个任务才能执行，一次只能操作一次,效率低下,无法满足高并发需求；
         */
        synchronized(this) {
            numbers--;
            PrintWriter printWriter = resp.getWriter();
            printWriter.println(numbers);
        };

        /** 2.实现SingleThreadModel接口
         *      Servlet实现SingleThreadModel接口后，每个线程都会创建servlet实例，实现初始化，效率太低
         *      这样每个客户端请求就不存在共享资源的问题，但是servlet响应客户端请求的效率太低，所以该接口已被淘汰；
         */

        /** 3.尽可能使用局部变量 */
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
