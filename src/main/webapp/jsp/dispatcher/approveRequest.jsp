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
    <title>Одобрение заявки</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="auth-container">
    <img src="../../images/logo.png">
    <form name = "ApproveRequestForm" method="POST" action = "approveRequest">
        <div class="input"><br>
            <input type="text" name="id" placeholder="ID заявки"><br>
            <label>Причал: </label>
            <div class="w-full flex items-center justify-center space-x-2">
                <p><select name="idPier">
                    <option value="0">-</option>
                    <option value="1">№1</option>
                    <option value="2">№2</option>
                    <option value="3">№3</option>
                    <option value="4">№4</option>
                    <option value="5">№5</option>
                </select></p>
            </div><br>
            <button class="submit">Одобрить заявку</button>
        </div>
    </form>
</div>
</body>
</html>
