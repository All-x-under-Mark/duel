<%@ page import="Entity.Personage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<style>

    .page__body{
        margin: auto;
        width: 800px;

    }
    </style>


<head>
    <title>Старт</title>
</head>
<body class="page__body">
<h2>Виберіть персонажа</h2>
<form action="BeginningServlet" method="GET">
    <p><label><h3>Напишіть ім'я першого гравця</h3></label> <input type="text" name="name_player_one"></p><br>
    <p><label>Виберіть кількість НР</label>
        <select name="hp_player_one">

            <option value="10">10</option>
            <option value="12">12</option>
            <option value="15">15</option>
        </select>
    </p> <br>

    <p><label>Виберіть значення шкоди</label>
        <select name="damage_player_one">

            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
        </select>
    </p> <br>

    <p><label>Виберіть значення захисту</label>
        <select name="protection_player_one">

            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
        </select>
    </p>

    <br><br><br>


    <p><label><h3>Напишіть ім'я другого гравця</h3></label> <input type="text" name="name_player_two"></p><br>
    <p><label>Виберіть кількість НР</label>
        <select name="hp_player_two">

            <option value="10">10</option>
            <option value="12">12</option>
            <option value="15">15</option>
        </select>
    </p><br>

    <p><label>Виберіть значення шкоди</label>
        <select name="damage_player_two">

            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
        </select>
    </p><br>

    <p><label>Виберіть значення захисту</label>
        <select name="protection_player_two">

            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
        </select>
    </p> <br><br>

    <input type="submit" value = "Старт">
</form>


</body>

</html>