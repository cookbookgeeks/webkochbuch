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
