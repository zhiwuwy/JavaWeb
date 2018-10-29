<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 90764
  Date: 2018/10/29
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>商品分类</title>
</head>
<body>
    <table border="1" width="50%" cellspacing="0" cellpadding="0">
        <tr>
            <th>分类编号</th>
            <th>种类名</th>
            <th>属类编号</th>
        </tr>
        <c:forEach items="${dirs}" var="dir">
            <tr>
                <td>${dir.did}</td>
                <td>${dir.dirName}</td>
                <td>${dir.parent_id}</td>
            </tr>
        </c:forEach>
    </table>
    <h5><a href="/seller">返回商品品列表</a></h5>
</body>
</html>
