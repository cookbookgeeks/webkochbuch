package org.cookbookgeeks.webkochbuch.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	 * @param id of the recipe which wil be shown.
	 * @param model Model the view extracts its data from.
	 * @return the view recipe.jsp
	 */
	@RequestMapping(method=RequestMethod.GET, value="/recipe/{id}")
	public String showRecipe(@PathVariable("id") int id, Model model) {
		logger.debug("Returning view recipe with recipe.id=" + id);
		
		// Get recipe.
		Recipe recipe = recipeService.getRecipe(id);
		
		model.addAttribute("recipe", recipe);
		return "recipe";
	}
	
	/**
	 * Adds a recipe and shows it afterwards.
	 * @param recipe which is added.
	 * @return the view recipe with the id of the created recipe.
	 */
	@RequestMapping(method=RequestMethod.POST, value="/recipe/add")
	public String addRecipe(@ModelAttribute("recipe") Recipe recipe) {
		//TODO: create recipe from post parameter	
		return "/recipe/" + recipe.getId();
	}
	
	/**
	 * Deletes a recipe and redirects to the start page.
	 * @param id of the recipe which gets deleted.
	 * @return the view of the start page.
	 */
	@RequestMapping(method=RequestMethod.GET, value="/recipe/delete/{id}")
	public String deleteRecipe(@PathVariable("id") int id) {
		//TODO: delete recipe.
		return "/";
	}
	
	/**
	 * Edits a recipe and show it afterwards.
	 * @param recipe which gets edited.
	 * @return the view recipe with the id of the recipe.
	 */
	@RequestMapping(method=RequestMethod.POST, value="/recipe/edit")
	public String editRecipe(@ModelAttribute("recipe") Recipe recipe) {
		//TODO: edit recipe.
		return "/recipe/" + recipe.getId();
	}

}
