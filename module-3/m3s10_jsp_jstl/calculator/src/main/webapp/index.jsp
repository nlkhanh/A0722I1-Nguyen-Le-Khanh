<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <title>Calculator</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="./static/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1 class="row mb-3">Simple Calculator</h1>
    <form action="/calculator" method="post">
        <div class="container">
            <fieldset class="form-group row border border-dark p-3">
                <legend class="col-form-legend d-inline-block p-1" style="width: auto;">Calculator</legend>
                <div>
                    <div class="form-group form-inline">
                        <label for="first_operand" class="mr-3 d-inline-block" style="width: 122px;">First Operand: </label>
                        <input type="text"
                               class="form-control" name="firstOperand" id="first_operand">
                    </div>
                    <div class="form-group form-inline">
                        <label for="operator" class="mr-3 d-inline-block" style="width: 122px;">Operator: </label>
                        <select class="form-control" name="operator" id="operator">
                            <option>Addition</option>
                            <option>Subtraction</option>
                            <option>Multiplication</option>
                            <option>Division</option>
                        </select>
                    </div>
                    <div class="form-group form-inline">
                        <label for="second_operand" class="mr-3 d-inline-block" style="width: 122px;">Second Operand: </label>
                        <input type="text"
                               class="form-control" name="secondOperand" id="second_operand">
                    </div>
                    <button type="submit" class="btn btn-primary" style="margin-left: 138px;">Calculate</button>
                </div>
            </fieldset>
        </div>
    </form>
</div>
<script src="./static/js/jquery-3.6.3.js"></script>
<script src="./static/js/popper.min.js"></script>
<script src="./static/js/bootstrap.min.js"></script>
</body>
</html>