
<%@ taglib prefix="m" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询所有大学</title>
</head>
<body>

    <a href="<m:url context='${pageContext.request.contextPath}' value='/universities'></m:url>">
        查询所有大学信息
    </a>
    <br/>
    <br/>
    <m:forEach var="item" items="${universities}">
       ${item.name}&nbsp;&nbsp;${item.address}&nbsp;&nbsp;
        ${item.level}&nbsp;&nbsp;
        ${item.studentsCount}&nbsp;&nbsp;
        ${item.teachersCount}&nbsp;&nbsp;
        <br/>
        <br/>
    </m:forEach>

</body>
</html>
