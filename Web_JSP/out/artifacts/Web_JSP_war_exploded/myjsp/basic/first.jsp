

<%--
    JSP指令：
        page... : 定义页面的依赖属性，比如脚本语言，error页面，缓存需求等等；
        include... : 包含其他文件；
        taglib... : 引入标签库的定义，可以是自定义标签；

    page指令的常用属性：
        contentType : 指定当前JSP页面的MIME类型和字符编码格式；
        errorPage : 指定当前程序发生异常时需要转向的错误处理页面；
        isErrorPage : 指定当前页面是否可以作为另一个JSP页面的错误处理页面；
        import : 导入要使用的java类；
        language : 定义JSP页面所用的脚本语言，默认Java；
        session : 指定JSP页面是否使用session，默认true立即创建，false为使用时创建；
        pageEncoding : 指定JSP页面的解码格式；

    include指令：
            语法：<%@ include file="被包含的JSP文件路径" %>
            通过 include指令来包含其他文件；
            被包含的文件可以是JSP文件，HTML文件或文本文件，包含的文件就好像是当前JSP文件的一部分，
        会被同时编译执行（静态包含）；

        可能会有重名的冲突问题，不建议使用；

    taglib指令：引入JSP的标准标签库
        语法：<%@ taglib prefix="c" uri="https://java.sun.com/jsp/jstl/core" %>

    动作标签：
        <jsp:动作 名称 属性="value" />
        动作：
            include:动作属性会将外部文件输出结果包含在JSP中（动态包含）;
            如 ： <jsp:include page="index.html" />
         (注意：
            include指令与include动作的区别：
               include指令是将外部文件的输出代码复制到当前的JSP文件中，
               而jsp:include动作是将外部文件的输出结果引入到了当前的JSP文件中；
          )

--%>

<%--<%@ taglib prefix="c" uri="https://java.sun.com/jsp/jstl/core" %>--%>

<jsp:include page="Main.jsp" />
<jsp:include page="index.jsp" />
<jsp:include page="indexOf" />

<%--    <%@ include file="Main.jsp" %>  --%>
<%--    <%@ include file="indexOf" %>   --%>

<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" errorPage="error.jsp" %>
<%--
    JSP的访问：在浏览器输入http://ip:port/项目路径/资源名称
--%>
<%--
    JSP与Servlet：
        关系：
            1.JSP文件在容器中会转换成Servlet执行；
            2.JSP是对Servlet的一种高级封装，本质还是Servlet；
        区别：
            1.与Servlet相比：JSP可以很方便的编写或者修改HTML网页而不用去面对大量的println语句；
 --%>
<%--
    JSP实现原理：
          Tomcat会将jsp文件转化成Java代码，进而编译成.class文件运行，
        最终将运行结果通过response响应给客户端；
--%>

<html>
<head>
    <title>JSP测试</title>
    <style>
        *{
            text-align: center;
            color: teal;
            font-family: "Apple Symbols";
            font-size: 25px;
            font-weight: normal;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<%-- <%=%> : 为输出脚本 --%>
<h1>
    <!-- 抛出异常测试，跳转到error.jsp异常页面 -->
<%--    <%=10/0%>--%>

    <%!
        /** %! : 1.声明脚本: 声明的变量都是全局变量 */
        /**
         * 1.脚本与脚本之间不可嵌套
         * 2.脚本与HTML之间不可嵌套；
         */
        int a = 10086;
        public void play() {
            System.out.println("playing...");
        }
        public String doWhat(){
            return "上海陆家嘴";
        }
    %>
</h1>

<h3>
    <%
        /** % : 2.普通脚本：普通脚本可以使用所有Java愈发，除了定义函数 */
        out.print(a);
        play();
    %>
</h3>

<h3>
    <%=
        /** %= : 3.输出脚本 */
        "上海中心"+"大厦"
    %>
    <Br/>
    <%= doWhat() %>
</h3>

<h4>
    <%
        /** 打印在控制台*/
        //System.out.println();
        DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        for (int i = 0; i < 5; i++) {
            Date date = new java.util.Date();
            String time = dateFormat.format(date);
            /** 打印在客户端页面 */
            out.println(time);
            out.println("<Br/>");
        }
    %>
</h4>
</body>
</html>

<jsp:include page="index.html" />