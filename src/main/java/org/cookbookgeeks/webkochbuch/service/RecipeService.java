package org.cookbookgeeks.webkochbuch.service;

import org.cookbookgeeks.webkochbuch.dao.RecipeDao;
import org.cookbookgeeks.webkochbuch.domain.Recipe;

/**
 * Service interface for a recipe service.
 * 
 * @author Nils Sommer
 *
 */
public interface RecipeService extends RecipeDao {
	
	/** {@inheritDoc} */
	@Override
	public void update(Recipe updated);

}
