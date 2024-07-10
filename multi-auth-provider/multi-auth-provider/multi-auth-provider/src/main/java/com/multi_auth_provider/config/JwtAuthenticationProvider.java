package com.multi_auth_provider.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.multi_auth_provider.filter.JwtAuthenticationToken;
import com.multi_auth_provider.service.JwtAuthService;

public class JwtAuthenticationProvider implements AuthenticationProvider {
	  private final JwtAuthService authService;

	  public JwtAuthenticationProvider(JwtAuthService service) {
	    this.authService = service;
	  }

	  @Override
	  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	    return authService.authenticate((JwtAuthenticationToken) authentication);
	  }

	  @Override
	  public boolean supports(Class<?> authentication) {
	    return authentication.equals(JwtAuthenticationToken.class);
	  }
	}
