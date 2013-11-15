package org.cookbookgeeks.webkochbuch.service;

import java.util.List;

import javax.annotation.Resource;

import org.cookbookgeeks.webkochbuch.domain.Recipe;
import org.cookbookgeeks.webkochbuch.domain.RecipeDTO;
import org.cookbookgeeks.webkochbuch.domain.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This implementation of the RecipeService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Nils Sommer
 *
 */
@Service
public class RepositoryRecipeService implements RecipeService {
	
	private static final Logger logger = LoggerFactory.getLogger(RepositoryRecipeService.class);

	@Resource
	private RecipeRepository recipeRepository;
	
	@Transactional
	@Override
	public Recipe create(RecipeDTO created) {
		logger.debug("Creating new Recipe with information: " + created);
		Recipe recipe = Recipe.getBuilder(created.getTitle(), created.getDesctiption(),
				created.getContent(), created.getPreparationEndurance(),
				created.getTotalEndurance(), created.getCreation()).getBuild();
		return recipeRepository.save(recipe);
	}

	@Transactional(rollbackFor=RecipeNotFoundException.class)
	@Override
	public Recipe delete(int id) throws RecipeNotFoundException {
		logger.debug("Deleting recipe with id: " + id);
		Recipe deleted = recipeRepository.findOne(id);
		
		if( deleted == null ) {
			logger.debug("No recipe found with id: " + id);
			throw new RecipeNotFoundException();
		}
		
		recipeRepository.delete(id);
		return deleted;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Recipe> getAll() {
		logger.debug("Find all recipes");
		return recipeRepository.findAll();
	}

	@Transactional(readOnly=true)
	@Override
	public Recipe get(int id) {
		logger.debug("Finding recipe by id: " + id);
		return recipeRepository.findOne(id);
	}

	@Transactional(rollbackFor=RecipeNotFoundException.class)
	@Override
	public Recipe update(RecipeDTO updated) throws RecipeNotFoundException {
		logger.debug("Updating recipe with id: " + updated);
		Recipe recipe = recipeRepository.findOne(updated.getId());
		
		if( recipe == null ) {
			logger.debug("No recipe found with id: " + updated.getId());
			throw new RecipeNotFoundException();
		}
		
		recipe.update(updated.getTitle(), updated.getDesctiption(), updated.getContent(),
				updated.getPreparationEndurance(), updated.getTotalEndurance(),
				updated.getCreation());
		return recipe;
	}

}
