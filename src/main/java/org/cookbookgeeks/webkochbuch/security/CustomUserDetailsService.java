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
