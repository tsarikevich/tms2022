<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My profile</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="resources/style.css">
    <link rel="stylesheet" type="text/css" href="resources/profileStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<ul>
    <li><a class="active" href='home'><i class="fa fa-fw fa-home"></i> Главная</a></li>
    <li style="float:right"><a href='cart'><i class="fa fa-fw fa-shopping-cart"></i> Корзина</a></li>
    <li style="float:right"><a href='profile'><i class="fa fa-fw fa-user"></i> Пользователь</a></li>
</ul>
<h3 class="text-center">Добро пожаловать, <b class="font-italic">${user.getLogin()}</b>!</h3>
<div class="container-fluid">
    <div class="userInfo">
        <h4><i>Личная информация</i></h4>
        <b>Имя:</b> ${user.getSurname()}<br>
        <b>Фамилия:</b> ${user.getSurname()}<br>
        <b>Дата рождения:</b> ${user.getDateOfBirth()}<br>
        <b>Email:</b> ${user.getEmail()}<br>
        <c:if test="${empty orders}">
            <b>Доп. информация:</b>Купленных товаров нет</p>
        </c:if>
        <button onclick="window.location.href = 'logout';" class="buttonQuit">
            <i class="fa fa-sign-out fa-lg" aria-hidden="true"></i> Выйти
        </button>
    </div>
</div>
<c:if test="${not empty orders}">
    <h4><p>История покупок:</p></h4>
    <c:forEach items="${orders}" var="orders">
        <p>Заказ №${orders.getId()}/ ${orders.getDate()}:
        <p>
        <div class="historyInfo">
            <c:forEach items="${orders.getProducts()}" var="product">
                <div class="history">
                    <a target="_blank" href="${contextPath}/product?productId=${product.getId()}">
                        <img src="${contextPath}/images/${product.getImageName()}" alt="${product.getImageName()}"
                             width="300" height="200">
                    </a>
                    <div class="desc"><b>Модель:</b> ${product.getName()}<br>
                        <b>Цена:</b> ${product.getPrice()} руб.
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:forEach>

</c:if>
</body>
</html>
