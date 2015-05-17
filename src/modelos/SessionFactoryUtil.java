package modelos;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * SessionFactoryUtil
 * 
 * @description: 	Con esta clase podremos obtener la  sesión actual 
 * 				 	de cualquier parte de nuestra aplicación.
 * @author Jesús
 *
 */
public class SessionFactoryUtil {
	 private static final SessionFactory sessionFactory;
	    static {
	        try {
	            // Create the SessionFactory from standard (hibernate.cfg.xml) 
	            // config file.
	            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	        } catch (Throwable ex) {
	            // Log the exception. 
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
	
}