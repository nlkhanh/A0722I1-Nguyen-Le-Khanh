<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Furama Resort</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <style>
        .form-group label {
            text-align: left;
            display: inline-block;
            width: 110px;
            margin-right: 12px;
        }

        .form-group > input {
            flex-grow: 2;
        }

        .form-group input[type = "date"] {
            flex-grow: 0;
        }
    </style>
</head>
<body>
<header>
    <nav class="navbar navbar-light bg-light">
        <a class="navbar-brand" href="/">
            <img src="/static/image/logo.png" width="30" height="30" class="d-inline-block align-top"
                 alt="">
            Furama Resort
        </a>
        <span class="navbar-text text-dark"> A0722I1 - Nguyễn Lê Khánh</span>
    </nav>
</header>
<div id="sub-header" class="position-relative mt-1">
    <nav class="navbar navbar-expand-lg navbar-light bg-light justify-content-around">
        <ul class="navbar-nav w-50 d-flex justify-content-around">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/furama-resort/employee">Employee</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/furama-resort/customer">Customer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/furama-resort/service">Service</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/furama-resort/contract">Contract</a>
            </li>
        </ul>
    </nav>
</div>
<main class="d-flex justify-content-center">
    <div id="main-body" class="py-2 px-4 col-11 position-relative bg-light my-2 rounded text-center">
        <h2 class="text-center text-dark mb-3">Edit Customer</h2>
        <form action="/furama-resort/customer" method="post" id="create-form">
            <input type="hidden" name="action" value="edit">
            <input type="hidden" name="id" value="${id}">
            <div class="form-group form-inline">
                <label for="name">Name: </label>
                <input type="text"
                       class="form-control" name="name" id="name" placeholder="name" value="${customer.name}">
            </div>
            <div class="form-group form-inline">
                <label for="birthday">Birthday: </label>
                <input type="date"
                       class="form-control" name="birthday" id="birthday" placeholder="birthday" value="${customer.birthday}">
            </div>
            <div class="form-check form-group form-check-inline text-left w-100">
                <label>Gender: </label>
                <label class="form-check-label">
                    <input class="form-check-input" type="radio" name="gender" id="male-input" value="true"> Nam
                </label>
                <label class="form-check-label">
                    <input class="form-check-input" type="radio" name="gender" id="female-input" value="false"> Nữ
                </label>
            </div>
            <div class="form-group form-inline">
                <label for="id-card">ID Card: </label>
                <input type="text"
                       class="form-control" name="idCard" id="id-card" placeholder="id card" value="${customer.idCard}">
            </div>
            <div class="form-group form-inline">
                <label for="phone">Phone: </label>
                <input type="text"
                       class="form-control" name="phone" id="phone" placeholder="phone" value="${customer.phone}">
            </div>
            <div class="form-group form-inline">
                <label for="email">Email: </label>
                <input type="email"
                       class="form-control" name="email" id="email" placeholder="email" value="${customer.email}">
            </div>
            <div class="form-group form-inline">
                <label for="address">Address: </label>
                <input type="text"
                       class="form-control" name="address" id="address" placeholder="address" value="${customer.address}">
            </div>
            <div class="form-group form-inline">
                <label for="customer-type">Customer type: </label>
                <select class="form-control" name="customerTypeId" id="customer-type">
                    <option id="member-option" value="1">Member</option>
                    <option id="silver-option" value="2">Silver</option>
                    <option id="gold-option" value="3">Gold</option>
                    <option id="platinum-option" value="4">Platinum</option>
                    <option id="diamond-option" value="5">Diamond</option>
                </select>
            </div>
            <button type="submit" class="float-right btn btn-primary" style="margin-top: -34px;">Edit Customer</button>
        </form>
    </div>
</main>
<footer class="position-fixed w-100" style="bottom: 0; left: 0; z-index: 100">
    <nav class="navbar navbar-dark bg-dark justify-content-center">
        <span class="navbar-text text-light"> A0722I1 - Nguyễn Lê Khánh - Customer Page</span>
    </nav>
</footer>
<%--JavaScript--%>
<script src="/static/js/jquery-3.6.3.js"></script>
<script src="/static/js/popper.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script>
    if (${customer.gender}) {
        $('#male-input').attr('checked', true);
    } else {
        $('#female-input').attr('checked', true);
    }
    switch (${customer.customerTypeId}) {
        case 1:
            $('#member-option').attr('selected', true);
            break;
        case 2:
            $('#silver-option').attr('selected', true);
            break;
        case 3:
            $('#gold-option').attr('selected', true);
            break;
        case 4:
            $('#platinum-option').attr('selected', true);
            break;
        case 5:
            $('#diamond-option').attr('selected', true);
            break;
    }
</script>
</body>
</html>