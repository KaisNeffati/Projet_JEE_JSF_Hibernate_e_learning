package tn.enicar.projet.DAO;

// Generated 15 nov. 2015 12:38:06 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.transaction.annotation.Transactional;

import tn.enicar.projet.model.Utilisateur;
import tn.enicar.projet.util.HibernateUtil;;

/**
 * Home object for domain model class Utilisateur.
 * @see com.esti.jsfHibernate.dao.HibernateUtil
 * @author Hibernate Tools
 */
public class UtilisateurDAO {

	private static final Log log = LogFactory.getLog(UtilisateurDAO.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) HibernateUtil.sessionFactory;
		} catch (Exception e) {
			log.error("Could not locate SessionFactory ", e);
			throw new IllegalStateException("Could not locate SessionFactory");
		}
	}


	public void persist(Utilisateur transientInstance) {
		log.debug("persisting Utilisateur instance");
		try {
			openTransaction();
			sessionFactory.getCurrentSession().persist(transientInstance);
			closeTransaction();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Utilisateur instance) {
		log.debug("attaching dirty Utilisateur instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Utilisateur instance) {
		log.debug("attaching clean Utilisateur instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Utilisateur persistentInstance) {
		log.debug("deleting Utilisateur instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Utilisateur merge(Utilisateur detachedInstance) {
		log.debug("merging Utilisateur instance");
		try {
			Utilisateur result = (Utilisateur) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	
	public Utilisateur findById(java.lang.String id) {
		log.debug("getting Utilisateur instance with id: " + id);
		try {
			openTransaction();
			Utilisateur instance = (Utilisateur) sessionFactory
					.getCurrentSession().get(
							"tn.enicar.projet.model.Utilisateur", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			closeTransaction();
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Utilisateur instance) {
		log.debug("finding Utilisateur instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("tn.enicar.projet.model.Utilisateur")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	private void openTransaction(){
		sessionFactory
		.getCurrentSession().beginTransaction();
	}
	
	private void closeTransaction(){
		sessionFactory
		.getCurrentSession().getTransaction().commit();
	}
 
}
