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
    <form name = "RejectRequestForm" method="POST" action = "rejectRequest">
        <div class="input"><br>
            <input type="text" name="id" placeholder="ID заявки"><br>
            <button class="submit">Отклонить заявку</button>
        </div>
    </form>
</div>
</body>
</html>
