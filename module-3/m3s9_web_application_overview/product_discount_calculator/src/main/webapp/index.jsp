<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <title>Product Discount Calculator</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2 class="row mb-3">Product Discount Calculator</h2>
    <form class="form" action="/discountCalculate" method="post">
        <div class="form-group">
            <label for="product_description">Product Description: </label>
            <input type="text" name="productDescription" id="product_description" class="form-control"
                   placeholder="Product Description">
        </div>
        <div class="form-group">
            <label for="list_price">List Price: </label>
            <input type="text" name="listPrice" id="list_price" class="form-control"
                   placeholder="List Price">
        </div>
        <div class="form-group">
            <label for="discount_percent">Discount Percent: </label>
            <input type="text" name="discountPercent" id="discount_percent" class="form-control"
                   placeholder="Discount Percent">
        </div>
        <button type="submit" class="btn btn-primary">Calculate Discount</button>
    </form>
</div>

<script src="./js/jquery-3.6.3.js"></script>
<script src="./js/popper.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</body>
</html>