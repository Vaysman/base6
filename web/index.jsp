<%@ page import="db.model.House" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Список</title>
</head>
<body>
<h1>House</h1>
<br />
<% pageContext.getAttribute("house"); %>
<br />
<table>
    <c:forEach var="houseDAO" items="${house}">
        <tr>
            <td>${house.getAdress}</td>
            <td>${house.getID}</td>
            <td>${house.getRoom_count}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>