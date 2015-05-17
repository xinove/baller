package modelos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import modelos.SessionFactoryUtil;
import modelos.Usuarios;

@SuppressWarnings("rawtypes")
public class UsuariosDao extends AbstractHibernateDAO{

	@Override
	protected Class<? extends UsuariosDao> getDomainClass() {
		return this.getClass();
	}
	private SessionFactory sessionFactory= SessionFactoryUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	
    public Usuarios insertarUsuario(Usuarios object){
    	save(object);
        object.setIdUsuario( getUsuarioUser(object));
        return object;
    }
	
    public void eliminarUsuario(Usuarios object){
        getHibernateTemplate().delete(object);
    }
    
    public int getUsuarioUser(Usuarios object){
    	
    	String query = "select u.id from Usuarios as u "+
    					"where u.usuario = '" + object.getUsuario() +"'";
    	
    	List<Integer> lista=(List<Integer>)session.createQuery(query).list();
    	
    	System.out.println("Valores: " + lista.size());
    	int num = 0;
    	if(lista.size() > 0) {
    		for (Integer auxNum : lista) {
    			num = auxNum.intValue();
    		}
    		return num;
    	}else
    		return -1;
    }
    
}