package com.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 现有问题：
 *    1.Http协议是无状态的，不能保存每次提交的信息；
 *    2.如果用户发来一个新的需求，服务器无法知道它是否与上次的请求有联系；
 *    3.对于那些需要多次提交数据才能完成的web操作，比如登录来说，就成问题了；
 *
 * 状态管理的概念：
 *      将浏览器与web服务器之间多次交互当作一个整体来处理，并且将多次交互所涉
 *    及的数据（即状态）保存下来；
 *
 * 状态管理分类：
 *       1.客户端状态管理技术：将状态保存在客户端，代表性的是Cookie技术；
 *       2.服务器状态管理技术：将状态保存在服务器端，代表性的是Session技术（
 *    服务器传递sessionId时需要使用Cookie非方式）和application；
 *
 * 什么是Cookie：
 *          Cookie是在浏览器访问web服务器的某个资源时，由web服务器在http响应消息头中
 *      附带传送给浏览器的一段小数据；
 *          一旦web浏览器保存了某个Cookie，那么它以后每次访问该web服务器时，都应在http
 *      请求头中将这个Cookie回传给web服务器；
 *          一个Cookie主要由标识该信息的名称（name）和值（value）组成；
 */

/**
 * Cookie的优点和缺点：
 *    优点：
 *        1.可配置到期规则；
 *        2.简单性：Cookie是一种基于文本的轻量结构，包含简单的键值对；
 *        3.数据持久性：Cookie默认在国旗之前是可以一致存在客户端浏览器上的；
 *    缺点：
 *        1.大小受到限制：大多数浏览器对Cookie的大小有4k、8k字节的限制；
 *        2.用户配置为禁用：有些用户禁用了浏览器或客户端设备接收Cookie的能力，因此限制了这一功能；
 *        3.潜在的安全风险：Cookie可能会被篡改，会对安全性造成风险或者 导致依赖雨Cookie的应用
 *        程序失败；
 */
@WebServlet(value = "/cookieA")
public class CookieReqA extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /** 1.服务端创建Cookie对象*/
        Cookie username = new Cookie("username","admin");
        Cookie password = new Cookie("password","1234");

        /**
         * 2.设置Cookie的访问路径:
         *      设置只有项目下的cookieB接口才能访问；
         *      不设置路径，表示这个容器下所有资源都可以访问这个Cookie；
         */
        username.setPath("/servlet/cookieB");
        password.setPath("/servlet/cookieB");

        /** 3.设置Cookie的生命周期：
         *    maxAge值的设置有三种：
         *       >0: 有效期，单位为秒；表示多少秒失效，销毁；
         *       =0：浏览器关闭失效，销毁；
         *       <0: 浏览器内存存储（临时存储），默认-1；
         */
        username.setMaxAge(1000);
        password.setMaxAge(1000);


        /** 4.添加Cookie到resp对象里，传给客户端 */
        resp.addCookie(username);
        resp.addCookie(password);

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("请求成功");

    }
}
