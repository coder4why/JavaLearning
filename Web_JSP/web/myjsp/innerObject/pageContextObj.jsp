
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext对象</title>
</head>
<body>
    <%
        /** 获取其他8大内置对象 */
        pageContext.getRequest();
        pageContext.getResponse();

        pageContext.getServletConfig();
        pageContext.getSession();

        pageContext.getServletContext();
        pageContext.getOut();

        pageContext.getPage();
        pageContext.getException();

    %>

    <!-- pageContext 操作其他作用域 -->
    <%
        /** 当前JSP有效 */
        pageContext.setAttribute("name","jack");

        /** 操作pageContext的作用域 */
        pageContext.setAttribute("aa","1234",PageContext.PAGE_SCOPE); //当前页面有效
        pageContext.setAttribute("bb","abcd",PageContext.REQUEST_SCOPE); //一次请求有效
        pageContext.setAttribute("cc","qwer",PageContext.SESSION_SCOPE); //一次会话有效
        pageContext.setAttribute("dd","poiu",PageContext.APPLICATION_SCOPE);//应用期间有效

        /** 取值方式一、*/
//        String aa = (String) pageContext.getAttribute("aa");
//        String bb = (String) request.getAttribute("bb");
//        String cc = (String) session.getAttribute("cc");
//        String dd = (String) application.getAttribute("dd");

        /** 取值方式二、推荐使用*/
        String aa = (String) pageContext.getAttribute("aa",PageContext.PAGE_SCOPE);
        String bb = (String) pageContext.getAttribute("bb",PageContext.REQUEST_SCOPE);
        String cc = (String) pageContext.getAttribute("cc",PageContext.SESSION_SCOPE);
        String dd = (String) pageContext.getAttribute("dd",PageContext.APPLICATION_SCOPE);

        /** 取值方式三、效率低下*/
        /** findAttribute取值查找流程： pageContext -> request -> session -> application */
        String normal = (String) pageContext.findAttribute("dd");

    %>
    pageContext：<%= aa %>
    <br/>
    request：<%= bb %>
    <br/>
    session：<%= cc %>
    <br/>
    application：<%= dd %>
    <br/>
    findAttribute：<%= normal %>
    <br/>

</body>
</html>
