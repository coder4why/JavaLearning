package www.mvc.controller.servlet.server;

import www.mvc.model.entity.University;
import www.mvc.model.service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UniPage",value = "/pageQuery")
public class UniPage extends HttpServlet {

    private static ServiceImpl serviceIMP = new ServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String pageSize = request.getParameter("page");
            String count = request.getParameter("count");
            List<University> universities = serviceIMP.select(Integer.valueOf(pageSize),Integer.valueOf(count));
            request.setAttribute("universities",universities);
            request.getRequestDispatcher("/view/pageQuery.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
