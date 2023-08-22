<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 08.08.2023
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Entity.Entrance" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<style>

    .page__body{
        margin: auto;
        width: 800px;

    }
</style>
<head>
    <title>Гравець, та його дані</title>
</head>
<body class="page__body">
<form action="UsersServlet" method="GET">
    <div class="users">
        <p>
        <h2>Клас персонажа</h2></p>
        <p><b><h2>${entrance.name}</h2></b></p>
        <p><b><h3>Одиниці життя ${entrance.hp}</h3></b></p>
        <p><b><h3>Одиниці пошкодження ${entrance.damage}</h3></b></p>
        <p><b><h3>Одиниці захисту ${entrance.protection}</h3></b></p>
        <p><input type="submit" name="tankSubmit" value="Вхід"></p>
    </div>
</form>
</body>
</html>
