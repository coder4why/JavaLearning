package www.servlet.com.Servlet学习;

/** 导入必须的Java库 **/
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * ServLet:Server Applet的简称；是服务器端的程序（代码、功能实现）;
 *         可交互式的处理客户端发送到服务端的请求，并完成操作响应；
 *
 * ServLet的作用：
 *      1.接口客户端请求 ，完成操作；
 *      2.动态生产网页（页面数据可变）；
 *      3.将包含操作结果的动态网页响应给客户端；
 */
/**
 * ServLet开发步骤：
 *      1.将ServLet相关的jar包（lib/servlet-api.jar）配置到classpath中；
 *      2.编写ServLet：
 *          a.实现javax.servlet.Servlet;
 *          b.重写5个主要方法；
 *          c.在核心的service()方法中编写输出语句，打印访问结果；
 */
public class ServLetTest implements Servlet{

    public static void main(String[] args) {

        System.out.println("ServLet测试文件");

    }

    /** 需要实现ServLet接口：**/
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
