package tn.enicar.projet.DAO;

// Generated 9 déc. 2015 01:40:45 by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import tn.enicar.projet.model.Etudiant;

/**
 * Home object for domain model class Etudiant.
 * @see tn.enicar.projet.DAO.Etudiant
 * @author Hibernate Tools
 */
@Stateless
public class EtudiantHome {

	private static final Log log = LogFactory.getLog(EtudiantHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Etudiant transientInstance) {
		log.debug("persisting Etudiant instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Etudiant persistentInstance) {
		log.debug("removing Etudiant instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Etudiant merge(Etudiant detachedInstance) {
		log.debug("merging Etudiant instance");
		try {
			Etudiant result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Etudiant findById(long id) {
		log.debug("getting Etudiant instance with id: " + id);
		try {
			Etudiant instance = entityManager.find(Etudiant.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
