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

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Resolution;

/**
 * POJO which represents a Recipe.
 * 
 * @author Nils Sommer
 *
 */
@Entity
@Table(name="t_recipes")
@Indexed
public class Recipe implements Serializable {

	private static final long serialVersionUID = 3239162951065313443L; // generated by eclipse
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="my_entity_seq_gen")
	@SequenceGenerator(name="my_entity_seq_gen", sequenceName="HIBERNATE_SEQUENCE", allocationSize=1)
	private Integer id;
	
	@Field
	@Column(name="title")
	private String title;
	
	@Field
	@Column(name="description")
	private String description;
	
	@Field
	@Column(name="content")
	private String content;
	
	@Field
	@Column(name="preparation_endurance")
	private Integer preparationEndurance				=			0;
	
	@Field
	@Column(name="total_endurance")
	private Integer totalEndurance						=			0;
	
	@Field
	@DateBridge(resolution=Resolution.MINUTE)
	@Column(name="creation_date")
	private Date creation;
	
	@Field
	@DateBridge(resolution=Resolution.MINUTE)
	@Column(name = "last_edit")
	private Date modification;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@OneToMany(mappedBy="recipe")
	private List<Image> images;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	/**
	 * Standard Constructor.
	 */
	public Recipe() {
		
	}
	
	/**
	 * Constructor without id.
	 * 
	 * @param title title of the recipe
	 * @param description description of the recipe
	 * @param content content of the recipe
	 * @param preparationEndurance preparation endurance needed to cook the recipe
	 * @param totalEndurance total endurance needed to cook the recipe
	 * @param creation creation date of the recipe
	 * @param modification last modification date of the recipe
	 * @param category category of the recipe
	 */
	public Recipe(String title, String description, String content, Integer preparationEndurance,
			Integer totalEndurance, Date creation, Date modification, Category category) {
		this.title = title;
		this.description = description;
		this.content = content;
		this.preparationEndurance = preparationEndurance;
		this.totalEndurance = totalEndurance;
		this.creation = creation;
		this.modification = modification;
		this.category = category;
	}
	
	// ----- Getters and setters here: -----
	
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
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param desctiption the desctiption to set
	 */
	public void setDescription(String desctiption) {
		this.description = desctiption;
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
	
	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}
	
	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
	
	/**
	 * @return a list of all image object which belong to this recipe
	 */
	public List<Image> getImages() {
		return images;
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
	
}
