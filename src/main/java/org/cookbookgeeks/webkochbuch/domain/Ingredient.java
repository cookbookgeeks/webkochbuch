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
 * POJO that represents an ingredient of a recipe.
 */
public class Ingredient {
	
	private Integer id;
	private String name;
	private Measure  measure;
	private Double amount;
	private Recipe recipe;
	private Date creation;
	private Date modification;
	
	/**
	 * Standard constructor.
	 */
	public Ingredient() {
		
	}
	
	/**
	 * Constructor without id.
	 * 
	 * @param name name of the ingredient
	 * @param measure measure of the ingredient
	 * @param amount amount of the ingredient needed for the recipe
	 * @param recipe recipe the ingredient belongs to
	 * @param creation creation date of the ingredient
	 * @param modification last modification date of the ingredient
	 */
	public Ingredient(String name, Measure measure, Double amount, Recipe recipe, Date creation, Date modification) {
		this.name = name;
		this.measure = measure;
		this.amount = amount;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the measure
	 */
	public Measure getMeasure() {
		return measure;
	}

	/**
	 * @param measure the measure to set
	 */
	public void setMeasure(Measure measure) {
		this.measure = measure;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
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
