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

import java.util.HashSet;

import org.cookbookgeeks.webkochbuch.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * AuthenticationProvider implementation for spring security that uses our own
 * service layer to access user information from the database.
 * 
 * @author Nils Sommer
 *
 */
@Component
public class UserServiceAuthenticationProvider implements
		AuthenticationProvider {
	
	private static final Logger Logger = LoggerFactory.getLogger(UserServiceAuthenticationProvider.class);
	
	@Autowired
	private UserService userService;

	/** {@inheritDoc} */
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		final String userName = authentication.getName();
		final String password = authentication.getCredentials().toString();
		
		final org.cookbookgeeks.webkochbuch.domain.User user = userService.getByUserName(userName);
		
		if(user == null) {
			Logger.info("### FAILED LOGIN ### Couldn't find user with username " + userName + " in database.");
			return null;
		}
		
		if(user.getPasswordHash().equals(password)) {
			final HashSet<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
			auths.add(new SimpleGrantedAuthority("ROLE_USER"));
			final UserDetails principal = new AuthenticationUserDetails(user, auths);
			final Authentication result = new UsernamePasswordAuthenticationToken(principal, password, auths);
			Logger.info("User " + userName + " succesfully logged in.");
			return result;
		}
		
		Logger.info("### FAILED LOGIN ### Couldn't find user with username " + userName + " in database.");
		return null;
	}

	/** {@inheritDoc} */
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
