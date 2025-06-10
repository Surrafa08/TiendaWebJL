<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar Corral</title>
</head>
<body>
    <h2>Registrar Corral</h2>

    <% if (request.getAttribute("mensaje") != null) { %>
        <p style="color:green;"><%= request.getAttribute("mensaje") %></p>
    <% } %>

    <form action="${pageContext.request.contextPath}/ControladorCorral" method="post">
        <input type="hidden" name="accion" value="registrarCorral" />

        <label>Nombre del Corral:</label><br/>
        <input type="text" name="nombreCorral" required><br/><br/>

        <label>Tipo de Animal:</label><br/>
        <input type="text" name="tipoAnimal" required><br/><br/>

        <input type="submit" value="Registrar Corral">
    </form>

    <br/>
    <a href="${pageContext.request.contextPath}/index.jsp">Volver al inicio</a>
</body>
</html>
