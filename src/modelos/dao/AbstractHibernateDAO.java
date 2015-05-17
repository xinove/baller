package modelos.dao;

	import java.io.Serializable;
	import java.util.List;

	import org.hibernate.HibernateException;
	import org.hibernate.Session;
	import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

	public abstract class AbstractHibernateDAO<DomainObject extends Serializable, KeyType extends Serializable> extends HibernateDaoSupport{
	        
        protected Class<DomainObject> domainClass = getDomainClass();
        
        protected abstract Class<DomainObject> getDomainClass();
        
        @SuppressWarnings("unchecked")
		public DomainObject load(KeyType id){
                return (DomainObject)getHibernateTemplate().load(getDomainClass(), id);
        }
	    
	    public void update(DomainObject object){
	        getHibernateTemplate().update(object);
	    }

	    public void save(DomainObject object){
	        getHibernateTemplate().save(object);
	    }

	    public void delete(DomainObject object){
	        getHibernateTemplate().delete(object);
	    }
	    
	    public void deleteById(KeyType id){
	        Object obj = load(id);
	        getHibernateTemplate().delete(obj);
	    }

	    @SuppressWarnings("unchecked")
		public List<DomainObject> getList(){
	        return (getHibernateTemplate().find("from " + domainClass.getName() + " o"));
	    }
	    
	    public void deleteAll(){
	         getHibernateTemplate().execute(new HibernateCallback() {
	             public Object doInHibernate(Session session) throws HibernateException {
	                 String hqlDelete = "delete " + domainClass.getName();
	                 //int deletedEntities = session.createQuery(hqlDelete).executeUpdate();
	                 session.createQuery(hqlDelete).executeUpdate();
	                 //return deletedEntities;
	                 return null;
	             }

	         });

	    }
	    
	    public int count(){
	        @SuppressWarnings("rawtypes")
			List list = getHibernateTemplate().find(
	                "select count(*) from " + domainClass.getName() + " o");
	        Integer count = (Integer) list.get(0);
	        return count.intValue();
	    }
	
}
