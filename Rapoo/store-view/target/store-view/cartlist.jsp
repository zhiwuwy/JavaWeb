<%--
  Created by IntelliJ IDEA.
  User: 90764
  Date: 2018/10/28
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的购物车</title>
</head>
<body>
    您的购物车:
    <table border="1" width="80%" cellpadding="0" cellspacing="0">
        <tr style="background-color: orange">
            <th>商品名</th>
            <th>商品价格</th>
            <th>商品数量</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${carts}" var="cart" varStatus="vs">
            <tr style="background-color: ${vs.count % 2 == 0 ? "gray" : ""};">
                <td>${cart.cName}</td>
                <td>${cart.cPrice}</td>
                <td>${cart.count}</td>
                <td>
                    <a href="/buyer?cmd=deleteFromCart&cid=${cart.cid}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <h3><a href="buyer">再去逛逛</a></h3>
</body>
</html>
