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
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	/**
	 * Calls a generic search method for the given pattern.
	 * 
	 * @param model of the view that will be shown
	 * @param pattern to search for
	 * @return the view search
	 */
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
	
	/**
	 * Calls a search method for the given pattern.
	 * Only specific fields will be used for the search.
	 * 
	 * @param model of the view that will be shown
	 * @param pattern to search for
	 * @param attributes to search on (model fields)
	 * @return the view search
	 */
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
	
	/**
	 * Calls the createIndex() method.
	 * 
	 * @return a message
	 */
	@RequestMapping(method=RequestMethod.GET, value="/createindex")
	public @ResponseBody String createIndex() {
		Logger.info("Creating index.");
		return "Index erstellt.";
	}

}
