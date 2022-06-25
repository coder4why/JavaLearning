
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL(表达式语言)</title>
</head>
<body>

    <%
        request.setAttribute("aa","1234");
        session.setAttribute("bb","abcd");
        application.setAttribute("cc","poiu");
        pageContext.setAttribute("dd","wsxz");

    %>
    一、通过作用域对象获取值
    <h3>
        <!--- 通过作用域对象获取值 -->
        <%= request.getAttribute("aa") %>
        <br/>
        <%= session.getAttribute("bb") %>
        <br/>
        <%= application.getAttribute("cc") %>
        <br/>
        <%= pageContext.getAttribute("dd") %>
        <br/>
    </h3>

    二、通过EL表达式获取值方式1:
    <h3>
        <!--- 通过EL表达式获取值 -->
        ${requestScope.aa}
        <br/>
        ${sessionScope.bb}
        <br/>
        ${applicationScope.cc}
        <br/>
        ${pageScope.dd}
        <br/>
    </h3>

    三、通过EL表达式获取值方式2:(效率低)
        (逐级查找 pageContext -> request -> session -> application )
    <h3>
        <!--- 通过EL表达式获取值 ：类似如pageContext.findAttribute(name) -->
        ${aa}
        <br/>
        ${bb}
        <br/>
        ${cc}
        <br/>
        ${dd}
        <br/>
    </h3>

    四、EL表达式与作用域对象查找的区别：
        EL表达式没找到返回为""；
        作用域对象没找到为null;
    <h3>

        作用域：<%= request.getAttribute("shanghai") %>
        <br/>
        EL：${requestScope.shanghai}
    </h3>

</body>
</html>
