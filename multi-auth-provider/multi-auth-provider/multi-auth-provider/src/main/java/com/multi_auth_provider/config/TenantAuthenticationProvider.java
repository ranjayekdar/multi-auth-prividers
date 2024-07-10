package com.multi_auth_provider.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.multi_auth_provider.filter.TenantAuthenticationToken;
import com.multi_auth_provider.service.TenantAuthenticationService;

public class TenantAuthenticationProvider implements AuthenticationProvider {

	  private final TenantAuthenticationService authService;
	  public TenantAuthenticationProvider(TenantAuthenticationService authService) {
	    this.authService = authService;
	  }

	  @Override
	  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	    return authService.authenticate((TenantAuthenticationToken) authentication);
	  }

	  @Override
	  public boolean supports(Class<?> authentication) {
	    return authentication.equals(TenantAuthenticationToken.class);
	  }
	}
