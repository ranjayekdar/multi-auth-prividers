package com.multi_auth_provider.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

public class AppUser implements UserDetails {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AppUser(String username) {
	    this.username = username;
	  }

	  private String username;
	  private String password;
	  @Getter
	  private String type = "user";

	  @Override
	  @JsonIgnore
	  public Collection<? extends GrantedAuthority> getAuthorities() {
	    return null;
	  }

	  @Override
	  @JsonIgnore
	  public String getPassword() {
	    return null;
	  }

	  @Override
	  public String getUsername() {
	    return username;
	  }

	  @Override
	  @JsonIgnore
	  public boolean isAccountNonExpired() {
	    return false;
	  }

	  @Override
	  @JsonIgnore
	  public boolean isAccountNonLocked() {
	    return false;
	  }

	  @Override
	  @JsonIgnore
	  public boolean isCredentialsNonExpired() {
	    return false;
	  }

	  @Override
	  @JsonIgnore
	  public boolean isEnabled() {
	    return false;
	  }
	}
