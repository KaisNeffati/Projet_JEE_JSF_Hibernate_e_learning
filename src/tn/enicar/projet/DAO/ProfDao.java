package tn.enicar.projet.DAO;

// Generated 9 déc. 2015 01:40:45 by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import java.util.List;

import tn.enicar.projet.util.HibernateUtil;
import tn.enicar.projet.model.Prof;

/**
 * Home object for domain model class Prof.
 * @see tn.enicar.projet.DAO.Prof
 * @author Hibernate Tools
 */
@Stateless
public class ProfDao {

	private static final Log log = LogFactory.getLog(ProfDao.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	@PersistenceContext
	private EntityManager entityManager;
	private void openTransaction(){
		sessionFactory
		.getCurrentSession().beginTransaction();
	}
	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) HibernateUtil.sessionFactory;
		} catch (Exception e) {
			log.error("Could not locate SessionFactory ", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory");
		}
	}
	private void closeTransaction(){
		sessionFactory//getcurrentSession == sess= seessfact.opensess();sees.perssist(
		.getCurrentSession().getTransaction().commit();
	}
 

	public void persist(Prof transientInstance) {
		openTransaction();
		log.debug("persisting client instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
			closeTransaction();
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void Supprimer(Prof persistentInstance) {
		openTransaction();
		log.debug("removing Prof instance");
		try {
			 sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("remove successful");
			closeTransaction();
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}
	public void Modifier(Prof persistentInstance) throws Exception {
		openTransaction();
		try {
		sessionFactory.getCurrentSession().update(persistentInstance);
		closeTransaction();
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		} finally {
			closeTransaction();
		}
	}

	public Prof merge(Prof detachedInstance) {
		log.debug("merging Prof instance");
		try {
			Prof result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public List<Prof> findAll() {
        List<Prof> ob = null;
        openTransaction();
        try {
        	Criteria list_prof = sessionFactory.getCurrentSession().createCriteria(Prof.class);
            ob=list_prof.list();
        	log.debug("persist successful");
			
        }catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		} finally {
        	closeTransaction();
        }
        return ob;
    }
	
	public Prof findById(long id) {
		log.debug("getting Prof instance with id: " + id);
		try {
			Prof instance = entityManager.find(Prof.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
