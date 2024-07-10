package com.multi_auth_provider.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutFilter;

import com.multi_auth_provider.filter.JwtAuthenticationFilter;
import com.multi_auth_provider.filter.TenantAuthenticationFilter;
import com.multi_auth_provider.service.JwtAuthService;
import com.multi_auth_provider.service.TenantAuthenticationService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Autowired
  private JwtAuthService jwtAuthService;

  @Autowired
  private TenantAuthenticationService tenantAuthService;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests((authorize) -> {
          authorize.anyRequest().authenticated();
        })
        .formLogin(AbstractHttpConfigurer::disable);

    http.addFilterBefore(new JwtAuthenticationFilter(authenticationManager()), LogoutFilter.class);
    http.addFilterBefore(new TenantAuthenticationFilter(authenticationManager()), JwtAuthenticationFilter.class);

    return http.build();
  }

  @Bean
  public AuthenticationManager authenticationManager() {
    JwtAuthenticationProvider jwtAuthenticationProvider = new JwtAuthenticationProvider(jwtAuthService);
    TenantAuthenticationProvider tenantAuthenticationProvider = new TenantAuthenticationProvider(tenantAuthService);
    return new ProviderManager(jwtAuthenticationProvider, tenantAuthenticationProvider);
  }

}
