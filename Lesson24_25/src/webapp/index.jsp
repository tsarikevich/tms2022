<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 17.04.2022
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My website</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<style>body {
    background-image: url("images/mainBackground.jpg");
    background-size: 100%;
}
</style>
<body>
<div class="container">
    <h2 class="text-danger">Добро пожаловать на мой сайт!</h2>
    <p></p>
    <div class="card" style="width:400px">
        <img class="card-img-top" src="images/photo.png" alt="Card image" style="width:100%">
        <div class="card-body">
            <i><h4 class="text-primary">Меня зовут Максим</h4></i>
            <p class="text">Я обучаюсь программированию на языке Java</p>
            <input class="btn btn-primary" type="button" value="Информация о обучении"
                   onclick="location.href = 'info'"/>
        </div>
        <input class="btn btn-secondary" type="button" value="Дополнительная информация обо мне"
               onclick="location.href = 'add_info'"/>
    </div>
</div>
</body>

