
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP四大域对象</title>
    <!--
        JSP四大域对象:
            pageContext ：当前JSP页面有效；
            request ：一次请求有效
            session ：一次会话有效（关闭浏览器失效）
            application ：整个Web应用有效（服务器重启或者关闭失效）
    -->
</head>
<body>

    <%
        /** 1.pageContext对象 ： 当前JSP页面有效 */
        pageContext.setAttribute("pageID","10010");
        String a = (String) pageContext.getAttribute("pageID");

        /** 2.request对象 ：一次请求有效 */
        String b = (String) request.getAttribute("requestScope");

        /** 3.session对象 ：一次会话有效 */
        String c = (String) session.getAttribute("sessionContent");

        /** 4.application对象 ： 整个应用期间有效（服务器重启或者关闭失效）*/
        String d = (String) application.getAttribute("contextScope");

    %>

    pageContext：<%= a %>
    <br/>
    request：<%= b %>
    <br/>
    session：<%= c %>
    <br/>
    application：<%= d %>
    <br/>

</body>
</html>
