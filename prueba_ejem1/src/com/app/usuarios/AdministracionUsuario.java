package com.app.usuarios;

import modelos.Usuarios;

public interface AdministracionUsuario {
	
	//public void AdministracionUsuarioImpl();
	
	public Usuarios insertarUsuario(Usuarios us);
	
	public boolean existeUsuario(Usuarios us);
	
	public Usuarios getUsuario(Usuarios us);

	public Usuarios existeUsuarioPassword(Usuarios us);
}
