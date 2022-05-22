<%@ page import="java.util.Date" %>
<%@ page import="bean.UserBean" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="com.mysql.cj.x.protobuf.MysqlxCrud" %>
<%@ page import="cn.study.annotation.E" %>

<%--
  Created by IntelliJ IDEA.
  User: Komorebi
  Date: 2022/5/3
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎</title>
</head>
<body>
    <h1 style="text-align: center">欢迎!</h1>
    <p style="text-align: center"><% java.util.Date now = new Date();
        out.print(now);
    %></p>
    <hr>
    <% UserBean user = new UserBean();%>
    <jsp:useBean id="user2" class="bean.UserBean" scope="page"/>
    <% user.setName("李四");
       user.setPwd("123456");%>
    <jsp:setProperty name="user2" property="name" value="张三"/>
    <jsp:setProperty name="user2" property="pwd" value="10010"/>
<%--    value和param="参数名"不能同时存在--%>
    用户名：<%=user.getName()%>
    密码：<%=user.getPwd()%>
    <hr/>
    用户名：<jsp:getProperty name="user2" property="name"/>
    密码：<jsp:getProperty name="user2" property="pwd"/>
<%--    <%--%>
<%--        Enumeration<String> initParameterNames = config.getInitParameterNames();--%>
<%--        while(initParameterNames.hasMoreElements()){--%>
<%--            out.println(initParameterNames.nextElement());--%>
<%--        }--%>

<%--        out.println();--%>
<%--    %>--%>
</body>
</html>
