package com.multi_auth_provider.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

public class AppTenant implements UserDetails {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AppTenant(String name, String tenantId) {
	    this.tenantId = tenantId;
	    this.name = name;
	  }

	  private String name;
	  @Getter
	  private String type = "tenant";
	  @Getter
	  private String tenantId;

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
	  @JsonProperty("name")
	  public String getUsername() {
	    return name;
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
