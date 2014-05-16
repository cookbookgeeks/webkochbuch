/*
 * Copyright (C) 2014  Cookbookgeeks
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

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
