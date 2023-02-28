<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Department</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%--    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.3.1/css/bootstrap.css">--%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="webjars/datatables/1.10.21/css/dataTables.bootstrap4.css">
</head>
<body>

<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="department">PHÒNG TRỌ</a>
    <div class="add-wrap">
        <a class="btn btn-primary" href="department?action=create" role="button">Tạo mới</a>
    </div>
    <div class="search-wrap">
        <form action="/rent-room" class="m-0 form-inline" method="get">
            <div class="form-group mr-2">
                <input type="text"
                       class="form-control" name="search" id="search-id">
            </div>
            <button type="submit" class="btn btn-primary">Tìm kiếm</button>
        </form>
    </div>
</nav>
<main class="container col-12 mt-1">
    <div class="table-wrap">
        <table id="table-id" class="table table-bordered">
            <caption style="caption-side: top" class="text-center text-dark">
                <h2>DANH SÁCH MẶT BẰNG</h2>
            </caption>
            <thead class="text-center">
            <tr>
                <th>Mã MB</th>
                <th>Diện tích</th>
                <th>Trạng thái</th>
                <th>Tầng</th>
                <th>Loại văn phòng</th>
                <th>Giá cho thuê</th>
                <th>Ngày bắt đầu</th>
                <th>Ngày kết thúc</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${departments}" var="deparment">
                <tr>
                    <td>${deparment.code}</td>
                    <td>${deparment.area}</td>
                    <td>${deparment.status} </td>
                    <td>${deparment.floor}</td>
                    <td>${deparment.type}</td>
                    <td>${deparment.cost}</td>
                    <td>${deparment.startDate}</td>
                    <td>${deparment.endDate}</td>
                    <td>
                        <a class="btn btn-primary" onclick="deleteId(${deparment.id})" role="button" data-toggle="modal" data-target="#modelId">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</main>

<%--Modal--%>
<div class="modal fade" id="modelId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">XÁC NHẬN XÓA</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                <form action="/department" class="m-0" method="get">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" id="id" value="">
                    <button type="submit" class="btn btn-primary" id="delete-btn">Xóa</button>
                </form>
            </div>
        </div>
    </div>
</div>

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

<%--<script src="webjars/jquery/3.3.1/dist/jquery.js"></script>--%>
<%--<script src="webjars/popper.js/1.14.7/dist/popper.js"></script>--%>
<%--<script src="webjars/bootstrap/4.3.1/js/bootstrap.js"></script>--%>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="webjars/datatables/1.10.21/js/jquery.dataTables.js"></script>
<script src="webjars/datatables/1.10.21/js/dataTables.bootstrap4.js"></script>
<script>
    if (${message != null}) {
        $('.toast').toast('show');
    }

    function deleteId(id) {
        $('#id').val(id);
        $('.modal-body').html("<p>Ban co muon xoa " + id + " không?</p>")
    }
</script>
</body>
</html>