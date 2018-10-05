<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	产品清单:
	<br />
	<a href="${pageContext.request.contextPath}/product?cmd=edit">添加产品</a>
	<table border="1" width="80%" cellpadding="0" cellspacing="0">
		<tr style="background-color: orange;">
			<th>货品编号</th>
			<th>产品名称</th>
			<th>产品品牌</th>
			<th>供&nbsp;货&nbsp;商</th>
			<th>货品分类</th>
			<th>零&nbsp;售&nbsp;价</th>
			<th>成&nbsp;本&nbsp;价</th>
			<th>折&emsp;&emsp;扣</th>
			<th>操&emsp;&emsp;作</th>
			
		</tr>
		<c:forEach items="${products}" var="product" varStatus="vs">
			<tr style="background-color: ${vs.count % 2 == 0 ? "gray":""}">
				<td>${product.id}</td>
				<td>${product.productName}</td>
				<td>${product.brand}</td>
				<td>${product.supplier}</td>
				<td>${product.dir_id}</td>
				<td>${product.salePrice}</td>
				<td>${product.costPrice}</td>
				<td>${product.cutoff}</td>
				<td>
					<a href="${pageContext.request.contextPath}/product?cmd=delete&&id=${product.id}">删除</a> |
					<a href="${pageContext.request.contextPath}/product?cmd=edit&id=${product.id}">编辑</a>
				</td> 
				
			</tr>

		</c:forEach>
	</table>
</body>
</html>