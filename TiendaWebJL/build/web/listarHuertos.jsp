<%@page import="modelo.Huerto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Huertos</title>
</head>
<body>
    <h1>Huertos Registrados</h1>

    <table border="1">
        <tr>
            <th>Nombre</th>
            <th>Ubicación</th>
        </tr>
        <%
            List<Huerto> huertos = (List<Huerto>) request.getAttribute("listaHuertos");
            if (huertos != null) {
                for (Huerto h : huertos) {
        %>
        <tr>
            <td><%= h.getNombre() %></td>
            <td><%= h.getUbicacion() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="2">No hay huertos registrados</td>
        </tr>
        <% } %>
    </table>

    <br>
    <a href="index.jsp">Volver al inicio</a>
</body>
</html>
