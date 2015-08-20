/**
 * 
 */
package com.softserve.edu.library2.dao.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author Назік
 *
 */
public class HibernateUtil {
	private static Logger logger = LogManager.getLogger();

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		logger.info("========================= buildSessionFactory ==============================");
		logger.entry();
		SessionFactory tempSessionFactory = null;
		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
					configuration.getProperties()).build();
			tempSessionFactory = configuration.buildSessionFactory(serviceRegistry);

		} catch (Exception e) {
			logger.info("========================= Exception ==============================");
			e.printStackTrace();
		}
		return logger.exit(tempSessionFactory);

	}

	public static SessionFactory getSessionFactory() {
		logger.info("========================= getSessionFactory ==============================");
		return sessionFactory;
	}

	public static Session beginTransaction() {
		logger.info("========================= beginTransaction ==============================");
		Session hibernateSession = HibernateUtil.getSession();
		hibernateSession.beginTransaction();
		return hibernateSession;
	}

	public static void commitTransaction() {
		logger.info("========================= commitTransaction ==============================");
		HibernateUtil.getSession().getTransaction().commit();
	}

	public static void rollbackTransaction() {
		logger.info("========================= rollbackTransaction ==============================");
		HibernateUtil.getSession().getTransaction().rollback();
	}

	public static void closeSession() {
		logger.info("========================= closeSession ==============================");
		HibernateUtil.getSession().close();
	}

	public static Session getSession() {
		Session hibernateSession = sessionFactory.getCurrentSession();
		return hibernateSession;
	}
}
