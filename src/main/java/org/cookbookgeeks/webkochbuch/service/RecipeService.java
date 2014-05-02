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

package org.cookbookgeeks.webkochbuch.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.TermMatchingContext;
import org.cookbookgeeks.webkochbuch.domain.Image;
import org.cookbookgeeks.webkochbuch.domain.Recipe;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class implements all regularily used database functions such as adding, deleting,
 * updating or reading of objects.
 * 
 * @author Nils Sommer
 *
 */
@Service("recipeService")
@Transactional
public class RecipeService {
	
	protected static final Logger logger = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	/**
	 * Getting a recipe by id.
	 * 
	 * @param id of the recipe.
	 * @return Recipe object.
	 */
	public Recipe getRecipe(Integer id) {
		logger.info("Retrieving person with id: " + id);
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Get recipe
		Recipe recipe = (Recipe) session.get(Recipe.class, id);
		
		// Retrieve recipe
		return recipe;
	}
	
	/**
	 * Getting a list with all available recipes.
	 * 
	 * @return A list with Recipe objects.
	 */
	@SuppressWarnings("unchecked")
	public List<Recipe> getAll() {
		logger.info("Retrieving all persons");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  Recipe");
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Get a list of the top items.
	 * 
	 * @param limit number of items to get
	 * @return list of items
	 */
	@SuppressWarnings("unchecked")
	public List<Recipe> getTopItems(int limit) {
		logger.info("Retrieving top Recipes");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  Recipe");
		query.setMaxResults(limit);
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Gets a list of items from a specific range.
	 * 
	 * @param start start of the range
	 * @param end end of the range
	 * @return list of items
	 */
	@SuppressWarnings("unchecked")
	public List<Recipe> getItemsRange(int start, int end) {
		logger.info("Retrieving recipes from start to end value");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  Recipe LIMIT "+start+","+ end);
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Add a Recipe object to the database.
	 * 
	 * @param recipe to save to the database.
	 */
	public void add(Recipe recipe) {
		logger.info("Adding new recipe");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Save
		session.save(recipe);
	}
	
	/**
	 * Delete a Recipe object from the database by id.
	 * 
	 * @param id of the Recipe object.
	 */
	public void delete(Integer id) {
		logger.info("Deleting existing recipe");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing recipe first
		Recipe recipe = (Recipe) session.get(Recipe.class, id);
		
		// Delete 
		session.delete(recipe);
	}
	
	/**
	 * Edit the information of a stored Recipe object.
	 * 
	 * @param edited recipe object with edited data.
	 */
	public void edit(Recipe edited) {
		logger.info("Editing existing recipe");
		
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
	
	/**
	 * Saving image object in the database.
	 * 
	 * @param image
	 */
	public Integer saveImage(Image image) {
		logger.info("Saving image.");
		Session session = sessionFactory.getCurrentSession();
		return (Integer) session.save(image);
	}
	
	/**
	 * Get image by id.
	 * 
	 * @param id of the image
	 * @return the image object
	 */
	public Image getImage(Integer id) {
		logger.info("Getting image by id: " + id.toString());
		Session session = sessionFactory.getCurrentSession();
		Image image = (Image) session.get(Image.class, id);
		return image;
	}
	
	/**
	 * Adding an image to a recipe.
	 * 
	 * @param image to add to the recipe
	 * @param recipeId Id of the recipe to add the image to
	 */
	public void addImage(Image image, Integer recipeId) {
		logger.info("Adding image to Recipe " + recipeId);
		Session session = sessionFactory.getCurrentSession();

		Recipe recipe = (Recipe) session.get(Recipe.class, recipeId);
		image.setRecipe(recipe);
		
		session.save(image);
	}
	
	/**
	 * Deletes an image.
	 * 
	 * @param id of the image
	 */
	public void deleteImage(Integer id) {
		logger.info("Deleting image with id " + id);
		Session session = sessionFactory.getCurrentSession();
		
		Image image = (Image) session.get(Image.class, id);
		
		session.delete(image);
	}
	
	/**
	 * Creates index files for the fulltext search.
	 * Call this method, if unindexed objects are in the database
	 * or you run webkochbuch for the first time.
	 */
	public void createIndex() {
		FullTextSession fullTextSession = Search.getFullTextSession(sessionFactory.getCurrentSession());
		try {
			fullTextSession.createIndexer().startAndWait();
		} catch (InterruptedException e) {
			logger.error("############ Creating index failed.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Executes a generic search on all recipes for the given pattern.
	 * 
	 * @param pattern to search for
	 * @return a list of recipes
	 */
	public List<Recipe> search(String pattern) {
		logger.info("Searching recipes by pattern: " + pattern);
		final FullTextSession fullTextSession = Search.getFullTextSession(sessionFactory.getCurrentSession());
		final org.hibernate.search.query.dsl.QueryBuilder qb = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Recipe.class).get();
		final org.apache.lucene.search.Query luceneQuery = qb.keyword().onFields("title", "description", "content").matching(pattern).createQuery();
		final org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(luceneQuery, Recipe.class);
		@SuppressWarnings("unchecked")
		final List<Recipe> result = hibQuery.list();
		
		return result;
	}
	
	/**
	 * Executes a search on all recipes for the given pattern only
	 * on the given fields (attributes). 
	 * 
	 * @param pattern to search for
	 * @param attributes of the recipes to search on
	 * @return a list of recipes
	 */
	public List<Recipe> search(String pattern, List<String> attributes) {
		logger.info("Searching recipes by pattern: " + pattern);
		final FullTextSession fullTextSession = Search.getFullTextSession(sessionFactory.getCurrentSession());
		final org.hibernate.search.query.dsl.QueryBuilder qb = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Recipe.class).get();
		
		// Create query
		// This will get even more ugly if more attributes should be supported ...
		// FIXME
		TermMatchingContext tmc = null;
		if(attributes.contains("title") && attributes.contains("description") && attributes.contains("content")) {
			tmc = qb.keyword().onFields("title", "description", "content");
		} else if(attributes.contains("title") && attributes.contains("description") && !attributes.contains("content")) {
			tmc = qb.keyword().onFields("title", "description");
		} else if(attributes.contains("title") && !attributes.contains("description") && attributes.contains("content")) {
			tmc = qb.keyword().onFields("title", "content");
		} else if(!attributes.contains("title") && attributes.contains("description") && attributes.contains("content")) {
			tmc = qb.keyword().onFields("description", "content");
		} else if(attributes.contains("title") && !attributes.contains("description") && !attributes.contains("content")) {
			tmc = qb.keyword().onField("title");
		} else if(!attributes.contains("title") && attributes.contains("description") && !attributes.contains("content")) {
			tmc = qb.keyword().onField("description");
		} else if(!attributes.contains("title") && !attributes.contains("description") && attributes.contains("content")) {
			tmc = qb.keyword().onField("content");
		} else {	// none of the attributes appear
			return null;
		}
		
		final org.apache.lucene.search.Query luceneQuery = tmc.matching(pattern).createQuery();
		final org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(luceneQuery, Recipe.class);

		@SuppressWarnings("unchecked")
		final List<Recipe> result = hibQuery.list();
		
		return result;
	}
}
