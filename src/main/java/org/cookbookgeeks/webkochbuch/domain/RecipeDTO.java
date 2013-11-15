package org.cookbookgeeks.webkochbuch.domain;

import java.util.Date;


/**
 * A DTO object which is used as a form object in create recipe
 * and edit recipe forms.
 * @author Nils Sommer
 *
 */
public class RecipeDTO {

	private int id;
	private String title;
	private String desctiption;
	private String content;
	private int preparationEndurance;
	private int totalEndurance;
	private Date creation;
	
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
		
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
		
	/**
	 * @return the desctiption
	 */
	public String getDesctiption() {
		return desctiption;
	}
		
	/**
	 * @param desctiption the desctiption to set
	 */
	public void setDesctiption(String desctiption) {
		this.desctiption = desctiption;
	}
		
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
		
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
		
	/**
	 * @return the preparationEndurance
	 */
	public int getPreparationEndurance() {
		return preparationEndurance;
	}
		
	/**
	 * @param preparationEndurance the preparationEndurance to set
	 */
	public void setPreparationEndurance(int preparationEndurance) {
		this.preparationEndurance = preparationEndurance;
	}
		
	/**
	 * @return the totalEndurance
	 */
	public int getTotalEndurance() {
		return totalEndurance;
	}
		
	/**
	 * @param totalEndurance the totalEndurance to set
	 */
	public void setTotalEndurance(int totalEndurance) {
		this.totalEndurance = totalEndurance;
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

}
