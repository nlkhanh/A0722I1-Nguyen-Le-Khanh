<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <title>Furama Resort</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
</head>
<body>
<header>
    <nav class="navbar navbar-light bg-light">
        <a class="navbar-brand" href="/">
            <img src="static/image/logo.png" width="30" height="30" class="d-inline-block align-top"
                 alt="">
            Furama Resort
        </a>
        <span class="navbar-text text-dark"> A0722I1 - Nguyễn Lê Khánh</span>
    </nav>
</header>
<div id="navigation" class="position-relative mt-1">
    <nav class="navbar navbar-expand-lg navbar-light bg-light justify-content-around">
        <ul class="navbar-nav w-50 d-flex justify-content-around">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Employee</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/furama-resort/customer?action=customer-list">Customer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Service</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Contract</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button>
        </form>
    </nav>
</div>
<main class="d-flex mt-2" style="height: 100vh">
    <div id="side-bar" class="w-25 pr-4">
        <div class="list-group list-group-flush">
            <a href="#" class="list-group-item list-group-item-action">Item 1</a>
            <a href="#" class="list-group-item list-group-item-action">Item 2</a>
            <a href="#" class="list-group-item list-group-item-action">Item 3</a>
            <a href="#" class="list-group-item list-group-item-action">Item 4</a>
            <a href="#" class="list-group-item list-group-item-action">Item 5</a>
            <a href="#" class="list-group-item list-group-item-action">Item 6</a>
            <a href="#" class="list-group-item list-group-item-action">Item 7</a>
            <a href="#" class="list-group-item list-group-item-action">Item 8</a>
        </div>
    </div>
    <div id="main-body" class="w-75 p-2 pr-4">
        <div id="content" class="h-100 bg-light rounded pl-3 pr-3 pt-2 pb-2"> HELLO </div>
    </div>
</main>
<footer>
    <nav class="navbar navbar-light bg-light justify-content-center w-100 position-fixed" style="bottom: 0; left: 0">
        <span class="navbar-text text-dark"> A0722I1 - Nguyễn Lê Khánh</span>
    </nav>
</footer>
<script src="static/js/jquery-3.6.3.js"></script>
<script src="static/js/popper.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
</body>
</html>