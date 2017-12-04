<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="db.model.house" %>
<html>
<head>
    <title>Список фильмов</title>
</head>
<body>
<h1>Список фильмов</h1>
<table>
    <%
        for (house house : (List<house>) response.getWriter()) {
    %>
    <tr>
        <td>
            <%=String.format("<a href='/film?id=%d'>%s</a>", house.getId(), house.getAdress())%>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>