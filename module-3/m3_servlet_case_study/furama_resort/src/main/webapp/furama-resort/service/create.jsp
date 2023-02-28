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
            width: 140px;
            margin-right: 12px;
        }

        .form-group > input {
            flex-grow: 2;
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
            <li class="nav-item">
                <a class="nav-link" href="/furama-resort/customer">Customer</a>
            </li>
            <li class="nav-item active">
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
        <h2 class="text-center text-dark mb-3">Add New Service</h2>
        <form action="/furama-resort/service" method="post">
            <input type="hidden" name="action" value="create">
            <div class="form-group form-inline">
                <label for="name">Name: </label>
                <input type="text"
                       class="form-control" name="name" id="name" placeholder="name">
            </div>
            <div class="form-group form-inline">
                <label for="area">Area: </label>
                <input type="text"
                       class="form-control" name="area" id="area" placeholder="area">
            </div>
            <div class="form-group form-inline">
                <label for="cost">Cost: </label>
                <input type="text"
                       class="form-control" name="cost" id="cost" placeholder="cost">
            </div>
            <div class="form-group form-inline">
                <label for="max-people">Max people: </label>
                <input type="text"
                       class="form-control" name="maxPeople" id="max-people" placeholder="max people">
            </div>
            <div class="form-group form-inline">
                <label for="rent-type">Rent type: </label>
                <select class="form-control" name="rentTypeId" id="rent-type">
                    <c:forEach items="${rentTypes}" var="rentType">
                        <option value="${rentType.id}">${rentType.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group form-inline">
                <label for="service-type">Service type: </label>
                <select class="form-control" name="serviceTypeId" id="service-type">
                    <c:forEach items="${serviceTypes}" var="serviceType">
                        <option value="${serviceType.id}">${serviceType.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group form-inline">
                <label for="standard-room">Standard room: </label>
                <input type="text" disabled
                       class="form-control" name="standardRoom" id="standard-room" placeholder="standard room">
            </div>
            <div class="form-group form-inline">
                <label for="other-convenience">other convenience: </label>
                <input type="text" disabled
                       class="form-control" name="otherConvenience" id="other-convenience"
                       placeholder="other convenience">
            </div>
            <div class="form-group form-inline">
                <label for="pool-area">Pool area: </label>
                <input type="text" disabled
                       class="form-control" name="poolArea" id="pool-area" placeholder="pool area">
            </div>
            <div class="form-group form-inline">
                <label for="number-of-floors">Number of floors: </label>
                <input type="text" disabled
                       class="form-control" name="numberOfFloors" id="number-of-floors" placeholder="number of floors">
            </div>
            <div class="form-group form-inline">
                <label for="free-service">Free service: </label>
                <input type="text"
                       class="form-control" name="freeService" id="free-service" placeholder="free service">
            </div>
            <button type="submit" class="float-right btn btn-primary">Add service</button>
        </form>
    </div>
</main>
<footer class="position-fixed w-100" style="z-index: 100; left: 0; bottom: 0">
    <nav class="navbar navbar-dark bg-dark justify-content-center">
        <span class="navbar-text text-light"> A0722I1 - Nguyễn Lê Khánh - Service Page</span>
    </nav>
</footer>

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
    $('#service-type').change(function () {
        if ($('#service-type').val() != 1) {
            $('#free-service').val("");
            $('#free-service').attr('disabled', true);
            $('#standard-room').attr('disabled', false);
            $('#other-convenience').attr('disabled', false);
            $('#number-of-floors').attr('disabled', false);
            if (($('#service-type').val() == 3)) {
                $('#pool-area').attr('disabled', false);
            }
        } else {
            $('#free-service').attr('disabled', false);
            $('#standard-room').val("");
            $('#standard-room').attr('disabled', true);
            $('#other-convenience').val("");
            $('#other-convenience').attr('disabled', true);
            $('#number-of-floors').val("");
            $('#number-of-floors').attr('disabled', true);
            $('#pool-area').val("");
            $('#pool-area').attr('disabled', true);
        }
    })
</script>
</body>
</html>


