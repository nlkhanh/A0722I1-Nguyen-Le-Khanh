<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nlk
  Date: 08/02/2023
  Time: 8:12 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>User Management Application</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5 text-center position-relative">
    <h1 class="mb-4">User Management</h1>
    <h2><a class="btn btn-primary" href="/user?action=create" role="button">Add New User</a></h2>
    <form action="/user" class="form-inline mb-3 justify-content-end position-absolute" style="top: 76px; left: 0;">
        <input type="hidden" name="action" value="search-by-name">
        <div class="form-group">
            <input type="text"
                   class="form-control mr-2" name="searchName" placeholder="Name">
            <button type="submit" class="btn btn-primary">Search</button>
        </div>
    </form>
    <h2 class="position-absolute" style="top: 74px; right: 0;"><a class="btn btn-primary" href="/user?action=sort-by-name" role="button">Sort By Name</a></h2>
    <table class="table">
        <caption style="caption-side: top" class="text-center text-dark"><h2>List of Users</h2></caption>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.country}</td>
                <td><a class="btn btn-primary" href="/user?action=edit&id=${user.id}" role="button">Edit</a></td>
                <td><a class="btn btn-primary" href="/user?action=delete&id=${user.id}" role="button">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="/static/js/jquery-3.6.3.js"></script>
<script src="/static/js/popper.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
</body>
</html>
