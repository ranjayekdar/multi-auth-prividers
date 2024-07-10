package com.multi_auth_provider.service;

import org.springframework.stereotype.Service;

import com.multi_auth_provider.dto.AppUser;
import com.multi_auth_provider.filter.JwtAuthenticationToken;

@Service
public class JwtAuthService {

  public JwtAuthenticationToken authenticate(JwtAuthenticationToken jwtAuthenticationToken) {
    // You would usually verify the token, fetch the user details based on the token and set it to the user object
    // but for this demo, we will just populate the user object with dummy data
    if (jwtAuthenticationToken.getToken().equals("valid-token")) {
      AppUser authenticatedUser = new AppUser("John Doe");
      return new JwtAuthenticationToken(jwtAuthenticationToken.getToken(), authenticatedUser);
    }

    return jwtAuthenticationToken;
  }

}
