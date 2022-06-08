<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
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
    <li style="float:right"><a href='eshop?command=redirect-to-search'><i class="fa fa-fw fa-search"></i>
        Поиск</a></li>

</ul>
<h2 style="padding-top: 16px">Popular categories</h2>
<div class="container-fluid">
    <c:if test="${not empty categories}">
        <div class="row">
            <c:forEach items="${categories}" var="category">
                <div class="card w-25 m-1" type="category">
                    <div class="card-body">
                            ${category.getName()}
                        <c:forEach items="${categoriesImages}" var="image">
                            <c:if test="${category.getId()==image.getCategoryId()}">
                                <a href="${contextPath}/eshop?command=category-redirect&categoryId=${category.getId()}&nameCategory=${category.getName()}">
                                    <img class="card-img"
                                         style="width:150px;height:120px"
                                         src="${contextPath}/images/${image.getImagePath()}"
                                         alt="Card image"></a>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>

            </c:forEach>
        </div>
    </c:if>
</div>
</div>
</body>
</html>

