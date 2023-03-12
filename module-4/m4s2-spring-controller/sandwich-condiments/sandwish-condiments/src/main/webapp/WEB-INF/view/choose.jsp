<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<main class="container">
    <h1>Sandwich Condiments</h1>
    <form action="/save" method="post">
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="Lettuce" name="condiment">
            <label class="form-check-label" for="inlineCheckbox1">Lettuce</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="Tomato" name="condiment">
            <label class="form-check-label" for="inlineCheckbox2">Tomato</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="Mustard" name="condiment">
            <label class="form-check-label" for="inlineCheckbox3">Mustard</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="inlineCheckbox4" value="Sprouts" name="condiment">
            <label class="form-check-label" for="inlineCheckbox4">Sprouts</label>
        </div>
        <div class="btn-wrap">
            <input type="submit" value="Save" class="btn btn-primary">
        </div>
    </form>
</main>
</body>
</html>
