
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL内置对象</title>
</head>
<body>
获取应用上下文：<br/>
<%=request.getContextPath()%> <br/>
${pageContext.request.contextPath} <br/>
    <a href="${pageContext.request.contextPath}/cookie">Click Me</a>
</body>
</html>
