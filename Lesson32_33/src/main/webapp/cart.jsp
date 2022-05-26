<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<ul>
    <li><a class="active" href='eshop?command=start_page'><i class="fa fa-fw fa-home"></i> Главная</a></li>
    <li style="float:right"><a href='eshop?command=redirect-to-shopping-cart'><i class="fa fa-fw fa-shopping-cart"></i>
        Корзина</a></li>
    <li style="float:right"><a href='eshop?command=redirect-to-profile'><i class="fa fa-fw fa-user"></i>
        Пользователь</a></li>
</ul>
<h2 style="padding-top: 16px">Ваша корзина</h2>
<c:if test="${not empty cartProductsList}">
    <c:forEach items="${cartProductsList}" var="myProduct">
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
                    <a href="${contextPath}/eshop?command=move-product&productId=${myProduct.getId()}&action=deleteProduct">
                        <button class="buttonDelete" type="submit"><i
                                class="fa fa-minus-square fa-lg" style="padding-right: 5px"></i>Удалить
                        </button>
                    </a>
                </div>
            </div>
        </div>
        <br>
    </c:forEach>
    <h5><p><b class="font-italic">Общая стоимость товаров в корзине:</b> ${totalCost} руб.</p></h5>
    <a style="text-decoration: none" href="${contextPath}/eshop?command=checkout-from-cart">
        <button type="submit" class="buttonOrder"><i
                class="fa fa-check-square-o fa-lg" style="padding-right: 5px"></i> Оформить заказ
        </button>
    </a>
</c:if>
<c:if test="${empty cartProductsList}">
    <h3><p class="text-center">В корзине нет товаров</p></h3>
</c:if>
</body>
</html>
