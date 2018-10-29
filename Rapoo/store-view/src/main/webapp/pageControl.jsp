<%--
  Created by IntelliJ IDEA.
  User: 90764
  Date: 2018/10/28
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 通用的分页代码 -->
<a href="javascript:go(1)">首页</a>
    <a href="javascript:go(${pageResult.prevPage})">上页</a>

    <a href="javascript:go(${pageResult.nextPage})">下页</a>
<a href="javascript:go(${pageResult.totalPage})">末页</a>
&emsp; 当前第${pageResult.currentPage}/${pageResult.totalPage}页
一共${pageResult.totalCount}条数据&emsp; 跳转到
<input type="number" min="1" max="${pageResult.totalPage}"
       id="currentPage" value="${pageResult.currentPage}" name="currentPage"
       style="width: 50px;">
页
<input type="submit" value="GO">
&emsp; 每页
<select name="pageSize" onchange="go(${currentPage});">
    <c:forEach items="${pageResult.pageItems}" var="ps">
        <option ${ps == pageResult.pageSize ? "selected":""}>${ps}</option>
    </c:forEach>
</select>
条数据
