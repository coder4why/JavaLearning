<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL数组、集合的访问</title>
</head>
<body>

<%
    int[] numbers = {1, 2, 3, 4, 5, 6};
    List<String> lists = new ArrayList<>();
    lists.add("中国");
    lists.add("美国");

    Map<String, String> map = new HashMap<>();
    map.put("US", "American");
    map.put("CN", "China");

    request.setAttribute("numbers", numbers);
    request.setAttribute("lists", lists);
    request.setAttribute("map", map);

%>

    1.下标索引获取值：${numbers[1]} <br/>
    2.get(index)获取值：${lists.get(1)} <br/>
    3.键取值：${map["US"]} <br/>
    4.点语法取值：${map.CN} <br/>

</body>
</html>
