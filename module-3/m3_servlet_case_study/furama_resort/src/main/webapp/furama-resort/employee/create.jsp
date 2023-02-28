<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Furama Resort</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        .form-group label {
            text-align: left;
            display: inline-block;
            width: 130px;
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
            <li class="nav-item active">
                <a class="nav-link" href="/furama-resort/employee">Employee</a>
            </li>
            <li class="nav-item">
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
<main class="d-flex justify-content-center" style="margin-bottom: 56px;">
    <div id="main-body" class="py-2 px-4 col-8 position-relative bg-light my-2 rounded text-center">
        <h2 class="text-center text-dark mb-3">Add New Employee</h2>
        <form action="/furama-resort/employee" method="post" id="create-form">
            <input type="hidden" name="action" value="create">
            <div class="form-group form-inline">
                <label for="name">Name: </label>
                <input type="text"
                       class="form-control" name="name" id="name" placeholder="name" value="${name}">
            </div>
            <div class="form-group form-inline">
                <label for="birthday">Birthday: </label>
                <input type="text"
                       class="form-control" name="birthday" id="birthday" placeholder="birthday"
                       value="${birthday}">
            </div>
            <div class="form-check form-group form-check-inline text-left w-100">
                <label>Gender: </label>
                <label class="form-check-label">
                    <input class="form-check-input" checked type="radio" name="gender" id="male" value="true"> Nam
                </label>
                <label class="form-check-label">
                    <input class="form-check-input" type="radio" name="gender" id="female" value="false"> Nữ
                </label>
            </div>
            <div class="form-group form-inline">
                <label for="id-card">ID Card: </label>
                <input type="text"
                       class="form-control" name="idCard" id="id-card" placeholder="id card" value="${idCard}">
            </div>
            <div class="form-group form-inline">
                <label for="salary">Salary: </label>
                <input type="text"
                       class="form-control" name="salary" id="salary" placeholder="salary" value="${salary}">
            </div>
            <div class="form-group form-inline">
                <label for="phone">Phone: </label>
                <input type="text"
                       class="form-control" name="phone" id="phone" placeholder="phone" value="${phone}">
            </div>
            <div class="form-group form-inline">
                <label for="email">Email: </label>
                <input type="email"
                       class="form-control" name="email" id="email" placeholder="email" value="${email}">
            </div>
            <div class="form-group form-inline">
                <label for="address">Address: </label>
                <input type="text"
                       class="form-control" name="address" id="address" placeholder="address"
                       value="${address}">
            </div>
            <div class="form-group form-inline">
                <label for="positionId">Position: </label>
                <select class="form-control" name="positionId" id="positionId">
                    <c:forEach items="${positions}" var="position">
                        <option value="${position.id}" id="positionId-${position.id}">${position.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group form-inline">
                <label for="educationDegreeId">Education degree: </label>
                <select class="form-control" name="educationDegreeId" id="educationDegreeId">
                    <c:forEach items="${educationDegrees}" var="educationDegree">
                        <option value="${educationDegree.id}"
                                id="educationDegreeId-${educationDegree.id}">${educationDegree.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class=" form-group form-inline
                    ">
                <label for="divisionId">Division: </label>
                <select class="form-control" name="divisionId" id="divisionId">
                    <c:forEach items="${divisions}" var="division">
                        <option value="${division.id}" id="divisionId-${division.id}">${division.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group form-inline">
                <label for="username">Username: </label>
                <input type="text"
                       class="form-control" name="username" id="username" placeholder="username"
                       value="${username}">
            </div>
            <div class="form-group form-inline">
                <label for="password">Password: </label>
                <input type="password"
                       class="form-control" name="password" id="password" placeholder="password">
            </div>
            <button type="submit" class="float-right btn btn-primary">Add employee</button>
        </form>
    </div>
</main>
<footer class="position-fixed w-100" style="z-index: 4; left: 0; bottom: 0">
    <nav class="navbar navbar-dark bg-dark justify-content-center">
        <span class="navbar-text text-light"> A0722I1 - Nguyễn Lê Khánh - Employee Page</span>
    </nav>
</footer>

<%--Toast--%>
<div class="position-fixed bottom-0 right-0 p-3" style="z-index: 5; right: 0; bottom: 20px;">
    <div class="toast" id="liveToast" role="alert" aria-live="assertive" aria-atomic="true" data-delay="2000">
        <div class="toast-header">
            <strong class="mr-2">Notification</strong>
            <small>1 sec ago</small>
            <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="toast-body">
            ${message}
        </div>
    </div>
</div>

<%--JavaScript--%>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script>
    if (${gender}) {
        $('#male-input').attr('checked', true);
    } else {
        $('#female-input').attr('checked', true);
    }
    $('#positionId-${positionId}').attr('selected', true);
    $('#educationDegreeId-${educationDegreeId}').attr('selected', true);
    $('#divisionId-${divisionId}').attr('selected', true);

    if (${message != null}) {
        $('.toast').toast('show');
    }
</script>
</body>
</html>


