<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.rsreu.port.entity.enums.Roles" %>
<html>
<head>
    <title>Список пользователей</title>
    <link rel="stylesheet" href="https://unpkg.com/flowbite@1.5.5/dist/flowbite.min.css"/>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200"/>
    <style>
        <%@include file="../css/style.css" %>
    </style>
    <script
            src="https://code.jquery.com/jquery-3.6.3.min.js"
            integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
            crossorigin="anonymous">
    </script>
</head>
<body>
<div class="userList">
    <div class="userList-container px-5">
        <div class="userList-inner">
            <div class="userList-title title">Список пользователей</div>
            <br>
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Имя</th>
                    <th>Роль в системе</th>
                    <th>Логин</th>
                    <th>Пароль</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.getUserId()}</td>
                    <td>${user.getName()}</td>
                    <td>${user.getUserRole().getRussianName()}</td>
                    <td>${user.getLogin()}</td>
                    <td>${user.getPassword()}</td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <a href="/port/changeUser" class="submit">Изменить</a>
    <a href="/port/deleteUser" class="submit">Удалить</a>
</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>
</body>
</html>
