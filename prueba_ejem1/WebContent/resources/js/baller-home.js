/**
 * 
 */ 

$(document).ready(function() {
      $("#fAcceso").validate({
        rules: {
          nombre: { required: true }
        }
      });
 });
      
function enviar(){
	// desarrolar JSP enviar()
}
function nuevoUsuario(){
	document.forms["nuevo"].submit();

}

function entrarBaller(){
	
	alert("Comprobando usuario/pass...");
	document.forms["fAcceso"].submit();
}