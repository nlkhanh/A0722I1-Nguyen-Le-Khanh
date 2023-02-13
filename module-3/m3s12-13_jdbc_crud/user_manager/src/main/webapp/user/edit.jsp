<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nlk
  Date: 08/02/2023
  Time: 11:07 SA
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
<div class="container mt-5">
  <h1 class="mb-4 text-center">User Editing</h1>
  <h2 class="mb-4 text-center"><a class="btn btn-primary" href="/user" role="button">List All User</a></h2>
  <form action="/user" method="post">
    <input type="hidden" name="action" value="edit">
    <input type="hidden" name="id" value="${user.id}">
    <fieldset class="border border-dark p-3">
      <legend class="col-form-legend d-inline-block pl-1 pr-1" style="width: auto;">User Information</legend>
      <div class="form-group">
        <label for="name">Name: </label>
        <input type="text" name="name" id="name" class="form-control" placeholder="Name" value="${user.name}">
      </div>
      <div class="form-group">
        <label for="email">Email: </label>
        <input type="email" name="email" id="email" class="form-control" placeholder="Email" value="${user.email}">
      </div>
      <div class="form-group">
        <label for="country">Country: </label>
        <input type="text" name="country" id="country" class="form-control" placeholder="Country" value="${user.country}">
      </div>
      <button type="submit" class="btn btn-primary float-right">Edit</button>
    </fieldset>
  </form>
  <p>
    <c:if test="${message != null}">
      <span class="text-success">${message}</span>
    </c:if>
  </p>
</div>
<script src="/static/js/jquery-3.6.3.js"></script>
<script src="/static/js/popper.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
</body>
</html>
