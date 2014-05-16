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
