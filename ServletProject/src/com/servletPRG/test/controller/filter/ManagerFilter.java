package com.servletPRG.test.controller.filter;

import com.servletPRG.test.entity.EmpManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "ManagerFilter",value = {"/register","/delete","/update","/select","/selectAll"})
public class ManagerFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest)req;
        HttpSession session = request.getSession();
        EmpManager manager = (EmpManager) session.getAttribute("manager");
        if (manager != null){
            chain.doFilter(req, resp);
        }else {

            HttpServletResponse response = (HttpServletResponse) resp;
            response.getWriter().println("请登录后在访问！！！");

        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
