<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <title>Currency Converter</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="./css/bootstrap.min.css" type="text/css">
</head>
<body>
<div class="container mt-4">
    <h2 class="row">Currency Converter</h2>
    <form action="/convert" method="post">
        <div class="form-group">
            <label for="rate">Rate: </label>
            <input type="text"
                   class="form-control" name="rate" id="rate" placeholder="RATE" value="220000">
        </div>
        <div class="form-group">
            <label for="usd">USD: </label>
            <input type="text"
                   class="form-control" name="usd" id="usd" placeholder="USD" value="0">
        </div>
        <button type="submit" class="btn btn-primary">Converter</button>
    </form>
</div>
<script src="./js/jquery-3.6.3.js"></script>
<script src="./js/popper.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</body>
</html>