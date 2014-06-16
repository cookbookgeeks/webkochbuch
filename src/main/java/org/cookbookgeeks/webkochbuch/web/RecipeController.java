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

package org.cookbookgeeks.webkochbuch.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.cookbookgeeks.webkochbuch.domain.Category;
import org.cookbookgeeks.webkochbuch.domain.Comment;
import org.cookbookgeeks.webkochbuch.domain.Image;
import org.cookbookgeeks.webkochbuch.domain.Ingredient;
import org.cookbookgeeks.webkochbuch.domain.Rating;
import org.cookbookgeeks.webkochbuch.domain.Recipe;
import org.cookbookgeeks.webkochbuch.domain.User;
import org.cookbookgeeks.webkochbuch.service.CategoryService;
import org.cookbookgeeks.webkochbuch.service.CommentService;
import org.cookbookgeeks.webkochbuch.service.ImageService;
import org.cookbookgeeks.webkochbuch.service.IngredientService;
import org.cookbookgeeks.webkochbuch.service.MeasureService;
import org.cookbookgeeks.webkochbuch.service.RatingService;
import org.cookbookgeeks.webkochbuch.service.RecipeService;
import org.cookbookgeeks.webkochbuch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Nils Sommer
 * 
 * This is the Controller which processes all recipe requests.
 */
@Controller
public class RecipeController {
	
	private static final Logger logger = LoggerFactory.getLogger(RecipeController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private RatingService ratingService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private MeasureService measureService;
	
	@Autowired
	private IngredientService ingredientService;
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * Returns the user currently logged on.
	 * 
	 * @return current user
	 */
	private User currentUser() {
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		final User user = userService.getByUserName(auth.getName());
		return user;
	}
	
	/**
	 * Shows a recipe.
	 * 
	 * @param id of the recipe which wil be shown.
	 * @param model Model the view extracts its data from.
	 * @return the view recipe.jsp
	 */
	@RequestMapping(method=RequestMethod.GET, value="/recipe/{id}")
	public String showRecipe(@PathVariable("id") long id, Model model) {
		logger.info("Returning view recipe with recipe.id=" + id);
		Recipe recipe = recipeService.find(id);

		if( recipe == null ) {
			logger.debug("No recipe with id" + id + "found. Return error page.");
			return "recipeNotFound";
		}
		
		model.addAttribute("recipe", recipe);
		return "recipe";
	}
	
	/**
	 * Shows a list of all recipes.
	 * 
	 * @param model Model the view extracts its data from.
	 * @return the view showList.jsp
	 */
	@RequestMapping(method=RequestMethod.GET, value="/list")
	public String listRecipes(Model model, @RequestParam(value = "heading", required = false) String heading) {
		logger.info("Returning view with list of all recipes");
		List<Recipe> recipes = recipeService.findAll();
		
		if(recipes != null) {
			model.addAttribute("recipes", recipes);
		}
		
		if(null == heading) {
			heading = "Alle Rezepte";
		}
		
		model.addAttribute("heading", heading);
		return "showList";
	}
	
	/**
	 * Adding a recipe, optionally with image relationships.
	 * 
	 * @param recipe to add
	 * @param ids of the images that belong to the recipe
	 * @return the view of the newly created recipe
	 */
	@RequestMapping(method=RequestMethod.POST, value="/recipe/adddata")
	public String addRecipe(@ModelAttribute("recipe") Recipe recipe, 
			@RequestParam(value = "categoryInput") Long categoryId,
			@RequestParam(value = "ids", required = false) List<Long> ids,
			@RequestParam(value="amount", required=false) List<Double> amounts,
			@RequestParam(value="measure", required=false) List<Long> measureIds,
			@RequestParam(value="ingredientName", required=false) List<String> ingredientNames) {
		logger.info("Adding new recipe with images.");
		
		// Current date.
		final Date now = new Date();
		recipe.setCreation(now);
		recipe.setModification(now);
		
		// Set user to dummy user:
		recipe.setUser(this.currentUser());
		
		// Set category
		final Category category = categoryService.find(categoryId);
		recipe.setCategory(category);
		
		recipeService.add(recipe);
		
		// add recipe relationship to images
		if(ids != null) {
			for(Long id : ids) {
				Image image = imageService.find(id);
				imageService.setRecipeRelation(image, recipe);
			}
		}
		
		// Add ingredients
		List<Ingredient> ingredients = this.instantiateIngredients(amounts, measureIds, ingredientNames, recipe, now, now);
		if(ingredients != null) {
			logger.info("Persisting ingredients ...");
			ingredientService.add(ingredients);
		}
		
		return "redirect:/recipe/" + recipe.getId();
	}
	
	/**
	 * Maps url which returns an input form view for adding recipes.
	 * 
	 * @return the addRecipe view
	 */
	@RequestMapping(method=RequestMethod.GET, value="/recipe/add")
	public String addForm(Model model) {
		logger.info("Returning addRecipe view.");
		model.addAttribute("recipe", new Recipe());
		model.addAttribute("measures", measureService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		return "addRecipe";
	}
	
	/**
	 * Deletes a recipe and redirects to the start page.
	 * 
	 * @param id of the recipe which gets deleted.
	 * @return the view of the start page.
	 */
	@RequestMapping(method=RequestMethod.GET, value="/recipe/delete/{id}")
	public String deleteRecipe(@PathVariable("id") long id) {
		logger.info("Deleting recipe with id " + id + ".");
		Recipe recipe = recipeService.find(id);
		recipeService.delete(recipe);
		return "redirect:/";
	}
	
	/**
	 * Edits a recipe and show it afterwards.
	 * 
	 * @param recipe which gets edited.
	 * @param ids of the images that belong to the recipe
	 * @return the view recipe with the id of the recipe.
	 */
	@RequestMapping(method=RequestMethod.POST, value="/recipe/editdata")
	public String editRecipe(@ModelAttribute("recipe") Recipe recipe,
			@RequestParam(value = "ids", required = false) List<Long> ids,
			@RequestParam(value = "categoryInput") Long categoryId,
			@RequestParam(value="amount", required=false) List<Double> amounts,
			@RequestParam(value="measure", required=false) List<Long> measureIds,
			@RequestParam(value="ingredientName", required=false) List<String> ingredientNames,
			@RequestParam(value="ingredientId", required=false) List<Long> ingredientIds,
			@RequestParam(value="amountNew", required=false) List<Double> newAmounts,
			@RequestParam(value="measureNew", required=false) List<Long> newMeasureIds,
			@RequestParam(value="ingredientNameNew", required=false) List<String> newIngredientNames) {
		logger.info("Editing recipe with id " + recipe.getId() + ".");
		
		final Date now = new Date();
		recipe.setModification(now);
		
		// Set category
		final Category category = categoryService.find(categoryId);
		logger.info("==== category: " + categoryId + " ===" + category.getId());
		recipe.setCategory(category);
		
		// Update recipe.
		recipeService.update(recipe);
		
		// add recipe relationship to images
		if(ids != null) {
			for(Long id : ids) {
				Image image = imageService.find(id);
				imageService.setRecipeRelation(image, recipe);
			}
		}
		
		// Update existing ingredients
		this.updateIngredients(ingredientIds, amounts, measureIds, ingredientNames, now);
		
		
		// Add new ingredients
		final List<Ingredient> newIngredients = this.instantiateIngredients(newAmounts, newMeasureIds,
				newIngredientNames, recipe, now, now);
		if(newIngredients != null) {
			logger.info("Persisting ingredients ...");
			ingredientService.add(newIngredients);
		}
		
		return "redirect:/recipe/" + recipe.getId();
	}
	
	/**
	 * Maps url which returns an input form view for adding recipes.
	 * 
	 * @return the editRecipe view
	 */
	@RequestMapping(method=RequestMethod.GET, value="/recipe/edit/{id}")
	public String editForm(@PathVariable("id") long id, Model model) {
		logger.info("Returning editRecipe view.");
		Recipe recipe = recipeService.find(id);

		if( recipe == null ) {
			logger.debug("Recipe with id " + id + " does not exist!");
			return "recipeNotFound";
		}
		
		model.addAttribute("recipe", recipe);	
		model.addAttribute("measures", measureService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		
		return "editRecipe";
	}
	
	/**
	 * Adds a new rating from the current user to a recipe.
	 * 
	 * @param model model the view extracts its data from
	 * @param id id of the rated recipe
	 * @param score score of the rating
	 * @return the single site view of the recipe
	 */
	@RequestMapping(method=RequestMethod.GET, value="/recipe/{id}/rating")
	public String rate(Model model, @PathVariable("id") long id, @RequestParam("score") int score) {
		// Invalid score value?
		if(0 >= score || 5 < score) {
			logger.warn("Invalid rating score value.");
			model.addAttribute("ratingError", new Boolean(true));
			return "redirect:/recipe/" + id;
		}
		
		final Recipe recipe = recipeService.find(id);
		final Date now = new Date();
		final Rating rating = new Rating(this.currentUser(), recipe, score, now, now);
		
		// TODO: Check, if the current user already rated the recipe and deny it if it applies.
		
		// Adding rating failed?
		if(null == ratingService.add(rating)) {
			logger.warn("Adding rating to recipe failed.");
			model.addAttribute("ratingError", new Boolean(true));
			return "redirect:/recipe/" + id;
		}
		
		model.addAttribute("ratingError", new Boolean(false));
		return "redirect:/recipe/" + id;
	}
	
	/**
	 * Adds a new comment from the current user to the recipe.
	 * 
	 * @param id id of the recipe the comment belongs to
	 * @param commentText text of the comment
	 * @return the single page view of the recipe
	 */
	@RequestMapping(method=RequestMethod.POST, value="/recipe/{id}/comment")
	public String comment(@PathVariable("id") long id, @RequestParam("comment") String commentText) {
		// comment string empty, don't do anything.
		if(commentText.isEmpty()) {
			return "redirect:/recipe/" + id;
		}
		
		final Recipe recipe = recipeService.find(id);
		final Date now = new Date();
		final Comment comment = new Comment(commentText, this.currentUser(), recipe, now, now);
		commentService.add(comment);
		
		return "redirect:/recipe/" + id;
	}
	
	// ######### Helpers: #########
	
	/**
	 * Helper class that instantiates a list of ingredients.
	 * 
	 * @param amounts amount numbers of the ingredients
	 * @param measureIds ids of the measures of the ingredients
	 * @param names names of the ingredients
	 * @param recipe recipe the ingredients belong to
	 * @param creation time of creation of the ingredients
	 * @param modification time of modification of the ingredients
	 * @return list of ingredients
	 */
	private List<Ingredient> instantiateIngredients(List<Double> amounts,
			List<Long> measureIds, List<String> names, Recipe recipe, Date creation, Date modification) {
		if(null == amounts || null == measureIds || null == names) {
			return null;
		}
		
		if(amounts.size() != measureIds.size() || amounts.size() != names.size()) {
			// lists are of different size
			return null;
		}
		
		final List<Ingredient> ingredients = new ArrayList<Ingredient>();
		
		for(int i = 0; i < amounts.size(); i++) {
			final Ingredient ingredient = new Ingredient(names.get(i), measureService.find(measureIds.get(i)),
					amounts.get(i), recipe, creation, modification);
			ingredients.add(ingredient);
		}
		
		return ingredients;
	}
	
	/**
	 * Updates a list of ingredients.
	 * 
	 * @param ids ids of the ingredients to update.
	 * @param amounts list of amount numbers
	 * @param measureIds list of ids of measures
	 * @param names list of names
	 * @param modification modification date
	 */
	private void updateIngredients(List<Long> ids, List<Double> amounts,
			List<Long> measureIds, List<String> names, Date modification) {
		if(null == ids || null == amounts || null == measureIds || null == names) {
			return;
		}
		
		if(amounts.size() != measureIds.size() || amounts.size() != names.size() 
				|| amounts.size() != ids.size()) {
			return;
		}
		
		for(int i = 0; i < ids.size(); i++) {
			final Ingredient ingredient = ingredientService.find(ids.get(i));
			ingredient.setAmount(amounts.get(i));
			ingredient.setMeasure(measureService.find(measureIds.get(i)));
			ingredient.setName(names.get(i));
			ingredient.setModification(modification);
			ingredientService.update(ingredient);
		}
		
	}
	
}