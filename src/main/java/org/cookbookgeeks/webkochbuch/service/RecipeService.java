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
	public Recipe getRecipe(int id) {
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
	
	public List<Recipe> getTopItems(int limit) {
		logger.debug("Retrieving top Recipes");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  Recipe");
		query.setMaxResults(limit);
		
		// Retrieve all
		return  query.list();
	}
	
	public List<Recipe> getItemsRange(int start, int end) {
		logger.debug("Retrieving recipes from start to end value");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  Recipe LIMIT "+start+","+ end);
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Add a Recipe object to the database.
	 * @param title of the recipe.
	 * @param description of the recipe.
	 * @param content of the recipe.
	 * @param preparationEndurance of the recipe.
	 * @param totalEndurance of the recipe.
	 * @param creation of the recipe.
	 */
	public void add(String title, String description, String content,
			int preparationEndurance, int totalEndurance, Date creation) {
		logger.debug("Adding new recipe");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a new Recipe
		Recipe recipe = new Recipe();
		recipe.setTitle(title);
		recipe.setDescription(description);
		recipe.setContent(content);
		recipe.setPreparationEndurance(preparationEndurance);
		recipe.setTotalEndurance(totalEndurance);
		recipe.setCreation(creation);
		
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
	 * @param id of the recipe.
	 * @param title of the recipe.
	 * @param description of the recipe.
	 * @param content of the recipe.
	 * @param preparationEndurance of the recipe.
	 * @param totalEndurance of the recipe.
	 * @param creation of the recipe.
	 */
	public void edit(Integer id, String title, String description, String content,
			int preparationEndurance, int totalEndurance, Date creation) {
		logger.debug("Editing existing recipe");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing recipe via id
		Recipe recipe = (Recipe) session.get(Recipe.class, id);
		
		// Assign updated values to this recipe
		recipe.setTitle(title);
		recipe.setDescription(description);
		recipe.setContent(content);
		recipe.setPreparationEndurance(preparationEndurance);
		recipe.setTotalEndurance(totalEndurance);
		recipe.setCreation(creation);

		// Save updates
		session.save(recipe);
	}
}
