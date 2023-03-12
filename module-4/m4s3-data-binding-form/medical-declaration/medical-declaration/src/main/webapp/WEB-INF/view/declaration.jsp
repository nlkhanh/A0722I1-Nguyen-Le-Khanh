<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="forn" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tờ khai y tế</title>
    <link rel="stylesheet" href="webjars/bootstrap/5.2.3/css/bootstrap.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <style>
        .radios span {
            margin-right: 16px;
        }
    </style>
</head>
<body>
<main class="container mt-4">
    <header class="text-center fw-bold">
        <p class="text-uppercase">Tờ khai y tế</p>
        <p class="text-uppercase">Đây là tài liệu quan trọng, thông tin của anh/ chị sẽ giúp cơ quan y tế liên lạc khi
            cần
            thiết để phòng chống dịch bệnh truyền nhiễm</p>
        <p class="text-danger">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể bị xử lý hình
            sự</p>
    </header>
    <form:form action="/declaration" method="post" modelAttribute="declarationForm">
        <div>
            <form:label path="name" cssClass="form-label">Họ tên (ghi chữ IN HOA) <span
                    class="text-danger fst-italic">(*)</span> </form:label>
            <form:input path="name" cssClass="form-control"/>
        </div>
        <div class="col-12 d-flex justify-content-between">
            <div class="col-4">
                <form:label path="birthYear" cssClass="form-label">Năm sinh <span
                        class="text-danger fst-italic">(*)</span> </form:label>
                <form:select path="birthYear" cssClass="form-select">
                    <form:options items="${years}"/>
                </form:select>
            </div>
            <div class="col-4 px-2">
                <form:label path="gender" cssClass="form-label">Giới tính <span
                        class="text-danger fst-italic">(*)</span> </form:label>
                <form:select path="gender" cssClass="form-select">
                    <option value="-Chọn-" selected disabled>-Chọn-</option>
                    <form:options items="${genders}"/>
                </form:select>
            </div>
            <div class="col-4">
                <form:label path="nationality" cssClass="form-label">Quốc tịch <span
                        class="text-danger fst-italic">(*)</span> </form:label>
                <form:select path="nationality" cssClass="form-select">
                    <form:options items="${nationalities}"/>
                </form:select>
            </div>
        </div>
        <div>
            <form:label path="id" cssClass="form-label">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác
                <span
                        class="text-danger fst-italic">(*)</span> </form:label>
            <form:input path="id" cssClass="form-control"/>
        </div>
        <div class="radios">
            <form:label path="movingInfo" cssClass="form-label d-block">Thông tin đi lại <span
                    class="text-danger fst-italic">(*)</span></form:label>
            <form:radiobuttons path="movingInfo" items="${moveInfos}" cssClass="form-check-input me-2"/>
        </div>
        <div class="col-12 d-flex justify-content-between">
            <div class="col-6 pe-1">
                <form:label path="movingId" cssClass="form-label">Số hiệu phương tiện</form:label>
                <form:input path="movingId" cssClass="form-control"/>
            </div>
            <div class="col-6 ps-1">
                <form:label path="seatNumber" cssClass="form-label">Số ghế</form:label>
                <form:input path="seatNumber" cssClass="form-control"/>
            </div>
        </div>
        <div class="col-12 d-flex justify-content-between">
            <div class="col-6 pe-1">
                <form:label path="" cssClass="form-label">Ngày khởi hành <span
                        class="text-danger fst-italic">(*)</span></form:label>
                <div class="d-flex">
                    <form:select path="startYear" cssClass="form-select">
                        <option value="" disabled selected>-Năm-</option>
                        <form:options items="${years}"/>
                    </form:select>
                    <form:select path="startMonth" cssClass="form-select">
                        <option value="" disabled selected>-Tháng-</option>
                        <form:options items="${months}"/>
                    </form:select>
                    <form:select path="startDay" cssClass="form-select">
                        <option value="" disabled selected>-Ngày-</option>
                        <form:options items="${days}"/>
                    </form:select>
                </div>
            </div>
            <div class="col-6 ps-1">
                <form:label path="" cssClass="form-label">Ngày kết thúc <span
                        class="text-danger fst-italic">(*)</span></form:label>
                <div class="d-flex col-12">
                    <form:select path="endYear" cssClass="form-select">
                        <option value="" disabled selected>-Năm-</option>
                        <form:options items="${years}"/>
                    </form:select>
                    <form:select path="endMonth" cssClass="form-select">
                        <option value="" disabled selected>-Tháng-</option>
                        <form:options items="${months}"/>
                    </form:select>
                    <form:select path="endDay" cssClass="form-select">
                        <option value="" disabled selected>-Ngày-</option>
                        <form:options items="${days}"/>
                    </form:select>
                </div>
            </div>
        </div>
        <div>
            <form:label path="recentMove"
                        cssClass="form-label">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào? <span
                    class="text-danger fst-italic">(*)</span> </form:label>
            <form:textarea path="recentMove" cssClass="form-control"/>
        </div>
        <div class="col-12 d-flex justify-content-between">
            <div class="col-4">
                <form:label path="province" cssClass="form-label">Tỉnh / thành <span
                        class="text-danger fst-italic">(*)</span></form:label>
                <form:select path="province" cssClass="form-select">
                    <option value="" selected disabled>-Chọn-</option>
                    <form:options items="${provinces}"/>
                </form:select>
            </div>
            <div class="col-4 px-2">
                <form:label path="district" cssClass="form-label">Quận / huyện <span
                        class="text-danger fst-italic">(*)</span></form:label>
                <form:select path="district" cssClass="form-select">
                    <option value="" disabled selected>-Chọn-</option>
                    <form:options items="${districts}"/>
                </form:select>
            </div>
            <div class="col-4">
                <form:label path="ward" cssClass="form-label">Phường / xã <span
                        class="text-danger fst-italic">(*)</span></form:label>
                <form:select path="ward" cssClass="form-select">
                    <option value="" disabled selected>-Chọn-</option>
                    <form:options items="${wards}"/>
                </form:select>
            </div>
        </div>
        <div>
            <form:label path="street" cssClass="form-label">Địa chỉ nơi ở
                <span
                        class="text-danger fst-italic">(*)</span></form:label>
            <form:input path="street" cssClass="form-control"/>
        </div>
        <div class="col-12 d-flex justify-content-between">
            <div class="col-6 pe-1">
                <form:label path="phone" cssClass="form-label">Điện thoại <span
                        class="text-danger fst-italic">(*)</span> </form:label>
                <form:input path="phone" cssClass="form-control"/>
            </div>
            <div class="col-6 ps-1">
                <form:label path="email" cssClass="form-label">Email</form:label>
                <form:input path="email" cssClass="form-control"/>
            </div>
        </div>
        <div>
            <p>Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện dấu hiệu nào sao đây không? <span
                    class="text-danger fst-italic">(*)</span></p>
            <div class="d-flex">
                <div class="col-6 pe-1">
                    <table class="table table-bordered text-center">
                        <thead>
                        <tr>
                            <th>Triệu chứng</th>
                            <th>Có</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><form:label path="fever">Sốt <span class="text-danger fst-italic">(*)</span></form:label></td>
                            <td><form:checkbox path="fever"/></td>
                        </tr>
                        <tr>
                            <td><form:label path="cough">Ho <span class="text-danger fst-italic">(*)</span></form:label></td>
                            <td><form:checkbox path="cough"/></td>
                        </tr>
                        <tr>
                            <td><form:label path="breathless">Khó thở <span class="text-danger fst-italic">(*)</span></form:label></td>
                            <td><form:checkbox path="breathless"/></td>
                        </tr>
                        <tr>
                            <td><form:label path="soreThroat">Đau họng <span class="text-danger fst-italic">(*)</span></form:label></td>
                            <td><form:checkbox path="soreThroat"/></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="col-6 ps-1">
                    <table class="table table-bordered text-center">
                        <thead>
                        <tr>
                            <th>Triệu chứng</th>
                            <th>Có</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><form:label path="vomiting">Nôn/buồn nôn <span class="text-danger fst-italic">(*)</span></form:label></td>
                            <td><form:checkbox path="vomiting"/></td>
                        </tr>
                        <tr>
                            <td><form:label path="diarrhea">Tiêu chảy <span class="text-danger fst-italic">(*)</span></form:label></td>
                            <td><form:checkbox path="diarrhea"/></td>
                        </tr>
                        <tr>
                            <td><form:label path="skinHemorrhage">Xuất huyết ngoài da <span class="text-danger fst-italic">(*)</span></form:label></td>
                            <td><form:checkbox path="skinHemorrhage"/></td>
                        </tr>
                        <tr>
                            <td><form:label path="rash">Nổi ban ngoài da <span class="text-danger fst-italic">(*)</span></form:label></td>
                            <td><form:checkbox path="rash"/></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div>
            <p>Lịch sử phơi nhiễm: Trong vòng 14 ngày qua, Anh/Chị có <span
                    class="text-danger fst-italic">(*)</span></p>
            <div>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th></th>
                        <th class="text-center">Có</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><form:label path="animalExposure">Đến trang trại chăn nuôi / chợ buôn bán động vật sống / cơ sở giết mổ động vật / tiếp xúc động vật <span class="text-danger fst-italic">(*)</span></form:label></td>
                        <td class="text-center"><form:checkbox path="animalExposure"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="patientExposure">Tiếp xúc gần (<2m) với người mắc bệnh viêm đường hô hấp do nCoV <span class="text-danger fst-italic">(*)</span></form:label></td>
                        <td class="text-center"><form:checkbox path="patientExposure"/></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <p class="text-danger">Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho công việc phòng chống dịch, thuộc quản lý của Ban chỉ đạo Quốc gia về Phòng chống dịch Covid-19.
            <br> Khi bạn nhấn nút "Gửi tờ khai" là bạn đã hiểu và đồng ý.</p>
        <div class="text-center"><input type="submit" value="Gửi tờ khai" class="btn btn-success"></div>
    </form:form>
    <c:if test="${message != null}">
        <p class="text-success">${message}</p>
    </c:if>
</main>
</body>
</html>
