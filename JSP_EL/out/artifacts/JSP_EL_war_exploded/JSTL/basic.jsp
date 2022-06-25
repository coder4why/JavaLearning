
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>什么是JSTL</title>
</head>
一、EL的问题：<br/>
    1.EL主要是用于作用域获取数据，虽然可以做运算判断，但是得到的都是一个结果，做展示；<br/>
    2.EL不存在流程控制，比如判断；<br/>
    3.EL对于集合只能做单点访问，不能实现遍历操作，不如循环；<br/>
<body>
<br/>
二、测试：<br/>
<%
    int[] a = {1,2,3,4,5,6};
    for (int num:a
         ) {
        out.println(num);
        out.println("\n");
    }
%>
<br/>
<br/>
三、什么是JSTL：<br/>
 1.JSTL全称是Java Server Pages Standard Tag Library；<br/>
 2.JSTL标准标签库（JSTL）：是一个JSP标签集合；<br/>
<br/>
四、JSTL的作用：<br/>
1.可对EL获取到的数据进行逻辑操作；<br/>
2.与EL合作完成数据的展示；<br/>
<br/>





</body>
</html>
