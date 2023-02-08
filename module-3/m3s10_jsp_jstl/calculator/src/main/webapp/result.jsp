<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nlk
  Date: 04/02/2023
  Time: 2:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h1>Result: </h1>
<c:choose>
    <c:when test="${operator eq 'Addition'}">
        <p>${firstOperand} + ${secondOperand} = ${result}</p>
    </c:when>
    <c:when test="${operator eq 'Subtraction'}">
        <p>${firstOperand} - ${secondOperand} = ${result}</p>
    </c:when>
    <c:when test="${operator eq 'Multiplication'}">
        <p>${firstOperand} x ${secondOperand} = ${result}</p>
    </c:when>
    <c:when test="${operator eq 'Division'}">
        <p>${firstOperand} : ${secondOperand} = ${result}</p>
    </c:when>
</c:choose>
</body>
</html>
