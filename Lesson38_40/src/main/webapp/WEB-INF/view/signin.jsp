<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login form</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="resources/signStyle.css" type="text/css">
    <script type="text/javascript" src="resources/script.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div id="container" style="text-align: center;">
    <form id="signinForm" method="post" action="/login">
        <div id="signinLbl">
            Авторизация
        </div>
        <input id="login" type="text" placeholder="Логин" name="login" oninput="validateLogin()"
               onsubmit="return validateForm()"><br/>
        <span id="loginError" style="display: none;">*Поле 'Логин' не заполнено!</span>
        <input id="password" type="text" placeholder="Пароль" name="password" oninput="validatePass()"><br/>
        <span id="passwordError" style="display: none;">*Поле 'Пароль' не заполнено!</span>
        <a href="${contextPath}/registration">
            <button id="signinBtn" type="submit">Войти</button>
        </a>
        <br/>
        <div style="padding-top: 16px">
            <span style="color: #777777">Нет аккаунта?</span>
            <a href="${contextPath}/registration" style="cursor: pointer;color: #0000CD">Зарегистрироваться</a>
        </div>
    </form>
</div>
</body>
</html>

