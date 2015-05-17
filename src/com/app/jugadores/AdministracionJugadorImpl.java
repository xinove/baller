package com.app.jugadores;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import modelos.Equipos;
import modelos.SessionFactoryUtil;
import modelos.Usuarios;
import modelos.UsuariosHome;
import modelos.dao.UsuariosDao;

@Service
public class AdministracionJugadorImpl implements AdministracionJugador {
	private static SessionFactory sessionFactory;
	private static Session session;
	public AdministracionJugadorImpl(){
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
		}finally{
			sessionFactory.close();
		}
		return eq;
	}

	@Override
	public boolean existeEquipo(Equipos eq) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Equipos getEquipo(Equipos eq) {
		// TODO Auto-generated method stub
		return null;
	}

}
