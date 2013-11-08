package org.cookbookgeeks.webkochbuch.domain;

import java.io.Serializable;

public class Image implements Serializable {

	private static final long serialVersionUID = 4364318268080958100L; // generated by eclipse
	
	private int id;
	private int recipeId;
	private String filePath;
	private String description;
	
	// ----- Getters and setters here: -----
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the recipeId
	 */
	public int getRecipeId() {
		return recipeId;
	}

	/**
	 * @param recipeId the recipeId to set
	 */
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	// ----- other methods -----
	
	public String toString() {
		return "File path: " + filePath + "\nDescription: " + description +
				"\nId: " + id;
	}

}
