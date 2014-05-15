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
public interface Dao<E, K extends Serializable> {
	
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
