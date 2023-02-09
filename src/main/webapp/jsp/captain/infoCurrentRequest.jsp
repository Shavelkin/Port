<%--
  Created by IntelliJ IDEA.
  User: Мишаня
  Date: 09.02.2023
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Текущая заявка</title>
    <style>
        <%@include file="../../css/style.css" %>
    </style>
    <link rel="stylesheet" href="https://unpkg.com/flowbite@1.5.5/dist/flowbite.min.css"/>
</head>
<body>
<div>
    <nav class="bg-white border-gray-200 px-2 py-2.5 rounded">
        <div class="container flex flex-wrap flex-col items-center justify-between mx-auto">
            <a class="flex items-center mb-2">
                <img src="../../images/logo.png" class="h-6 mr-3"/>
                <span class="self-center text-xl font-semibold whitespace-nowrap">Сетевая информационная система "Порт"</span>
            </a>
            <ul class="flex item-center space-x-1 p-1 mt-4 border border-gray-100 rounded-lg bg-gray-50">
                <form name = "InfoCurrentRequestForm" method="POST" action = "infoCurrentRequest">

                    <label>Займите/освободите ${captainRequest.pierId} пирс</label><br>
                    <label>Время заявки: ${captainRequest.datetime}</label><br>
                    <label>Статус: ${captainRequest.status}</label><br>
                    <label>Тип заявки: ${captainRequest.type}</label><br>

                    <button class="submit">Подтвердить приплытие/отплытие</button>
                    <button class="submit">Отменить заявку</button>
                </form>
            </ul>
        </div>
    </nav>
</div>
</body>
</html>
