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
            width: 90px;
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
            <li class="nav-item">
                <a class="nav-link" href="/furama-resort/customer">Customer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/furama-resort/service">Service</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/furama-resort/contract">Contract</a>
            </li>
        </ul>
    </nav>
</div>
<main class="d-flex justify-content-center" style="margin-bottom: 56px;">
    <div id="main-body" class="py-2 px-4 col-8 position-relative bg-light my-2 rounded text-center">
        <h2 class="text-center text-dark mb-3">Add New Contract</h2>
        <p class="mb-3 text-left text-dark font-italic" style="font-size: 20px;">Customer: ${customer.name},
            Id: ${customer.id}</p>
        <form action="/furama-resort/contract" method="post" id="create-form">
            <input type="hidden" name="action" value="create">
            <c:choose>
                <c:when test="${contract != null}">
                    <input type="hidden" name="customerId" value="${contract.customerId}">
                </c:when>
                <c:otherwise>
                    <input type="hidden" name="customerId" value="${customer.id}">
                </c:otherwise>
            </c:choose>
            <div class="form-group form-inline">
                <label for="employeeId">Employee: </label>
                <select class="form-control" name="employeeId" id="employeeId">
                    <c:forEach items="${employees}" var="customer">
                        <option value="${customer.id}" id="employeeId-${customer.id}">${customer.id}
                            - ${customer.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group form-inline">
                <label for="serviceId">Service: </label>
                <select class="form-control" name="serviceId" id="serviceId" onchange="getTotalMoney()">
                    <c:forEach items="${services}" var="service">
                        <option value="${service.id}"
                                id="serviceId-${service.id}" data-cost="${service.cost}">${service.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group form-inline">
                <label for="startDate">Start date: </label>
                <input type="date"
                       class="form-control" name="startDate" id="startDate" placeholder="start date"
                       value="${contract.startDate}">
            </div>
            <div class="form-group form-inline">
                <label for="endDate">End date: </label>
                <input type="date"
                       class="form-control" name="endDate" id="endDate" placeholder="end date"
                       value="${contract.endDate}">
            </div>
            <div class="w-100 d-flex justify-content-start mb-3">
                <button type="button" class=" btn btn-primary" data-toggle="collapse"
                        data-target="#contractDetailInput" aria-expanded="false" aria-controls="contractDetailInput">Add
                    contract detail
                </button>
            </div>
            <div class="collapse" id="contractDetailInput">
                <table class="table">
                    <caption style="caption-side: top" class="text-center text-dark"><h4>Attach Services</h4></caption>
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Cost</th>
                        <th>Unit</th>
                        <th>Status</th>
                        <th>Use</th>
                        <th>Quantity</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${attachServices}" var="attachService">
                        <tr>
                            <td>${attachService.name}</td>
                            <td>${attachService.cost}</td>
                            <td>${attachService.unit}</td>
                            <td>${attachService.status}</td>
                            <td>
                                <div class="form-check">
                                    <input type="checkbox" class="form-check-input" name="useAttachService"
                                           value="${attachService.id}" onclick="activeQuantity(${attachService.id})">
                                </div>
                            </td>
                            <td>
                                <div class="form-group">
                                    <input type="text" disabled
                                           data-cost="${attachService.cost}"
                                           onchange="getTotalMoney()"
                                           class="form-control attachServiceQuantity" name="quantity-${attachService.id}"
                                           id="quantity-${attachService.id}"
                                           placeholder="quantity">
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="form-group form-inline">
                <label for="totalMoney">Total money: </label>
                <input type="text"
                       class="form-control" name="totalMoney" id="totalMoney" placeholder="total money"
                       value="${contract.totalMoney}">
            </div>
            <div class="form-group form-inline">
                <label for="deposit">Deposit: </label>
                <input type="text"
                       class="form-control" name="deposit" id="deposit" placeholder="deposit"
                       value="${contract.deposit}">
            </div>
            <button type="submit" class="float-right btn btn-primary">Add contract</button>
        </form>
    </div>
</main>
<footer class="position-fixed w-100" style="z-index: 4; left: 0; bottom: 0">
    <nav class="navbar navbar-dark bg-dark justify-content-center">
        <span class="navbar-text text-light"> A0722I1 - Nguyễn Lê Khánh - Contract Page</span>
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
    $('#employeeId-${contract.employeeId}').attr('selected', true);
    $('#serviceId-${contract.serviceId}').attr('selected', true);
    $('#attachServiceId-${contractDetail.attachServiceId}').attr('selected', true);

    if (${message != null}) {
        $('.toast').toast('show');
    }


    function activeQuantity(id) {
        let quantityInput = $('#quantity-' + id);
        let check = quantityInput.attr("disabled") === "disabled";
        if (check) {
            quantityInput.attr("disabled", false);
        } else {
            quantityInput.val("");
            quantityInput.attr("disabled", true);
        }
    }

    function getAttachServiceCost() {
        let sum = 0;
        $('.attachServiceQuantity').each(function (i, obj) {
            if ($(obj).val() !== "") {
                sum += parseInt($(obj).val());
            }
        })
        return sum;
    }

    function getTotalMoney() {
        let attachServiceCost = getAttachServiceCost();
        let serviceId = $('#serviceId').val();
        let serviceCost = parseInt($('#serviceId-' + serviceId).da  ta('cost'));
        $('#totalMoney').val(attachServiceCost + serviceCost);
    }

</script>
</body>
</html>


