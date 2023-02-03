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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="auth-container">
    <img src="../../images/logo.png">
    <form name = "LoginForm" method="POST" action = "login">
        <div class="input"><br>
                <input type="text" name="login" placeholder="Введите логин"><br>
                <input type="password" name="password" placeholder="Введите пароль">
        </div><br>
        <button class="submit">Войти</button>
    </form>

</div>
</body>
</html>