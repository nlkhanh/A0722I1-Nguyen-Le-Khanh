<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<form action="${pageContext.request.contextPath}/trans" method="post">
    <div class="form-wrap">
        <label for="word" class="form-label">Enter your word: </label>
        <input type="text" name="word" id="word" class="form-control" value="${searchWord.word}">
    </div>
    <div class="form-wrap">
        <label for="result" class="form-label">Result: </label>
        <input type="text" name="result" id="result" class="form-control" readonly value="${searchWord.result}">
    </div>
    <div class="btn-wrap">
        <input type="submit" value="Search" class="btn btn-primary">
    </div>
</form>
</body>
</html>
