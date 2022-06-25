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

/** 查询数据库所有大学*/
@WebServlet(name = "UniAll",value = "/universities")
public class UniAll extends HttpServlet {
    private static ServiceImpl serviceIMP = new ServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<University> universities = serviceIMP.selectAll();
        request.setAttribute("universities",universities);

        request.getRequestDispatcher("/view/selectAll.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
