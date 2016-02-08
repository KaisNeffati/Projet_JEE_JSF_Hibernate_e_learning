package tn.enicar.projet.util;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory sessionFactory;
	public static String CONFIG_FILE_LOCATION = "hibernate.cfg.xml";
	static {
		try {
			Configuration cfg = new AnnotationConfiguration();
			sessionFactory = cfg.configure(CONFIG_FILE_LOCATION)
					.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

}
