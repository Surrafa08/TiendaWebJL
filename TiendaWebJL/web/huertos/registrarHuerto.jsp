<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar Huerto</title>
</head>
<body>
    <h2>Registrar Huerto</h2>
    <form action="../Controlador" method="post">
        <input type="hidden" name="accion" value="registrarHuerto" />
        <label>Nombre del Huerto:</label><br/>
        <input type="text" name="nombreHuerto" required><br/><br/>
        <label>Ubicación:</label><br/>
        <input type="text" name="ubicacionHuerto" required><br/><br/>
        <input type="submit" value="Registrar">
    </form>
</body>
</html>
