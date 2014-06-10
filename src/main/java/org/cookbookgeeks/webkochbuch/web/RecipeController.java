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

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.cookbookgeeks.webkochbuch.domain.Image;
import org.cookbookgeeks.webkochbuch.domain.Rating;
import org.cookbookgeeks.webkochbuch.domain.Recipe;
import org.cookbookgeeks.webkochbuch.domain.User;
import org.cookbookgeeks.webkochbuch.service.ImageService;
import org.cookbookgeeks.webkochbuch.service.RatingService;
import org.cookbookgeeks.webkochbuch.service.RecipeService;
import org.cookbookgeeks.webkochbuch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	/**
	 * Because user management isn't implemented yet, this helper method will return a manually created
	 * dummy user entry from the database. As soon as user management is completely implemented,
	 * this will be replaced with a method that returns the currently logged in user.
	 * 
	 * @return dummy user object
	 */
	private User currentUser() {
		Long key = 0L;
		return userService.find(key);
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
	public String listRecipes(Model model) {
		logger.info("Returning view with list of all recipes");
		List<Recipe> recipes = recipeService.findAll();
		
		if(recipes != null) {
			model.addAttribute("recipes", recipes);
		}
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
			@RequestParam(value = "ids", required = false) List<Long> ids) {
		logger.info("Adding new recipe with images.");
		
		// Current date.
		recipe.setCreation(new Date());
		recipe.setModification(recipe.getCreation());
		
		// Set user to dummy user:
		recipe.setUser(this.currentUser());
		
		recipeService.add(recipe);
		
		// add recipe relationship to images
		if(ids != null) {
			for(Long id : ids) {
				Image image = imageService.find(id);
				imageService.setRecipeRelation(image, recipe);
			}
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
			@RequestParam(value = "ids", required = false) List<Long> ids) {
		logger.info("Editing recipe with id " + recipe.getId() + ".");
		
		recipe.setModification(new Date());
		
		// Update recipe.
		recipeService.update(recipe);
		
		// add recipe relationship to images
		if(ids != null) {
			for(Long id : ids) {
				Image image = imageService.find(id);
				imageService.setRecipeRelation(image, recipe);
			}
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
	public String rating(Model model, @PathVariable("id") long id, @RequestParam("score") int score) {
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
	
}
