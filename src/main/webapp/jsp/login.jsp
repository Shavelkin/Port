<%--
  Created by IntelliJ IDEA.
  User: Мишаня
  Date: 23.01.2023
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
</head>
<body>
<div class="auth-container">
    <form name = "LoginForm" method="POST" action = "login">
        <div class="input">
            <p style="text-align:center">
                <input type="text" name="login" placeholder="Введите логин"><br><br>
                <input type="password" name="password" placeholder="Введите пароль">
            </p>
        </div><br>
        <p style="text-align:center"> <button class="submit">Войти</button></p>
    </form>

</div>
</body>
</html>