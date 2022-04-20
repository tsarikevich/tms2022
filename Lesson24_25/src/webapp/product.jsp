<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Product</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        .responsive {
            max-width: 100%;
            height: auto;
        }
    </style>
</head>
<body>
<input class="btn btn-secondary" type="button" value="ГЛАВНАЯ СТРАНИЦА"
       onclick="location.href = 'javascript:history.back()'"/>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h2>${categoryName}</h2><br>
<div class="container-fluid">
    <c:if test="${not empty products}">

    <c:forEach items="${products}" var="product">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-1" style="background-color:white;">
                    <img src="${contextPath}/images/${product.getImageName()}"
                         alt="${product.getImageName()}" class="responsive"></div>
                <div class="col" style="background-color:white;">
                    <p>Модель: ${product.getName()}</p>
                    <p>Описание: ${product.getDescription()}</p>
                    <p>Цена: ${product.getPrice()} руб.</p>
                </div>
            </div>
        </div>
        <br>
    </c:forEach>
</div>
</c:if>
</div>
</body>
</html>


