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
    <style>
        #web-brand:hover {
            color: #1d2124;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="container mt-3 text-center position-relative">
    <h1 class="mb-4"><a class="text-dark" id="web-brand" href="/user">User Management</a></h1>
    <h2><a class="btn btn-primary" href="/user?action=create" role="button">Add New User</a></h2>
    <form action="/user" class="form-inline mb-3 justify-content-end position-absolute" style="top: 76px; left: 0;">
        <input type="hidden" name="action" value="search-by-country">
        <div class="form-group">
            <c:choose>
                <c:when test="${searchCountry != null}">
                    <input type="text"
                           class="form-control mr-2" name="search" placeholder="Country" value="${searchCountry}">
                </c:when>
                <c:otherwise>
                    <input type="text"
                           class="form-control mr-2" name="search" placeholder="Country">
                </c:otherwise>
            </c:choose>
            <button type="submit" class="btn btn-primary">Search</button>
        </div>
    </form>
    <c:choose>
        <c:when test="${searchCountry != null}">
            <h2 class="position-absolute" style="top: 74px; right: 0;"><a class="btn btn-primary"
                                                                          href="/user?action=sort-by-name&search=${searchCountry}"
                                                                          role="button">Sort By Name</a></h2>
        </c:when>
        <c:otherwise>
            <h2 class="position-absolute" style="top: 74px; right: 0;"><a class="btn btn-primary"
                                                                          href="/user?action=sort-by-name"
                                                                          role="button">Sort By Name</a></h2>
        </c:otherwise>
    </c:choose>
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
                        <a class="page-link" href="/user?page=${current_page - 1}${paginationParam}">Previous</a>
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
                                                    href="/user?page=${numberOfPages}${paginationParam}">Last Page</a>
            </li>
        </ul>
    </nav>
    <p class="text-secondary d-flex justify-content-end position-absolute" style="bottom: -8px; right: 60px;">
        [<span>${current_page}</span>/<span>${numberOfPages}</span>]</p>
</div>

<%--Modal Delete--%>
<div class="modal fade" id="staticBackdrop_delete-confirm" data-backdrop="static" data-keyboard="false" tabindex="-1"
     aria-labelledby="staticBackdropLabel" aria-hidden="true" role="dialog">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Delete User Confirm</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body" id="delete-modal-body">
            </div>
            <div class="modal-footer">
                <form action="/user" method="post" id="delete-user-btn-form">
                    <input type="hidden" name="action" value="delete">
                    <button type="submit" class="btn btn-primary">Yes</button>
                </form>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<%--js--%>
<script src="/static/js/jquery-3.6.3.js"></script>
<script src="/static/js/popper.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script>
    document.getElementById("page-" + ${current_page}).classList.add("active");
    let currentPage = ${current_page};
    let lastPage = ${numberOfPages};
    if (lastPage === 0) {
        document.getElementById("page-first").classList.add("disabled");
        document.getElementById("page-previous").classList.add("disabled");
        document.getElementById("page-next").classList.add("disabled");
        document.getElementById("page-last").classList.add("disabled");
    } else {
        if (currentPage === 1) {
            document.getElementById("page-previous").classList.add("disabled");
            document.getElementById("page-first").classList.add("disabled");
        }
        if (currentPage === lastPage) {
            document.getElementById("page-next").classList.add("disabled");
            document.getElementById("page-last").classList.add("disabled");
        }
    }

    $('#staticBackdrop_delete-confirm').on('show.bs.modal', function (event) {
        const button = $(event.relatedTarget);
        const userInfo = "<p> Do you want to delete user: <br/>" + button.data('whatever') + " ?</p>";
        const modal = $(this);
        modal.find('.modal-body').html(userInfo);
        const deleteParam =
            '<input type=hidden name="action" value="delete"/>' +
            '<input type=hidden name="id" value="' + button.data('id') + '"/>';
        $('#delete-user-btn-form').prepend(deleteParam);
    })
</script>
</body>
</html>
