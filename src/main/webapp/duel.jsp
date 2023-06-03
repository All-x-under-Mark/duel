<%@ page import="Entity.Personage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<style>

    .page__body {
        margin: auto;
        width: 800px;

    }

    .columns {
        display: grid;
        grid-template-columns: 1fr 1fr;
        column-gap: 20px;
    }
</style>


<head>
    <title>Дуель</title>
</head>
<body class="page__body">
<h2>Дуель</h2>
<form action="ServletDuel" method="GET">
    <h2><p>Гравець <b>${personageOne.name}</b></p></h2>
    <%--  Як ще можна Записати дані в інпут--%>
    <%--    <p>Одиниці життя <b><input type="text" name="hp_player_one" value="${personageOne.hp}"></b>--%>


    <p>Одиниці життя <b>${personageOne.hp}</b> Одиниці атаки <b>${personageOne.damage}</b> Одиниці захисту
        <b>${personageOne.protection}</b></p>

    <div class="columns">
        <div class="columns_item">
            <p>
            <h2>Захищаємо</h2></p>
            <p><b>Голова</b></p>
            <select name="head_player_one_defense">

                <option value="true">Захищати</option>
                <option value="false">Не захищати</option>
            </select>
            <br>


            <p><b>Тулуб</b></p>
            <select name="torso_player_one_defense">

                <option value="true">Захищати</option>
                <option value="false">Не захищати</option>
            </select>
            <br>


            <p><b>Ноги</b></p>
            <select name="legs_player_one_defense">

                <option value="true">Захищати</option>
                <option value="false">Не захищати</option>
            </select>

            <p><b>${personageOne.message}</b></p>
        </div>



        <div class="columns_item">
            <p>
            <h2>Атакуємо</h2></p>
            <p><b>Голова</b></p>
            <select name="head_player_one_attack">

                <option value="true">Атакувати</option>
                <option value="false">Не атакувати</option>
            </select>
            <br>


            <p><b>Тулуб</b></p>
            <select name="torso_player_one_attack">

                <option value="true">Атакувати</option>
                <option value="false">Не Атакувати</option>
            </select>
            <br>


            <p><b>Ноги</b></p>
            <select name="legs_player_one_attack">

                <option value="true">Атакувати</option>
                <option value="false">Не атакувати</option>
            </select>
        </div>
    </div>

    <br><br><br>


    <p>
    <h2>Гравець <b>${personageTwo.name}</b></h2></p>
    <p>Одиниці життя <b>${personageTwo.hp}</b> Одиниці атаки <b>${personageTwo.damage}</b> Одиниці захисту
        <b>${personageTwo.protection}</b></p>
    <div class="columns">
        <div class="columns_item">
            <p>
            <h2>Захищаємо</h2></p>
            <p><b>Голова</b></p>
            <select name="head_player_two_defense">

                <option value="true">Захищати</option>
                <option value="false">Не захищати</option>
            </select>
            <br>


            <p><b>Тулуб</b></p>
            <select name="torso_player_two_defense">

                <option value="true">Захищати</option>
                <option value="false">Не захищати</option>

            </select>
            <br>

            <p><b>Ноги</b></p>
            <select name="legs_player_two_defense">

                <option value="true">Захищати</option>
                <option value="false">Не захищати</option>
            </select>

            <p><b>${personageTwo.message}</b></p>
        </div>



        <div class="columns_item">
            <p>
            <h2>Атакуємо</h2></p>
            <p><b>Голова</b></p>
            <select name="head_player_two_attack">

                <option value="true">Атакувати</option>
                <option value="false">Не атакувати</option>
            </select>
            <br>


            <p><b>Тулуб</b></p>
            <select name="torso_player_two_attack">

                <option value="true">Атакувати</option>
                <option value="false">Не Атакувати</option>
            </select>
            <br>


            <p><b>Ноги</b></p>
            <select name="legs_player_two_attack">

                <option value="true">Атакувати</option>
                <option value="false">Не атакувати</option>
            </select>
        </div>

    </div>
    <br><br><br>
    <p><b>${personageOne.message}</b></p>
    <p><b>${personageTwo.message}</b></p>



    <input type="submit" value="Раунд">
</form>
</body>
</html>
