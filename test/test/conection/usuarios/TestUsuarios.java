package test.conection.usuarios;

import java.util.List;

import modelos.SessionFactoryUtil;
import modelos.Usuarios;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Test Conexion 
 * 
 * @author Jesús
 */
public class TestUsuarios {

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
		Usuarios usuario = new Usuarios(
				"Jesús", null, "xinove",
				"123456", "Calle la fuente hermosa", 'V', -1);
		
		try{
			//guardamos y commit
//			if(session.equals(usuario)){
//				System.out.println("Existe!!!");
//			}else{
//				System.out.println("No existe!!!!");
//			}
			session.save(usuario);
			session.getTransaction().commit();
			System.out.println("Has insertado un usuario correctamente");
		}catch (HibernateException e){
			e.printStackTrace();
			if(session.getTransaction()!=null ) session.getTransaction().rollback();
		}
		
		try{
			
			List<Usuarios> lista=(List<Usuarios>)session.createQuery("from Usuarios").list();
			for (Usuarios us : lista) {
				System.out.println("Valor: " + us.getNombre() + " - " + us.getApellidos() + " - " + us.getUsuario());
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
