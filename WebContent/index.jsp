<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" src="resources/js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.validate.min.js"></script>
	
	<script type="text/javascript" src="resources/js/baller-home.js"></script>
	
	<title>Baller4Ever!!!</title>
</head>
<body>

	<form name="fAcceso" action="/prueba_ejem1/baller4ever/home" method="post">
		Usuario: 	<input type="text" name="usuario" /> 
		Contraseña: <input type="password" name="password" />
		
		<input type="submit" value="Entrar" onclick="entrarBaller()" />
	</form>

	<form name="nuevo" action="/prueba_ejem1/baller4ever/nuevoUsuario"
		method="get">
		<input type="submit" value="Nuevo Usuario" onclick="nuevoUsuario()" />
	</form>

</body>
</html>