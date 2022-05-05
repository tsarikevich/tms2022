<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<html>
<head>
    <title>Products</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="resources/style.css" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        <%@include file='resources/style.css' %>
    </style>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<ul>
    <li><a class="active" href='home'><i class="fa fa-fw fa-home"></i> Главная</a></li>
    <li style="float:right"><a href='cart'><i class="fa fa-fw fa-shopping-cart"></i> Корзина</a></li>
    <li style="float:right"><a href='profile'><i class="fa fa-fw fa-user"></i> Пользователь</a></li>
</ul>
<br>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h2>${nameCategory}</h2><br>
<div class="container-fluid">
    <c:if test="${not empty products}">
    <c:forEach items="${products}" var="product">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-1" style="background-color:white;">
                    <a href="${contextPath}/product?productId=${product.getId()}">
                        <img src="${contextPath}/images/${product.getImageName()}"
                             alt="${product.getImageName()}" class="responsive"></a></div>
                <div class="col" style="background-color:white;">
                    <p><b class="font-italic">Модель:</b> ${product.getName()}</p>
                    <p><b class="font-italic">Описание:</b> ${product.getDescription()}</p>
                    <p><b class="font-italic">Цена:</b> ${product.getPrice()} руб.</p>
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


