package org.cookbookgeeks.webkochbuch.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.cookbookgeeks.webkochbuch.domain.Recipe;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class implements all regularily used database functions such as adding, deleting,
 * updating or reading of objects.
 * @author Nils Sommer
 *
 */
@Service("recipeService")
@Transactional
public class RecipeService {
	
	protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	/**
	 * Getting a recipe by id.
	 * @param id of the recipe.
	 * @return Recipe object.
	 */
	public Recipe getRecipe(Integer id) {
		logger.debug("Retrieving person with id: " + id);
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Get recipe
		Recipe recipe = (Recipe) session.get(Recipe.class, id);
		
		// Retrieve recipe
		return recipe;
	}
	
	/**
	 * Getting a list with all available recipes.
	 * @return A list with Recipe objects.
	 */
	public List<Recipe> getAll() {
		logger.debug("Retrieving all persons");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  Recipe");
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Add a Recipe object to the database.
	 * @param recipe to save to the database.
	 */
	public void add(Recipe recipe) {
		logger.debug("Adding new recipe");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Save
		session.save(recipe);
	}
	
	/**
	 * Delete a Recipe object from the database by id.
	 * @param id of the Recipe object.
	 */
	public void delete(Integer id) {
		logger.debug("Deleting existing person");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing recipe first
		Recipe person = (Recipe) session.get(Recipe.class, id);
		
		// Delete 
		session.delete(person);
	}
	
	/**
	 * Edit the information of a stored Recipe object.
	 * @param edited recipe object with edited data.
	 */
	public void edit(Recipe edited) {
		logger.debug("Editing existing recipe");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing recipe via id
		Recipe recipe = (Recipe) session.get(Recipe.class, edited.getId());
		
		// Assign updated values to this recipe
		recipe.setTitle(edited.getTitle());
		recipe.setDescription(edited.getDescription());
		recipe.setContent(edited.getContent());
		recipe.setPreparationEndurance(edited.getPreparationEndurance());
		recipe.setTotalEndurance(edited.getTotalEndurance());
		recipe.setCreation(edited.getCreation());

		// Save updates
		session.save(recipe);
	}
}
