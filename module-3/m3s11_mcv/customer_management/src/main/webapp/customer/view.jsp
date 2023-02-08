<%--
  Created by IntelliJ IDEA.
  User: nlk
  Date: 05/02/2023
  Time: 9:22 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer View</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-2">
    <h1 class="row">Customer Details</h1>
    <p class="text-right">
        <a class="btn btn-primary" href="/customer" role="button">Back to customer list</a>
    </p>
    <form action="/customer" method="post" class="mt-2">
        <fieldset class="border border-dark p-3">
            <legend class="col-form-legend d-inline-block pl-1 pr-1" style="width: auto;">Customer Information</legend>
            <div class="form-group">
                <label for="name">Name: </label>
                <input type="text" name="name" id="name" class="form-control" placeholder="Name" value="${customer.name}">
            </div>
            <div class="form-group">
                <label for="email">Email: </label>
                <input type="email" name="email" id="email" class="form-control" placeholder="Email" value="${customer.email}">
            </div>
            <div class="form-group">
                <label for="address">Name: </label>
                <input type="text" name="address" id="address" class="form-control" placeholder="Address" value="${customer.address}">
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>
