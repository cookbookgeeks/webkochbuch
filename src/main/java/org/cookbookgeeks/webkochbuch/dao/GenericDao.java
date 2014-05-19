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

/**
 * Generic Interface for Data Access Objects, defining some basic
 * database transactions.
 * 
 * @author Nils Sommer
 *
 * @param <E> Entity type
 * @param <K> Key type of the entity
 */
public interface GenericDao<E, K extends Serializable> {
	
	/**
	 * Finds an entity by its key.
	 * 
	 * @param key key value of the entity
	 * @return the entity
	 */
	public E find(K key);
	
	/**
	 * Adds an entity.
	 * 
	 * @param entity entity to add
	 * @return true if the transaction was successful, false if the transaction failed
	 */
	public K add(E entity);
	
	/**
	 * Updates an entity.
	 * 
	 * @param entity entity to update
	 * @return the key of the persisted entity
	 */
	public void update(E entity);
	
	/**
	 * Deletes an entity.
	 * 
	 * @param entity entity to delete
	 * @return true if the transaction was successful, false if the transaction failed
	 */
	public void delete(E entity);
	
	/**
	 * Finds all entites.
	 * 
	 * @return a list of all entities
	 */
	public List<E> findAll();

}
