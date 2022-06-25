
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL运算符</title>
    <style>
        *{
            font-weight: bolder;
            font-size: 18px;
        }
        h4{
            font-weight: normal;
            font-size: large;
        }
    </style>
</head>
<body>
    <%
        request.setAttribute("age",10086);
    %>

    一、使用常规运算符：<br/>
    <h4>
        ${requestScope.age+5} <br/>
        ${requestScope.age-5} <br/>
        ${requestScope.age*5} <br/>
        ${requestScope.age/5} <br/>
        ${requestScope.age%5} <br/>

    </h4>
    二、使用EL运算符：<br/>
    <h4>
        EL除(div)： ${requestScope.age div 5} <br/>
        EL取模(mod)：${requestScope.age mod 5} <br/>

        EL相等(== or eq)：${requestScope.age eq 1000} <br/>
        EL不等(!= or ne)：${requestScope.age ne 1000} <br/>

        EL小于(< or lt)：${requestScope.age lt 1000} <br/>
        EL大于(> or gt)：${requestScope.age gt 1000} <br/>

        EL小于等于(<= or le)：${requestScope.age le 1000} <br/>
        EL大于等于(>= or ge)：${requestScope.age ge 1000} <br/>

        EL逻辑与(&& or and)：${requestScope.age gt 100 and requestScope.age lt 100000} <br/>
        EL逻辑或(|| or or)：${requestScope.age lt 100 or false} <br/>
        EL逻辑非(! or not)：${not false} <br/>

        EL空值判断(empty)：${empty 10} <br/>
    </h4>

</body>
</html>
