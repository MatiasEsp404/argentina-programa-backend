package com.argentina.programa.security.util;

import com.argentina.programa.repository.IUserRepository;
import com.argentina.programa.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtils {


  @Autowired
  private IUserRepository userRepository;

  public Authentication getAuthentication() {
    return SecurityContextHolder.getContext().getAuthentication();
  }

  public UserDetails getUserAuthenticated() {
    Object principal = getAuthentication().getPrincipal();
    String username = (principal instanceof UserDetails) ? ((UserDetails) principal).getUsername()
        : principal.toString();

    return userRepository.findByEmail(username);
  }

  public boolean hasOwnerRole() {
    return getAuthentication().getAuthorities().stream().anyMatch(
        grantedAuthority -> Role.OWNER.getFullRoleName().equals(grantedAuthority.getAuthority()));
  }

}
