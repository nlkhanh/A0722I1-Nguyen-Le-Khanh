<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Create New Customer</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-2">
    <h1 class="row">Create New Customer</h1>
    <p>
        <c:if test="${message != null}">
            <span class="text-success">${message}</span>
        </c:if>
    </p>
    <p class="text-right">
        <a class="btn btn-primary" href="/customer" role="button">Back to customer list</a>
    </p>
    <form action="/customer" method="post" class="mt-2">
        <input type="hidden" name="action" value="create">
        <fieldset class="border border-dark p-3">
            <legend class="col-form-legend d-inline-block pl-1 pr-1" style="width: auto;">Customer Information</legend>
            <div class="form-group">
                <label for="name">Name: </label>
                <input type="text" name="name" id="name" class="form-control" placeholder="Name">
            </div>
            <div class="form-group">
                <label for="email">Email: </label>
                <input type="email" name="email" id="email" class="form-control" placeholder="Email">
            </div>
            <div class="form-group">
                <label for="address">Address: </label>
                <input type="text" name="address" id="address" class="form-control" placeholder="Address">
            </div>
            <button type="submit" class="btn btn-primary float-right">Create customer</button>
        </fieldset>
    </form>
</div>
</body>
</html>
