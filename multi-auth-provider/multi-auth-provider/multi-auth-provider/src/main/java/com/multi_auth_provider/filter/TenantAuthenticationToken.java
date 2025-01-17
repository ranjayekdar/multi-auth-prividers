package com.multi_auth_provider.filter;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.multi_auth_provider.dto.AppTenant;

import lombok.Getter;

public class TenantAuthenticationToken implements Authentication {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean isAuthenticated;
	  private AppTenant userDetails;
	  @Getter
	  private String clientId;
	  @Getter
	  private String clientSecret;

	  // Constructor to be used pre-authentication
	  public TenantAuthenticationToken(String clientId, String clientSecret) {
	    this.clientId = clientId;
	    this.clientSecret = clientSecret;
	  }

	  // Constructor to be used after successful authentication
	  public TenantAuthenticationToken(AppTenant tenant) {
	    this.userDetails = tenant;
	    this.isAuthenticated = true;
	  }

	  @Override
	  public Collection<? extends GrantedAuthority> getAuthorities() {
	    return null;
	  }

	  @Override
	  public Object getCredentials() {
	    return null;
	  }

	  @Override
	  public Object getDetails() {
	    return userDetails;
	  }

	  @Override
	  public Object getPrincipal() {
	    return userDetails;
	  }

	  @Override
	  public boolean isAuthenticated() {
	    return isAuthenticated;
	  }

	  @Override
	  public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
	    throw new IllegalArgumentException("Not supported, use constructor");
	  }

	  @Override
	  public String getName() {
	    return userDetails.getUsername();
	  }
	}
