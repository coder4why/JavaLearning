
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="m"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL-url标签</title>
</head>
<body>

    一、URL标签：<br/>
    在cookie禁用的情况下，通过重写URL拼接JSESSIONID来传递ID值，
    便于下一次访问时仍可查找到上一次的session对象；
    <br/>
    <br/>
    <a href="${pageContext.request.contextPath}/cookie">Click Me</a>
    <br/>
    <br/>
    <a href="<m:url context='${pageContext.request.contextPath}' value='/cookie'></m:url>">Click URL</a>

</body>
</html>
