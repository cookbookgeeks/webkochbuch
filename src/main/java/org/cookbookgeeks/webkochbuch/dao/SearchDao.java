package org.cookbookgeeks.webkochbuch.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Generic Interface that defines search methods usually needed.
 * 
 * @author Nils Sommer
 *
 * @param <E> entity type
 * @param <K> entity key type
 */
public interface SearchDao<E, K extends Serializable> {
	
	/**
	 * Searches for entities containing the given keyword(s).
	 * 
	 * @param pattern search pattern containing one or more keywords
	 * @return a list of entities
	 */
	public List<E> searchByKeywords(String pattern);

}
