<%--
  Created by IntelliJ IDEA.
  User: 90764
  Date: 2018/10/29
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑产品信息</title>
</head>
<body>
<form action="/seller?cmd=save" method="POST">
    <input type="hidden" name="id" value="${product.id}"/>
    产品名称:<input type="text" name="productName" value="${product.productName}"/><br/>
    产品品牌:<input type="text" name="brand" value="${product.brand}"/><br/>
    供 &nbsp;货&nbsp;商:<input type="text" name="supplier" value="${product.supplier}"/><br/>
    货品分类:
    <select name="dir_id">
        <c:forEach items="${dirs}" var="dir">
            <option value="${dir.did}" ${product.dir_id == dir.did?"selected":""}>${dir.dirName}</option>
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
