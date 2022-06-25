package com.servlet.filter;

import com.servlet.session.practise.entity.User;
import com.servlet.session.practise.service.impl.LoginServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.http.HttpRequest;

/** 拦截整个项目所有请求 */

/**
 * 过滤器链：
 *       客户端对服务器请求之后，服务器调用servlet之前会执行一组过滤器（多个过滤器），
 *    那么这组过滤器就称为一条过滤器链；
 *       当第一个doFilter方法被调用的时候，web服务器会创建一个代表Filter链的FilterChain
 *    对象传递给该方法，在doFilter方法中，开发人员如果调用了FilterChain对象的doFilter方法，则
 *    web服务器会检查FilterChain对象中是否还有Filter，如果有，则调用第二个filter，没有的话，
 *    则调用目标资源；
 *
 * 过滤器优先级：
 *      在一个web应用中，可以开发编写多个Filter，这些Filter组合起来称之为一个Filter链；
 * 优先级：
 *      如果为注解的话，是按照类全名称的字符串顺序决定作用顺序
 *            (优先执行直接关联资源的filter，然后执行拦截所有的filter)；
 *      如果web.xml,按照filter-mapping注册顺序，从上往下；
 *      web.xml配置高于注解方法；
 *      如果注解和web.xml同时配置，会创建多个过滤器对象，造成过滤多次；
 *
 */
/** 过滤器典型应用之乱码处理 */

@WebFilter(filterName = "AllFilter",value = "/*")
public class AllFilter implements Filter {

    private LoginServiceImpl loginService = new LoginServiceImpl();
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("---拦截所有请求---");

        /** 过滤器典型应用之乱码处理 */
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        /** 过滤器典型应用之登录验证 */
        HttpServletRequest httpRequest = (HttpServletRequest)req;
        HttpSession session = httpRequest.getSession();

        HttpServletResponse response = (HttpServletResponse)resp;

        /** 1.获取session参数*/
        String name = (String)session.getAttribute("name");
        String password = (String)session.getAttribute("password");

        System.out.println(name+","+password);

        User user = loginService.select(name,password);
        if (user != null){
            /** 用户已登录*/
            chain.doFilter(req, resp);
            response.getWriter().println("欢迎您："+"\n"+"账号:"+name+",密码:"+password);

        }else {
            /** 用户未登录*/
            chain.doFilter(req, resp);
            response.getWriter().println("请先登录再访问！");

        }
        System.out.println("---任务结束---");

    }

    public void init(FilterConfig config) throws ServletException {}

}
