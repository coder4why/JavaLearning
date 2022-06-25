package com.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "ServletFilter",value = "/filter")
public class ServletFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("---Filter拦截---");
        /** 让请求继续 */
        chain.doFilter(req, resp);
        /** 响应拦截 */
        System.out.println("----任务结束----");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
