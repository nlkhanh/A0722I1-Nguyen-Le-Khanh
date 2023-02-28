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
    <div id="main-body" class="p-2 col-12 position-relative">
        <a class="btn btn-primary position-absolute" href="/furama-resort/service?action=create"
           style="left: 28px; top: 24px" role="button">Add New Service</a>
        <form class="form-inline my-2 my-lg-0 position-absolute" style="right: 28px; top: 24px"
              action="/furama-resort/service"
              method="get">
            <input class="form-control mr-sm-2" type="search" name="search" placeholder="Service's name..."
                   aria-label="Search" value="${search}">
            <button class="btn btn-outline-dark my-2 my-sm-0" type="submit">Search</button>
        </form>
        <div id="content" class="bg-light rounded px-2">
            <table class="table text-center">
                <caption style="caption-side: top" class="text-center text-dark"><h2>List of Services</h2></caption>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Area</th>
                    <th>Cost</th>
                    <th>Max people</th>
                    <th>Rent type</th>
                    <th>Service Type</th>
                    <th>Standard Room</th>
                    <th>Other Convenience</th>
                    <th>Pool area</th>
                    <th>Number Of Floors</th>
                    <th>Free Service</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${services}" var="service">
                    <tr>
                        <td>${service.id}</td>
                        <td class="text-left">${service.name}</td>
                        <td>${service.area}</td>
                        <td>${service.cost}</td>
                        <td>${service.maxPeople}</td>
                        <td>
                            <c:forEach items="${rentTypes}" var="rentType">
                                <c:if test="${rentType.id == service.rentTypeId}">
                                    ${rentType.name}
                                </c:if>
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach items="${serviceTypes}" var="serviceType">
                                <c:if test="${serviceType.id == service.serviceTypeId}">
                                    ${serviceType.name}
                                </c:if>
                            </c:forEach>
                        </td>
                        <c:choose>
                            <c:when test="${service.serviceTypeId == 1}">
                                <td>Không</td>
                                <td>Không</td>
                                <td>Không</td>
                                <td>Không</td>
                                <td>${service.freeService}</td>
                            </c:when>
                            <c:when test="${service.serviceTypeId == 2}">
                                <td>${service.standardRoom}</td>
                                <td>${service.otherConvenience}</td>
                                <td>Không</td>
                                <td>${service.numberOfFloors}</td>
                                <td>Không</td>
                            </c:when>
                            <c:when test="${service.serviceTypeId == 3}">
                                <td>${service.standardRoom}</td>
                                <td>${service.otherConvenience}</td>
                                <td>${service.poolArea}</td>
                                <td>${service.numberOfFloors}</td>
                                <td>Không</td>
                            </c:when>
                        </c:choose>
                        <td><a class="btn btn-primary"
                               href="/furama-resort/service?action=edit&id=${service.id}"
                               role="button">Edit</a>
                        </td>
                        <td>
                            <button type="button" class="btn btn-primary"
                                    id="btn-delete-next"
                                    data-toggle="modal" data-target="#staticBackdrop_delete-confirm"
                                    <c:choose>
                                        <c:when test="${service.serviceTypeId == 1}">
                                            data-whatever="(id: ${service.id}, name: ${service.name}, service type: Room)"
                                        </c:when>
                                        <c:when test="${service.serviceTypeId == 2}">
                                            data-whatever="(id: ${service.id}, name: ${service.name}, service type: House)"
                                        </c:when>
                                        <c:when test="${service.serviceTypeId == 3}">
                                            data-whatever="(id: ${service.id}, name: ${service.name}, service type: Villa)"
                                        </c:when>
                                    </c:choose>
                                    data-id="${service.id}">
                                Delete
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <nav aria-label="pagination" class="position-relative">
            <c:choose>
                <c:when test="${search == null}">
                    <c:set scope="request" var="paginationParam" value=""/>
                </c:when>
                <c:when test="${search != nul}">
                    <c:set scope="request" var="paginationParam" value="&search=${search}"/>
                </c:when>
            </c:choose>
            <ul class="pagination justify-content-center mt-4">
                <li class="page-item" id="page-first"><a class="page-link"
                                                         href="/furama-resort/service?page=1${paginationParam}">Fist
                    Page</a>
                </li>
                <li class="page-item" id="page-previous">
                    <a class="page-link"
                       href="/furama-resort/service?page=${page - 1}${paginationParam}">Previous</a>
                </li>
                <c:forEach items="${pageList}" var="pageItem">
                    <li class="page-item" id="page-${pageItem}"><a class="page-link"
                                                                   href="/furama-resort/service?page=${pageItem}${paginationParam}">${pageItem}</a>
                    </li>
                </c:forEach>
                <li class="page-item" id="page-next">
                    <a class="page-link" href="/furama-resort/service?page=${page + 1}${paginationParam}">Next</a>
                </li>
                <li class="page-item" id="page-last"><a class="page-link"
                                                        href="/furama-resort/service?page=${numberOfPages}${paginationParam}">Last
                    Page</a>
                </li>
            </ul>
            <c:choose>
                <c:when test="${numberOfPages == 0}">
                    <p class="text-secondary d-flex justify-content-end position-absolute m-0"
                       style="top: 10px; right: 24px;">
                        [<span>0</span>/<span>${numberOfPages}</span>]</p>
                </c:when>
                <c:otherwise>
                    <p class="text-secondary d-flex justify-content-end position-absolute m-0"
                       style="top: 10px; right: 24px;">
                        [<span>${page}</span>/<span>${numberOfPages}</span>]</p>
                </c:otherwise>
            </c:choose>
        </nav>
    </div>
</main>
<footer class="position-fixed w-100" style="z-index: 100; left: 0; bottom: 0">
    <nav class="navbar navbar-dark bg-dark justify-content-center">
        <span class="navbar-text text-light"> A0722I1 - Nguyễn Lê Khánh - Service Page</span>
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

<%--Modal Delele--%>
<div class="modal fade" id="staticBackdrop_delete-confirm" data-backdrop="static" data-keyboard="false" tabindex="-1"
     aria-labelledby="staticBackdropLabel" aria-hidden="true" role="dialog">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Delete Confirm</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body" id="delete-modal-body">
            </div>
            <div class="modal-footer">
                <form action="/furama-resort/service" method="get" id="form-btn-delete">
                    <input type="hidden" name="action" value="delete">
                    <button type="submit" class="btn btn-primary">Yes</button>
                </form>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
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
    let currentPage = ${page};
    let lastPage = ${numberOfPages};
    if (lastPage === 0) {
        document.getElementById("page-first").classList.add("disabled");
        document.getElementById("page-previous").classList.add("disabled");
        document.getElementById("page-next").classList.add("disabled");
        document.getElementById("page-last").classList.add("disabled");
    } else {
        document.getElementById("page-" + currentPage).classList.add("active");
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
        const customerInfo = "<p> Do you want to delete service: <br/>" + button.data('whatever') + " ?</p>";
        const modal = $(this);
        modal.find('.modal-body').html(customerInfo);
        const deleteParam = '<input type=hidden name="id" value="' + button.data('id') + '"/>';
        $('#form-btn-delete').prepend(deleteParam);
    })

    if (${message != null}) {
        $('.toast').toast('show');
    }
</script>
</body>
</html>
