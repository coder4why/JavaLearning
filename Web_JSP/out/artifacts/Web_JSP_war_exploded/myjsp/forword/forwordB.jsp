
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<html>
<meta charset="UTF-8" content="text/html;charset=UTF-8">
<head>
    <title>JSP转发-接收</title>
</head>
<body>

<%
    String name = request.getParameter("username");
%>
<%= name %>

</body>
</html>
