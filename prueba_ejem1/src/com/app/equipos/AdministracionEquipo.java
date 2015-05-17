package com.app.equipos;

import java.util.List;

import modelos.Jugadores;
import modelos.Equipos;

public interface AdministracionEquipo {
	
	//public void AdministracionUsuarioImpl();
	
	public Equipos insertarEquipo(Equipos eq);
	
	public boolean existeEquipo(Equipos eq);
	
	public Equipos getEquipo(Equipos eq);

	public Equipos getEquipoUsuario(Integer idUsuarioFk);

	Equipos getEquipoId(int idequipo);

	public List<Jugadores> getJugadores(Equipos eq);

}
