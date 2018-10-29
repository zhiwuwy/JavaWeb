<%--
  Created by IntelliJ IDEA.
  User: 90764
  Date: 2018/10/27
  Time: 2:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <h2>用户登录</h2>
    <% session.invalidate(); %>
    <form action="/login" method="post">
        账号:<input type="text" name="username"><span style="color: red">${errType}</span><br>
        密码:<input type="password" name="password"><br>
        <input type="radio" name="logintype" value="buyer" checked>用户&emsp;
        <input type="radio" name="logintype" value="seller">管理员<br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
