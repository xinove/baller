package com.app.equipos;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import modelos.Equipos;
import modelos.Jugadores;
import modelos.SessionFactoryUtil;
import modelos.Usuarios;
import modelos.UsuariosHome;
import modelos.dao.UsuariosDao;

@Service
public class AdministracionEquipoImpl implements AdministracionEquipo {
	private static SessionFactory sessionFactory;
	private static Session session;
	public AdministracionEquipoImpl(){
		sessionFactory =  SessionFactoryUtil.getSessionFactory();;
		session = null;
	}
	
	@Override
	public Equipos insertarEquipo(Equipos eq) {
		try{
			session = sessionFactory.openSession();
			session.beginTransaction();
			if(!existeEquipo(eq)){
				session.save(eq);
				session.getTransaction().commit();
				//Obtenemos el Id:
				eq = getEquipo(eq);
				System.out.println("ID: " + eq.getIdEquipo());
			}
			
		}catch (HibernateException e){
			e.printStackTrace();
			if(session.getTransaction()!=null ) session.getTransaction().rollback();
			return null;
		}finally{
			sessionFactory.close();
		}
		return eq;
	}

	@Override
	public boolean existeEquipo(Equipos eq) {
		boolean existe = false;
		System.out.println("Id_equipo: " + eq.getIdEquipo());
		String query = "select eq from Equipos as eq where eq.idEquipo = '"+ eq.getIdEquipo()+"'"; 
		List<Equipos> ls  = session.createQuery(query).list();
		
		for(Equipos auxEq : ls){
			if (auxEq.getIdEquipo() != null && auxEq.getIdEquipo() > 0){ 
				existe = true;
				eq = auxEq;
			}
		}
		return existe;
	}

	@Override
	public Equipos getEquipo(Equipos eq) {
		//boolean existe = false;
		System.out.println("Id_usuario: " + eq.getIdUsuarioFk());
		String query = "select eq from Equipos as eq where eq.idUsuarioFk = '"+ eq.getIdUsuarioFk()+"'"; 
		List<Equipos> ls  = session.createQuery(query).list();
		
		for(Equipos auxEq : ls){
			if (auxEq.getIdEquipo() != null && auxEq.getIdEquipo() > 0){ 
				//existe = true;
				eq = auxEq;
			}
		}
		return eq;
	}
	@Override
	public Equipos getEquipoId(int idequipo) {
		//boolean existe = false;
		String query = "select eq from Equipos as eq where eq.idEquipo = '"+ idequipo +"'"; 
		List<Equipos> ls  = session.createQuery(query).list();
		Equipos eq = new Equipos();
		for(Equipos auxEq : ls){
			if (auxEq.getIdEquipo() != null && auxEq.getIdEquipo() > 0){ 
				eq = auxEq;
			}
		}
		return eq;
	}

	@Override
	public Equipos getEquipoUsuario(Integer idUsuarioFk) {
		//boolean existe = false;
		String query = "select eq from Equipos as eq where eq.idUsuarioFk = '"+ idUsuarioFk +"'"; 
		List<Equipos> ls  = session.createQuery(query).list();
		Equipos eq = null;
		for(Equipos auxEq : ls){
			if (auxEq.getIdEquipo() != null && auxEq.getIdEquipo() > 0){ 
				//existe = true;
				eq = auxEq;
			}
		}
		return eq;
	}

	@Override
	public List<Jugadores> getJugadores(Equipos eq) {
		//boolean existe = false;
		String query = "select juga from Jugadores as juga where juga.idEquipoFk = '"+ eq.getIdEquipo() +"'"; 
		List<Jugadores> lsJugadores  = session.createQuery(query).list();

		return lsJugadores;
	}

}
