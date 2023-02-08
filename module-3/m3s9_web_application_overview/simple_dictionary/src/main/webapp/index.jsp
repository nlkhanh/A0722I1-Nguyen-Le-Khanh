<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <title>Simple Dictionary</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h3 class="row">Vietnamese Dictionary</h3>
    <form action="/translate" method="post" class="form-inline">
        <div class="form-group mr-2">
            <input type="text"
                   class="form-control" name="txtSearch" placeholder="Enter your word: ">
        </div>
        <button type="submit" class="btn btn-primary">Search</button>
    </form>
</div>
<script src="./js/jquery-3.6.3.js"></script>
<script src="./js/popper.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</body>
</html>