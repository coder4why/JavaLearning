<%--

  JSP内置对象：
      由JSP自动创建的对象，可以直接使用；
      JSP九大内置对象：
        request :       javax.servlet.http.HttpServletRequest;
        response :      javax.servlet.http.HttpServletResponse;
        session :       javax.servlet.http.HttpSession;
        application :   javax.servlet.ServletContext;
        config  :       javax.servlet.ServletConfig;
        exception :     java.lang.Throwable
        out :           java.servlet.jsp.JspWriter
        pageContext :   java.servlet.jsp.PageContext
        page    :       java.lang.Object当前对象 （当前servlet对象）

--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="false" %>
<html>
<head>
    <title>JSP九大内置对象</title>
</head>
<body>

    <%
        request.setAttribute("username","Given");
    %>

    <%=
       request.getAttribute("username")
    %>

</body>
</html>
