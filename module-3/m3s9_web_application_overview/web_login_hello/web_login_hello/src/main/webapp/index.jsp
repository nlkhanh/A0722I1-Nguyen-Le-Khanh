<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <title>Web Login Hello</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
</head>
<body>
<div class="container mt-3">
    <h2 class="row">Login</h2>
    <form action="/login" method="post" name="login_form">
        <div class="form-group">
            <input type="text"
                   class="form-control" name="username" id="user_name" aria-describedby="helpId" placeholder="username">
        </div>
        <div class="form-group">
            <input type="password"
                   class="form-control" name="password" id="password" aria-describedby="helpId" placeholder="password">
        </div>
        <button type="submit" class="btn btn-primary">Sign in</button>
    </form>
</div>
<script src="./js/jquery-3.6.3.js"></script>
<script src="./js/popper.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</body>
</html>