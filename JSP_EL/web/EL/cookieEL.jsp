
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL内置对象-Cookie</title>
</head>
<body>

    <a href="${pageContext.request.contextPath}/cookie">Click Me</a>
    <br/>
    一、使用老办法获取Cookie <br/>
    <%
        Cookie[] cookies = request.getCookies();
        String username = "";
        String password = "";
        for (Cookie cookie :
                cookies) {
            if (cookie.getName().equals("username")){
                username = cookie.getValue();
            }
            if (cookie.getName().equals("password")){
                password = cookie.getValue();
            }
        }
    %>

    <%= username %> <br/>
    <%= password %> <br/>

    二、使用EL表达式获取cookie <br/>
    ${cookie.username.value} <br/>
    ${cookie.password.value} <br/>

</body>
</html>
