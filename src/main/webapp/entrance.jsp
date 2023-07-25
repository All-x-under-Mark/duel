<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<style>

    .page__body {
        margin: auto;
        width: 800px;

    }

</style>


<head>
    <title>Вхід</title>
</head>
<body class="page__body">
<h2>Вхід</h2>
<form action="EntranceServlet" method="GET">
   <p><label><h3>Назвіться</h3> </label></p>
    <p><input type="text" name="name"></p>
    <p><label><h3>Пароль</h3></label></p>
    <p><input type="text" name="pass"></p>
    <p><input type="submit" value="Вхід"></p>
</form>

</body>
</html>
