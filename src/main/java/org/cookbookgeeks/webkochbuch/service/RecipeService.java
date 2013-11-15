package org.cookbookgeeks.webkochbuch.service;

import java.util.List;

import org.cookbookgeeks.webkochbuch.domain.Recipe;
import org.cookbookgeeks.webkochbuch.domain.RecipeDTO;

/**
 * Declares methods to obtain and modify recipe objects.
 * @author Nils Sommer
 *
 */
public interface RecipeService {
	
	/**
	 * Creates a new Recipe.
	 * @param created the information of the recipe.
	 * @return the created recipe.
	 */
	public Recipe create(RecipeDTO created);
	
	/**
	 * Deletes a recipe.
	 * @param id of the recipe.
	 * @return the deleted recipe.
	 * @throws RecipeNotFoundException if no recipe is found with the given id.
	 */
	public Recipe delete(int id) throws RecipeNotFoundException;
	
	/**
	 * Gets all available recipes.
	 * @return all available recipes.
	 */
	public List<Recipe> getAll();
	
	/**
	 * Get a recipe.
	 * @param id of the recipe.
	 * @return the recipe or null if the recipe is not found.
	 */
	public Recipe get(int id);
	
	/**
	 * Updates a recipe.
	 * @param updated the information of the updated recipe.
	 * @return the updated recipe.
	 * @throws RecipeNotFoundException if no recipe is found with the given id.
	 */
	public Recipe update(RecipeDTO updated) throws RecipeNotFoundException;

}
