<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Department</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.3.1/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="webjars/datatables/1.10.21/css/dataTables.bootstrap4.css">
    <style>
        label {
            width: 150px;
            justify-content: left !important;
        }

        input, textarea {
            flex-grow: 1;
        }

        input[type='date'] {
            flex-grow: 0;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="department">DEPARTMENT</a>
</nav>
<main class="container mt-1">
    <h2 class="text-center my-4">TẠO MỚI THÔNG TIN MẶT BẰNG</h2>
    <form action="department" method="post">
        <input type="hidden" name="action" value="create">
        <div class="form-group form-inline">
            <label for="code">Mã mặt bằng: </label>
            <input type="text"
                   class="form-control" name="code" id="code" value="${code}">
        </div>
        <div class="form-group form-inline">
            <label for="area">Diện tích: </label>
            <input type="text"
                   class="form-control" name="area" id="area" value="${area}">
        </div>
        <div class="form-group form-inline">
            <label for="status">Trạng thái: </label>
            <select class="form-control" name="status" id="status">
                    <option value="Trống" id="status_one">Trống</option>
                    <option value="Hạ tầng" id="status_two">Hạ tầng</option>
                    <option value="Đầy đủ" id="status_three">Đầy đủ</option>
            </select>
        </div>
        <div class="form-group form-inline">
            <label for="floor">Tầng: </label>
            <select class="form-control" name="floor" id="floor">
                <option value="1" id="floor-1">1</option>
                <option value="2" id="floor-2">2</option>
                <option value="3" id="floor-3">3</option>
                <option value="4" id="floor-4">4</option>
                <option value="5" id="floor-5">5</option>
                <option value="6" id="floor-6">6</option>
                <option value="7" id="floor-7">7</option>
                <option value="8" id="floor-8">8</option>
                <option value="9" id="floor-9">9</option>
                <option value="10" id="floor-10">10</option>
                <option value="11" id="floor-11">11</option>
                <option value="12" id="floor-12">12</option>
                <option value="13" id="floor-13">13</option>
                <option value="14" id="floor-14">14</option>
                <option value="15" id="floor-15">15</option>
            </select>
        </div>
        <div class="form-group form-inline">
            <label for="type">Loại cho thuê: </label>
            <select class="form-control" name="type" id="type">
                <option value="Chia sẻ" id="type_one">Chia sẻ</option>
                <option value="Trọn gói" id="type_two">Trọn gói</option>
            </select>
        </div>
        <div class="form-group form-inline">
            <label for="detail">Mô tả chi tiết: </label>
            <textarea class="form-control" name="detail" id="detail" rows="3">${detail}</textarea>
        </div>
        <div class="form-group form-inline">
            <label for="cost">Giá cho thuê: </label>
            <input type="text"
                   class="form-control" name="cost" id="cost" value="${cost}">
        </div>
        <div class="form-group form-inline">
            <label for="startDate">Ngày bắt đầu: </label>
            <input type="date"
                   class="form-control" name="startDate" id="startDate" value="${startDate}">
        </div>
        <div class="form-group form-inline">
            <label for="endDate">Ngày kết thúc: </label>
            <input type="date"
                   class="form-control" name="endDate" id="endDate" value="${endDate}">
        </div>

        <button type="submit" class="btn btn-primary">Lưu</button>
        <a class="btn btn-primary" href="department" role="button">Hủy</a>
    </form>
</main>

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

<script src="webjars/jquery/3.3.1/dist/jquery.js"></script>
<script src="webjars/popper.js/1.14.7/dist/popper.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.js"></script>
<script src="webjars/datatables/1.10.21/js/jquery.dataTables.js"></script>
<script src="webjars/datatables/1.10.21/js/dataTables.bootstrap4.js"></script>
<script>
    if (${message != null}) {
        $('.toast').toast('show');
    }
</script>
</body>
</html>