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

import java.util.ArrayList;
import java.util.List;

import org.cookbookgeeks.webkochbuch.dao.IngredientHibernateDao;
import org.cookbookgeeks.webkochbuch.domain.Ingredient;
import org.springframework.stereotype.Service;

/**
 * Service class for ingredient related database operations. This class contains methods
 * that are more business related than in the Daos.
 * 
 * @author Nils Sommer
 *
 */
@Service("ingredientService")
public class IngredientHibernateService extends IngredientHibernateDao
		implements IngredientService {
	
	/** {@inheritDoc} */
	@Override
	public void update(Ingredient updated) {
		Ingredient ingredient = this.find(updated.getId());
		//name, measure, amount, modification
		ingredient.setName(updated.getName());
		ingredient.setMeasure(updated.getMeasure());
		ingredient.setAmount(updated.getAmount());
		ingredient.setModification(updated.getModification());
		super.update(ingredient);
	}
	
	/** {@inheritDoc} */
	public List<Long> add(List<Ingredient> ingredients) {
		final List<Long> ids = new ArrayList<Long>();
		
		for(Ingredient ingredient : ingredients) {
			final Long id = this.add(ingredient);
			ids.add(id);
		}
		
		return ids;
	}

	/** {@inheritDoc} */
	public void update(List<Ingredient> ingredients) {
		for(Ingredient ingredient : ingredients) {
			this.update(ingredient);
		}
	}
}
