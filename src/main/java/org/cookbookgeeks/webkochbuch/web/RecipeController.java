package org.cookbookgeeks.webkochbuch.web;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.cookbookgeeks.webkochbuch.domain.Image;
import org.cookbookgeeks.webkochbuch.domain.Recipe;
import org.cookbookgeeks.webkochbuch.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Nils Sommer
 * 
 * This is the Controller which processes all recipe requests.
 */
@Controller
public class RecipeController {
	
	private static final Logger logger = LoggerFactory.getLogger(RecipeController.class);
	
	@Resource(name="recipeService")
	private RecipeService recipeService;
	
	/**
	 * Shows a recipe.
	 * 
	 * @param id of the recipe which wil be shown.
	 * @param model Model the view extracts its data from.
	 * @return the view recipe.jsp
	 */
	@RequestMapping(method=RequestMethod.GET, value="/recipe/{id}")
	public String showRecipe(@PathVariable("id") int id, Model model) {
		logger.info("Returning view recipe with recipe.id=" + id);
		
		// Get recipe.
		Recipe recipe = recipeService.getRecipe(id);
		
		// check if there is a recipe with the given id
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
		
		// Get all recipes.
		List<Recipe> recipes = recipeService.getAll();
		
		model.addAttribute("recipes", recipes);
		return "showList";
	}
	
	/**
	 * Adds a recipe and shows it afterwards.
	 * 
	 * @param recipe which is added.
	 * @return the view recipe with the id of the created recipe.
	 */
	@RequestMapping(method=RequestMethod.POST, value="/recipe/adddata")
	public String addRecipe(@ModelAttribute("recipe") Recipe recipe) {
		logger.info("Adding new recipe.");
		
		// Current date.
		recipe.setCreation(new Date());
		
		// Adding the recipe
		recipeService.add(recipe);
		
		// Display view with the newly created recipe.
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
	public String deleteRecipe(@PathVariable("id") int id) {
		logger.info("Deleting recipe with id " + id + ".");
		
		// Deleting recipe.
		recipeService.delete(id);
		
		return "redirect:/";
	}
	
	/**
	 * Edits a recipe and show it afterwards.
	 * 
	 * @param recipe which gets edited.
	 * @return the view recipe with the id of the recipe.
	 */
	@RequestMapping(method=RequestMethod.POST, value="/recipe/editdata")
	public String editRecipe(@ModelAttribute("recipe") Recipe recipe) {
		logger.info("Editing recipe with id " + recipe.getId() + ".");
		
		// update date
		recipe.setCreation(new Date());
		
		// Update recipe.
		recipeService.edit(recipe);
		
		// Display edited recipe.
		return "redirect:/recipe/" + recipe.getId();
	}
	
	/**
	 * Maps url which returns an input form view for adding recipes.
	 * 
	 * @return the editRecipe view
	 */
	@RequestMapping(method=RequestMethod.GET, value="/recipe/edit/{id}")
	public String editForm(@PathVariable("id") int id, Model model) {
		logger.info("Returning editRecipe view.");
		
		// Get the recipe.
		Recipe recipe = recipeService.getRecipe(id);
		
		// Check if it exists at all.
		if( recipe == null ) {
			logger.debug("Recipe with id " + id + " does not exist!");
			return "recipeNotFound";
		}
		
		// Give recipe object to view.
		model.addAttribute("recipe", recipe);
		
		return "editRecipe";
	}
	
	/**
	 * Deletes an image.
	 * 
	 * @param id of the image
	 * @return the start page view
	 */
	@RequestMapping(method=RequestMethod.GET, value="/image/delete/{id}")
	public String deleteImage(@PathVariable("id") int id) {
		logger.info("Deleting image with id " + id);
		recipeService.deleteImage(id);
		
		return "redirect:/";
	}

}
