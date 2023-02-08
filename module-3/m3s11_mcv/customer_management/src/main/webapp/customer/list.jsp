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
    <title>Customer List</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h1 class="row mb-3">Customer List</h1>
    <p class="mb-3 text-right"><a class="btn btn-primary" href="/customer?action=create" role="button">Create new customer</a></p>
    <table class="table text-center">
        <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${customerList}" var="customer">
                <tr>
                    <td><a href="/customer?action=view&id=${customer.id}">${customer.name}</a></td>
                    <td>${customer.email}</td>
                    <td>${customer.address}</td>
                    <td><a class="btn btn-primary" href="/customer?action=edit&id=${customer.id}"  role="button">Edit</a></td>
                    <td><a class="btn btn-primary" href="/customer?action=delete&id=${customer.id}" role="button">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
