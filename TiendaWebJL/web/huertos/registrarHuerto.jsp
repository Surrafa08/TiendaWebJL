<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar Huerto</title>
</head>
<body>
    <h2>Registrar Huerto</h2>
    
    <% if (request.getAttribute("mensaje") != null) { %>
    <p style="color:green;"><%= request.getAttribute("mensaje") %></p>
    <% } %>

    <form action="../Controlador" method="post">
        <input type="hidden" name="accion" value="registrarHuerto" />

        <label>Nombre del Huerto:</label><br/>
        <input type="text" name="nombreHuerto" required><br/><br/>

        <label>Ubicación:</label><br/>
        <input type="text" name="ubicacionHuerto" required><br/><br/>

        <input type="submit" value="Registrar Huerto">
    </form>

    <br/>
    <a href="../index.jsp">Volver al inicio</a>
</body>
</html>
