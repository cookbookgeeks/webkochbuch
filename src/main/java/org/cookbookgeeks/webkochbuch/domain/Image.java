package org.cookbookgeeks.webkochbuch.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="images")
public class Image implements Serializable {

	private static final long serialVersionUID = 4364318268080958100L; // generated by eclipse
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="my_entity_seq_gen")
	@SequenceGenerator(name="my_entity_seq_gen", sequenceName="HIBERNATE_SEQUENCE", allocationSize=1)
	private Integer id;
	
	@Column(name="path")
	private String path;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="recipe_id")
	private Recipe recipe;
	
	/**
	 * Default Constructor.
	 */
	public Image() {
		
	}
	
	/**
	 * Constructor which sets the path and the description of the image.
	 * 
	 * @param path the path of the image file
	 * @param description the description of the image
	 */
	public Image(String path, String description) {
		this.path = path;
		this.description = description;
	}
	
	/**
	 * Constructor which sets the recipe, the path and the description of the image.
	 * 
	 * @param recipe the recipe the image belongs to
	 * @param path the path of the image file
	 * @param description the description of the image
	 */
	public Image(Recipe recipe, String path, String description) {
		this.recipe = recipe;
		this.path = path;
		this.description = description;
	}
	
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
	 * @return the filePath
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param filePath the filePath to set
	 */
	public void setPath(String path) {
		this.path = path;
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
	
	// ----- other methods -----
	
	public String toString() {
		return "File path: " + path + "\nDescription: " + description +
				"\nId: " + id;
	}

}
