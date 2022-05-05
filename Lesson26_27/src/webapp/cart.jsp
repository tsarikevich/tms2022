<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<html>
<head>
    <title>My cart</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="resources/style.css">
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
<h2>Ваша корзина</h2>
<c:if test="${not empty myProducts}">
    <c:forEach items="${myProducts}" var="myProduct">
        <div class="container-fluid">
            <div class="row">
                <div class="col" style="background-color:white;height: auto;max-width: 200px">
                    <img src="${contextPath}/images/${myProduct.getImageName()}"
                         alt="${myProduct.getImageName()}" class="mx-auto d-block"
                         style="max-height: 100px;width: auto">
                </div>
                <div class="col" style="background-color:white;">
                    <p><b class="font-italic">Модель:</b> ${myProduct.getName()}</p>
                    <p><b class="font-italic">Описание:</b> ${myProduct.getDescription()}</p>
                    <p><b class="font-italic">Цена:</b> ${myProduct.getPrice()} руб.</p>
                    <form method="post" action="${pageContext.request.contextPath}/cart">
                        <input type="hidden" value="${myProduct.getId()}" name="id"/>
                        <input type="hidden" value="${myProduct.getImageName()}" name="imageName"/>
                        <input type="hidden" value="${myProduct.getName()}" name="name"/>
                        <input type="hidden" value="${myProduct.getDescription()}" name="description"/>
                        <input type="hidden" value="${myProduct.getPrice()}" name="price"/>
                        <input type="hidden" value="${myProduct.getCategory_id()}" name="categoryId"/>
                        <button type="submit" value="Удалить" name="action" class="buttonDelete"><i
                                class="fa fa-minus-square fa-lg"></i> Удалить
                        </button>
                    </form>
                </div>
            </div>

        </div>
        <br>
    </c:forEach>
</c:if>
<c:if test="${empty myProducts}">
    <h3><p class="text-center">В корзине нет товаров</p></h3>
</c:if>
</body>
</html>
