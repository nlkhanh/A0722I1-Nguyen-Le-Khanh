<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<h3>Add Product</h3>
<p><a href="/product">Back to product list</a></p>
<form:form action="/product/save" modelAttribute="productForm" method="post" novalidate="novalidate"
           enctype="multipart/form-data">
    <form:hidden path="id"/>

    <form:label path="name">Name: </form:label>
    <form:input path="name"/>

    <form:label path="description">Description: </form:label>
    <form:input path="description"/>

    <form:label path="image">Image: </form:label>
    <input type="file" name="image"/>

    <input type="submit" value="save">
</form:form>
</body>
</html>
