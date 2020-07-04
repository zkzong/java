<%--
  Created by IntelliJ IDEA.
  User: Zong
  Date: 2016/9/28
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.zkzong.chapter1.javabean.UserBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<%
    String submitFlag = request.getParameter("submitFlag");
    if ("login".equals(submitFlag)) {//登录
        //1收集参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2验证并封装参数(重复的步骤)
        UserBean user = new UserBean();
        user.setUsername(username);
        user.setPassword(password);
        //3调用javabean对象（业务方法）
        if (user.login()) {
            //4根据返回值选择下一个页面
            out.write("login success");
        } else {
            out.write("login fail");
        }
    } else {
%>
<form action="" method="post">
    <input type="hidden" name="submitFlag" value="login" />
    username:<input type="text" name="username" /><br>
    password:<input type="password" name="password" /><br>
    <input type="submit" value="login">
</form>
<%
    }
%>
</body>
</html>
