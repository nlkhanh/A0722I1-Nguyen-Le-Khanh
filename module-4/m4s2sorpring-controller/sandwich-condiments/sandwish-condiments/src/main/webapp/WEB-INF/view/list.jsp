<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<main class="container">
    <p>Sandwich Condiments Were Chosen:</p>
    <ul class="list-group">
        <c:forEach items="${condiments}" var="condiment">
            <li class="list-group-item">${condiment}</li>
        </c:forEach>
    </ul>
</main>
</body>
</html>
