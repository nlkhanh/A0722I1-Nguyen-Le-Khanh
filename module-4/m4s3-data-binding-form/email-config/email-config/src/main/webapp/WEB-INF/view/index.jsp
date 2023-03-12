<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Configuration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<form:form action="/email-config/update" method="post" modelAttribute="emailConfig" cssClass="container mt-3">
    <h1>Settings</h1>
    <div class="row mb-3">
        <form:select path="language" cssClass="form-select">
            <option disabled selected>--SELECT LANGUAGE--</option>
            <form:options items="${languages}"></form:options>
        </form:select>
    </div>
    <div class="row mb-3">
        <form:select path="pageSize" cssClass="form-select">
            <option disabled selected>--SELECT PAGE SIZE--</option>
            <form:options items="${pageSizes}"></form:options>
        </form:select>
    </div>
    <div class="row">
        <span class="text-bold col-2">Spams filter: </span>
        <div class="form-check mb-3 col-10">
            <form:checkbox path="spamFilter" cssClass="form-check-input"/>
            <form:label cssClass="form-check-label" path="spamFilter">Enable spams filter</form:label>
        </div>
    </div>
    <div class="row mb-3">
        <form:label cssClass="form-label" path="signature">Signature:</form:label>
        <form:textarea path="signature" cssClass="form-control"/>
    </div>
    <div class="d-flex justify-content-center">
        <input type="submit" value="Update" class="btn btn-primary me-4" style="width: 200px">
        <a href="/email-config" class="btn btn-secondary" style="width: 200px">Cancel</a>
    </div>
</form:form>
</body>
</html>
