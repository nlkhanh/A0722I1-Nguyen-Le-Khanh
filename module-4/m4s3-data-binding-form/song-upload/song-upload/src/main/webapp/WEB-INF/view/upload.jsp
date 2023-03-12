<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Song Upload</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<main class="container mt-4">
    <h1>Upload New Song</h1>
    <form:form action="/song-upload/upload" method="post" modelAttribute="songForm" enctype="multipart/form-data">
        <div>
            <form:label cssClass="form-label" path="name">Name: </form:label>
            <form:input cssClass="form-control" path="name"/>
        </div>

        <div>
            <form:label cssClass="form-label" path="author">Author: </form:label>
            <form:input cssClass="form-control" path="author"/>
        </div>

        <div>
            <form:label cssClass="form-label" path="types">Types: </form:label>
            <form:checkboxes path="types" items="${types}"/>
        </div>

        <div>
            <form:label cssClass="form-label" path="file">File: </form:label>
            <input type="file" name="file" class="form-control">
        </div>

        <div class="mt-2">
            <input type="submit" value="Upload" class="btn btn-primary">
            <a href="/song-upload" class="btn btn-secondary">Cancel</a>
        </div>
    </form:form>
</main>
</body>
</html>
