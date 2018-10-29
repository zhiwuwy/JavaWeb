<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 90764
  Date: 2018/10/27
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品管理</title>
</head>
<body>
    欢迎你管理员:${USER_IN_SESSION.username}&emsp;<a href="/logout">注销</a>
    &emsp;<a href="/seller?cmd=dirlist">查看商品分类</a>
    <script type="text/javascript">
        function go(pageNo) {
            document.getElementById("currentPage").value = pageNo;
            document.forms[0].submit();
        }
    </script>
    <form action="/seller" method="post">
        商品名称:<input type="text" name="productName" value="${pq.productName}">
        价格:<input type="text" name="minSalePrice" value="${pq.minSalePrice}">到
        <input type="text" name="maxSalePrice" value="${pq.maxSalePrice}">
        关键字:<input type="text" name="keyword" value="${pq.keyword}">
        商品分类:
        <select name="dir_id">
            <option value="-1">所有分类</option>
            <c:forEach items="${dirs}" var="dir">
                <option value="${dir.did}" ${pq.dir_id == dir.did ? "selected":""}>${dir.dirName}</option>
            </c:forEach>
        </select>
        <input type="submit" value="查询" style="background-color: orange"><br>
        <a href="/seller?cmd=edit">添加产品</a>
        <table border="1" width="80%" cellpadding="0" cellspacing="0">
            <tr style="background-color: orange">
                <th>商品名称</th>
                <th>品牌</th>
                <th>供货商</th>
                <th>商品分类</th>
                <th>售价</th>
                <th>折扣</th>
                <th>进价</th>
                <th>操作</th>
            </tr>
            <tr>
                <c:forEach items="${pageResult.listData}" var="product" varStatus="vs">
                    <tr style="background-color: ${vs.count % 2 == 0? "gray" : ""};">
                        <td>${product.productName}</td>
                        <td>${product.brand}</td>
                        <td>${product.supplier}</td>
                        <td>
                            <c:choose>
                                <c:when test="${product.dir_id == 1}">有线鼠标</c:when>
                                <c:when test="${product.dir_id == 2}">无线鼠标</c:when>
                                <c:when test="${product.dir_id == 3}">有线键盘</c:when>
                                <c:when test="${product.dir_id == 4}">无线键盘</c:when>
                                <c:when test="${product.dir_id == 5}">有线耳机</c:when>
                                <c:when test="${product.dir_id == 6}">有线耳机</c:when>
                            </c:choose>
                        </td>
                        <td>${product.salePrice}</td>
                        <td>${product.cutoff}</td>
                        <td>${product.costPrice}</td>
                        <td>
                            <a href="/seller?cmd=edit&id=${product.id}">修改</a>
                            <a href="/seller?cmd=delete&id=${product.id}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </tr>
            <tr align="center">
                <td colspan="9">
                    <%@include file="/pageControl.jsp" %>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
