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
    <li><a class="active" href='eshop?command=start_page'><i class="fa fa-fw fa-home"></i> Главная</a></li>
    <li style="float:right"><a href='eshop?command=redirect-to-shopping-cart'><i class="fa fa-fw fa-shopping-cart"></i>
        Корзина</a></li>
    <li style="float:right"><a href='eshop?command=redirect-to-profile'><i class="fa fa-fw fa-user"></i>
        Пользователь</a></li>
    <li style="float:right"><a href='eshop?command=redirect-to-search'><i class="fa fa-fw fa-search"></i>
        Поиск</a></li>
</ul>
<h3 class="text-center">Добро пожаловать, <b class="font-italic">${user.getLogin()}</b>!</h3>
<div class="container-fluid">
    <div class="userInfo">
        <h4><i>Личная информация</i></h4>
        <b>Имя:</b> ${user.getSurname()}<br>
        <b>Фамилия:</b> ${user.getSurname()}<br>
        <b>Дата рождения:</b>
        <fmt:parseDate value="${user.getBirthDate()}" pattern="yyyy-MM-dd" var="parsedDate" type="both"/>
        <fmt:formatDate pattern="dd.MM.yyyy" value="${parsedDate}"/><br>
        <b>Email:</b> ${user.getEmail()}<br>
        <c:if test="${empty orders}">
            <b>Доп. информация:</b> Купленных товаров нет</p>
        </c:if>
        <button onclick="window.location.href ='/eshop?command=logout';" class="buttonQuit">
            <i class="fa fa-sign-out fa-lg" style="padding-right: 5px"></i> Выйти
        </button>
    </div>
</div>
<c:if test="${not empty orders}">
    <h4><p>История покупок:</p></h4>
    <% int orderCount = 1;%>
    <c:forEach items="${orders}" var="order">
        <p>Заказ №<%=orderCount%>/${order.getDate()}/общая стоимость ${order.getPrice()} руб.:<br>
        <div class="historyInfo">
            <c:forEach items="${order.getProducts()}" var="product">
                <div class="history">
                    <c:forEach items="${orderProductsImages}" var="image">
                        <c:if test="${product.key.getId()==image.getProductId()}">
                            <a target="_blank"
                               href="${contextPath}/eshop?command=redirect-to-product&productId=${product.key.getId()}">
                                <img src="${contextPath}/images/${image.getImagePath()}" alt="${image.getImagePath()}"
                                     width="300" height="200">
                            </a>
                        </c:if>

                    </c:forEach>
                    <div class="desc"><b>Модель:</b> ${product.key.getName()}<br>
                        <b>Количество:</b> ${product.value} шт.<br>
                        <b>Цена (1 шт.):</b> ${product.key.getPrice()} руб.<br>
                    </div>
                </div>
            </c:forEach>
        </div>
        <% orderCount++;%>
    </c:forEach>

</c:if>
</body>
</html>
