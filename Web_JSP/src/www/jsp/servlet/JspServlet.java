package www.jsp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/** 调用当前接口，转发到JSP文件 */
@WebServlet(name = "JspServlet",value = "/scope")
public class JspServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("requestScope","雷神索尔403");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
//        response.getWriter().println("欢迎来到王者荣耀！");

        /** 1.使用转发，传递数据 */
//        request.getRequestDispatcher("/myjsp/innerObject/scopeObj.jsp").forward(request,response);

        /** 2.使用重定向，session传递数据*/
        HttpSession session = request.getSession();
        session.setAttribute("sessionContent","索尔奥丁森");
        /** 3.使用重定向，ServletContext 传递数据 */
        request.getServletContext().setAttribute("contextScope","莱昂纳多");

        response.sendRedirect(request.getContextPath()+"/myjsp/innerObject/scopeObj.jsp");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
