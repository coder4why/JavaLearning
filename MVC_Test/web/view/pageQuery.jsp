<%@ taglib prefix="m" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>分页查询学校</title>
</head>
<body>

<%--<%!--%>
<%--    Integer pageSize = 0;--%>
<%--%>--%>

<%--<a href="<m:url context='${pageContext.request.contextPath}' value='/pageQuery'>--%>
<%--    <m:param name='page' value='<%=pageSize%>'></m:param>--%>
<%--    <m:param name='count' value='${count}'></m:param>--%>
<%--</m:url>">--%>
<%--    下一页--%>
<%--</a>--%>
<%--&nbsp;&nbsp;--%>
<%--<a href="<m:url context='${pageContext.request.contextPath}' value='/pageQuery'>--%>
<%--    <m:param name='page' value='<%=pageSize%>'></m:param>--%>
<%--    <m:param name='count' value='${count}'></m:param>--%>
<%--</m:url>">--%>
<%--    上一页--%>
<%--</a>--%>

<br/>
<br/>

<m:forEach var="item" items="${universities}" varStatus="is">

    ${is.index+1}&nbsp;${item.name}&nbsp;&nbsp;${item.address}&nbsp;&nbsp;${item.level}
    &nbsp;&nbsp;${item.studentsCount}&nbsp;&nbsp;${item.teachersCount}
    <br/>
    <br/>

</m:forEach>

</body>
</html>
