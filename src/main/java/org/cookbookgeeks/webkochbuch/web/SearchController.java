
package org.cookbookgeeks.webkochbuch.web;

import java.util.List;

import javax.annotation.Resource;

import org.cookbookgeeks.webkochbuch.domain.Recipe;
import org.cookbookgeeks.webkochbuch.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller for search actions.
 * 
 * @author Nils Sommer
 *
 */
@Controller
@RequestMapping("/search")
public class SearchController {
	
	private static final Logger Logger = LoggerFactory.getLogger(SearchController.class);
	
	@Resource(name="recipeService")
	private RecipeService recipeService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String genericSearch(Model model, @RequestParam("s") String pattern) {
		List<Recipe> recipes = recipeService.search(pattern);
		if(!recipes.isEmpty()) {
			Logger.info(recipes.size() + "results found for generic search with pattern: " + pattern);
			model.addAttribute("recipes", recipes);
		}
		model.addAttribute("lastPattern", pattern);
		return "search";
	}
	
	@RequestMapping(method=RequestMethod.GET, params = {"s", "attributes"})
	public String detailedSearch(Model model, @RequestParam("s") String pattern, 
			@RequestParam("attributes") List<String> attributes) {
		List<Recipe> recipes = recipeService.search(pattern, attributes);
		if(!recipes.isEmpty()) {
			Logger.info(recipes.size() + "results found for detailed search with pattern: " + pattern);
			model.addAttribute("recipes", recipes);
		}
		model.addAttribute("lastPattern", pattern);
		return "search";
	}

}
