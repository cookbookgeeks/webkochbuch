package org.cookbookgeeks.webkochbuch.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of the Interface Dao.
 * 
 * @author Nils Sommer
 *
 * @param <E> entity type
 * @param <K> entity key type
 */
@Transactional
public abstract class GenericDao<E, K extends Serializable> implements Dao<E, K> {
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	protected Class <? extends E> type;
	
	/**
	 * Helper method.
	 * 
	 * @return the current session
	 */
	protected Session currentSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	/** {@inheritDoc} */
	@SuppressWarnings("unchecked")
	public E find(K key) {
		return (E) this.currentSession().get(type, key);
	}
	
	/** {@inheritDoc} */
	@SuppressWarnings("unchecked")
	public K add(E entity) {
		return (K) this.currentSession().save(entity);
	}
	
	/** {@inheritDoc} */
	public void update(E entity) {
		currentSession().saveOrUpdate(entity);
	}
	
	/** {@inheritDoc} */
	public void delete(E entity) {
		currentSession().delete(entity);
	}
	
	/** {@inheritDoc} */
	@SuppressWarnings("unchecked")
	public List<E> findAll() {
		return currentSession().createCriteria(type).list();
	}

}
