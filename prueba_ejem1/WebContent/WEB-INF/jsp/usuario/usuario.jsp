<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- 	<script type="text/javascript" src="../resources/js/jquery-1.7.1.min.js"></script> -->
	<script type="text/javascript" src="../resources/js/jquery.validate.min.js"></script>
	
	<script type="text/javascript" src="../resources/js/baller-usuario.js"></script>
   
<title>VER USUARIO!!!</title>
</head>
<body>
	<form name="fAccion" action="/prueba_ejem1/baller4ever/nuevoEquipo" method="GET">
		<label for="usuario">Id Usuario: ${usuario.idUsuario} ></label>
		<input type="hidden" name="idUsuarioFk" value="${usuario.idUsuario}" />
		<input type="submit" value="Crear Nuevo equipo" onclick="crearEquipo()" />
	</form>

</body>
</html>