<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<h3>Product Management</h3>
<p><a href="/product/create">Add new product</a></p>
<table id="product">
    <thead>
        <tr>
            <td>Name</td>
            <td>Description</td>
            <td>Image</td>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td><img width="100" height="100" src="/files/${product.image}" alt=""></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
