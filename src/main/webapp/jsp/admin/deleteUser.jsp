<%--
  Created by IntelliJ IDEA.
  User: Мишаня
  Date: 08.02.2023
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru-RU"><head><meta charset="UTF-8">
<html>
<head>
    <title>Добавление пользователя</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="auth-container">
    <img src="../../images/logo.png">
    <form name = "AddUserForm" method="POST" action = "deleteUser">
        <div class="input"><br>
            <p><select name="user_role">
                <option value="CAPTAIN">Капитан</option>
                <option value="DISPATCHER">Диспетчер</option>
                <option value="ADMIN">Администратор</option>
            </select></p>
            <input type="text" name="user_id" placeholder="ID пользователя"><br>

            <button class="submit">Удалить данного пользователя</button>
        </div><br>

    </form>
</div>
</body>
</html>
