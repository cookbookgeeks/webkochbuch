package org.cookbookgeeks.webkochbuch.web;

import org.cookbookgeeks.webkochbuch.domain.Category;
import org.cookbookgeeks.webkochbuch.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This controller processes all category related requests.
 * 
 * @author Nils Sommer
 *
 */
@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	/**
	 * Shows all categories.
	 * 
	 * @param model model that belongs to the view
	 * @return the view 'categories'
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/categories")
	public String categories(Model model) {
		model.addAttribute("categories", categoryService.findAll());
		return "categories";
	}
	
	/**
	 * Shows all recipes that belong to a given category.
	 * 
	 * @param model model that belongs to the view
	 * @param id if of the category
	 * @return the view 'showList'
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/category/{id}")
	public String category(Model model, @PathVariable("id") long id) {
		final Category category = categoryService.find(id);
		model.addAttribute("recipes", category.getRecipes());
		return "showList";
	}
	
}
