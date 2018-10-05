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
	<form action="${pageContext.request.contextPath}/product?cmd=save" method="POST">
		<input type="hidden" name="id" value="${product.id}"/>
		产品名称:<input type="text" name="productName" value="${product.productName}"/><br/>
		产品品牌:<input type="text" name="brand" value="${product.brand}"/><br/>
		供 &nbsp;货&nbsp;商:<input type="text" name="supplier" value="${product.supplier}"/><br/>
		货品分类:
		<select name="dir_id">
			<c:forEach items="${dirs}" var="dir">
				<option value="${dir.id}" ${product.dir_id == dir.id?"selected":""}>${dir.dirName}</option>
			</c:forEach>
		</select>
		<br/>
		零&nbsp;售&nbsp;价:<input type="text" name="salePrice" value="${product.salePrice}"/><br/>
		成&nbsp;本&nbsp;价:<input type="text" name="costPrice" value="${product.costPrice}"/><br/>
		折&emsp;&emsp; 扣:<input type="text" name="cutoff" value="${product.cutoff}"/><br/>
		<input type="submit" value="${product == null ? "添加产品" : "更新产品信息"}"/>
	</form>
</body>
</html>