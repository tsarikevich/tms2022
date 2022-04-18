<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 17.04.2022
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>About my course</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<style>body {
    background-image: url("images/yellowBackground.jpg");
    background-size: 100%;
}
</style>
<body>
<input class="btn btn-info" type="button" value="ГЛАВНАЯ СТРАНИЦА" onclick="location.href = 'index.jsp'"/>
<div class="container">
    <div style="text-align: center;"><h2>На данный момент пройдены следующие темы по курсу JAVA</h2></div>
    <ul class="list-group">
        <li class="list-group-item list-group-item-success"> 1. Система контроля версий Git</li>
        <li class="list-group-item list-group-item-success"> 2. Введение в Java</li>
        <li class="list-group-item list-group-item-success"> 3. Операторы управления</li>
        <li class="list-group-item list-group-item-success"> 4. Одномерные массивы</li>
        <li class="list-group-item list-group-item-success"> 5. Многомерные массивы</li>
        <li class="list-group-item list-group-item-success">6. ООП в Java. Классы и методы</li>
        <li class="list-group-item list-group-item-success">7. ООП в Java. Интерфейсы и абстрактные классы</li>
        <li class="list-group-item list-group-item-success"> 8. ООП в Java. Принципы</li>
        <li class="list-group-item list-group-item-success"> 9. ООП в Java. Полиморфизм и статические методы</li>
        <li class="list-group-item list-group-item-success"> 10. Обработка строк</li>
        <li class="list-group-item list-group-item-success"> 11. Исключения и ошибки</li>
        <li class="list-group-item list-group-item-success"> 12. Файлы, потоки ввода/вывода</li>
        <li class="list-group-item list-group-item-success"> 13. Коллекции и Generics</li>
        <li class="list-group-item list-group-item-success"> 14. Особенности работы с Java 8 (Часть 1)</li>
        <li class="list-group-item list-group-item-success"> 15. Особенности работы с Java 8 (Часть 2)</li>
        <li class="list-group-item list-group-item-success"> 16. Основные изменения в Java 9-12</li>
        <li class="list-group-item list-group-item-success"> 17. Регулярные выражения</li>
        <li class="list-group-item list-group-item-success"> 18. Основы работы с XML и JSON</li>
        <li class="list-group-item list-group-item-success"> 19. Определение потоков Java</li>
        <li class="list-group-item list-group-item-success"> 20. JDBC (Java DataBase Connectivity)</li>
        <li class="list-group-item list-group-item-success"> 21. Работа с интернетом и сетью</li>
        <li class="list-group-item list-group-item-success"> 22. Основы Servlet API</li>
        <li class="list-group-item list-group-item-success"> 23. Основы Servlet API. Filter, Listener, Scopes</li>
        <li class="list-group-item list-group-item-success"> 24. Введение в HTML, CSS</li>
        <li class="list-group-item list-group-item-success"> 25. Быстрое прототипирование с Bootstrap</li>
    </ul>
</div>
<div class="container">
    <div style="text-align: center;"><h2>Не пройдены следующие темы по курсу JAVA:</h2></div>
    <ul class="list-group">
        <li class="list-group-item list-group-item-danger"> 26. Основы шаблонизации с JSP</li>
        <li class="list-group-item list-group-item-danger"> 27. Стандартная библиотека тегов JSTL</li>
        <li class="list-group-item list-group-item-danger"> 28. Системы сборки проектов</li>
        <li class="list-group-item list-group-item-danger"> 29. S.O.L.I.D</li>
        <li class="list-group-item list-group-item-danger">30. Паттерны проектирования (Часть 1)</li>
        <li class="list-group-item list-group-item-danger"> 31. Паттерны проектирования (Часть 2)</li>
        <li class="list-group-item list-group-item-danger">32. Паттерны проектирования в Java Enterprise Edition</li>
        <li class="list-group-item list-group-item-danger">33. Методы класса Object</li>
        <li class="list-group-item list-group-item-danger">34. Знакомство с инструментами журналирования и тестирования
            в Java
        </li>
        <li class="list-group-item list-group-item-danger">35. Продвинутое изучение JDBC</li>
        <li class="list-group-item list-group-item-danger">36. Продвинутое изучение коллекций JDK</li>
        <li class="list-group-item list-group-item-danger">37. Spring Core. IoC</li>
        <li class="list-group-item list-group-item-danger">38. Spring Core. AOP</li>
        <li class="list-group-item list-group-item-danger">39. Spring MVC. Controller. Interceptors</li>
        <li class="list-group-item list-group-item-danger">40. Spring MVC. Bean Validation. Exception handling</li>
        <li class="list-group-item list-group-item-danger">41. Spring Boot. Starter, actuator</li>
        <li class="list-group-item list-group-item-danger">42. Spring Boot MVC. Шаблонизация</li>
        <li class="list-group-item list-group-item-danger">43. Hibernate. Object states. Hibernate Session</li>
        <li class="list-group-item list-group-item-danger">44. Hibernate. Relations. Cascades. HQL</li>
        <li class="list-group-item list-group-item-danger">45. Java Persistence API</li>
        <li class="list-group-item list-group-item-danger">46. Spring Boot. REST (Часть 1)</li>
        <li class="list-group-item list-group-item-danger">47. Spring Boot. REST (Часть 2)</li>
        <li class="list-group-item list-group-item-danger">48. REST API Documentation</li>
        <li class="list-group-item list-group-item-danger">49. Spring Data JPA</li>
        <li class="list-group-item list-group-item-danger">50. Spring Security. Basic Authentication</li>
        <li class="list-group-item list-group-item-danger">51. Spring Security. JWT</li>
        <li class="list-group-item list-group-item-danger">52. Spring Security. Практика</li>
        <li class="list-group-item list-group-item-danger">53. DevOps</li>
        <li class="list-group-item list-group-item-danger">54. Amazon: основные сервисы</li>
        <li class="list-group-item list-group-item-danger">55. Микросервисная архитектура, Docker / Docker compose</li>
        <li class="list-group-item list-group-item-danger">56. Docker (Часть 2)</li>
        <li class="list-group-item list-group-item-danger">57. Docker (Часть 3)</li>
        <li class="list-group-item list-group-item-danger">58. Закрепление пройденного материала</li>
        <li class="list-group-item list-group-item-danger">59. Онлайн-тренинг "Трудоустройство в IT"</li>
        <li class="list-group-item list-group-item-danger">60. Защита дипломного проекта</li>
    </ul>
</div>
<br><input class="btn btn-info btn-lg btn-block" type="button"
           value="Кликните, чтобы узнать более подробную информацию о курсах" title="TeachMeSkills.by"
           onclick="location.href = 'https://teachmeskills.by/kursy-programmirovaniya/obuchenie-java-online'"/>
</body>
</html>
