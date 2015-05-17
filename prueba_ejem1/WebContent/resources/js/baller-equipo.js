/**
 * 
 */
function crearEquipo(){
	//deberiamos guardar el idUsuario
	document.forms["fAccion"].action = document.forms["fAccion"].action + "nuevoEquipo";
	document.forms["fAccion"].submit();
}
function verEquipo(){
	//deberiamos guardar el idUsuario
	document.forms["fAccion"].action = document.forms["fAccion"].action + "equipo";
	document.forms["fAccion"].submit();
}
