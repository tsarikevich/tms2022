<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="resources/style.css" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<style>
    <%@include file='resources/style.css' %>
</style>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<ul>
    <li><a class="active" href='home'><i class="fa fa-fw fa-home"></i> Главная</a></li>
    <li style="float:right"><a href='cart'><i class="fa fa-fw fa-shopping-cart"></i> Корзина</a></li>
    <li style="float:right"><a href='profile'><i class="fa fa-fw fa-user"></i> Пользователь</a></li>
</ul>
<br>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:if test="${not empty oneProduct}">
    <div class="container-fluid">
        <h2 class="text-center">${oneProduct.getName()}</h2><br>

        <img class="mx-auto d-block" style="height:auto; max-width: 400px;"
             src="${contextPath}/images/${oneProduct.getImageName()}"
             alt="${oneProduct.getImageName()}">

        <br>
        <div class="container">
            <h2>Информация о продукте:</h2>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th class="text-center" style="vertical-align: middle">Описание</th>
                    <th class="text-center" style="vertical-align: middle">Цена, руб.</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${oneProduct.getDescription()}</td>
                    <td class="text-center" style="vertical-align: middle">${oneProduct.getPrice()}</td>
                </tr>
                </tbody>
            </table>
        </div>
        <br>
        <form method="post" action="${pageContext.request.contextPath}/cart">
            <input type="hidden" value="${oneProduct.getId()}" name="id"/>
            <input type="hidden" value="${oneProduct.getImageName()}" name="imageName"/>
            <input type="hidden" value="${oneProduct.getName()}" name="name"/>
            <input type="hidden" value="${oneProduct.getDescription()}" name="description"/>
            <input type="hidden" value="${oneProduct.getPrice()}" name="price"/>
            <input type="hidden" value="${oneProduct.getCategory_id()}" name="categoryId"/>
            <button type="submit" value="Купить" name="action" class="buttonAddProduct"><i
                    class="fa fa-cart-plus fa-lg"></i> Купить
            </button>
            <br>
        </form>
    </div>
</c:if>
</body>
</html>
