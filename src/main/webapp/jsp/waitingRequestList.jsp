<%--
  Created by IntelliJ IDEA.
  User: Мишаня
  Date: 09.02.2023
  Time: 19:49
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
</head>
<body>
<div class="waitingRequestList">
  <div class="waitingRequestList-container px-5">
    <div class="waitingRequestList-inner">
      <div class="waitingRequestList-title title">Список ожидающих заявок</div>
      <br>
      <a href="/port/approveRequest" class="submit">Одобрить заявку</a>
      <a href="/port/rejectRequest" class="submit">Отклонить заявку</a>
      <a href="/port/dispatcherProfile" class="submit">В меню</a><br><br>
      <table class="table">
        <thead>
        <tr>
          <th>ID</th>
          <th>ID Капитана</th>
          <th>Время</th>
          <th>Статус</th>
          <th>Тип</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="waitingRequest" items="${waitingRequest}">
          <tr>
            <td>${waitingRequest.getId()}</td>
            <td>${waitingRequest.getCaptainId()}</td>
            <td>${waitingRequest.getDatetime()}</td>
            <td>${waitingRequest.getStatus()}</td>
            <td>${waitingRequest.getType()}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>
</div>
</body>
</html>

