<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 28.07.2023
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Servlet.EntranceServlet" %>
<%@ page import="Entity.Entrance" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<style>

    .page__body {
        margin: auto;
        width: 800px;

    }

    .columns {
        display: grid;
        /*column-count: 3;*/
        /*grid-column: 3;*/
        grid-template-columns: 1fr 1fr 1fr;
        column-gap: 20px;

    }

</style>

<head>
    <title>Вибір персонажа</title>
</head>
<body class="page__body">

<p>
<h2>Виберіть собі персонажа ${entrance.name}</h2></p>
<div class="columns">
    <form action="/CharacterSelectionTankServlet" method="GET">
        <div class="tank">
            <p>
            <h2>Клас персонажа</h2></p>
            <p><b><h2>ТАНК</h2></b></p>
            <p><b><h3>Одиниці життя ${hpTank}</h3></b></p>
            <p><b><h3>Одиниці пошкодження 3</h3></b></p>
            <p><b><h3>Одиниці захисту 4</h3></b></p>
            <p><input type="submit" name="tankSubmit" value="Вхід"></p>
        </div>
    </form>

    <form action="/CharacterSelectionDodgerServlet" method="get">
        <div class="dodger">
            <p>
            <h2>Клас персонажа</h2></p>
            <p><b><h2>ЛОВКАЧ</h2></b></p>
            <p><b><h3>Одиниці життя 15</h3></b></p>
            <p><b><h3>Одиниці пошкодження 4</h3></b></p>
            <p><b><h3>Одиниці захисту 3</h3></b></p>
            <p><input type="submit" name="dodgerSubmit" value="Вхід"></p>
        </div>
    </form>

    <form action="/CharacterSelectionStrongmanServlet" method="get">
        <div class="strongman">
            <p>
            <h2>Клас персонажа</h2></p>
            <p><b><h2>СИЛАЧ</h2></b></p>
            <p><b><h3>Одиниці життя 12</h3></b></p>
            <p><b><h3>Одиниці пошкодження 5</h3></b></p>
            <p><b><h3>Одиниці захисту 2</h3></b></p>
            <p><input type="submit" name="strongmanSubmit" value="Вхід"></p>
        </div>
    </form>

</div>


</body>
</html>
