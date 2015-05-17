package test.conection.estadios;

import java.util.List;

import modelos.Equipos;
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
public class TestEquipos {

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
			List<Equipos> lista=(List<Equipos>)session.createQuery("from Equipos").list();
			for (Equipos eq : lista) {
				System.out.println("Valor: " + eq.getIdEquipo() + " - " + eq.getEstadio() + " - " + eq.getNombre());
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
