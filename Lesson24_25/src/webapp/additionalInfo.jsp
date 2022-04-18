<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 18.04.2022
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<style>body {
    background-image: url("images/footballBackground.jpg");
    background-size: 100%;
}

</style>
<body>
<input class="btn btn-info" type="button" value="ГЛАВНАЯ СТРАНИЦА" onclick="location.href = 'index.jsp'"/>
<div style="text-align: center;"><p class="text-danger">
    <h1 style="color:#008000">ФУТБОЛ - одно из моих увлечений</h1></div>
</p>
<div div style="text-align: center;" class="container">
    <a href="#demo" class="btn btn-primary" data-toggle="collapse">Кликните, чтобы узнать мой любимый футбольный
        клуб</a>
    <div id="demo" class="collapse">
        <img src="images/realMadrid.jpg" alt="realmadrid">
        <div class="centered"><h1 style="color:#FFFAFA">РЕАЛ МАДРИД (ИСПАНИЯ)</h1></div>
    </div>
</div>
</body>
</html>
