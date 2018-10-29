<%--
  Created by IntelliJ IDEA.
  User: 90764
  Date: 2018/10/27
  Time: 2:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>雷柏网店</title>
</head>
<body>
    <script type="text/javascript">
        function go(pageNo) {
            document.getElementById("currentPage").value = pageNo;
            document.forms[0].submit();
        }
    </script>
    欢迎你买家${USER_IN_SESSION.username}&emsp;
    <a href="/logout">注销</a>
    <a href="/buyer?cmd=cartList">购物车</a>
    <form id="form1" action="/buyer" method="post">
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
        <input type="submit" value="查询" style="background-color: orange">
        <table border="1" width="80%" cellpadding="0" cellspacing="0">
            <tr style="background-color: orange;">
                <th>商&nbsp;品&nbsp;名</th>
                <th>商品品牌</th>
                <th>商品分类</th>
                <th>商品价格</th>
                <th>操&emsp;作</th>

            </tr>
            <c:forEach items="${pageResult.listData}" var="commodity" varStatus="vs">
                <tr style="background-color: ${vs.count % 2 == 0 ? "gray":""};">
                    <td>${commodity.productName}</td>
                    <td>${commodity.brand}</td>
                    <td>
                        <c:choose>
                            <c:when test="${commodity.dir_id == 1}">有线鼠标</c:when>
                            <c:when test="${commodity.dir_id == 2}">无线鼠标</c:when>
                            <c:when test="${commodity.dir_id == 3}">有线键盘</c:when>
                            <c:when test="${commodity.dir_id == 4}">无线键盘</c:when>
                            <c:when test="${commodity.dir_id == 5}">有线耳机</c:when>
                            <c:when test="${commodity.dir_id == 6}">无线耳机</c:when>
                        </c:choose>
                    </td>
                    <td>${commodity.salePrice}</td>
                    <td style="background-color: darksalmon">
                        <input type="number" name="count"  min="1" max="5">
                        <a href="javascript:add(${commodity.id});">添加到购物车</a>
                    </td>
                </tr>
            </c:forEach>
            <tr align="center">
                <td colspan="5">
                    <%@include file="/pageControl.jsp" %>
                </td>
            </tr>
        </table>
    </form>
    <script>
        function add(flag) {
            var form1 = document.getElementById('form1');
            form1.action = "/buyer?cmd=add2Cart&id="+flag;
            form1.submit();
        }
    </script>
</body>
</html>
