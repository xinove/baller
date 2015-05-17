package com.app.jugadores;

import modelos.Equipos;

public interface AdministracionJugador {
	
	//public void AdministracionUsuarioImpl();
	
	public Equipos insertarEquipo(Equipos eq);
	
	public boolean existeEquipo(Equipos eq);
	
	public Equipos getEquipo(Equipos eq);

}
