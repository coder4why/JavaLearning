package com.servletContext.desc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext对象：
 *      1.全局对象，也拥有作用域，对应一个Tomcat中的web应用；
 *      2.当Web服务器启动时，会为每一个web应用程序创建一块共享的存储区域（ServletContext）;
 *      3.ServletContext在web服务器启动时创建，服务器关闭时销毁；
 *
 *  获取ServletContext的三种方式：
 *      1.使用GeneraticServlet提供的getServletContext()方法（推荐），this.getServletContext()；
 *      2.HttpServletRequest提供了 getServletContext()方法；（推荐）；
 *      3.HttpSession提供了getServletContext()方法；
 *
 *  ServletContext的特点：
 *      1.唯一性：一个应用对应一个servlet上下文；
 *      2.生命周期：只要容器不关闭或者应用不卸载，ServletContext对象就一直存在；
 */
@WebServlet(name = "ScontextCtrl",value = "/descSC")
public class ScontextCtrl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /** 获取ServletContext的三种方法：获取为同一个对象 */
        /** 1.*/
        ServletContext context = this.getServletContext();

        /** 2.*/
        ServletContext context1 = request.getServletContext();

        /** 3.*/
        ServletContext context2 = request.getSession().getServletContext();

        /** ServletContext的作用 */
        /** 1.获取项目发布的真实路径*/
        String project_path = context.getRealPath("/");
        System.out.println("项目路径："+project_path);

        /** 2.获取项目上下文路径 */
        String cxtPath = context.getContextPath();
        System.out.println("上下文路径："+cxtPath);

        /**
         * 3.全局容器：
         *     servletContext拥有作用域，可以存储数据到全局容器；
         */
        /** 1.存储数据*/
        context.setAttribute("address","上海市嘉定区");
        /** 2.获取数据*/
        String address = (String) context.getAttribute("address");
        System.out.println(address);
        /** 3.移除数据*/
        context.removeAttribute("address");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
