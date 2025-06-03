<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>TiendaWebJL</title>
</head>
<body>

    <h1>Bienvenido a TiendaWebJL</h1>
    <p>Proyecto de control de producción agrícola</p>

    <p><a href="Controlador">Ir al Servlet</a></p>
    <a href="Controlador?accion=listar">Ver lista de huertos</a>


    <hr>

    <h2>Formulario de Registro de Producto</h2>
    <form action="Controlador" method="post">
        <label for="nombre">Ingrese su nombre:</label><br>
        <input type="text" id="nombre" name="nombre"><br><br>

        <label for="producto">Producto:</label><br>
        <input type="text" id="producto" name="producto"><br><br>

        <input type="submit" value="Enviar">
    </form>

</body>
</html>
