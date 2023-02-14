<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Furama Resort</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
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
<div id="sub-header" class="mt-1">
    <nav class="navbar navbar-expand-lg navbar-light bg-light justify-content-between">
        <a class="navbar-brand w-25 d-flex justify-content-center" href="/furama-resort?action=customer-list">
            Customer
        </a>
        <form class="form-inline my-2 my-lg-0 w-75 pr-4 justify-content-end" action="/furama-resort/customer"
              method="get">
            <input type="hidden" name="action" value="search">
            <input class="form-control mr-sm-2" type="search" name="search" placeholder="Customer's name..."
                   aria-label="Search">
            <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button>
        </form>
    </nav>
</div>
<main class="d-flex mt-2" style="height: 100vh">
    <div id="side-bar" class="w-25 pr-4">
        <div class="list-group list-group-flush">
            <a href="#" class="list-group-item list-group-item-action">Add New Customer</a>
            <a href="/" class="list-group-item list-group-item-action">Back to Home</a>
        </div>
    </div>
    <div id="main-body" class="w-75 p-2 pr-4">
        <div id="content" class="h-100 bg-light rounded pl-3 pr-3 pt-2 pb-2">
            <table class="table">
                <caption style="caption-side: top" class="text-center text-dark"><h2>List of Customers</h2></caption>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Birthday</th>
                    <th>Gender</th>
                    <th>Identify Card</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Type</th>
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
                        <td><a class="btn btn-primary" href="/user?action=edit&id=${user.id}" role="button">Edit</a>
                        </td>
                        <td>
                            <button type="button" class="btn btn-primary"
                                    id="btn-delete-next"
                                    data-toggle="modal" data-target="#staticBackdrop_delete-confirm"
                                    data-whatever="(${user.id}, ${user.name}, ${user.email}, ${user.email}, ${user.country})"
                                    data-id="${user.id}">
                                Delete
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <nav aria-label="pagination">
                <c:choose>
                    <c:when test="${searchCountry == null && sort == null}">
                        <c:set scope="request" var="paginationParam" value=""/>
                    </c:when>
                    <c:when test="${searchCountry != null && sort == null}">
                        <c:set scope="request" var="paginationParam" value="&search=${searchCountry}"/>
                    </c:when>
                    <c:when test="${searchCountry == null && sort != null}">
                        <c:set scope="request" var="paginationParam" value="&sort=${sort}"/>
                    </c:when>
                    <c:when test="${searchCountry != null && sort != null}">
                        <c:set scope="request" var="paginationParam" value="&search=${searchCountry}&sort=${sort}"/>
                    </c:when>
                </c:choose>
                <ul class="pagination justify-content-center mt-4">
                    <li class="page-item" id="page-first"><a class="page-link"
                                                             href="/user?page=1${paginationParam}">Fist Page</a>
                    </li>
                    <li class="page-item" id="page-previous">
                        <c:choose>
                            <c:when test="${current_page == 1}">
                                <a class="page-link" href="/user?page=${current_page}${paginationParam}">Previous</a>
                            </c:when>
                            <c:otherwise>
                                <a class="page-link"
                                   href="/user?page=${current_page - 1}${paginationParam}">Previous</a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                    <c:forEach items="${pageList}" var="page">
                        <li class="page-item" id="page-${page}"><a class="page-link"
                                                                   href="/user?page=${page}${paginationParam}">${page}</a>
                        </li>
                    </c:forEach>
                    <li class="page-item" id="page-next">
                        <c:choose>
                            <c:when test="${current_page == numberOfPages}">
                                <a class="page-link" href="/user?page=${current_page}${paginationParam}">Next</a>
                            </c:when>
                            <c:otherwise>
                                <a class="page-link" href="/user?page=${current_page + 1}${paginationParam}">Next</a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                    <li class="page-item" id="page-last"><a class="page-link"
                                                            href="/user?page=${numberOfPages}${paginationParam}">Last
                        Page</a>
                    </li>
                </ul>
            </nav>
            <p class="text-secondary d-flex justify-content-end position-absolute" style="bottom: -8px; right: 60px;">
                [<span>${current_page}</span>/<span>${numberOfPages}</span>]</p>
        </div>
    </div>
</main>
<footer>
    <nav class="navbar navbar-light bg-light justify-content-center w-100 position-fixed" style="bottom: 0; left: 0">
        <span class="navbar-text text-dark"> A0722I1 - Nguyễn Lê Khánh - Customer Page</span>
    </nav>
</footer>
<script src="/static/js/jquery-3.6.3.js"></script>
<script src="/static/js/popper.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
</body>
</html>
