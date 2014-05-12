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
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Nils Sommer
 * 
 * POJO that represents a user.
 */
@Entity
@Table(name = "t_users")
public class User {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="my_entity_seq_gen")
	@SequenceGenerator(name="my_entity_seq_gen", sequenceName="HIBERNATE_SEQUENCE", allocationSize=1)
	private Integer id;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password_hash")
	private String passwordHash;
	
	@Column(name = "e_mail")
	private String email;
	
	@Column(name = "creation_date")
	private Date creation;
	
	@Column(name = "last_edit")
	private Date modification;
	
	@OneToMany(mappedBy = "user")
	private List<Recipe> recipes;
	
	@OneToMany(mappedBy = "user")
	private List<Image> images;
	
	@OneToMany(mappedBy = "user")
	private List<Comment> comments;
	
	@OneToMany(mappedBy = "user")
	private List<Rating> ratings;
	
	/**
	 * Standard constructor.
	 */
	public User() {
		
	}
	
	/**
	 * Constructor without id.
	 * 
	 * @param userName username of the user
	 * @param passwordHash hashed password string
	 * @param email email address of the user
	 * @param creation creation date of the user
	 * @param modification last modification date of the user
	 */
	public User(String userName, String passwordHash, String email, Date creation, Date modification) {
		this.userName = userName;
		this.passwordHash = passwordHash;
		this.email = email;
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the passwordHash
	 */
	public String getPasswordHash() {
		return passwordHash;
	}

	/**
	 * @param passwordHash the passwordHash to set
	 */
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * @return the recipes
	 */
	public List<Recipe> getRecipes() {
		return recipes;
	}

	/**
	 * @return the images
	 */
	public List<Image> getImages() {
		return images;
	}

	/**
	 * @return the comments
	 */
	public List<Comment> getComments() {
		return comments;
	}

	/**
	 * @return the ratings
	 */
	public List<Rating> getRatings() {
		return ratings;
	}

}
