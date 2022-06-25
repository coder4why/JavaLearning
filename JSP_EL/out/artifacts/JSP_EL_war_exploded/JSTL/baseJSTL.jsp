<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="www.el.entity.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="m" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL的基本使用</title>
</head>
<body>

    <%
        request.setAttribute("name","长白山");
        request.setAttribute("age",180);

        List<String> list = new ArrayList<>();
        list.add("Alibaba");
        list.add("Tencent");
        list.add("Sina");
        list.add("Baidu");
        list.add("HuaWei");
        list.add("360");
        request.setAttribute("company",list);

        List<User> users = new ArrayList<>();
        User user = new User("张曼玉",14);
        User user1 = new User("罗志祥",20);
        users.add(user);
        users.add(user1);
        request.setAttribute("users",users);

    %>

    一、使用if条件判断：<br/>
    <m:if test="${name eq '长白山'}">
        欢迎你，${name}
    </m:if>
    <br/>
    <m:if test="${name ne '上海市'}">
        请重新登录！
    </m:if>
    <br/>
    <br/>
    二、多条件choose判断：<br/>
    <m:choose>
        <m:when test="${age < 18}">少年</m:when>
        <m:when test="${age >= 18 and age <30}">青年</m:when>
        <m:when test="${age>=30 && age<50}">壮年</m:when>
        <m:when test="${age>=50 && age<120}">老年</m:when>
        <m:otherwise>外星人</m:otherwise>
    </m:choose>
    <br/>
    <br/>
    三、使用foreach迭代标签：<br/>
    <m:forEach var="item" items="${company}" begin="0" end="${company.size()}" step="1" varStatus="is">
        <!--
            varStatus的属性：
                current：当前item的值；
                index：当前item的索引；
                first：当前item是否是第一个元素；
                last：当前item是否是最后一个元素；
        -->
        ${item}&nbsp;&nbsp;${is.current}&nbsp;&nbsp;${is.index}&nbsp;&nbsp;${is.first}&nbsp;&nbsp;${is.last}
        <br/>
    </m:forEach>

    <br/>
    <m:forEach var="item" items="${users}">
        ${item.name}:${item.age}
        <br/>
    </m:forEach>

</body>
</html>
