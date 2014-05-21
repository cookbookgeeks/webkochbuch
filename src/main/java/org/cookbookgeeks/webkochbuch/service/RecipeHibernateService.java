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

import org.cookbookgeeks.webkochbuch.dao.RecipeHibernateDao;
import org.cookbookgeeks.webkochbuch.domain.Recipe;
import org.hibernate.search.FullTextSession;
import org.springframework.stereotype.Service;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.TermMatchingContext;

/**
 * Service class for recipe related database operation. This class contains methods
 * that are more business related than in the Daos.
 * 
 * @author Nils Sommer
 *
 */
@Service("recipeService")
public class RecipeHibernateService extends RecipeHibernateDao implements RecipeService {

	/** {@inheritDoc} */
	@Override
	public void update(Recipe updated) {
		final Recipe recipe = this.find(updated.getId());
		recipe.setTitle(updated.getTitle());
		recipe.setDescription(updated.getDescription());
		recipe.setContent(updated.getContent());
		recipe.setPreparationEndurance(updated.getPreparationEndurance());
		recipe.setTotalEndurance(updated.getTotalEndurance());
		recipe.setModification(updated.getModification());
		super.update(recipe);
	}
	
	/** {@inheritDoc} */
	public List<Recipe> searchByKeywords(String pattern) {		
		final FullTextSession fullTextSession = Search.getFullTextSession(this.currentSession());
		final org.hibernate.search.query.dsl.QueryBuilder qb = fullTextSession.getSearchFactory()
				.buildQueryBuilder().forEntity(Recipe.class).get();
		final org.apache.lucene.search.Query luceneQuery = qb.keyword()
				.onFields("title", "description", "content").matching(pattern).createQuery();
		final org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(luceneQuery, Recipe.class);
		
		@SuppressWarnings("unchecked")
		List<Recipe> result = hibQuery.list();
		return result;
	}
	
	/** {@inheritDoc} */
	public List<Recipe> searchByKeywords(String pattern, List<String> attributes) {
		final FullTextSession fullTextSession = Search.getFullTextSession(this.currentSession());
		final org.hibernate.search.query.dsl.QueryBuilder qb = fullTextSession.getSearchFactory()
				.buildQueryBuilder().forEntity(Recipe.class).get();
		
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
