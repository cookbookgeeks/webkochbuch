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

package org.cookbookgeeks.webkochbuch.domain;

import java.util.Date;

/**
 * @author Nils Sommer
 *
 * POJO that represents a comment by a user on a recipe.
 */
public class Comment {
	
	private Integer id;
	private String comment;
	private User user;
	private Recipe recipe;
	private Date creation;
	private Date modification;
	
	/**
	 * Standard constructor.
	 */
	public Comment() {
		
	}
	
	/**
	 * Constructor without id.
	 * 
	 * @param comment text of the comment
	 * @param user the user that created the comment
	 * @param recipe the recipe the comment belongs to
	 * @param creation creation date of the comment
	 * @param modification last modification date of the comment
	 */
	public Comment(String comment, User user, Recipe recipe, Date creation, Date modification) {
		this.comment = comment;
		this.user = user;
		this.recipe = recipe;
		this.creation = creation;
		this.modification = modification;
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the recipe
	 */
	public Recipe getRecipe() {
		return recipe;
	}

	/**
	 * @param recipe the recipe to set
	 */
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	/**
	 * @return the creation
	 */
	public Date getCreation() {
		return creation;
	}

	/**
	 * @param creation the creation to set
	 */
	public void setCreation(Date creation) {
		this.creation = creation;
	}

	/**
	 * @return the modification
	 */
	public Date getModification() {
		return modification;
	}

	/**
	 * @param modification the modification to set
	 */
	public void setModification(Date modification) {
		this.modification = modification;
	}

}
