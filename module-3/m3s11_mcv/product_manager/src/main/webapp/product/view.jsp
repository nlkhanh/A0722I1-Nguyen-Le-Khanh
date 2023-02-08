<%--
  Created by IntelliJ IDEA.
  User: nlk
  Date: 06/02/2023
  Time: 11:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>View Product</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-2">
    <h1 class="row">View Product</h1>
    <p class="text-right">
        <a class="btn btn-primary" href="/product" role="button">Back to product list</a>
    </p>
    <form action="/product" class="mt-2">
        <fieldset class="border border-dark p-3">
            <legend class="col-form-legend d-inline-block pl-1 pr-1" style="width: auto;">Product Information</legend>
            <div class="form-group">
                <label for="name">Name: </label>
                <input type="text" name="name" id="name" class="form-control" placeholder="Name" value="${product.name}">
            </div>
            <div class="form-group">
                <label for="price">Price: </label>
                <input type="text" name="price" id="price" class="form-control" placeholder="Price" value="${product.price}">
            </div>
            <div class="form-group">
                <label for="detail">Detail: </label>
                <input type="text" name="detail" id="detail" class="form-control" placeholder="Detail" value="${product.detail}">
            </div>
            <div class="form-group">
                <label for="manufacturer">Manufacturer: </label>
                <input type="text" name="manufacturer" id="manufacturer" class="form-control" placeholder="Manufacturer" value="${product.manufacturer}">
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>
