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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * UserDetails implementation for our costum AuthenticationProvider implementation.
 * This is specifically needed to support the remember-me configuration.
 * 
 * @author Nils Sommer
 *
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {
	
	private static final Logger Logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private UserService userService;

	/** {@inheritDoc} */
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		final org.cookbookgeeks.webkochbuch.domain.User user = userService.getByUserName(userName);
		
		if(user == null) {
			Logger.info("### FAILED LOGIN ### Couldn't find user with username " + userName + " in database.");
			return null;
		}
		
		HashSet<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		final UserDetails userDetails = new AuthenticationUserDetails(user, authorities);
		return userDetails;
	}

}
