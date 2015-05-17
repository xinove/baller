package com.app.caracteristicas;

import modelos.Equipos;

public interface AdministracionCaracteristicas {
	
	//public void AdministracionUsuarioImpl();
	
	public Equipos insertarEquipo(Equipos eq);
	
	public boolean existeEquipo(Equipos eq);
	
	public Equipos getEquipo(Equipos eq);

}
