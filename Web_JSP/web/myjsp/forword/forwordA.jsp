
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<html>
<head>
    <title>JSP转发</title>
</head>
<body>

    <jsp:forward page="forwordB.jsp">
        <jsp:param name="username" value="Pretty Girl"/>
    </jsp:forward>

</body>
</html>
