<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Song List</title>
    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/5.2.3/css/bootstrap.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<main class="container mt-4">
    <h1>List of Song</h1>
    <table class="table">
        <thead>
        <tr class="text-center">
            <th>Name</th>
            <th>Author</th>
            <th>Types</th>
            <th>Link</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${songs}" var="song">
            <tr>
                <td>${song.name}</td>
                <td>${song.author}</td>
                <td>${song.types}</td>
                <td>${song.link}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/song-upload/upload" class="btn btn-primary">Upload new song</a>
    <p>${message}</p>
</main>
</body>
</html>
