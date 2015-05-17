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
 * Home object for domain model class FrecuenciaNacionalidad.
 * @see modelos.FrecuenciaNacionalidad
 * @author Hibernate Tools
 */
public class FrecuenciaNacionalidadHome {

	private static final Log log = LogFactory
			.getLog(FrecuenciaNacionalidadHome.class);

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

	public void persist(FrecuenciaNacionalidad transientInstance) {
		log.debug("persisting FrecuenciaNacionalidad instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(FrecuenciaNacionalidad instance) {
		log.debug("attaching dirty FrecuenciaNacionalidad instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FrecuenciaNacionalidad instance) {
		log.debug("attaching clean FrecuenciaNacionalidad instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(FrecuenciaNacionalidad persistentInstance) {
		log.debug("deleting FrecuenciaNacionalidad instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FrecuenciaNacionalidad merge(FrecuenciaNacionalidad detachedInstance) {
		log.debug("merging FrecuenciaNacionalidad instance");
		try {
			FrecuenciaNacionalidad result = (FrecuenciaNacionalidad) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FrecuenciaNacionalidad findById(java.lang.Integer id) {
		log.debug("getting FrecuenciaNacionalidad instance with id: " + id);
		try {
			FrecuenciaNacionalidad instance = (FrecuenciaNacionalidad) sessionFactory
					.getCurrentSession().get("modelos.FrecuenciaNacionalidad",
							id);
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

	public List findByExample(FrecuenciaNacionalidad instance) {
		log.debug("finding FrecuenciaNacionalidad instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("modelos.FrecuenciaNacionalidad")
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
