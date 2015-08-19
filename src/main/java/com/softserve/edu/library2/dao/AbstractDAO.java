/**
 *  
 */
package com.softserve.edu.library2.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.softserve.edu.library2.dao.util.HibernateUtil;


/**
 * @author Назік
 * @param <T>
 * Abstract class for DAO hierarchy
 *
 */
public abstract class AbstractDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {
	protected Session getSession() {
		return HibernateUtil.getSession();
	}

	/**
	 * Saving entity to DB
	 */
	public void save(T entity) {
		getSession().saveOrUpdate(entity);
	}

	/**
	 * Merging entity to DB
	 */
	public void merge(T entity) {
		getSession().merge(entity);
	}

	/**
	 * Deletion entity from DB
	 */
	public void delete(T entity) {
		getSession().delete(entity);
	}

	/**
	 * Return query result us list
	 */
	@SuppressWarnings("unchecked")
	public List<T> findMany(Query query) {
		return (List<T>) query.list();
	}

	@SuppressWarnings("unchecked")
	public T findOne(Query query) {
		return (T) query.uniqueResult();
	}

	public List<?> findAll(Class<?> clazz) {

		return getSession().createQuery("FROM" + clazz.getName()).list();
	}

	/**
	 * Return the persistent instance of the given entity class with the given
	 * identifier, or null if there is no such persistent instance. (If the
	 * instance is already associated with the session, return that instance.
	 * This method never returns an uninitialized instance.)
	 *
	 * @param clazz
	 *            a persistent class
	 * @param id
	 *            an identifier
	 * @return a persistent instance or null
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T findByID(Class clazz, 
			Integer id) {
		return (T) getSession().get(clazz, id);
	}

}
