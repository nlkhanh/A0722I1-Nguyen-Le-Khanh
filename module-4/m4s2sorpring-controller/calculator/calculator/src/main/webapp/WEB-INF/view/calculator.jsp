<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<main class="container mt-4">
    <h1 class="text-bold">Calculator</h1>
    <form action="/calculate">
        <div class="d-flex">
            <div class="pe-2">
                <input class="form-control" type="text" name="firstOperand" value="${calculator.firstOperand}">
            </div>
            <div>
                <input class="form-control" type="text" name="secondOperand"
                       value="${calculator.secondOperand}">
            </div>
        </div>
        <div class="form-group mt-2">
            <input type="submit" value="plus" name="operator" class="btn btn-primary">
            <input type="submit" value="sub" name="operator" class="btn btn-primary">
            <input type="submit" value="mul" name="operator" class="btn btn-primary">
            <input type="submit" value="div" name="operator" class="btn btn-primary">
        </div>
    </form>
    <div class="result-wrap">
        <p>${calculator.message}</p>
    </div>
</main>

</body>
</html>
