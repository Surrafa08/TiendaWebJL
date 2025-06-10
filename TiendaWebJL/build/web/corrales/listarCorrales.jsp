<%@ page import="java.util.List" %>
<%@ page import="modelo.Corral" %>
<%@ page import="modelo.CorralDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de Corrales</title>
</head>
<body>
<h1>Corrales Registrados</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Ubicación</th>
    </tr>

    <%
        CorralDAO dao = new CorralDAO();
        List<Corral> lista = dao.listarCorrales();

        for (Corral c : lista) {
    %>
    <tr>
        <td><%= c.getId() %></td>
        <td><%= c.getNombre() %></td>
        <td><%= c.getUbicacion() %></td>
    </tr>
    <%
        }
    %>
</table>

<a href="../index.jsp">Volver al inicio</a>
</body>
</html>
