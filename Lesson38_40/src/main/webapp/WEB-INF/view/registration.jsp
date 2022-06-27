<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registration</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="resources/signStyle.css">
    <script type="text/javascript" src="resources/script.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:if test="${isNewUserAdd==true}">
    <div id="container" style="text-align: center;">
        <form id="registrationForm" method="post" action="/registration" onsubmit="return validateForm()">
            <div id="registrationLbl">
                Регистрация
            </div>
            <input id="login" type="text" placeholder="Логин" name="login" oninput="validateLogin()"><br/>
            <span id="loginError" style="display: none;">*Поле 'Логин' не заполнено!</span>
            <div id="brthDateLbl">
                <label>Дата рождения</label><br>
            </div>

            <select id="brthDays" name="brthDay">
                <c:forEach var="i" begin="1" end="31">
                    <c:if test="${i > 0 && i <= 9}">
                        <option value="0${i}">0${i}</option>
                    </c:if>
                    <c:if test="${i > 9}">
                        <option value="${i}">${i}</option>
                    </c:if>
                </c:forEach>
            </select>
            <select id="brthMonths" name="brthMonth">
                <c:forEach var="i" begin="1" end="12">
                    <c:if test="${i > 0 && i <= 9}">
                        <option value="0${i}">0${i}</option>
                    </c:if>
                    <c:if test="${i > 9}">
                        <option value="${i}">${i}</option>
                    </c:if>
                </c:forEach>
            </select>
            <select id="brthYears" name="brthYear" oninput="validateBrthday()">
                <c:forEach var="i" begin="1910" end="2022">
                    <option value="${i}">${i}</option>
                </c:forEach>
            </select>
            <span id="brthErr" style="display: none;">*Возрастное ограничение: 16 лет и старше!</span>
            <div class="form-group">
                <input id="name" type="text" placeholder="Имя" name="name" oninput="validateName()"><br/>
                <span id="nameError" style="display: none;">*Поле 'Имя' не заполнено!</span>
                <input id="surname" type="text" placeholder="Фамилия" name="surname"
                       oninput="validateSurname()"><br/>
                <span id="surnameError" style="display: none;">*Поле 'Фамилия' не заполнено!</span>
            </div>
            <input id="email" type="text" placeholder="Email" name="email" oninput="validateEmail()"><br/>
            <span id="emailError" style="display: none;">*Поле 'Email' не заполнено!</span>
            <span id="validationErr" style="display: none;">*Неверный формат email адреса!</span>
            <input id="password" type="text" placeholder="Пароль" name="password" oninput="validatePass()"><br/>
            <span id="passwordError" style="display: none;">*Поле 'Пароль' не заполнено!</span>
            <input id="repeatPswd" type="text" placeholder="Повторите пароль" name="repeatPass"
                   oninput="validateRepeatPass()"><br/>
            <span id="repeatPassError" style="display: none;">*Поле 'Повторите пароль' не заполнено!</span>
            <span id="matchingError" style="display: none;">*Пароли не совпадают!</span>
            <button id="regFormSignUpBtn" type="submit">Зарегистрироваться</button>
            <br/>
            <div style="padding-top: 16px">
                <span style="color: #777777">Есть аккаунт? </span>
                <a href="${contextPath}/login" style="cursor: pointer;color: #0000CD">Войти</a>
            </div>
        </form>
    </div>
</c:if>
<c:if test="${isNewUserAdd==false}">
    <div class="container" style="text-align: center;">
        <p>
        <h3>Пользователь с логином <u><i>${userLogin.getLogin()}</i></u> уже существует</h3>
        </p>
        <div class="btn-group" style="">
            <a href="${contextPath}/registration">
                <button type="button" class="btn btn-info">Регистрация</button>
            </a>
            <a href="${contextPath}/login">
                <button type="button" class="btn btn-primary">Авторизация</button>
            </a>
        </div>
    </div>
</c:if>
</body>
</html>
