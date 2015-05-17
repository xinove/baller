<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 	<script type="text/javascript" src="resources/js/jquery-1.7.1.min.js"></script> -->
	<script type="text/javascript" src="../resources/js/jquery.validate.min.js"></script>
	
	<script type="text/javascript" src="../resources/js/baller-nuevo-equipo.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Nuevo Equipoo!!!</title>
</head>
<body>

	<form name="fEquipo"
		action="/prueba_ejem1/baller4ever/nuevoEquipo" method="POST">
		<div id="centro1" align="center">
			<label for="usuario">Id Usuario: ${equipo.idUsuarioFk} </label>
			<br>
			Nombre del equipo: <input type="text" name="nombre"><br>
			Nombre del pabellon: <input type="text" name="estadio"><br>
			<input type="submit" value="Crear Equipo" onclick="enviarFormulario()">
			<input type="reset">
		</div>
	</form>

</body>
</html>