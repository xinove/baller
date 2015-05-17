package test.generar.jugador;

import java.util.List;

import modelos.SessionFactoryUtil;
import modelos.Usuarios;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestGenerarJugador {
	public static void main(String[] args) {
		System.out.println("Comenzamos la conexion a BD");
		SessionFactory sessionFactory= SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Fin inicio configuracion");
		
		try{ 	
			int numNombres = 0;
			List<Long> lsNombres=(List<Long>)session.createQuery("select count(nombre) from Nombres as nombre").list();
			if (lsNombres.size() > 0){
				for(Long valor : lsNombres){
					System.out.println("Cantidad de nombres: " + valor);
					numNombres = valor.intValue();
				}
			}
			
			// Obtenemos un nombre aleatorio
			List<Long> lista=(List<Long>)session.createQuery("select sum(frec.cantidad) from FrecNacNombre as frec").list();
			int numeroAleatorio = (int) (Math.random() * numNombres + 1);
			int numJugadores = 0;
			if(lista.size() > 0){
				for(Long valor : lista){
					System.out.println("Cantidad de elementos: " + valor);
					numJugadores = valor.intValue();
					
				}
			}else
				System.out.println("La consulta no devuelve resultados");
			
//			session.save(usuario);
//			session.getTransaction().commit();
			//System.out.println("Has insertado un usuario correctamente");
		}catch (HibernateException e){
			e.printStackTrace();
			if(session.getTransaction()!=null ) session.getTransaction().rollback();
		}
		
		try{
			
			
			//sessionFactory.commit();
		}catch (HibernateException e){
			e.printStackTrace();
			//if(session!=null ) sessionFactory.rollback();
		}
			
		session.close();
		System.out.println("Fin Aplicacion Test");	
	}
}

