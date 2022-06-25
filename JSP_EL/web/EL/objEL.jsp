<%@ page import="www.el.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL获取对象</title>
</head>
<body>

    <%
        User user = new User("张三丰",130);
        request.setAttribute("who",user);
    %>
    <%
        User user1 = (User) request.getAttribute("who");
        out.println(user1.getName());
        out.println(user1.getAge());
    %>
    <br/>
    ${who}
    <br/>
    ${who.name}
    <br/>
    ${who.age}


</body>
</html>
