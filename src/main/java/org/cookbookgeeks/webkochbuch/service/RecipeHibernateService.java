package org.cookbookgeeks.webkochbuch.service;

import org.cookbookgeeks.webkochbuch.dao.RecipeHibernateDao;
import org.cookbookgeeks.webkochbuch.domain.Recipe;
import org.springframework.stereotype.Service;

/**
 *Service class for recipe related database operation. This class contains methods
 * that are more business related than in the Daos.
 * 
 * @author Nils Sommer
 *
 */
@Service("recipeService")
public class RecipeHibernateService extends RecipeHibernateDao implements RecipeService {

	/** {@inheritDoc} */
	@Override
	public void update(Recipe updated) {
		Recipe recipe = this.find(updated.getId());
		recipe.setTitle(updated.getTitle());
		recipe.setDescription(updated.getDescription());
		recipe.setContent(updated.getContent());
		recipe.setPreparationEndurance(updated.getPreparationEndurance());
		recipe.setTotalEndurance(updated.getTotalEndurance());
		recipe.setModification(updated.getModification());
		super.update(recipe);
	}

}
