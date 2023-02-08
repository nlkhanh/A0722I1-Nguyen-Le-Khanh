<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nlk
  Date: 06/02/2023
  Time: 8:19 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Product List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h1 class="row mb-3">Product List</h1>
    <form action="/product" class="form-inline mb-3 justify-content-between">
        <a class="btn btn-primary" href="/product?action=create" role="button">Create new product</a>
        <input type="hidden" name="action" value="search">
        <div class="form-group">
            <input type="text"
                   class="form-control mr-2" name="nameSearch" placeholder="Name">
        <button type="submit" class="btn btn-primary">Tìm kiếm</button>
        </div>
    </form>
    <table class="table text-center">
        <thead>
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Detail</th>
            <th>Manufacturer</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${productList}" var="product">
            <tr>
                <td><a href="/product?action=view&id=${product.id}">${product.name}</a></td>
                <td>${product.price}</td>
                <td>${product.detail}</td>
                <td>${product.manufacturer}</td>
                <td><a class="btn btn-primary" href="/product?action=edit&id=${product.id}" role="button">Edit</a></td>
                <td><a class="btn btn-primary" href="/product?action=delete&id=${product.id}" role="button">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>