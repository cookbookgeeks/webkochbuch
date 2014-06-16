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

package org.cookbookgeeks.webkochbuch.security;

import java.util.Collection;
import java.util.HashSet;

import org.cookbookgeeks.webkochbuch.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Helper class to build a UserDetails instance.
 * 
 * @author Nils Sommer
 *
 */
public class AuthenticationUserDetails implements UserDetails {

	private static final long serialVersionUID = -9213797115741530463L;
	
	private String userName;
	private String passwordHash;
	private HashSet<GrantedAuthority> authorities;
	
	/**
	 * Standard constructor.
	 * 
	 * @param user user object from the database
	 * @param authorities authorities for the user
	 */
	public AuthenticationUserDetails(User user, HashSet<GrantedAuthority> authorities) {
		this.userName = user.getUserName();
		this.passwordHash = user.getPasswordHash();
		this.authorities = authorities;
	}

	/** {@inheritDoc} */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	/** {@inheritDoc} */
	@Override
	public String getPassword() {
		return passwordHash;
	}

	/** {@inheritDoc} */
	@Override
	public String getUsername() {
		return userName;
	}

	/** {@inheritDoc} */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public boolean isEnabled() {
		return true;
	}

}
