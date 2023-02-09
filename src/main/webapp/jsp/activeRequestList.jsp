<%--
  Created by IntelliJ IDEA.
  User: Мишаня
  Date: 09.02.2023
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
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
<div class="activeRequestList">
    <div class="activeRequestList-container px-5">
        <div class="activeRequestList-inner">
            <div class="activeRequestList-title title">Список активных заявок</div>
            <br>
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>ID Капитана</th>
                    <th>Номер пирса</th>
                    <th>Время</th>
                    <th>Статус</th>
                    <th>Тип</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="activeRequest" items="${activeRequest}">
                    <tr>
                        <td>${activeRequest.getId()}</td>
                        <td>${activeRequest.getCaptainId()}</td>
                        <td>${activeRequest.getPierId()}</td>
                        <td>${activeRequest.getDatetime()}</td>
                        <td>${activeRequest.getStatus()}</td>
                        <td>${activeRequest.getType()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>
</body>
</html>


