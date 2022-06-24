<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
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
    <li><a class="active" href='/home'><i class="fa fa-fw fa-home"></i> Главная</a></li>
    <li style="float:right"><a href='/cart'><i class="fa fa-fw fa-shopping-cart"></i>
        Корзина</a></li>
    <li style="float:right"><a href='/profile'><i class="fa fa-fw fa-user"></i>
        Пользователь</a></li>
    <li style="float:right"><a href='/search'><i class="fa fa-fw fa-search"></i>
        Поиск</a></li>
</ul>
<div class="container-fluid">
    <form id="searchLbl" method="post" action="/search">
        <input id="inpSearchLbl" type="search" placeholder="Поиск.." name="search">
        <button class="buttonSearch" id="btnSearchLbl" name="command" value="redirect-to-search" type="submit"><i
                class="fa fa-search"></i></button>
    </form>
    <c:if test="${not empty foundProducts}">
    <h3><p class="text-center">Найденные продукты по вашему запросу:</p></h3>
    <c:forEach items="${foundProducts}" var="product">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-1" style="background-color:white;">
                    <c:forEach items="${foundImages}" var="image">
                        <c:if test="${product.getId()==image.getProductId()}">
                            <a href="${contextPath}/eshop?command=redirect-to-product&productId=${product.getId()}">
                                <img src="${contextPath}/images/${image.getImagePath()}"
                                     alt="${image.getImagePath()}" class="responsive"></a>
                        </c:if>
                    </c:forEach>
                </div>
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
<c:if test="${empty foundProducts}">
    <h3><p class="text-center">Введите новый запрос</p></h3>
</c:if>
</body>
</html>


