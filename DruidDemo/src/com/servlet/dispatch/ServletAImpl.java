package com.servlet.dispatch;

import com.dao.druid.entity.University;
import com.dao.druid.service.UniversityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet的转发与重定向：
 *   forword转发：
 *      1.使用Servlet的转发功能，可以实现数据操作与报文展示分离；
 *      2.转发属于一次request请求，可以通过Request.setAttribute()实现数据缓存共享；
 *      3.forwoard转发，浏览器地址不变；
 *      4.不使用明文传输，更加安全；
 *   重定向：
 *      1.使用重定向也属于网络接口请求转发；
 *      2.属于至少两次的访问请求（可以多次重定向）,没有数据共享；
 *      3.重定向浏览器地址会改变（每一次重定向变化一次，多次重定向每一次都变）；
 *      4.重定向两次跳转间传输的信息会丢失（request范围）；
 *      5.重定向可以指向任何的资源，包括当前应用程序中的其他资源，同一个站点上的其他应用程
 *      序中的资源，其他站点的资源；
 *      6.使用明文传递数据，不安全；
 */
@WebServlet(value = "/shwoAll")
public class ServletAImpl extends HttpServlet {

    private static UniversityServiceImpl service = new UniversityServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /** 1.dispatch实现转发，request完成数据传递 */
        /** 数据查询*/
        List<University> universities = service.selectAll();
        /** 数据保存*/
        req.setAttribute("universities",universities);
        /** 转发*/
        req.getRequestDispatcher("/shwoResponse").forward(req,resp);

//        doPost(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);

        /** 2.重定向：使用全路径（除域名外）转发，参数传递只能使用字符串*/
//        resp.sendRedirect("/servlet/shwoResponse?method=selectAll");

    }
}
