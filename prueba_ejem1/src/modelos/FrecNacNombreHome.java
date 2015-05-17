package modelos;

// Generated 21-feb-2012 17:01:18 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class FrecNacNombre.
 * @see modelos.FrecNacNombre
 * @author Hibernate Tools
 */
public class FrecNacNombreHome {

	private static final Log log = LogFactory.getLog(FrecNacNombreHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(FrecNacNombre transientInstance) {
		log.debug("persisting FrecNacNombre instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(FrecNacNombre instance) {
		log.debug("attaching dirty FrecNacNombre instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FrecNacNombre instance) {
		log.debug("attaching clean FrecNacNombre instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(FrecNacNombre persistentInstance) {
		log.debug("deleting FrecNacNombre instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FrecNacNombre merge(FrecNacNombre detachedInstance) {
		log.debug("merging FrecNacNombre instance");
		try {
			FrecNacNombre result = (FrecNacNombre) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FrecNacNombre findById(java.lang.Integer id) {
		log.debug("getting FrecNacNombre instance with id: " + id);
		try {
			FrecNacNombre instance = (FrecNacNombre) sessionFactory
					.getCurrentSession().get("modelos.FrecNacNombre", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(FrecNacNombre instance) {
		log.debug("finding FrecNacNombre instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("modelos.FrecNacNombre")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
