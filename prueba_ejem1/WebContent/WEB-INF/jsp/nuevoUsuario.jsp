<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="resources/js/baller-nuevo-usuario.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Nuevo USUARIOS!!!</title>
</head>
<body>

	<form name="formularioUsuario"
		action="/prueba_ejem1/baller4ever/nuevoUsuario" method="post">
		<div id="centro1" align="center">
			Usuario: <input type="text" name="usuario"><br>
			Contraseña: <input type="password" name="password"><br>
			Nombre: <input type="text" name="nombre"><br> Apellidos:
			<input type="text" name="apellidos"><br> Dirección: <input
				type="text" name="direccion"><br> E-mail: <input
				type="text" name="email"><br>
			<!--     <input type="radio" name="sexo" value="Varón"> Varón<br> -->
			<!--     <input type="radio" name="sexo" value="Mujer"> Mujer<br> -->
			<input type="submit" value="Enviar" onclick="enviarFormulario()">
			<input type="reset">
		</div>
	</form>

</body>
</html>