<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Validation</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<h1>Email Validate</h1>
<h3 class="text-danger">${message}</h3>

<form action="validate" method="post">
    <input class="form-control" type="text" name="email" value="${email}">
    <input type="submit" value="Check" class="btn btn-primary">
</form>
</body>
</html>
