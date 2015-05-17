package com.app.usuarios;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import modelos.SessionFactoryUtil;
import modelos.Usuarios;
import modelos.UsuariosHome;
import modelos.dao.UsuariosDao;

@Service
public class AdministracionUsuarioImpl implements AdministracionUsuario {
	private static SessionFactory sessionFactory;
	private static Session session;
	public AdministracionUsuarioImpl(){
		sessionFactory =  SessionFactoryUtil.getSessionFactory();;
		session = null;
	}
	
	@Override
	public Usuarios insertarUsuario(Usuarios us) {
		try{
			session = sessionFactory.openSession();
			session.beginTransaction();
			if(!existeUsuario(us)){
				session.save(us);
				session.getTransaction().commit();
				//Obtenemos el Id:
				us = getUsuario(us);
				System.out.println("ID: " + us.getIdUsuario());
			}
			
		}catch (HibernateException e){
			e.printStackTrace();
			if(session.getTransaction()!=null ) session.getTransaction().rollback();
		}finally{
			sessionFactory.close();
		}
		return us;
	}
	
	@Override
	public boolean existeUsuario(Usuarios us){
		if(session==null || !session.isConnected()){
			session = sessionFactory.openSession();
			session.beginTransaction();
		}
		boolean existe = false;
		String query = "select us from Usuarios as us where us.usuario = '"+ us.getUsuario() +"'"; 
		List<Usuarios> ls  = session.createQuery(query).list();
		for(Usuarios auxUs : ls){
			if (auxUs.getIdUsuario() != null && auxUs.getIdUsuario() > 0){ 
				existe = true;
				us.setIdUsuario(auxUs.getIdUsuario());
			}
		}
		return existe;
	}
	
	@Override
	public Usuarios getUsuario(Usuarios us){
		if(session==null || !session.isConnected()){
			session = sessionFactory.openSession();
			session.beginTransaction();
		}
		boolean existe = false;
		String query = "select us from Usuarios as us where us.usuario = '"+ us.getUsuario() +"'"; 
		List<Usuarios> ls  = session.createQuery(query).list();
		for(Usuarios auxUs : ls){
			if (auxUs.getIdUsuario() != null && auxUs.getIdUsuario() > 0){ 
				existe = true;
				us.setIdUsuario(auxUs.getIdUsuario());
			}
		}
		return us;
	}
	
	@Override
	public Usuarios existeUsuarioPassword(Usuarios us){
		if(session==null || !session.isConnected()){
			session = sessionFactory.openSession();
			session.beginTransaction();
		}
		String query = "select us from Usuarios as us where us.usuario = '"+ us.getUsuario() +
			"'  and us.password = '" + us.getPassword() + "'" ; 
		List<Usuarios> ls  = session.createQuery(query).list();
		System.out.println("Array: " + ls.size());
	
			for(Usuarios auxUs : ls){
				if (auxUs.getIdUsuario() != null && auxUs.getIdUsuario() > 0){ 
					us.setIdUsuario(auxUs.getIdUsuario());
				}
			}		
		
		return us;
	}

	
}
