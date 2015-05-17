package test.conection.jugadores;

import java.util.List;

import modelos.Equipos;
import modelos.Jugadores;
import modelos.SessionFactoryUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

//import modelos.conectivity.EquiposHome;
//import modelos.dao.Equipo;

/**
 * Test Conexion 
 * 
 * @author Jesús
 */
public class TestJugadores {

	/**
	 * @param args
	 */
	@Autowired
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		System.out.println("Comienza... inicio configuracion");
		SessionFactory sessionFactory= SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Fin inicio configuracion");
		
		try{
			List<Jugadores> lista=(List<Jugadores>)session.createQuery("from Jugadores").list();
			for (Jugadores ju : lista) {
				System.out.println("Jugador: " + ju.getNombre() );
			}
			//sessionFactory.commit();
		}catch (HibernateException e){
			e.printStackTrace();
			//if(session!=null ) sessionFactory.rollback();
		}
			
		session.close();
		System.out.println("Fin Aplicacion Test");	
	}
}
