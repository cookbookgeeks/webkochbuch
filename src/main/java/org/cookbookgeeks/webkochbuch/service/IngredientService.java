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

package org.cookbookgeeks.webkochbuch.service;

import java.util.List;

import org.cookbookgeeks.webkochbuch.dao.IngredientDao;
import org.cookbookgeeks.webkochbuch.domain.Ingredient;

/**
 * Service interface for an ingredient service.
 * 
 * @author Nils Sommer
 *
 */
public interface IngredientService extends IngredientDao {
	
	/** {@inheritDoc} */
	@Override
	public void update(Ingredient updated);
	
	/**
	 * Persists a list of ingredients.
	 * 
	 * @param ingredients ingredients to add
	 * @return list of ids from the added ingredients
	 */
	public List<Long> add(List<Ingredient> ingredients);
	
	/**
	 * Update a list of ingredients.
	 * 
	 * @param ingredients ingredients to update.
	 */
	public void update(List<Ingredient> ingredients);
	
	/**
	 * Finds a list of ingredients by their ids.
	 * 
	 * @param ids ids of the ingredients
	 * @return list of ingredients
	 */
	public List<Ingredient> find(List<Long> ids);

}
