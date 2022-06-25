
<!--
jsp:useBean : 动作用来加载一个将在JSP页面中使用的JavaBean；
格式 ：jsp:useBean id= "" class = ""
在类载入后，我们可以通过jsp:setProperty和jsp:getProperty动作来修改和获取bean属性；
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>JSP中使用useBean</title>
</head>
<body>
    <!--- id:对象的名称 class：类的路径(全限定名) -->
    <jsp:useBean id="user" class="www.jsp.entity.User"/>

    <!--  jsp:setProperty 设置id对象的属性值 --->
    <jsp:setProperty name="user" property="name" value="胡先生"/>
    <jsp:setProperty name="user" property="age" value="20"/>

    <!--  jsp:getProperty 获取id对象的属性值，并在客户端打印输出 --->
    <jsp:getProperty name="user" property="name"/>
    <br/>
    <jsp:getProperty name="user" property="age"/>

</body>
</html>
