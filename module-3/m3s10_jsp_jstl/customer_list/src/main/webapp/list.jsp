<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.customer_list.Customer" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <title>Customer List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="./static/css/bootstrap.min.css">
</head>
<body>
<%
    List<Customer> customerList = new ArrayList<>();
    customerList.add(new Customer("Mai Văn A", "1983-08-20", "Hà Nội", "./static/image/download.jpg"));
    customerList.add(new Customer("Mai Văn B", "1993-08-20", "Đà Nẵng", "./static/image/download.jpg"));
    customerList.add(new Customer("Mai Văn C", "1990-08-20", "Hồ Chí Minh", "./static/image/download.jpg"));
    customerList.add(new Customer("Mai Văn D", "2001-08-20", "Huế", "./static/image/download.jpg"));
    customerList.add(new Customer("Mai Văn E", "1999-08-20", "Hà Nội", "./static/image/download.jpg"));
    request.setAttribute("customerList", customerList);
%>
<div class="container mt-5">
    <h1 class="text-center mb-3">Danh sách khách hàng</h1>
    <table class="table">
        <thead>
        <tr>
            <th>Tên</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>Ảnh</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customerList}" var="customer">
            <tr>
                <td><c:out value="${customer.name}"/></td>
                <td><c:out value="${customer.birthday}"/></td>
                <td><c:out value="${customer.address}"/></td>
                <td><img src="${customer.image}" width="50px">
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<script src="./static/js/jquery-3.6.3.js"></script>
<script src="./static/js/popper.min.js"></script>
<script src="./static/js/bootstrap.min.js"></script>
</body>
</html>