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
    <script>
        function orderCompletedMsg() {
            window.confirm("Заказ успешно оформлен!");
        }
    </script>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<ul>
    <li><a class="active" href='/home'><i class="fa fa-fw fa-home"></i> Главная</a></li>
    <li style="float:right"><a href='/cart'><i class="fa fa-fw fa-shopping-cart"></i>
        Корзина</a></li>
    <li style="float:right"><a href='/profile'><i class="fa fa-fw fa-user"></i>
        Пользователь</a></li>
    <li style="float:right"><a href='/search'><i class="fa fa-fw fa-search"></i>
        Поиск</a></li>
</ul>
<h2 style="padding-top: 16px">Ваша корзина</h2>
<c:if test="${not empty cartProductsList}">
    <c:forEach items="${cartProductsList}" var="myProduct">
        <div class="container-fluid">
            <div class="row">
                <div class="col" style="background-color:white;height: auto;max-width: 200px">
                    <c:forEach items="${cartProductsImages}" var="image">
                        <c:if test="${myProduct.key.getId()==image.getProductId()}">
                            <img src="${contextPath}/images/${image.getImagePath()}"
                                 alt="${image.getImagePath()}" class="mx-auto d-block"
                                 style="max-height: 100px;width: auto">
                        </c:if>
                    </c:forEach>
                </div>
                <div class="col" style="background-color:white;">
                    <p><b class="font-italic">Модель:</b> ${myProduct.key.getName()}</p>
                    <p><b class="font-italic">Описание:</b> ${myProduct.key.getDescription()}</p>
                    <p><b class="font-italic">Цена:</b> ${myProduct.key.getPrice()} руб.</p>
                        <%--                    <c:forEach items="${cart.getNumbersProducts()}" var="number">--%>
                        <%--                                                <c:if test="${myProduct.getId()==number.key}">--%>
                    <p><b class="font-italic">Количество:</b> ${myProduct.value} шт.</p>
                        <%--                        </c:if>--%>
                        <%--                    </c:forEach>--%>
                    <a href="${contextPath}/cart/delete?productId=${myProduct.key.getId()}">
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
    <a style="text-decoration: none" href="${contextPath}/cart/checkout"
       onclick="orderCompletedMsg()">
        <button type="submit" class="buttonOrder"><i
                class="fa fa-check-square-o fa-lg" style="padding-right: 5px"></i>
            Оформить заказ
        </button>
    </a>
</c:if>
<c:if test="${empty cartProductsList}">
    <h3><p class="text-center">В корзине нет товаров</p></h3>
</c:if>
</body>
</html>
